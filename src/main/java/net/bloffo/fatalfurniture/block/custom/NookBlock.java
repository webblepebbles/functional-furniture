package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.bloffo.fatalfurniture.block.entity.custom.NookBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NookBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<NookBlock> CODEC = createCodec(NookBlock::new);
    public static final DirectionProperty FACING;
    private static final VoxelShape BASE_SHAPE;
    private static final VoxelShape TOP_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape X_AXIS_SHAPE;
    private static final VoxelShape Z_AXIS_SHAPE;

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new NookBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof NookBlockEntity) {
                ItemScatterer.spawn(world, pos, ((NookBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof NookBlockEntity NookBlockEntity) {
            if(NookBlockEntity.isEmpty() && !stack.isEmpty()) {
                NookBlockEntity.setStack(0, stack.copyAndEmpty());
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);
                stack.decrement(1);

                NookBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            } else if(stack.isEmpty() && !player.isSneaking()) {
                ItemStack stackOnNook = NookBlockEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnNook);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                NookBlockEntity.clear();

                NookBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
        }

        return ItemActionResult.SUCCESS;
    }

    public NookBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = (Direction)state.get(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_SHAPE : Z_AXIS_SHAPE;
    }

    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(2.0F, 40);
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return state.getMapColor(world, pos).color;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        BASE_SHAPE = Block.createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)2.0F, (double)16.0F);
        TOP_SHAPE = Block.createCuboidShape((double)0.0F, (double)14.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        WEST_SHAPE = Block.createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)2.0F, (double)16.0F, (double)16.0F);
        EAST_SHAPE = Block.createCuboidShape((double)14.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        NORTH_SHAPE = Block.createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)2.0F);
        SOUTH_SHAPE = Block.createCuboidShape((double)0.0F, (double)0.0F, (double)14.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        X_AXIS_SHAPE = VoxelShapes.union(BASE_SHAPE, new VoxelShape[]{TOP_SHAPE, SOUTH_SHAPE, NORTH_SHAPE});
        Z_AXIS_SHAPE = VoxelShapes.union(BASE_SHAPE, new VoxelShape[]{TOP_SHAPE, WEST_SHAPE, EAST_SHAPE});
    }
}
