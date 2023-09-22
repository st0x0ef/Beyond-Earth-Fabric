package com.st0x0ef.beyond_earth.common.effect;

import com.st0x0ef.beyond_earth.common.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.Random;

public class RadiationEffect extends StatusEffect {
    protected RadiationEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if ((new Random()).nextInt(2) == 0) {
            if (!entity.getWorld().isClient()) {
                entity.damage(ModDamageSources.of(entity.getWorld(), ModDamageSources.DAMAGE_SOURCE_RADIATIONS), 1.0F);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int j = 25 >> amplifier;
        if (j > 0) {
            return duration % j == 0;
        } else {
            return true;
        }
    }
}
