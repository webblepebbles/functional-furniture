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
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.VELVET_COUCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.JADE_COUCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.NAVY_COUCH);
        blockStateModelGenerator.registerGeneric(ModBlocks.LAMP);
        blockStateModelGenerator.registerGeneric(ModBlocks.VELVET_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.NAVY_CUSHION);
        blockStateModelGenerator.registerGeneric(ModBlocks.JADE_CUSHION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
