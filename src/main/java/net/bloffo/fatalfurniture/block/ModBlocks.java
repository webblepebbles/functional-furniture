package net.bloffo.fatalfurniture.block;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.custom.*;
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
    public static final Block WHITE_COUCH = registerBlock("white_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.WHITE)));
    public static final Block BLACK_COUCH = registerBlock("black_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLACK)));
    public static final Block GRAY_COUCH = registerBlock("gray_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GRAY)));
    public static final Block LIGHT_GRAY_COUCH = registerBlock("light_gray_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIGHT_GRAY)));
    public static final Block BROWN_COUCH = registerBlock("brown_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BROWN)));
    public static final Block RED_COUCH = registerBlock("red_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.RED)));
    public static final Block ORANGE_COUCH = registerBlock("orange_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.ORANGE)));
    public static final Block YELLOW_COUCH = registerBlock("yellow_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.YELLOW)));
    public static final Block LIME_COUCH = registerBlock("lime_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIME)));
    public static final Block GREEN_COUCH = registerBlock("green_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GREEN)));
    public static final Block BLUE_COUCH = registerBlock("blue_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLUE)));
    public static final Block LIGHT_BLUE_COUCH = registerBlock("light_blue_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIGHT_BLUE)));
    public static final Block PURPLE_COUCH = registerBlock("purple_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.PURPLE)));
    public static final Block MAGENTA_COUCH = registerBlock("magenta_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.MAGENTA)));
    public static final Block PINK_COUCH = registerBlock("pink_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.PINK)));
    public static final Block CYAN_COUCH = registerBlock("cyan_couch", new CouchBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.CYAN)));

    public static final Block LAMP = registerBlock("lamp", new LampBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1f).luminance(State -> State.get(LampBlock.ON) ? 12 : 0).sounds(BlockSoundGroup.WOOD)));
    public static final Block RIGGEDLAMP = registerBlock("riggedlamp", new RiggedLampBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1f).sounds(BlockSoundGroup.WOOD)));

    public static final Block TABLE = registerBlock("table", new TableBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOD).mapColor(DyeColor.BROWN)));

    public static final Block WHITE_CUSHION = registerBlock("white_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.WHITE)));
    public static final Block BLACK_CUSHION = registerBlock("black_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLACK)));
    public static final Block GRAY_CUSHION = registerBlock("gray_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GRAY)));
    public static final Block LIGHT_GRAY_CUSHION = registerBlock("light_gray_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIGHT_GRAY)));
    public static final Block BROWN_CUSHION = registerBlock("brown_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BROWN)));
    public static final Block RED_CUSHION = registerBlock("red_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.RED)));
    public static final Block ORANGE_CUSHION = registerBlock("orange_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.ORANGE)));
    public static final Block YELLOW_CUSHION = registerBlock("yellow_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.YELLOW)));
    public static final Block LIME_CUSHION = registerBlock("lime_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIME)));
    public static final Block GREEN_CUSHION = registerBlock("green_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GREEN)));
    public static final Block BLUE_CUSHION = registerBlock("blue_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLUE)));
    public static final Block LIGHT_BLUE_CUSHION = registerBlock("light_blue_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIGHT_BLUE)));
    public static final Block PURPLE_CUSHION = registerBlock("purple_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.PURPLE)));
    public static final Block MAGENTA_CUSHION = registerBlock("magenta_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.MAGENTA)));
    public static final Block PINK_CUSHION = registerBlock("pink_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.PINK)));
    public static final Block CYAN_CUSHION = registerBlock("cyan_cushion", new CushionBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.CYAN)));

    public static final Block WHITE_POUFFE = registerBlock("white_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.WHITE)));
    public static final Block BLACK_POUFFE = registerBlock("black_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLACK)));
    public static final Block GRAY_POUFFE = registerBlock("gray_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GRAY)));
    public static final Block LIGHT_GRAY_POUFFE = registerBlock("light_gray_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIGHT_GRAY)));
    public static final Block BROWN_POUFFE = registerBlock("brown_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BROWN)));
    public static final Block RED_POUFFE = registerBlock("red_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.RED)));
    public static final Block ORANGE_POUFFE = registerBlock("orange_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.ORANGE)));
    public static final Block YELLOW_POUFFE = registerBlock("yellow_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.YELLOW)));
    public static final Block LIME_POUFFE = registerBlock("lime_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIME)));
    public static final Block GREEN_POUFFE = registerBlock("green_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.GREEN)));
    public static final Block BLUE_POUFFE = registerBlock("blue_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.BLUE)));
    public static final Block LIGHT_BLUE_POUFFE = registerBlock("light_blue_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.LIGHT_BLUE)));
    public static final Block PURPLE_POUFFE = registerBlock("purple_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.PURPLE)));
    public static final Block MAGENTA_POUFFE = registerBlock("magenta_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.MAGENTA)));
    public static final Block PINK_POUFFE = registerBlock("pink_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.PINK)));
    public static final Block CYAN_POUFFE = registerBlock("cyan_pouffe", new PouffeBlock(AbstractBlock.Settings.create()
            .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.CYAN)));

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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(WHITE_COUCH);
            entries.add(WHITE_CUSHION);
            entries.add(WHITE_POUFFE);
            entries.add(LIGHT_GRAY_COUCH);
            entries.add(LIGHT_GRAY_CUSHION);
            entries.add(LIGHT_GRAY_POUFFE);
            entries.add(GRAY_COUCH);
            entries.add(GRAY_CUSHION);
            entries.add(GRAY_POUFFE);
            entries.add(BLACK_COUCH);
            entries.add(BLACK_CUSHION);
            entries.add(BLACK_POUFFE);
            entries.add(BROWN_COUCH);
            entries.add(BROWN_CUSHION);
            entries.add(BROWN_POUFFE);
            entries.add(RED_COUCH);
            entries.add(RED_CUSHION);
            entries.add(RED_POUFFE);
            entries.add(ORANGE_COUCH);
            entries.add(ORANGE_CUSHION);
            entries.add(ORANGE_POUFFE);
            entries.add(YELLOW_COUCH);
            entries.add(YELLOW_CUSHION);
            entries.add(YELLOW_POUFFE);
            entries.add(LIME_COUCH);
            entries.add(LIME_CUSHION);
            entries.add(LIME_POUFFE);
            entries.add(GREEN_COUCH);
            entries.add(GREEN_CUSHION);
            entries.add(GREEN_POUFFE);
            entries.add(CYAN_COUCH);
            entries.add(CYAN_CUSHION);
            entries.add(CYAN_POUFFE);
            entries.add(LIGHT_BLUE_COUCH);
            entries.add(LIGHT_BLUE_CUSHION);
            entries.add(LIGHT_BLUE_POUFFE);
            entries.add(BLUE_COUCH);
            entries.add(BLUE_CUSHION);
            entries.add(BLUE_POUFFE);
            entries.add(PURPLE_COUCH);
            entries.add(PURPLE_CUSHION);
            entries.add(PURPLE_POUFFE);
            entries.add(MAGENTA_COUCH);
            entries.add(MAGENTA_CUSHION);
            entries.add(MAGENTA_POUFFE);
            entries.add(PINK_COUCH);
            entries.add(PINK_CUSHION);
            entries.add(PINK_POUFFE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(LAMP);
            entries.add(TABLE);
        });
    }
}