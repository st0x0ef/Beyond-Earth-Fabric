package net.mrscauthd.beyond_earth.common.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;

public class ModRegisteries {
    public static void registerModStuff() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
        fuelRegistry.add(ModBlocks.GLACIO_WOOD, 300);
        fuelRegistry.add(ModBlocks.GLACIO_WOOD_LOG, 300);
        fuelRegistry.add(ModBlocks.GLACIO_WOOD_PLANKS, 300);
        fuelRegistry.add(ModBlocks.GLACIO_WOOD_SLAB, 150);
        fuelRegistry.add(ModBlocks.GLACIO_WOOD_STAIRS, 300);
        fuelRegistry.add(ModBlocks.GLACIO_PRESSURE_PLATE, 300);
        fuelRegistry.add(ModBlocks.GLACIO_BUTTON, 100);
        fuelRegistry.add(ModBlocks.GLACIO_WOOD_TRAPDOOR, 300);
        fuelRegistry.add(ModBlocks.GLACIO_FENCE_GATE, 300);
        fuelRegistry.add(ModBlocks.GLACIO_FENCE, 300);
        fuelRegistry.add(ModBlocks.GLACIO_WOOD_DOOR, 200);
    }
}
