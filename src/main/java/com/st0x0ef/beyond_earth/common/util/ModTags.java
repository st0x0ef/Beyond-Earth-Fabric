package com.st0x0ef.beyond_earth.common.util;

import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import com.st0x0ef.beyond_earth.BeyondEarth;

public class ModTags {

    /** ENTITIES */
    public static final TagKey<EntityType<?>> ENTITY_NO_OXYGEN_NEEDED_TAG = createEntityTag("no_oxygen_needed");
    public static final TagKey<EntityType<?>> ENTITY_PLANET_FIRE_TAG = createEntityTag("planet_fire");
    public static final TagKey<EntityType<?>> ENTITY_VENUS_RAIN_TAG = createEntityTag("venus_rain");


    /** FLUIDS */
    public static final TagKey<Fluid> FLUID_VEHICLE_FUEL_TAG = createFluidTag("vehicle_fuel");
    public static final TagKey<Fluid> FLUID_OIL_FLUID_TAG = createFluidTag("oil");


    /** BIOMES */
    public static final TagKey<Biome> GLACIO_BIOMES_TAG = createBiomeTag("glacio");
    public static final TagKey<Biome> MARS_BIOMES_TAG = createBiomeTag("mars");
    public static final TagKey<Biome> MERCURY_BIOMES_TAG = createBiomeTag("mercury");
    public static final TagKey<Biome> MOON_BIOMES_TAG = createBiomeTag("moon");
    public static final TagKey<Biome> VENUS_BIOMES_TAG = createBiomeTag("venus");



    /** ROCKET UPGRADE */
    public static final TagKey<Item> ROCKET_UPGRADE_TAG = createItemTag("rocket_upgrade");

    /** ITEMS */
    public static final TagKey<Item> RADIOACTIVE_ITEMS_TAG = createItemTag("radioactive_items");


    private static TagKey<Item> createItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(BeyondEarth.MOD_ID, name));
    }

    private static TagKey<Fluid> createFluidTag(String name) {
        return TagKey.of(RegistryKeys.FLUID, new Identifier(BeyondEarth.MOD_ID, name));
    }

    private static TagKey<EntityType<?>> createEntityTag(String name) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, name));
    }

    private static TagKey<Biome> createBiomeTag(String name) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(BeyondEarth.MOD_ID, name));
    }
}
