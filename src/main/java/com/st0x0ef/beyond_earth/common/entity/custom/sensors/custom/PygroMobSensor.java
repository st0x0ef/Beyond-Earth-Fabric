package com.st0x0ef.beyond_earth.common.entity.custom.sensors.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.LivingTargetCache;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PygroMobSensor extends Sensor<LivingEntity> {

    @Override
    protected void sense(ServerWorld world, LivingEntity entity) {
        Brain<?> brain = entity.getBrain();
        brain.remember(MemoryModuleType.NEAREST_REPELLENT, findNearestRepellent(world, entity));
        Optional<MobEntity> optional = Optional.empty();
        Optional<HoglinEntity> optional1 = Optional.empty();
        Optional<HoglinEntity> optional2 = Optional.empty();
        Optional<PiglinEntity> optional3 = Optional.empty();
        Optional<LivingEntity> optional4 = Optional.empty();
        Optional<PlayerEntity> optional5 = Optional.empty();
        Optional<PlayerEntity> optional6 = Optional.empty();
        int i = 0;
        List<AbstractPiglinEntity> list = Lists.newArrayList();
        List<AbstractPiglinEntity> list1 = Lists.newArrayList();
        LivingTargetCache nearestvisiblelivingentities = brain.getOptionalRegisteredMemory(MemoryModuleType.VISIBLE_MOBS).orElse(LivingTargetCache.empty());

        for(LivingEntity livingentity : nearestvisiblelivingentities.iterate((p_186157_) -> true)) {
            if (livingentity instanceof HoglinEntity hoglinentity) {
                if (hoglinentity.isBaby() && !optional2.isPresent()) {
                    optional2 = Optional.of(hoglinentity);
                } else if (hoglinentity.isAdult()) {
                    ++i;
                    if (!optional1.isPresent() && hoglinentity.canBeHunted()) {
                        optional1 = Optional.of(hoglinentity);
                    }
                }
            } else if (livingentity instanceof PiglinBruteEntity) {
                list.add((PiglinBruteEntity)livingentity);
            } else if (livingentity instanceof PiglinEntity piglinentity) {
                if (piglinentity.isBaby() && !optional3.isPresent()) {
                    optional3 = Optional.of(piglinentity);
                } else if (piglinentity.isAdult()) {
                    list.add(piglinentity);
                }
            } else if (livingentity instanceof PlayerEntity playerentity) {

                if (false) {
                    optional5 = Optional.of(playerentity);
                }

                if (!optional6.isPresent() && !playerentity.isSpectator() && PiglinBrain.isGoldHoldingPlayer(playerentity)) {
                    optional6 = Optional.of(playerentity);
                }
            } else if (optional.isPresent() || !(livingentity instanceof WitherSkeletonEntity) && !(livingentity instanceof WitherEntity)) {
                if (!optional4.isPresent() && PiglinBrain.isZombified(livingentity.getType())) {
                    optional4 = Optional.of(livingentity);
                }
            } else {
                optional = Optional.of((MobEntity)livingentity);
            }
        }

        for(LivingEntity livingentity1 : brain.getOptionalRegisteredMemory(MemoryModuleType.MOBS).orElse(ImmutableList.of())) {
            if (livingentity1 instanceof AbstractPiglinEntity && ((AbstractPiglinEntity)livingentity1).isAdult()) {
                list1.add((AbstractPiglinEntity) livingentity1);
            }
        }

        brain.remember(MemoryModuleType.NEAREST_VISIBLE_NEMESIS, optional);
        brain.remember(MemoryModuleType.NEAREST_VISIBLE_HUNTABLE_HOGLIN, optional1);
        brain.remember(MemoryModuleType.NEAREST_VISIBLE_BABY_HOGLIN, optional2);
        brain.remember(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED, optional4);
        brain.remember(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD, optional5);
        brain.remember(MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM, optional6);
        brain.remember(MemoryModuleType.NEARBY_ADULT_PIGLINS, list1);
        brain.remember(MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS, list);
        brain.remember(MemoryModuleType.VISIBLE_ADULT_PIGLIN_COUNT, list.size());
        brain.remember(MemoryModuleType.VISIBLE_ADULT_HOGLIN_COUNT, i);
    }

    @Override
    public Set<MemoryModuleType<?>> getOutputMemoryModules() {
        return ImmutableSet.of(MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.MOBS, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD, MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM, MemoryModuleType.NEAREST_VISIBLE_HUNTABLE_HOGLIN, MemoryModuleType.NEAREST_VISIBLE_BABY_HOGLIN, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS, MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.VISIBLE_ADULT_PIGLIN_COUNT, MemoryModuleType.VISIBLE_ADULT_HOGLIN_COUNT, MemoryModuleType.NEAREST_REPELLENT);
    }

    private static Optional<BlockPos> findNearestRepellent(ServerWorld world, LivingEntity livingEntity) {
        return BlockPos.findClosest(new BlockPos((int)livingEntity.getX(), (int)livingEntity.getY(), (int)livingEntity.getZ()), 8, 4, (pos) -> isRepellent(world, pos));
    }

    private static boolean isRepellent(ServerWorld world, BlockPos pos) {
        return false;
    }
}
