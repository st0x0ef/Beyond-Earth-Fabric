package net.mrscauthd.beyond_earth;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.util.Identifier;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;

public class BeyondEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerFluidRendererHandlers();
    }

    private void registerFluidRendererHandlers() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.FUEL_FLOWING,
                new SimpleFluidRenderHandler(
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/fuel_still"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/fuel_flow"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/fuel_overlay")));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.FUEL_STILL,
                new SimpleFluidRenderHandler(
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/fuel_still"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/fuel_flow"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/fuel_overlay")));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.OIL_FLOWING,
                new SimpleFluidRenderHandler(
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/oil_still"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/oil_flow"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/oil_overlay")));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.OIL_STILL,
                new SimpleFluidRenderHandler(
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/oil_still"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/oil_flow"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/oil_overlay")));
    }
}
