package com.st0x0ef.beyond_earth.client;

import com.st0x0ef.beyond_earth.client.events.ClientKeyEvents;
import com.st0x0ef.beyond_earth.client.renderers.armor.NetheriteSpaceSuitRenderer;
import com.st0x0ef.beyond_earth.client.renderers.armor.SpaceSuitRenderer;
import com.st0x0ef.beyond_earth.client.renderers.armor.models.ISpaceArmorModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.alien.AlienModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.alien.AlienRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.alienZombie.AlienZombieModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.alienZombie.AlienZombieRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.flag.FlagHeadModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.flag.FlagHeadRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.martianRaptor.MartianRaptorModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.martianRaptor.MartianRaptorRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.mogler.MoglerModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.mogler.MoglerRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygro.PygroModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygro.PygroRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygrobrute.PygroBruteRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.rover.RoverItemRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.rover.RoverModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.rover.RoverRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.starCrawler.StarCrawlerModel;
import com.st0x0ef.beyond_earth.client.renderers.entities.starCrawler.StarCrawlerRenderer;
import com.st0x0ef.beyond_earth.common.blocks.entities.ModBlockEntities;
import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.items.ModItems;
import com.st0x0ef.beyond_earth.common.networking.ModPackets;
import com.st0x0ef.beyond_earth.common.particles.ModParticles;
import com.st0x0ef.beyond_earth.common.particles.custom.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.client.item.CompassAnglePredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.client.renderers.entities.globe.GlobeBlockRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.globe.EarthGlobeItemRenderer;
import com.st0x0ef.beyond_earth.client.renderers.entities.globe.GlobeModel;
import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.fluids.ModFluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.world.World;

public class BeyondEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerFluids();
        registerGlobes();
        registerBlocksWithCutout();
        registerEntityRenderers();
        registerParticles();
        registerItemRenderers();
        registerPredicateProviders();
        registerEvents();
        registerArmorRenderers();
        ModPackets.registerS2CPackets();
    }


    private void registerEvents() {
        ClientKeyEvents.tick();
        ClientKeyEvents.onDisconnect();
    }


    private void registerBlocksWithCutout(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLACIO_WOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLACIO_WOOD_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COAL_LANTERN_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COAL_TORCH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_COAL_TORCH_BLOCK, RenderLayer.getCutout());
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
        EntityModelLayerRegistry.registerModelLayer(AlienZombieModel.LAYER_LOCATION, AlienZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(FlagHeadModel.LAYER_LOCATION, FlagHeadModel::createHumanoidHeadLayer);
        EntityModelLayerRegistry.registerModelLayer(RoverModel.LAYER_LOCATION, RoverModel::createBodyLayer);

        BlockEntityRendererRegistry.register(ModBlockEntities.FLAG_BLOCK_ENTITY, ctx -> new FlagHeadRenderer());

        EntityRendererRegistry.register(ModEntities.PYGRO_BRUTE, context -> new PygroBruteRenderer(context, EntityModelLayers.PIGLIN_BRUTE_INNER_ARMOR, EntityModelLayers.PIGLIN_BRUTE_OUTER_ARMOR));
        EntityRendererRegistry.register(ModEntities.PYGRO, context -> new PygroRenderer(context, EntityModelLayers.PIGLIN_INNER_ARMOR, EntityModelLayers.PIGLIN_OUTER_ARMOR));

        EntityRendererRegistry.register(ModEntities.MOGLER, MoglerRenderer::new);
        EntityRendererRegistry.register(ModEntities.STAR_CRAWLER, StarCrawlerRenderer::new);
        EntityRendererRegistry.register(ModEntities.MARTIAN_RAPTOR, MartianRaptorRenderer::new);
        EntityRendererRegistry.register(ModEntities.ALIEN, AlienRenderer::new);
        EntityRendererRegistry.register(ModEntities.ALIEN_ZOMBIE, AlienZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.ICE_SPIT_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ROVER, RoverRenderer::new);
    }


    private void registerArmorRenderers() {
        EntityModelLayerRegistry.registerModelLayer(ISpaceArmorModel.LayerOne.LAYER_LOCATION, ISpaceArmorModel.LayerOne::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ISpaceArmorModel.LayerTwo.LAYER_LOCATION, ISpaceArmorModel.LayerTwo::getTexturedModelData);

        ArmorRenderer.register(new SpaceSuitRenderer(), ModItems.SPACE_HELMET, ModItems.SPACE_SUIT, ModItems.SPACE_PANTS, ModItems.SPACE_BOOTS);
        ArmorRenderer.register(new NetheriteSpaceSuitRenderer(), ModItems.NETHERITE_SPACE_HELMET, ModItems.NETHERITE_SPACE_SUIT, ModItems.NETHERITE_SPACE_PANTS, ModItems.NETHERITE_SPACE_BOOTS);
    }


    private void registerItemRenderers() {
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.ROVER_ITEM, new RoverItemRenderer());
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

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.HYDROGEN_STILL,
                new SimpleFluidRenderHandler(
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/hydrogen_still"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/hydrogen_flow"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/hydrogen_overlay")));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.HYDROGEN_FLOWING,
                new SimpleFluidRenderHandler(
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/hydrogen_still"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/hydrogen_flow"),
                        new Identifier(BeyondEarth.MOD_ID, "block/fluid/hydrogen_overlay")));
    }




    private void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.LARGE_FLAME_PARTICLE, LargeFlameParticle.ParticleFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LARGE_SMOKE_PARTICLE, LargeSmokeParticle.ParticleFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SMALL_FLAME_PARTICLE, SmallFlameParticle.ParticleFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SMALL_SMOKE_PARTICLE, SmallSmokeParticle.ParticleFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.VENUS_RAIN_PARTICLE, VenusRainParticle.ParticleFactory::new);
    }





    private void registerPredicateProviders() {
        ModelPredicateProviderRegistry.register(ModItems.SPACE_BALISE, new Identifier("angle"), new CompassAnglePredicateProvider((world, stack, entity) -> {
            if (stack.getOrCreateSubNbt("coords") != null && stack.getOrCreateSubNbt("coords").getBoolean("coordsSet")) {
                NbtCompound coords = stack.getOrCreateSubNbt("coords");
                return GlobalPos.create(getWorld(coords), new BlockPos(coords.getInt("x"), coords.getInt("y"), coords.getInt("z")));
            }
            return null;
        }));
    }

    private RegistryKey<World> getWorld(NbtCompound compound) {
        return RegistryKey.of(RegistryKey.ofRegistry(new Identifier(compound.getString("levelNamespace"), compound.getString("level"))), new Identifier(compound.getString("levelValueNamespace"), compound.getString("levelValuePath")));
    }
}
