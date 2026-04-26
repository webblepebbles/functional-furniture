package net.bloffo.fatalfurniture.item;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.item.custom.KnifeItem;
import net.bloffo.fatalfurniture.item.custom.WirecutterItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item WIRECUTTERS = registerItem("wirecutters", new WirecutterItem(new Item.Settings().maxDamage(32).maxCount(1)));
    public static final Item KNIFE = registerItem("knife", new KnifeItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -1.0f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FatalFurniture.MOD_ID, name), item);
    }
    public static void registerModItems() {
        FatalFurniture.LOGGER.info("Registering mod items for " + FatalFurniture.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(WIRECUTTERS);
            entries.add(KNIFE);
        });
    }
}
