package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CandleStickBlock extends Block {

    private static final VoxelShape SHAPE = CandleStickBlock.createCuboidShape(6, 0, 6, 10, 16, 10);
    public static final MapCodec<CandleStickBlock> CODEC = CandleStickBlock.createCodec(CandleStickBlock::new);

    public CandleStickBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

}
