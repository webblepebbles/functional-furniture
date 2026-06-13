package net.bloffo.fatalfurniture.block.entity.renderer;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.bloffo.fatalfurniture.block.entity.custom.NookBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class NookBlockEntityRenderer implements BlockEntityRenderer<NookBlockEntity> {
    public NookBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(NookBlockEntity entity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null)
            return;
        BlockState state = world.getBlockState(entity.getPos());
        if (!state.contains(HorizontalFacingBlock.FACING))
            return;
        Direction facing = state.get(HorizontalFacingBlock.FACING);

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getStack(0);

        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.scale(0.5f, 0.5f, 0.5f);
        float yRot = switch (facing) {
            case NORTH -> 180f;
            case WEST -> 270f;
            case EAST -> 90f;
            default -> 0f;
        };
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yRot));

        itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
