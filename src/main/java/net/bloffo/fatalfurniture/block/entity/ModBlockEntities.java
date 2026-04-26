package net.bloffo.fatalfurniture.block.entity;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.block.ModBlocks;
import net.bloffo.fatalfurniture.block.entity.custom.TableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<TableBlockEntity> TABLE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FatalFurniture.MOD_ID, "table_be"),
                    BlockEntityType.Builder.create(TableBlockEntity::new, ModBlocks.TABLE).build(null));

    public static void registerBlockEntities() {
    }
}
