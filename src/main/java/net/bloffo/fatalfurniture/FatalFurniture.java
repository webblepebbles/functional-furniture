package net.bloffo.fatalfurniture;

import net.bloffo.fatalfurniture.block.ModBlocks;
import net.bloffo.fatalfurniture.block.entity.ModBlockEntities;
import net.bloffo.fatalfurniture.component.ModDataComponentTypes;
import net.bloffo.fatalfurniture.entity.ModEntities;
import net.bloffo.fatalfurniture.item.ModItems;
import net.bloffo.fatalfurniture.screen.ModScreenHandlers;
import net.bloffo.fatalfurniture.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.SharedConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FatalFurniture implements ModInitializer {
	public static final String MOD_ID = "fatalfurniture";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModScreenHandlers.registerScreenHandlers();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModBlockEntities.registerBlockEntities();
		ModSounds.registersounds();
		ModDataComponentTypes.registerDataComponentTypes();
	}
}