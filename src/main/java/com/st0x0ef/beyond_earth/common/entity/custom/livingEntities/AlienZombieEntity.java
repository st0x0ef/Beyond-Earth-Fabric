package com.st0x0ef.beyond_earth.common.entity.custom.livingEntities;

import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.entity.custom.IceSpitEntity;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.alien.AlienEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class AlienZombieEntity extends HostileEntity implements RangedAttackMob {
    public AlienZombieEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return PiglinBruteEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.8));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, AlienEntity.class, false, false));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25, 20, 15));
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) {
        return SoundEvents.ENTITY_PILLAGER_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PILLAGER_DEATH;
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        if (!this.getWorld().isClient() && getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnEntity(getIceSpitEntity(target, serverWorld));

            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.HOSTILE, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
        }
    }

    @NotNull
    private IceSpitEntity getIceSpitEntity(LivingEntity target, ServerWorld serverWorld) {
        IceSpitEntity iceSpitEntity = new IceSpitEntity(ModEntities.ICE_SPIT_ENTITY, serverWorld);

        double d0 = target.getY() - this.getY() + target.getStandingEyeHeight()*2 - this.getStandingEyeHeight();
        double d1 = target.getX() - this.getX();
        double d3 = target.getZ() - this.getZ();

        iceSpitEntity.setVelocity(d1, d0, d3, 0.7f * 2, 0f);
        iceSpitEntity.setPosition(getPos().getX(), getEyeY() - 0.1, getPos().getZ());
        iceSpitEntity.setSilent(true);
        iceSpitEntity.setDamage(2);
        iceSpitEntity.setPunch(1);
        iceSpitEntity.setCritical(false);
        iceSpitEntity.setOwner(this);
        return iceSpitEntity;
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        BlockState blockState = world.getBlockState(new BlockPos((int) this.getX(), (int) this.getY() - 1, (int) this.getZ()));

        if (blockState.getBlock().equals(Blocks.LAVA) || blockState.getBlock().equals(Blocks.AIR)) {
            return false;
        }

        return super.canSpawn(world, spawnReason);
    }

    /*@Override
    public void tick() {
        super.tick();
        if (!Config.ALIEN_ZOMBIE_SPAWN.get()) {
            if (!this.level().isClientSide) {
                this.remove(RemovalReason.DISCARDED);
            }
        }
    }*/
}
