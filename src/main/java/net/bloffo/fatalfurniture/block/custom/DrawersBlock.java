package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.bloffo.fatalfurniture.block.entity.custom.DrawersBlockEntity;
import net.minecraft.block.*;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Box;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DrawersBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<DrawersBlock> CODEC = createCodec(DrawersBlock::new);
    public static final DirectionProperty FACING;
    private static final VoxelShape BASE_SHAPE;
    public static final BooleanProperty LOCKED = BooleanProperty.of("locked");

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DrawersBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        if (!state.get(LOCKED)) {
            super.onStacksDropped(state, world, pos, tool, dropExperience);
        }
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DrawersBlockEntity drawers) {
                if (state.get(LOCKED)) {
                    DefaultedList<ItemStack> saved = drawers.getSavedItems();
                    super.onStateReplaced(state, world, pos, newState, moved);
                    if (!world.isClient() && world instanceof ServerWorld serverWorld) {
                        pendingReplacements.computeIfAbsent(serverWorld, k -> new java.util.ArrayList<>()).add(new ReplacementTask(pos, state, saved));
                    }
                    return;
                }
                ItemScatterer.spawn(world, pos, drawers);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient() && !state.get(LOCKED)) {
            if (world.getBlockEntity(pos) instanceof DrawersBlockEntity drawersBlockEntity) {
                world.playSound(null, pos, SoundEvents.BLOCK_BARREL_OPEN, SoundCategory.BLOCKS, 1.0F,
                        world.getRandom().nextFloat() * 0.4F + 0.8F);
                player.openHandledScreen(drawersBlockEntity);
                drawersBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
            PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public DrawersBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState())
                .with(FACING, Direction.NORTH).with(LOCKED, false));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BASE_SHAPE;
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LOCKED);
    }

    public static boolean canlock(BlockState state) {
        return state.contains(LOCKED) && !state.get(LOCKED);
    }

    public static boolean canunlock(BlockState state) {
        return state.contains(LOCKED) && state.get(LOCKED);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        if (state.get(LOCKED)) {
            return 0.0F;
        }
        return super.calcBlockBreakingDelta(state, player, world, pos);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return state.getMapColor(world, pos).color;
    }

    private static final java.util.Map<ServerWorld, java.util.List<ReplacementTask>> pendingReplacements = new java.util.HashMap<>();

    private static class ReplacementTask {
        private final BlockPos pos;
        private final BlockState state;
        private final DefaultedList<ItemStack> saved;

        ReplacementTask(BlockPos pos, BlockState state, DefaultedList<ItemStack> saved) {
            this.pos = pos;
            this.state = state;
            this.saved = saved;
        }
    }

    public static void registerTickHandler() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            java.util.List<ReplacementTask> tasks = pendingReplacements.remove(world);
            if (tasks != null) {
                for (ReplacementTask task : tasks) {
                    world.setBlockState(task.pos, task.state, Block.NOTIFY_ALL);
                    BlockEntity newBe = world.getBlockEntity(task.pos);
                    if (newBe instanceof DrawersBlockEntity newDrawers) {
                        for (int i = 0; i < task.saved.size(); i++) {
                            newDrawers.getItems().set(i, task.saved.get(i).copy());
                        }
                        newDrawers.setSavedItems(task.saved);
                        newDrawers.markDirty();
                    }
                    removeDroppedItems(world, task.pos);
                }
            }
        });
    }

    private static void removeDroppedItems(ServerWorld world, BlockPos pos) {
        for (ItemEntity entity : world.getEntitiesByClass(ItemEntity.class, new Box(pos).expand(0.5), e -> true)) {
            entity.discard();
        }
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        BASE_SHAPE = Block.createCuboidShape((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F,
                (double) 16.0F, (double) 16.0F);
    }
}
