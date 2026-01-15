package net.bloffo.fatalfurniture;

import net.bloffo.fatalfurniture.entity.ModEntities;
import net.bloffo.fatalfurniture.entity.client.ChairRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class FatalFurnitureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
    }
}
