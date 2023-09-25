package com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.alien;

import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.AlienZombieEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;

public class AlienEntity extends VillagerEntity {
    public AlienEntity(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return PiglinBruteEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new FleeEntityGoal<>(this, AlienZombieEntity.class, 15.0F, 0.5F, 0.5F));
    }
}
