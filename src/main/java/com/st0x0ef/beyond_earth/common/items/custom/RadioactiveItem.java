package com.st0x0ef.beyond_earth.common.items.custom;

import com.st0x0ef.beyond_earth.common.effect.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RadioactiveItem extends Item {
    public RadioactiveItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            //if (!Methods.isLivingInJetSuit(player)) {
                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.RADIATION, 50), player);
            //}
        }
    }
}
