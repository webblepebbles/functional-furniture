package net.bloffo.fatalfurniture.entity;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.bloffo.fatalfurniture.entity.custom.ChairEntity;
import net.bloffo.fatalfurniture.entity.custom.CushionEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ChairEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(FatalFurniture.MOD_ID, "chair_entity"),
            EntityType.Builder.create(ChairEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build());
    public static final EntityType<CushionEntity> CUSHION = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(FatalFurniture.MOD_ID, "cushion_entity"),
            EntityType.Builder.create(CushionEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.15f).build());

    public static void registerModEntities() {
        FatalFurniture.LOGGER.info("registering entities");
    }
}
