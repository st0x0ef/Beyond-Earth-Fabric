package com.st0x0ef.beyond_earth.common.particles.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ExplosionSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class SmallSmokeParticle extends ExplosionSmokeParticle {
    protected SmallSmokeParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ, spriteProvider);
        this.gravityStrength = 2.5F;
        this.scale(0.5f);
    }

    public void tick() {
        super.tick();
        this.velocityY -= 0.004D + 0.04D * (double)this.gravityStrength;
    }

    @Environment(EnvType.CLIENT)
    public static class ParticleFactory implements net.minecraft.client.particle.ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteSet;

        public ParticleFactory(SpriteProvider spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new SmallSmokeParticle(world, x, y, z, velocityX, velocityY, velocityZ, spriteSet);
        }
    }
}
