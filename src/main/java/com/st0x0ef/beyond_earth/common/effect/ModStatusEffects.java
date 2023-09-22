package com.st0x0ef.beyond_earth.common.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;

public class ModStatusEffects {
    public static StatusEffect RADIATION;

    private static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(BeyondEarth.MOD_ID, name),
                new RadiationEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        RADIATION = registerStatusEffect("radiation_effect");
    }
}
