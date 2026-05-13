package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.bloffo.fatalfurniture.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LampBlock extends Block {
    public static final MapCodec<LampBlock> CODEC = createCodec(LampBlock::new);
    private static final VoxelShape SHAPE =  Block.createCuboidShape(4, 0, 4, 12, 16, 12);
    public static final BooleanProperty ON = BooleanProperty.of("on");


    public LampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(ON, false));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            world.playSound(null, pos, ModSounds.LAMP_CLICKS, SoundCategory.BLOCKS, 2.0F, 0.75F);
            world.setBlockState(pos, state.cycle(ON));
        }
            return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }
}
