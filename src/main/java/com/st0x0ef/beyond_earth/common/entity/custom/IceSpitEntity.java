package com.st0x0ef.beyond_earth.common.entity.custom;

import com.st0x0ef.beyond_earth.common.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IceSpitEntity extends ArrowEntity implements FlyingItemEntity {
    public IceSpitEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ItemStack getStack() {
        return new ItemStack(ModItems.ICE_SHARD);
    }

    @Nullable
    @Override
    public ItemStack getPickBlockStack() {
        return new ItemStack(ModItems.ICE_SHARD);
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        target.setStuckArrowCount(target.getStuckArrowCount() - 1);
    }

    @Override
    public void tick() {
        super.tick();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Vec3d vec = this.getVelocity();

        this.getWorld().addParticle(ParticleTypes.SPIT, x - vec.x, y - vec.y, z - vec.z, 0, 0.001, 0);
        this.getWorld().addParticle(ParticleTypes.ITEM_SNOWBALL, x - vec.x, y - vec.y, z - vec.z, 0, 0.001, 0);

        if (this.inGround) {
            if (!this.getWorld().isClient()) {
                this.remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }
}
