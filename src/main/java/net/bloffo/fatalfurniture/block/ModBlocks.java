package net.bloffo.fatalfurniture.block;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.custom.CouchBlock;
import net.bloffo.fatalfurniture.block.custom.TrimBlock;
import net.bloffo.fatalfurniture.block.custom.mediumTableDeco;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block VELVET_COUCH = registerBlock("velvet_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(2f).sounds(BlockSoundGroup.WOOL)));
    public static final Block JADE_COUCH = registerBlock("jade_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(2f).sounds(BlockSoundGroup.WOOL)));
    public static final Block NAVY_COUCH = registerBlock("navy_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(2f).sounds(BlockSoundGroup.WOOL)));
    public static final Block TABLE = registerBlock("table", new Block(AbstractBlock.Settings.create().nonOpaque().strength(2f)));
    public static final Block LAMP = registerBlock("lamp", new mediumTableDeco(AbstractBlock.Settings.create().nonOpaque().strength(1f).luminance(State -> 12)));
    public static final Block GOLD_TRIM = registerBlock("gold_trim", new TrimBlock(AbstractBlock.Settings.create().nonOpaque().strength(3f).sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FatalFurniture.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FatalFurniture.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FatalFurniture.LOGGER.info("registers blocks for" + FatalFurniture.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(VELVET_COUCH);
            entries.add(JADE_COUCH);
            entries.add(NAVY_COUCH);
            entries.add(TABLE);
            entries.add(LAMP);
            entries.add(GOLD_TRIM);
        });

    }
}