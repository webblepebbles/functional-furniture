package net.bloffo.fatalfurniture;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.bloffo.fatalfurniture.block.entity.ModBlockEntities;
import net.bloffo.fatalfurniture.block.entity.renderer.TableBlockEntityRenderer;
import net.bloffo.fatalfurniture.entity.ModEntities;
import net.bloffo.fatalfurniture.entity.client.ChairRenderer;
import net.bloffo.fatalfurniture.entity.client.CushionRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class    FatalFurnitureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
        EntityRendererRegistry.register(ModEntities.CUSHION, CushionRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.TABLE_BE, TableBlockEntityRenderer::new);
    }
}
