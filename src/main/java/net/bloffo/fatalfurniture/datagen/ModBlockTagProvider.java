package net.bloffo.fatalfurniture.datagen;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.bloffo.fatalfurniture.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ModBlocks.WHITE_COUCH)
                .add(ModBlocks.WHITE_CUSHION)
                .add(ModBlocks.WHITE_POUFFE)
                .add(ModBlocks.LIGHT_GRAY_COUCH)
                .add(ModBlocks.LIGHT_GRAY_CUSHION)
                .add(ModBlocks.LIGHT_GRAY_POUFFE)
                .add(ModBlocks.GRAY_COUCH)
                .add(ModBlocks.GRAY_CUSHION)
                .add(ModBlocks.GRAY_POUFFE)
                .add(ModBlocks.BLACK_COUCH)
                .add(ModBlocks.BLACK_CUSHION)
                .add(ModBlocks.BLACK_POUFFE)
                .add(ModBlocks.BROWN_COUCH)
                .add(ModBlocks.BROWN_CUSHION)
                .add(ModBlocks.BROWN_POUFFE)
                .add(ModBlocks.RED_COUCH)
                .add(ModBlocks.RED_CUSHION)
                .add(ModBlocks.RED_POUFFE)
                .add(ModBlocks.ORANGE_COUCH)
                .add(ModBlocks.ORANGE_CUSHION)
                .add(ModBlocks.ORANGE_POUFFE)
                .add(ModBlocks.YELLOW_COUCH)
                .add(ModBlocks.YELLOW_CUSHION)
                .add(ModBlocks.YELLOW_POUFFE)
                .add(ModBlocks.LIME_COUCH)
                .add(ModBlocks.LIME_CUSHION)
                .add(ModBlocks.LIME_POUFFE)
                .add(ModBlocks.GREEN_COUCH)
                .add(ModBlocks.GREEN_CUSHION)
                .add(ModBlocks.GREEN_POUFFE)
                .add(ModBlocks.CYAN_COUCH)
                .add(ModBlocks.CYAN_CUSHION)
                .add(ModBlocks.CYAN_POUFFE)
                .add(ModBlocks.LIGHT_BLUE_COUCH)
                .add(ModBlocks.LIGHT_BLUE_CUSHION)
                .add(ModBlocks.LIGHT_BLUE_POUFFE)
                .add(ModBlocks.BLUE_COUCH)
                .add(ModBlocks.BLUE_CUSHION)
                .add(ModBlocks.BLUE_POUFFE)
                .add(ModBlocks.PURPLE_COUCH)
                .add(ModBlocks.PURPLE_CUSHION)
                .add(ModBlocks.PURPLE_POUFFE)
                .add(ModBlocks.MAGENTA_COUCH)
                .add(ModBlocks.MAGENTA_CUSHION)
                .add(ModBlocks.MAGENTA_POUFFE)
                .add(ModBlocks.PINK_COUCH)
                .add(ModBlocks.PINK_CUSHION)
                .add(ModBlocks.PINK_POUFFE);
        getOrCreateTagBuilder(ModTags.Blocks.COUCH)
                .add(ModBlocks.WHITE_COUCH)
                .add(ModBlocks.LIGHT_GRAY_COUCH)
                .add(ModBlocks.GRAY_COUCH)
                .add(ModBlocks.BLACK_COUCH)
                .add(ModBlocks.BROWN_COUCH)
                .add(ModBlocks.RED_COUCH)
                .add(ModBlocks.ORANGE_COUCH)
                .add(ModBlocks.YELLOW_COUCH)
                .add(ModBlocks.LIME_COUCH)
                .add(ModBlocks.GREEN_COUCH)
                .add(ModBlocks.CYAN_COUCH)
                .add(ModBlocks.LIGHT_BLUE_COUCH)
                .add(ModBlocks.BLUE_COUCH)
                .add(ModBlocks.PURPLE_COUCH)
                .add(ModBlocks.MAGENTA_COUCH)
                .add(ModBlocks.PINK_COUCH);
        getOrCreateTagBuilder(ModTags.Blocks.CUSHION)
                .add(ModBlocks.WHITE_CUSHION)
                .add(ModBlocks.LIGHT_GRAY_CUSHION)
                .add(ModBlocks.GRAY_CUSHION)
                .add(ModBlocks.BLACK_CUSHION)
                .add(ModBlocks.BROWN_CUSHION)
                .add(ModBlocks.RED_CUSHION)
                .add(ModBlocks.ORANGE_CUSHION)
                .add(ModBlocks.YELLOW_CUSHION)
                .add(ModBlocks.LIME_CUSHION)
                .add(ModBlocks.GREEN_CUSHION)
                .add(ModBlocks.CYAN_CUSHION)
                .add(ModBlocks.LIGHT_BLUE_CUSHION)
                .add(ModBlocks.BLUE_CUSHION)
                .add(ModBlocks.PURPLE_CUSHION)
                .add(ModBlocks.MAGENTA_CUSHION)
                .add(ModBlocks.PINK_CUSHION);
        getOrCreateTagBuilder(ModTags.Blocks.POUFFE)
                .add(ModBlocks.WHITE_POUFFE)
                .add(ModBlocks.LIGHT_GRAY_POUFFE)
                .add(ModBlocks.GRAY_POUFFE)
                .add(ModBlocks.BLACK_POUFFE)
                .add(ModBlocks.BROWN_POUFFE)
                .add(ModBlocks.RED_POUFFE)
                .add(ModBlocks.ORANGE_POUFFE)
                .add(ModBlocks.YELLOW_POUFFE)
                .add(ModBlocks.LIME_POUFFE)
                .add(ModBlocks.GREEN_POUFFE)
                .add(ModBlocks.CYAN_POUFFE)
                .add(ModBlocks.LIGHT_BLUE_POUFFE)
                .add(ModBlocks.BLUE_POUFFE)
                .add(ModBlocks.PURPLE_POUFFE)
                .add(ModBlocks.MAGENTA_POUFFE)
                .add(ModBlocks.PINK_POUFFE);
    }
}
