package net.bloffo.fatalfurniture.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class CushionEntity extends Entity {
    public CushionEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }


    private void tickController(World world) {
        if (this.getFirstPassenger() instanceof PlayerEntity playerEntity) {
            boolean bl = playerEntity.hasStatusEffect(StatusEffects.REGENERATION);
            boolean bl2 = world.getTime() % 40L == 0L;
            if (!bl || bl2) {
                playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 0, true, true, true));
            }
        }
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        this.kill();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getEntityWorld().isClient()) {
            this.tickController(this.getEntityWorld());
        }
    }
}
