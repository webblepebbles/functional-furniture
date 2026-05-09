package net.bloffo.fatalfurniture.block.entity;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.ModBlocks;
import net.bloffo.fatalfurniture.block.entity.custom.NookBlockEntity;
import net.bloffo.fatalfurniture.block.entity.custom.TableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<TableBlockEntity> TABLE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FatalFurniture.MOD_ID, "table_be"),
                    BlockEntityType.Builder.create(TableBlockEntity::new, ModBlocks.TABLE).build(null));
    public static final BlockEntityType<NookBlockEntity> NOOK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FatalFurniture.MOD_ID, "nook_be"),
                    BlockEntityType.Builder.create(NookBlockEntity::new, ModBlocks.OAK_NOOK, ModBlocks.BIRCH_NOOK, ModBlocks.DARK_OAK_NOOK, ModBlocks.SPRUCE_NOOK, ModBlocks.JUNGLE_NOOK, ModBlocks.ACACIA_NOOK, ModBlocks.MANGROVE_NOOK, ModBlocks.WARPED_NOOK, ModBlocks.CRIMSON_NOOK, ModBlocks.BAMBOO_NOOK, ModBlocks.CHERRY_NOOK).build(null));

    public static void registerBlockEntities() {
    }
}
