package com.st0x0ef.beyond_earth.common.particles;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType LARGE_FLAME_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType LARGE_SMOKE_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SMALL_FLAME_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SMALL_SMOKE_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType VENUS_RAIN_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(BeyondEarth.MOD_ID, "large_flame"),
                LARGE_FLAME_PARTICLE);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(BeyondEarth.MOD_ID, "large_smoke"),
                LARGE_SMOKE_PARTICLE);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(BeyondEarth.MOD_ID, "small_flame"),
                SMALL_FLAME_PARTICLE);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(BeyondEarth.MOD_ID, "small_smoke"),
                SMALL_SMOKE_PARTICLE);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(BeyondEarth.MOD_ID, "venus_rain"),
                VENUS_RAIN_PARTICLE);
    }
}
