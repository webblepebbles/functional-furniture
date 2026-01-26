package net.bloffo.fatalfurniture.block;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.custom.CouchBlock;
import net.bloffo.fatalfurniture.block.custom.CushionBlock;
import net.bloffo.fatalfurniture.block.custom.RagBlock;
import net.bloffo.fatalfurniture.block.custom.mediumTableDeco;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block VELVET_COUCH = registerBlock("velvet_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(2f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.RED)));
    public static final Block JADE_COUCH = registerBlock("jade_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(2f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GREEN)));
    public static final Block NAVY_COUCH = registerBlock("navy_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(2f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLUE)));
    public static final Block LAMP = registerBlock("lamp", new mediumTableDeco(AbstractBlock.Settings.create().nonOpaque().strength(1f).luminance(State -> 12)));
    public static final Block VELVET_CUSHION = registerBlock("velvet_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.RED)));
    public static final Block JADE_CUSHION = registerBlock("jade_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GREEN)));
    public static final Block NAVY_CUSHION = registerBlock("navy_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLUE)));
    public static final Block RAG = registerBlock("rag", new RagBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.PALE_YELLOW).nonOpaque().sounds(BlockSoundGroup.WOOL).strength(1f).noCollision().burnable().pistonBehavior(PistonBehavior.DESTROY)));

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
            entries.add(VELVET_CUSHION);
            entries.add(JADE_COUCH);
            entries.add(JADE_CUSHION);
            entries.add(NAVY_COUCH);
            entries.add(NAVY_CUSHION);
            entries.add(LAMP);
            entries.add(RAG);
        });

    }
}