package com.st0x0ef.beyond_earth.common.fluids;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid FUEL_STILL = registerFluid("fuel", new FuelFluid.Still());
    public static final FlowableFluid FUEL_FLOWING = registerFluid("flowing_fuel", new FuelFluid.Flowing());

    public static final FlowableFluid OIL_STILL = registerFluid("oil", new OilFluid.Still());
    public static final FlowableFluid OIL_FLOWING = registerFluid("flowing_oil", new OilFluid.Flowing());

    public static final FlowableFluid HYDROGEN_STILL = registerFluid("hydrogen", new HydrogenFluid.Still());
    public static final FlowableFluid HYDROGEN_FLOWING = registerFluid("flowing_hydrogen", new HydrogenFluid.Flowing());



    private static FlowableFluid registerFluid(String name, FlowableFluid fluid){
        return Registry.register(Registries.FLUID, new Identifier(BeyondEarth.MOD_ID, name), fluid);
    }
}
