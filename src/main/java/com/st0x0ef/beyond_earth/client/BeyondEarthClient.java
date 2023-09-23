package com.st0x0ef.beyond_earth.client;

import com.st0x0ef.beyond_earth.client.renderers.entities.alien.AlienModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.alien.AlienRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.martianRaptor.MartianRaptorModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.martianRaptor.MartianRaptorRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.mogler.MoglerModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.mogler.MoglerRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygro.PygroModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygro.PygroRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygrobrute.PygroBruteRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.starCrawler.StarCrawlerModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.starCrawler.StarCrawlerRenderer;
import com.st0x0ef.beyond_earth.common.blocks.entities.ModBlockEntities;
import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.client.renderers.entities.globe.GlobeBlockRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.globe.EarthGlobeItemRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.globe.GlobeModel;
import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.fluids.ModFluids;

public class BeyondEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerFluidRendererHandlers();
    }

    private void registerFluidRendererHandlers() {
        registerFluids();
        registerGlobes();
        registerBlocksWithCutout();
        registerEntityRenderers();
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


    private void registerEntityRenderers() {
        EntityModelLayerRegistry.registerModelLayer(PygroModel.LAYER_LOCATION, PygroModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(MoglerModel.LAYER_LOCATION, MoglerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(StarCrawlerModel.LAYER_LOCATION, StarCrawlerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MartianRaptorModel.LAYER_LOCATION, MartianRaptorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(AlienModel.LAYER_LOCATION, AlienModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PYGRO_BRUTE, context -> new PygroBruteRenderer(context, EntityModelLayers.PIGLIN_BRUTE_INNER_ARMOR, EntityModelLayers.PIGLIN_BRUTE_OUTER_ARMOR));
        EntityRendererRegistry.register(ModEntities.PYGRO, context -> new PygroRenderer(context, EntityModelLayers.PIGLIN_INNER_ARMOR, EntityModelLayers.PIGLIN_OUTER_ARMOR));

        EntityRendererRegistry.register(ModEntities.MOGLER, MoglerRenderer::new);
        EntityRendererRegistry.register(ModEntities.STAR_CRAWLER, StarCrawlerRenderer::new);
        EntityRendererRegistry.register(ModEntities.MARTIAN_RAPTOR, MartianRaptorRenderer::new);
        EntityRendererRegistry.register(ModEntities.ALIEN, AlienRenderer::new);
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
