package com.st0x0ef.beyond_earth.common.armor;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ISpaceArmor extends ArmorItem {
    public static final String FUEL_TAG = BeyondEarth.MOD_ID + ":fuel";

    public ISpaceArmor(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    public static abstract class Helmet extends ISpaceArmor {
        public Helmet(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, Type.HELMET, properties);
        }

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            /*IOxygenStorage oxygen = OxygenUtil.getItemStackOxygenStorage(itemStack);
            list.add(GaugeTextHelper.buildSpacesuitOxygenTooltip(GaugeValueHelper.getOxygen(oxygen.getOxygen(), oxygen.getMaxCapacity())));*/
        }
    }

    public static abstract class Chestplate extends ISpaceArmor {
        public Chestplate(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, Type.CHESTPLATE, properties);
        }


        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            /*IOxygenStorage oxygen = OxygenUtil.getItemStackOxygenStorage(itemStack);
            list.add(GaugeTextHelper.buildSpacesuitOxygenTooltip(GaugeValueHelper.getOxygen(oxygen.getOxygen(), oxygen.getMaxCapacity())));*/
        }

        /*@Override
        public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
            return new OxygenProvider(stack, this.getOxygenCapacity());
        }*/

        /*@Override
        public void onArmorTick(ItemStack stack, Level level, Player player) {
            super.onArmorTick(stack, level, player);
        }*/

        public abstract int getOxygenCapacity();
    }

    public static abstract class Leggings extends ISpaceArmor {
        public Leggings(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, Type.LEGGINGS, properties);
        }

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            int fuel = stack.getOrCreateNbt().getInt(FUEL_TAG);
            int capacity = this.getFuelCapacity();
            //tooltip.add(GaugeTextHelper.buildFuelStorageTooltip(GaugeValueHelper.getFuel(fuel, capacity), ChatFormatting.GRAY));
        }

        /*@Override
        public void onArmorTick(ItemStack stack, Level level, Player player) {
            super.onArmorTick(stack, level, player);
        }*/

        public abstract int getFuelCapacity();
    }

    public static abstract class Boots extends ISpaceArmor {
        public Boots(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, Type.BOOTS, properties);
        }
    }

    /*public Identifier getTexture(ItemStack itemStack, LivingEntity entity) {
        String loc = itemStack.getItem().(itemStack, entity, itemStack.getEquipmentSlot(), null);
        Identifier texture = TEXTURES.get(loc);
        if (texture == null) {
            texture = new Identifier(loc);
            TEXTURES.put(loc, texture);
        }

        return texture;
    }*/
}
