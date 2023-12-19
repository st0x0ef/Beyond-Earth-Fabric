package com.st0x0ef.beyond_earth.common.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public record ModArmorMaterials() {
        public static ArmorMaterial JET_SUIT_MATERIAL = new ArmorMaterial() {
            @Override
            public int getDurability(ArmorItem.Type type) {
                return new int[]{481, 555, 592, 407}[type.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getProtection(ArmorItem.Type type) {
                return new int[]{3, 6, 8, 3}[type.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 15;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(Items.NETHERITE_INGOT);
            }

            @Override
            public String getName() {
                return "jet_suit";
            }

            @Override
            public float getToughness() {
                return 3.0f;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.1f;
            }
        };

        public static ArmorMaterial NETHERITE_SPACE_SUIT_MATERIAL = new ArmorMaterial() {

            @Override
            public int getDurability(ArmorItem.Type type) {
                return new int[]{3, 6, 8, 3}[type.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getProtection(ArmorItem.Type type) {
                return new int[]{3, 6, 8, 3}[type.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 15;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(Items.NETHERITE_INGOT);
            }

            @Override
            public String getName() {
                return "netherite_space_suit";
            }

            @Override
            public float getToughness() {
                return 3.0f;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.1f;
            }
        };


    public static ArmorMaterial SPACE_SUIT_MATERIAL = new ArmorMaterial() {

        @Override
        public int getDurability(ArmorItem.Type type) {
            return new int[]{195, 225, 240, 165}[type.getEquipmentSlot().getEntitySlotId()];
        }

        @Override
        public int getProtection(ArmorItem.Type type) {
            return new int[]{2, 5, 6, 2}[type.getEquipmentSlot().getEntitySlotId()];
        }

        @Override
        public int getEnchantability() {
            return 14;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.IRON_INGOT);
        }

        @Override
        public String getName() {
            return "space_suit";
        }

        @Override
        public float getToughness() {
            return 0f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0f;
        }
    };
}
