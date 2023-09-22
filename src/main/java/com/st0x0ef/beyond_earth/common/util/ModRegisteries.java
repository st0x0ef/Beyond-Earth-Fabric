package com.st0x0ef.beyond_earth.common.util;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.PygroBruteEntity;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.PygroEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegisteries {
    public static void registerModStuff() {
        registerFuels();
        registerAttributes();
    }


    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.PYGRO_BRUTE, PygroBruteEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PYGRO, PygroEntity.setAttributes());
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
