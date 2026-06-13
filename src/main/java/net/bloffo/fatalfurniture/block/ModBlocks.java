package net.bloffo.fatalfurniture.block;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModBlocks {
        public static final Block WHITE_COUCH = registerBlock("white_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.WHITE)));
        public static final Block BLACK_COUCH = registerBlock("black_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BLACK)));
        public static final Block GRAY_COUCH = registerBlock("gray_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.GRAY)));
        public static final Block LIGHT_GRAY_COUCH = registerBlock("light_gray_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIGHT_GRAY)));
        public static final Block BROWN_COUCH = registerBlock("brown_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BROWN)));
        public static final Block RED_COUCH = registerBlock("red_couch", new CouchBlock(AbstractBlock.Settings.create()
                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL).mapColor(DyeColor.RED)));
        public static final Block ORANGE_COUCH = registerBlock("orange_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.ORANGE)));
        public static final Block YELLOW_COUCH = registerBlock("yellow_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.YELLOW)));
        public static final Block LIME_COUCH = registerBlock("lime_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIME)));
        public static final Block GREEN_COUCH = registerBlock("green_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.GREEN)));
        public static final Block BLUE_COUCH = registerBlock("blue_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BLUE)));
        public static final Block LIGHT_BLUE_COUCH = registerBlock("light_blue_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIGHT_BLUE)));
        public static final Block PURPLE_COUCH = registerBlock("purple_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.PURPLE)));
        public static final Block MAGENTA_COUCH = registerBlock("magenta_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.MAGENTA)));
        public static final Block PINK_COUCH = registerBlock("pink_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.PINK)));
        public static final Block CYAN_COUCH = registerBlock("cyan_couch",
                        new CouchBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.CYAN)));

        public static final Block LAMP = registerBlock("lamp", new LampBlock(AbstractBlock.Settings.create()
                        .nonOpaque().strength(1f).luminance(State -> State.get(LampBlock.ON) ? 12 : 0)
                        .sounds(BlockSoundGroup.WOOD)));
        public static final Block RIGGEDLAMP = registerBlock("riggedlamp",
                        new RiggedLampBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1f).sounds(BlockSoundGroup.WOOD)));
        public static final Block TABLE = registerBlock("table", new TableBlock(AbstractBlock.Settings.create()
                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOD).mapColor(DyeColor.BROWN)));
        public static final Block CANDLE_STICK = registerBlock("candle_stick",
                        new CandleStickBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(2.0f).sounds(BlockSoundGroup.METAL)
                                        .mapColor(MapColor.IRON_GRAY)),
                        new Item.Settings().attributeModifiers(
                                        SwordItem.createAttributeModifiers(ToolMaterials.IRON, 4, -3.0f)));

        public static final Block WHITE_CUSHION = registerBlock("white_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.WHITE)));
        public static final Block BLACK_CUSHION = registerBlock("black_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BLACK)));
        public static final Block GRAY_CUSHION = registerBlock("gray_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.GRAY)));
        public static final Block LIGHT_GRAY_CUSHION = registerBlock("light_gray_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIGHT_GRAY)));
        public static final Block BROWN_CUSHION = registerBlock("brown_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BROWN)));
        public static final Block RED_CUSHION = registerBlock("red_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.RED)));
        public static final Block ORANGE_CUSHION = registerBlock("orange_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.ORANGE)));
        public static final Block YELLOW_CUSHION = registerBlock("yellow_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.YELLOW)));
        public static final Block LIME_CUSHION = registerBlock("lime_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIME)));
        public static final Block GREEN_CUSHION = registerBlock("green_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.GREEN)));
        public static final Block BLUE_CUSHION = registerBlock("blue_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BLUE)));
        public static final Block LIGHT_BLUE_CUSHION = registerBlock("light_blue_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIGHT_BLUE)));
        public static final Block PURPLE_CUSHION = registerBlock("purple_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.PURPLE)));
        public static final Block MAGENTA_CUSHION = registerBlock("magenta_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.MAGENTA)));
        public static final Block PINK_CUSHION = registerBlock("pink_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.PINK)));
        public static final Block CYAN_CUSHION = registerBlock("cyan_cushion",
                        new CushionBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.CYAN)));

        public static final Block WHITE_POUFFE = registerBlock("white_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.WHITE)));
        public static final Block BLACK_POUFFE = registerBlock("black_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BLACK)));
        public static final Block GRAY_POUFFE = registerBlock("gray_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.GRAY)));
        public static final Block LIGHT_GRAY_POUFFE = registerBlock("light_gray_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIGHT_GRAY)));
        public static final Block BROWN_POUFFE = registerBlock("brown_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BROWN)));
        public static final Block RED_POUFFE = registerBlock("red_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.RED)));
        public static final Block ORANGE_POUFFE = registerBlock("orange_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.ORANGE)));
        public static final Block YELLOW_POUFFE = registerBlock("yellow_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.YELLOW)));
        public static final Block LIME_POUFFE = registerBlock("lime_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIME)));
        public static final Block GREEN_POUFFE = registerBlock("green_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.GREEN)));
        public static final Block BLUE_POUFFE = registerBlock("blue_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.BLUE)));
        public static final Block LIGHT_BLUE_POUFFE = registerBlock("light_blue_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.LIGHT_BLUE)));
        public static final Block PURPLE_POUFFE = registerBlock("purple_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.PURPLE)));
        public static final Block MAGENTA_POUFFE = registerBlock("magenta_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.MAGENTA)));
        public static final Block PINK_POUFFE = registerBlock("pink_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.PINK)));
        public static final Block CYAN_POUFFE = registerBlock("cyan_pouffe",
                        new PouffeBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.5f).sounds(BlockSoundGroup.WOOL)
                                        .mapColor(DyeColor.CYAN)));

        public static final Block OAK_NOOK = registerBlock("oak_nook", new NookBlock(AbstractBlock.Settings.create()
                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN)));
        public static final Block BIRCH_NOOK = registerBlock("birch_nook", new NookBlock(AbstractBlock.Settings.create()
                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PALE_YELLOW)));
        public static final Block DARK_OAK_NOOK = registerBlock("dark_oak_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.BROWN)));
        public static final Block SPRUCE_NOOK = registerBlock("spruce_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.SPRUCE_BROWN)));
        public static final Block JUNGLE_NOOK = registerBlock("jungle_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.DIRT_BROWN)));
        public static final Block ACACIA_NOOK = registerBlock("acacia_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.ORANGE)));
        public static final Block MANGROVE_NOOK = registerBlock("mangrove_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.RED)));
        public static final Block WARPED_NOOK = registerBlock("warped_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.NETHER_WOOD)
                                        .mapColor(MapColor.DARK_AQUA)));
        public static final Block CRIMSON_NOOK = registerBlock("crimson_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.NETHER_WOOD)
                                        .mapColor(MapColor.DULL_PINK)));
        public static final Block BAMBOO_NOOK = registerBlock("bamboo_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.BAMBOO_WOOD)
                                        .mapColor(MapColor.YELLOW)));
        public static final Block CHERRY_NOOK = registerBlock("cherry_nook",
                        new NookBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.CHERRY_WOOD)
                                        .mapColor(MapColor.TERRACOTTA_WHITE)));

        public static final Block OAK_DRAWERS = registerBlock("oak_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.OAK_TAN)));
        public static final Block BIRCH_DRAWERS = registerBlock("birch_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.PALE_YELLOW)));
        public static final Block DARK_OAK_DRAWERS = registerBlock("dark_oak_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.BROWN)));
        public static final Block SPRUCE_DRAWERS = registerBlock("spruce_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.SPRUCE_BROWN)));
        public static final Block JUNGLE_DRAWERS = registerBlock("jungle_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.DIRT_BROWN)));
        public static final Block ACACIA_DRAWERS = registerBlock("acacia_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.ORANGE)));
        public static final Block MANGROVE_DRAWERS = registerBlock("mangrove_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.WOOD)
                                        .mapColor(MapColor.RED)));
        public static final Block WARPED_DRAWERS = registerBlock("warped_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.NETHER_WOOD)
                                        .mapColor(MapColor.DARK_AQUA)));
        public static final Block CRIMSON_DRAWERS = registerBlock("crimson_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.NETHER_WOOD)
                                        .mapColor(MapColor.DULL_PINK)));
        public static final Block BAMBOO_DRAWERS = registerBlock("bamboo_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.BAMBOO_WOOD)
                                        .mapColor(MapColor.YELLOW)));
        public static final Block CHERRY_DRAWERS = registerBlock("cherry_drawers",
                        new DrawersBlock(AbstractBlock.Settings.create()
                                        .nonOpaque().strength(1.75f).sounds(BlockSoundGroup.CHERRY_WOOD)
                                        .mapColor(MapColor.TERRACOTTA_WHITE)));

        private static Block registerBlock(String name, Block block) {
                registerBlockItem(name, block);
                return Registry.register(Registries.BLOCK, Identifier.of(FatalFurniture.MOD_ID, name), block);
        }

        private static Block registerBlock(String name, Block block, Item.Settings settings) {
                registerBlockItem(name, block, settings);
                return Registry.register(Registries.BLOCK, Identifier.of(FatalFurniture.MOD_ID, name), block);
        }

        private static void registerBlockItem(String name, Block block) {
                Registry.register(Registries.ITEM, Identifier.of(FatalFurniture.MOD_ID, name),
                                new BlockItem(block, new Item.Settings()));
        }

        private static void registerBlockItem(String name, Block block, Item.Settings settings) {
                Registry.register(Registries.ITEM, Identifier.of(FatalFurniture.MOD_ID, name),
                                new BlockItem(block, settings));
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
                        entries.add(RIGGEDLAMP);
                        entries.add(LAMP);
                        entries.add(TABLE);
                        entries.add(CANDLE_STICK);
                        entries.add(OAK_NOOK);
                        entries.add(BIRCH_NOOK);
                        entries.add(DARK_OAK_NOOK);
                        entries.add(SPRUCE_NOOK);
                        entries.add(JUNGLE_NOOK);
                        entries.add(ACACIA_NOOK);
                        entries.add(MANGROVE_NOOK);
                        entries.add(CRIMSON_NOOK);
                        entries.add(WARPED_NOOK);
                        entries.add(BAMBOO_NOOK);
                        entries.add(CHERRY_NOOK);
                        entries.add(OAK_DRAWERS);
                        entries.add(BIRCH_DRAWERS);
                        entries.add(DARK_OAK_DRAWERS);
                        entries.add(SPRUCE_DRAWERS);
                        entries.add(JUNGLE_DRAWERS);
                        entries.add(ACACIA_DRAWERS);
                        entries.add(MANGROVE_DRAWERS);
                        entries.add(CRIMSON_DRAWERS);
                        entries.add(WARPED_DRAWERS);
                        entries.add(BAMBOO_DRAWERS);
                        entries.add(CHERRY_DRAWERS);
                });
        }
}