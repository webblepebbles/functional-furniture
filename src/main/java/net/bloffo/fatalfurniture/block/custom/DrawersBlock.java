package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.bloffo.fatalfurniture.block.entity.custom.DrawersBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
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
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DrawersBlockEntity) {
                ItemScatterer.spawn(world, pos, ((DrawersBlockEntity) blockEntity));
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

    static {
        FACING = HorizontalFacingBlock.FACING;
        BASE_SHAPE = Block.createCuboidShape((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F,
                (double) 16.0F, (double) 16.0F);
    }
}
