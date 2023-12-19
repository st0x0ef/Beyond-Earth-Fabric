package com.st0x0ef.beyond_earth.common.armor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;

public class SpaceSuit {
    public static class Helmet extends ISpaceArmor.Helmet {
        public Helmet(ArmorMaterial armorMaterial, FabricItemSettings properties) {
            super(armorMaterial, properties);
        }
    }

    public static class Suit extends ISpaceArmor.Chestplate {

        public Suit(ArmorMaterial armorMaterial, FabricItemSettings properties) {
            super(armorMaterial, properties);
        }
        @Override
        public int getOxygenCapacity() {
            return 36000;
        }
    }

    public static class Pants extends ISpaceArmor.Leggings {
        public Pants(ArmorMaterial armorMaterial, FabricItemSettings properties) {
            super(armorMaterial, properties);
        }

        @Override
        public int getFuelCapacity() {
            return 500;
        }
    }

    public static class Boots extends ISpaceArmor.Boots {
        public Boots(ArmorMaterial armorMaterial, FabricItemSettings properties) {
            super(armorMaterial, properties);
        }
    }
}
