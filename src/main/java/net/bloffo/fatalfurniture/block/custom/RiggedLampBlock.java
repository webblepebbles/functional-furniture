package net.bloffo.fatalfurniture.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class RiggedLampBlock extends Block {
    public static final MapCodec<RiggedLampBlock> CODEC = createCodec(RiggedLampBlock::new);
    private static final VoxelShape SHAPE =  Block.createCuboidShape(4, 0, 4, 12, 16, 12);

    public RiggedLampBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            Vec3d vec3d = pos.toCenterPos();
            world.removeBlock(pos, false);
            world.createExplosion(null, world.getDamageSources().explosion(null), null, vec3d, 2.0F, true, World.ExplosionSourceType.BLOCK);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
