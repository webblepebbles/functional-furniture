package net.bloffo.fatalfurniture.util;

import net.minecraft.block.Block;
import net.bloffo.fatalfurniture.FatalFurniture;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> COUCH = createTag("couch");
        public static final TagKey<Block> CUSHION = createTag("cushion");
        public static final TagKey<Block> POUFFE = createTag("pouffe");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FatalFurniture.MOD_ID, name));
        }
    }
}
