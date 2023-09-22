package com.st0x0ef.beyond_earth.common.util;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import com.st0x0ef.beyond_earth.BeyondEarth;

public class ModDamageSources {
    public static final RegistryKey<DamageType> DAMAGE_SOURCE_OXYGEN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(BeyondEarth.MOD_ID, "oxygen"));

    public static final RegistryKey<DamageType> DAMAGE_SOURCE_ACID_RAIN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(BeyondEarth.MOD_ID, "venus_acid"));

    public static final RegistryKey<DamageType> DAMAGE_SOURCE_RADIATIONS = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(BeyondEarth.MOD_ID, "radiations"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }

    public static void registerDamageSources() {
        BeyondEarth.LOGGER.info("Registering damage sources for " + BeyondEarth.MOD_ID);
    }
}
