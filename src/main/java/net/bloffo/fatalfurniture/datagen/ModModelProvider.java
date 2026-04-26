package net.bloffo.fatalfurniture.datagen;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerGeneric(ModBlocks.LAMP);
        blockStateModelGenerator.registerGeneric(ModBlocks.RIGGEDLAMP);
        blockStateModelGenerator.registerGeneric(ModBlocks.TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.WHITE_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.WHITE_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LIGHT_GRAY_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIGHT_GRAY_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIGHT_GRAY_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GRAY_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.GRAY_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.GRAY_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.BLACK_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.BLACK_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BROWN_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.BROWN_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.BROWN_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RED_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.RED_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.RED_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.ORANGE_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.ORANGE_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.ORANGE_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.YELLOW_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.YELLOW_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.YELLOW_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LIME_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIME_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIME_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GREEN_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.GREEN_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.GREEN_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CYAN_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.CYAN_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.CYAN_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LIGHT_BLUE_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIGHT_BLUE_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIGHT_BLUE_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLUE_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.BLUE_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.BLUE_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PURPLE_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.PURPLE_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.PURPLE_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MAGENTA_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.MAGENTA_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.MAGENTA_POUFFE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PINK_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.PINK_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.PINK_POUFFE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
