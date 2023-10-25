package com.st0x0ef.beyond_earth.common.blocks.entities.custom.machines.gauge;

import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;

public interface IGaugeValue extends NbtElement {
    Text getDisplayName();

    String getUnit();

    int getAmount();

    int getCapacity();

    default int getColor()
    {
        return 0x00000000;
    }

    boolean isReverse();

    default double getDisplayRatio() {
        int capacity = this.getCapacity();

        if (capacity == 0) {
            return 0.0D;
        }

        int amount = this.getAmount();
        return (this.isReverse() ? (capacity - amount) : amount) / (double) capacity;
    }
}
