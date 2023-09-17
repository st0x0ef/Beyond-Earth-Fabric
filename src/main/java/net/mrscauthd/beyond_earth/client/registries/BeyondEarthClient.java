package net.mrscauthd.beyond_earth.client.registries;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.client.renderers.entities.globe.GlobeBlockRenderer;
import net.mrscauthd.beyond_earth.client.renderers.entities.globe.EarthGlobeItemRenderer;
import net.mrscauthd.beyond_earth.client.renderers.entities.globe.GlobeModel;
import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;
import net.mrscauthd.beyond_earth.common.blocks.entities.ModBlockEntities;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;

public class BeyondEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerFluidRendererHandlers();
    }

    private void registerFluidRendererHandlers() {
        registerFluids();
        registerGlobes();
        registerBlocksWithCutout();
    }

    private void registerBlocksWithCutout(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLACIO_WOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLACIO_WOOD_TRAPDOOR, RenderLayer.getCutout());
    }

    private void registerGlobes() {
        EntityModelLayerRegistry.registerModelLayer(GlobeModel.LAYER_LOCATION, GlobeModel::createLayer);
        BlockEntityRendererRegistry.register(ModBlockEntities.GLOBE_TILE_ENTITY, GlobeBlockRenderer::new);

        // GLOBE ITEMS
        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.EARTH_GLOBE_BLOCK, new EarthGlobeItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.MOON_GLOBE_BLOCK, new EarthGlobeItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.MARS_GLOBE_BLOCK, new EarthGlobeItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.MERCURY_GLOBE_BLOCK, new EarthGlobeItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.VENUS_GLOBE_BLOCK, new EarthGlobeItemRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.GLACIO_GLOBE_BLOCK, new EarthGlobeItemRenderer());
    }

    private void registerFluids() {
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
