package net.bloffo.fatalfurniture.datagen;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.WHITE_POUFFE);
        addDrop(ModBlocks.WHITE_CUSHION);
        addDrop(ModBlocks.WHITE_COUCH);
        addDrop(ModBlocks.LIGHT_GRAY_POUFFE);
        addDrop(ModBlocks.LIGHT_GRAY_CUSHION);
        addDrop(ModBlocks.LIGHT_GRAY_COUCH);
        addDrop(ModBlocks.GRAY_POUFFE);
        addDrop(ModBlocks.GRAY_CUSHION);
        addDrop(ModBlocks.GRAY_COUCH);
        addDrop(ModBlocks.BLACK_POUFFE);
        addDrop(ModBlocks.BLACK_CUSHION);
        addDrop(ModBlocks.BLACK_COUCH);
        addDrop(ModBlocks.BROWN_POUFFE);
        addDrop(ModBlocks.BROWN_CUSHION);
        addDrop(ModBlocks.BROWN_COUCH);
        addDrop(ModBlocks.RED_POUFFE);
        addDrop(ModBlocks.RED_CUSHION);
        addDrop(ModBlocks.RED_COUCH);
        addDrop(ModBlocks.ORANGE_POUFFE);
        addDrop(ModBlocks.ORANGE_CUSHION);
        addDrop(ModBlocks.ORANGE_COUCH);
        addDrop(ModBlocks.YELLOW_POUFFE);
        addDrop(ModBlocks.YELLOW_CUSHION);
        addDrop(ModBlocks.YELLOW_COUCH);
        addDrop(ModBlocks.LIME_POUFFE);
        addDrop(ModBlocks.LIME_CUSHION);
        addDrop(ModBlocks.LIME_COUCH);
        addDrop(ModBlocks.GREEN_POUFFE);
        addDrop(ModBlocks.GREEN_CUSHION);
        addDrop(ModBlocks.GREEN_COUCH);
        addDrop(ModBlocks.CYAN_POUFFE);
        addDrop(ModBlocks.CYAN_CUSHION);
        addDrop(ModBlocks.CYAN_COUCH);
        addDrop(ModBlocks.LIGHT_BLUE_POUFFE);
        addDrop(ModBlocks.LIGHT_BLUE_CUSHION);
        addDrop(ModBlocks.LIGHT_BLUE_COUCH);
        addDrop(ModBlocks.BLUE_POUFFE);
        addDrop(ModBlocks.BLUE_CUSHION);
        addDrop(ModBlocks.BLUE_COUCH);
        addDrop(ModBlocks.PURPLE_POUFFE);
        addDrop(ModBlocks.PURPLE_CUSHION);
        addDrop(ModBlocks.PURPLE_COUCH);
        addDrop(ModBlocks.MAGENTA_POUFFE);
        addDrop(ModBlocks.MAGENTA_CUSHION);
        addDrop(ModBlocks.MAGENTA_COUCH);
        addDrop(ModBlocks.PINK_POUFFE);
        addDrop(ModBlocks.PINK_CUSHION);
        addDrop(ModBlocks.PINK_COUCH);
        addDrop(ModBlocks.TABLE);

        addDrop(ModBlocks.LAMP);
    }
}
