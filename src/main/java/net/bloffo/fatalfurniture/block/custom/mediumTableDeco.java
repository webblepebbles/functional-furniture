package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class mediumTableDeco extends Block {
    public static final MapCodec<CouchBlock> CODEC = createCodec(CouchBlock::new);
    private static final VoxelShape SHAPE =  Block.createCuboidShape(4, 0, 4, 12, 16, 12);


    public mediumTableDeco(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

}
