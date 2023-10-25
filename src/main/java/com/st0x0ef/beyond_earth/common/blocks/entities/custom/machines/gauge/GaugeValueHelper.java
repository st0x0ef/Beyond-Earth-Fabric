package com.st0x0ef.beyond_earth.common.blocks.entities.custom.machines.gauge;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.minecraft.util.Identifier;

public class GaugeValueHelper {
    public static final Identifier ENERGY_NAME = new Identifier(BeyondEarth.MOD_ID, "energy");
    public static final Identifier OXYGEN_NAME = new Identifier(BeyondEarth.MOD_ID, "oxygen");
    public static final Identifier FLUID_NAME = new Identifier(BeyondEarth.MOD_ID, "fluid");
    public static final Identifier FUEL_NAME = new Identifier(BeyondEarth.MOD_ID, "fuel");
    public static final Identifier BURNTIME_NAME = new Identifier(BeyondEarth.MOD_ID, "burntime");
    public static final Identifier COOKTIME_NAME = new Identifier(BeyondEarth.MOD_ID, "cooktime");

    public static final int ENERGY_COLOR = 0xA0FF404B;
    public static final int OXYGEN_COLOR = 0xA000FFFF;
    public static final int FUEL_COLOR = 0xA099993D;
    public static final int BURNTIME_COLOR = 0xA0FF3F00;
    public static final int COOKTIME_COLOR = 0xA0FFFFFF;

    public static final String ENERGY_UNIT = "FE";
    public static final String OXYGEN_UNIT = "mB";
    public static final String FLUID_UNIT = "mB";

    public static String makeTranslationKey(Identifier name) {
        return "general." + name.getNamespace() + "." + name.getPath();
    }

    /*public static IGaugeValue getFluid(int amount) {
        return getFluid(amount, 0);
    }

    public static IGaugeValue getFluid(int amount, int capacity) {
        return new GaugeValueSimple(FLUID_NAME, amount, capacity, null, FLUID_UNIT);
    }

    public static IGaugeValue getFluid(Fluid fluid, int amount) {
        return getFluid(new FluidStack(fluid, amount));
    }

    public static IGaugeValue getFluid(Fluid fluid, int amount, int capacity) {
        return getFluid(new FluidStack(fluid, amount), capacity);
    }

    public static IGaugeValue getFluid(FluidStack stack) {
        return getFluid(stack, 0);
    }

    public static IGaugeValue getFluid(FluidStack stack, int capacity) {
        return new GaugeValueFluidStack(stack, capacity);
    }

    public static IGaugeValue getFluid(IFluidTank tank) {
        return getFluid(tank.getFluid(), tank.getCapacity());
    }

    public static IGaugeValue getEnergy(int amount) {
        return getEnergy(amount, 0);
    }

    public static IGaugeValue getEnergy(int stored, int capacity) {
        return new GaugeValueSimple(ENERGY_NAME, stored, capacity, null, ENERGY_UNIT).color(ENERGY_COLOR);
    }

    public static IGaugeValue getEnergy(IEnergyStorage energyStorage) {
        return getEnergy(energyStorage.getEnergyStored(), energyStorage.getMaxEnergyStored());
    }

    public static IGaugeValue getEnergy(AbstractMachineBlockEntity blockEntity) {
        return getEnergy(blockEntity.getPrimaryEnergyStorage());
    }

    public static IGaugeValue getOxygen(int amount) {
        return getOxygen(amount, 0);
    }

    public static IGaugeValue getOxygen(int amount, int capacity) {
        return new GaugeValueSimple(OXYGEN_NAME, amount, capacity, null, OXYGEN_UNIT).color(OXYGEN_COLOR);
    }

    public static IGaugeValue getOxygen(OxygenStorage oxygenStorage) {
        return getOxygen(oxygenStorage.getOxygen(), oxygenStorage.getMaxCapacity());
    }

    public static IGaugeValue getBurnTime(int amount) {
        return getBurnTime(amount, 0);
    }

    public static IGaugeValue getBurnTime(int amount, int capacity) {
        return new GaugeValueSimple(BURNTIME_NAME, amount, capacity).color(BURNTIME_COLOR);
    }

    public static IGaugeValue getBurnTime(PowerSystemFuelBurnTime fuelPowerSystem) {
        return getBurnTime(fuelPowerSystem.getStored(), fuelPowerSystem.getCapacity());
    }

    public static IGaugeValue getCookTime(int timer, int maxTimer) {
        return new GaugeValueSimple(COOKTIME_NAME, maxTimer - timer, maxTimer).color(COOKTIME_COLOR).reverse(true);
    }

    public static IGaugeValue getFuel(int amount) {
        return getFuel(amount, 0);
    }

    public static IGaugeValue getFuel(int amount, int capacity) {
        return new GaugeValueSimple(FUEL_NAME, amount, capacity, null, FLUID_UNIT).color(FUEL_COLOR);
    }*/

}
