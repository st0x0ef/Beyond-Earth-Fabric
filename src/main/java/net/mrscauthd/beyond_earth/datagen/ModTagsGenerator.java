package net.mrscauthd.beyond_earth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;
import net.mrscauthd.beyond_earth.common.items.ModItems;
import net.mrscauthd.beyond_earth.common.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModTagsGenerator {
    public static class ModBlockTagsGenerator extends FabricTagProvider.BlockTagProvider {
        public ModBlockTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            addGlacioWoodSet();
            addStairs();
            addSlabs();
            addSand();
            addDirt();
        }

        private void addStairs() {
            getOrCreateTagBuilder(BlockTags.STAIRS)
                    .add(ModBlocks.GLACIO_STONE_BRICK_STAIRS)
                    .add(ModBlocks.MARS_STONE_BRICK_STAIRS)
                    .add(ModBlocks.MERCURY_STONE_BRICK_STAIRS)
                    .add(ModBlocks.MOON_STONE_BRICK_STAIRS)
                    .add(ModBlocks.VENUS_SANDSTONE_BRICK_STAIRS)
                    .add(ModBlocks.VENUS_STONE_BRICK_STAIRS);
        }

        private void addSlabs() {
            getOrCreateTagBuilder(BlockTags.SLABS)
                    .add(ModBlocks.MARS_STONE_BRICK_SLAB)
                    .add(ModBlocks.MOON_STONE_BRICK_SLAB)
                    .add(ModBlocks.MERCURY_STONE_BRICK_SLAB)
                    .add(ModBlocks.VENUS_STONE_BRICK_SLAB)
                    .add(ModBlocks.VENUS_SANDSTONE_BRICK_SLAB)
                    .add(ModBlocks.GLACIO_STONE_BRICK_SLAB);
        }

        private void addSand() {
         getOrCreateTagBuilder(BlockTags.SAND)
                 .add(ModBlocks.MARS_SAND)
                 .add(ModBlocks.MOON_SAND)
                 .add(ModBlocks.VENUS_SAND);
        }

        private void addDirt() {
            getOrCreateTagBuilder(BlockTags.DIRT).add(ModBlocks.PERMAFROST_DIRT);
        }

        private void addGlacioWoodSet() {
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.GLACIO_BUTTON);
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.GLACIO_WOOD_DOOR);
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.GLACIO_FENCE);
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.GLACIO_WOOD_SLAB);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.GLACIO_WOOD_STAIRS);
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.GLACIO_PRESSURE_PLATE);
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.GLACIO_WOOD_TRAPDOOR);
            getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.GLACIO_FENCE_GATE);
            getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.GLACIO_WOOD_PLANKS);
            getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.GLACIO_WOOD_LEAVES);
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(ModBlocks.GLACIO_WOOD_LOG).add(ModBlocks.GLACIO_WOOD);
        }
    }


    public static class ModItemTagsGenerator extends FabricTagProvider.ItemTagProvider {
        public ModItemTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            //getOrCreateTagBuilder(ModTags.ROCKET_UPGRADE_TAG).add(ModItems.)
        }
    }

    public static class ModFluidTagsGenerator extends FabricTagProvider.FluidTagProvider {

        public ModFluidTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            //getOrCreateTagBuilder(FluidTags.WATER).add(ModFluids.FUEL_STILL).add(ModFluids.FUEL_FLOWING);
            //getOrCreateTagBuilder(FluidTags.WATER).add(ModFluids.OIL_STILL).add(ModFluids.OIL_FLOWING);
            getOrCreateTagBuilder(ModTags.FLUID_OIL_FLUID_TAG).add(ModFluids.OIL_FLOWING).add(ModFluids.OIL_STILL);
            getOrCreateTagBuilder(ModTags.FLUID_VEHICLE_FUEL_TAG).add(ModFluids.FUEL_FLOWING).add(ModFluids.FUEL_STILL);
        }
    }
}
