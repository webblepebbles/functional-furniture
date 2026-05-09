package net.bloffo.fatalfurniture.sound;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent LAMP_CLICKS = registerSoundEvent("lamp_clicks");
    public static final SoundEvent CUSHION_RUSTLES = registerSoundEvent("cushion_rustles");
    public static final SoundEvent WIRECUTTERS_SNIP = registerSoundEvent("wirecutters_snip");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(FatalFurniture.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registersounds() {
        FatalFurniture.LOGGER.info("registering sounds for" + FatalFurniture.MOD_ID);
    }
}