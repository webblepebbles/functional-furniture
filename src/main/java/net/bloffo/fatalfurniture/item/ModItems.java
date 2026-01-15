package net.bloffo.fatalfurniture.item;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FatalFurniture.MOD_ID, name), item);
    }
    public static void registerModItems() {
        FatalFurniture.LOGGER.info("Registering mod items for " + FatalFurniture.MOD_ID);
    }
}
