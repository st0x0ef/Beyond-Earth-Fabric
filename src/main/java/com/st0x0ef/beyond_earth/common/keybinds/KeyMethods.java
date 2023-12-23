package com.st0x0ef.beyond_earth.common.keybinds;

import com.st0x0ef.beyond_earth.common.armor.JetSuit;
import com.st0x0ef.beyond_earth.common.util.Methods;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class KeyMethods {
    /*public static void startRocket(PlayerEntity player) {
        if (player.hasVehicle() && player.getVehicle() instanceof RocketEntity rocket) {

            rocket.startRocket();
        }
    }*/

    public static void switchJetSuitMode(PlayerEntity player) {
        if (Methods.isLivingInJetSuit(player)) {
            ItemStack itemStack = player.getEquippedStack(EquipmentSlot.CHEST);
            JetSuit.Suit item = (JetSuit.Suit) itemStack.getItem();

            //item.switchJetSuitMode(player, itemStack);
        }
    }
}
