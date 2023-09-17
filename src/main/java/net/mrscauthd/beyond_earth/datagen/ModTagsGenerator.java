package net.mrscauthd.beyond_earth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;

import java.util.concurrent.CompletableFuture;

public class ModTagsGenerator {
    public static class ModBlockTagsGenerator extends FabricTagProvider.BlockTagProvider {
        public ModBlockTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            //addGlacioWoodSet();
        }

        private void addGlacioWoodSet() {
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.GLACIO_WOOD_SLAB);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.GLACIO_WOOD_STAIRS);
            getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.GLACIO_WOOD_LEAVES);
            getOrCreateTagBuilder(BlockTags.LOGS).add(ModBlocks.GLACIO_WOOD_LOG);
            getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.GLACIO_WOOD_PLANKS);
        }
    }


    public static class ModItemTagsGenerator extends FabricTagProvider.ItemTagProvider {
        public ModItemTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
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
        }
    }
}
