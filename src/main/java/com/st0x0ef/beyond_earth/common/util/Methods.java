package com.st0x0ef.beyond_earth.common.util;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.items.ModItems;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Methods {
    public static final Identifier SPACE_STATION = new Identifier(BeyondEarth.MOD_ID, "space_station");

    public static void setEntityRotation(Entity vehicle, float rotation) {
        vehicle.setYaw(vehicle.getYaw() + rotation);
        vehicle.setBodyYaw(vehicle.getYaw());
        vehicle.prevYaw = vehicle.getYaw();
    }

    public static boolean isLivingInSpaceSuit(LivingEntity entity) {
        if (!isLivingInArmor(entity, EquipmentSlot.HEAD, ModItems.SPACE_HELMET)) return false;
        if (!isLivingInArmor(entity, EquipmentSlot.CHEST, ModItems.SPACE_SUIT)) return false;
        if (!isLivingInArmor(entity, EquipmentSlot.LEGS, ModItems.SPACE_PANTS)) return false;
        return isLivingInArmor(entity, EquipmentSlot.FEET, ModItems.SPACE_BOOTS);
    }

    public static boolean isLivingInNetheriteSpaceSuit(LivingEntity entity) {
        if (!isLivingInArmor(entity, EquipmentSlot.HEAD, ModItems.NETHERITE_SPACE_HELMET)) return false;
        if (!isLivingInArmor(entity, EquipmentSlot.CHEST, ModItems.NETHERITE_SPACE_SUIT)) return false;
        if (!isLivingInArmor(entity, EquipmentSlot.LEGS, ModItems.NETHERITE_SPACE_PANTS)) return false;
        return isLivingInArmor(entity, EquipmentSlot.FEET, ModItems.NETHERITE_SPACE_BOOTS);
    }

    public static boolean isLivingInJetSuit(LivingEntity entity) {
        if (!isLivingInArmor(entity, EquipmentSlot.HEAD, ModItems.JET_HELMET)) return false;
        if (!isLivingInArmor(entity, EquipmentSlot.CHEST, ModItems.JET_SUIT)) return false;
        if (!isLivingInArmor(entity, EquipmentSlot.LEGS, ModItems.JET_PANTS)) return false;
        return isLivingInArmor(entity, EquipmentSlot.FEET, ModItems.JET_BOOTS);
    }

    public static boolean isLivingInAnySpaceSuits(LivingEntity entity) {
        if (!(entity.getEquippedStack(EquipmentSlot.HEAD).isIn(ModTags.ItemTags.SPACE_SUIT_PART))) return false;
        if (!(entity.getEquippedStack(EquipmentSlot.CHEST).isIn(ModTags.ItemTags.SPACE_SUIT_PART))) return false;
        if (!(entity.getEquippedStack(EquipmentSlot.LEGS).isIn(ModTags.ItemTags.SPACE_SUIT_PART))) return false;
        return entity.getEquippedStack(EquipmentSlot.FEET).isIn(ModTags.ItemTags.SPACE_SUIT_PART);
    }

    public static boolean isLivingInArmor(LivingEntity entity, EquipmentSlot slot, Item item) {
        return entity.getEquippedStack(slot).getItem() == item;
    }
}
