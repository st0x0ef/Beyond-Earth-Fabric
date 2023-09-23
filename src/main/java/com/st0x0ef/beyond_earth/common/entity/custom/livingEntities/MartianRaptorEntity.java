package com.st0x0ef.beyond_earth.common.entity.custom.livingEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class MartianRaptorEntity extends HostileEntity {
    private float AttackAnim = 0;

    public MartianRaptorEntity(EntityType<? extends HostileEntity> entityType, World world) {
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
    public void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.8));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_STRIDER_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_STRIDER_DEATH;
    }

    @Override
    public boolean tryAttack(Entity target) {
        this.AttackAnim = 10;
        this.getWorld().sendEntityStatus(this, (byte)4);
        return super.tryAttack(target);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 4) {
            this.AttackAnim = 10;
        } else {
            super.handleStatus(status);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.AttackAnim > 0) {
            --this.AttackAnim;
        }
    }

    /*Override
    public void baseTick() {
        super.baseTick();
        if (!Config.MARTIAN_RAPTOR_SPAWN.get()) {
            if (!this.level().isClientSide) {
                this.remove(RemovalReason.DISCARDED);
            }
        }
    }*/

    public float getAttackAnim() {
        return AttackAnim;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }
}
