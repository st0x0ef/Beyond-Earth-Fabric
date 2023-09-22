package com.st0x0ef.beyond_earth.common.entity.custom.livingEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.world.World;

public class PygroBruteEntity extends PiglinBruteEntity {
    public PygroBruteEntity(EntityType<? extends PiglinBruteEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return PiglinBruteEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }

    @Override
    public void tick() {
        super.tick();
        /*if (!Config.PYGRO_BRUTE_SPAWN.get()) {
            if (!this.getWorld().isClient()) {
                this.remove(Entity.RemovalReason.DISCARDED);
            }
        }*/
    }
}
