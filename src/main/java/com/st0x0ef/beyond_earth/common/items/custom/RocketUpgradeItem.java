package com.st0x0ef.beyond_earth.common.items.custom;

import net.minecraft.item.Item;

public class RocketUpgradeItem extends Item {
    private final int fuelCapacityModifier;
    private final int fuelUsageModifier;
    public RocketUpgradeItem(Settings settings, int fuelCapacityModifier, int fuelUsageModifier) {
        super(settings);
        this.fuelCapacityModifier = fuelCapacityModifier;
        this.fuelUsageModifier = fuelUsageModifier;
    }


    public int getFuelCapacityModifier() {
        return  fuelCapacityModifier;
    }

    public int getFuelUsageModifier() {
        return fuelUsageModifier;
    }
}
