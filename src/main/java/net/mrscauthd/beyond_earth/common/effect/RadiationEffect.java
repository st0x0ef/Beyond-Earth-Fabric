package net.mrscauthd.beyond_earth.common.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.mrscauthd.beyond_earth.common.util.ModDamageSources;

import java.util.Random;

public class RadiationEffect extends StatusEffect {
    protected RadiationEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if ((new Random()).nextInt(2) == 0) {
            entity.damage(new DamageSource(ModDamageSources.RADIATION), 1.0F);
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
