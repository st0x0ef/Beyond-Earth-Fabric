package com.st0x0ef.beyond_earth.common.particles.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class VenusRainParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteSet;
    private final float angularVelocity;
    private final float angularAcceleration;
    protected VenusRainParticle(ClientWorld clientWorld, double d, double e, double f, SpriteProvider spriteSet) {
        super(clientWorld, d, e, f);
        this.spriteSet = spriteSet;
        this.scale *= 1F;
        this.collidesWithWorld = true;
        this.angularVelocity = 0.1F;
        this.angularAcceleration = 0.01F;
        this.velocityX *= 0.3D;
        this.velocityY = Math.random() * 0.2D + 0.1D;
        this.velocityZ *= 0.3D;
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.gravityStrength = 0.06F;
        this.age = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.setSprite(spriteSet);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age-- <= 0) {
            this.markDead();
        } else {
            this.velocityY -= this.gravityStrength;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= 0.98D;
            this.velocityY *= 0.98D;
            this.velocityZ *= 0.98D;
            if (this.onGround) {
                if (Math.random() < 0.5D) {
                    this.markDead();
                }

                this.velocityX *= 0.7D;
                this.velocityZ *= 0.7D;
            }

            BlockPos blockpos = new BlockPos((int)this.x, (int)this.y, (int)this.z);
            double d0 = Math.max(this.world.getBlockState(blockpos).getCollisionShape(this.world, blockpos).getEndingCoord(Direction.Axis.Y, this.x - (double)blockpos.getX(), this.z - (double)blockpos.getZ()), this.world.getFluidState(blockpos).getHeight(this.world, blockpos));
            if (d0 > 0.0D && this.y < (double)blockpos.getY() + d0) {
                this.markDead();
            }
        }
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
            return new VenusRainParticle(world, x, y, z, spriteSet);
        }
    }
}
