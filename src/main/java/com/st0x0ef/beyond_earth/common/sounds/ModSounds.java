package com.st0x0ef.beyond_earth.common.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;

public class ModSounds {
    public static SoundEvent ROCKET_SOUND = registerSoundEvent("rocket_fly");
    public static SoundEvent BOOST_SOUND = registerSoundEvent("boost");
    public static SoundEvent BEEP_SOUND = registerSoundEvent("beep");
    public static SoundEvent SONIC_BOOM_SOUND = registerSoundEvent("sonic_boom");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BeyondEarth.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds(){
        BeyondEarth.LOGGER.info("Registering sounds for " + BeyondEarth.MOD_ID);
    }
}
