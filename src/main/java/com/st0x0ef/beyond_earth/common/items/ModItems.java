package com.st0x0ef.beyond_earth.common.items;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.items.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.fluids.ModFluids;
import net.minecraft.util.Rarity;

public class ModItems {
    /** VEHICLE ITEMS*/
    public static final Item ROVER_ITEM = registerItemGroupNormal("rover", new RoverItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    /**
     * SPAWN EGG ITEMS
     */
    public static final Item ALIEN_SPAWN_EGG = registerSpawnEgg("alien_spawn_egg", new SpawnEggItem(ModEntities.ALIEN, -13382401, -11650781, new FabricItemSettings()));
    public static final Item ALIEN_ZOMBIE_SPAWN_EGG = registerSpawnEgg("alien_zombie_spawn_egg", new SpawnEggItem(ModEntities.ALIEN_ZOMBIE, -14804199, -16740159, new FabricItemSettings()));
    public static final Item STAR_CRAWLER_SPAWN_EGG = registerSpawnEgg("star_crawler_spawn_egg", new SpawnEggItem(ModEntities.STAR_CRAWLER, -13421773, -16724788, new FabricItemSettings()));
    public static final Item PYGRO_SPAWN_EGG = registerSpawnEgg("pygro_spawn_egg", new SpawnEggItem(ModEntities.PYGRO, -3381760, -6750208, new FabricItemSettings()));
    public static final Item PYGRO_BRUTE_SPAWN_EGG = registerSpawnEgg("pygro_brute_spawn_egg", new SpawnEggItem(ModEntities.PYGRO_BRUTE, -3381760, -67208, new FabricItemSettings()));
    public static final Item MOGLER_SPAWN_EGG = registerSpawnEgg("mogler_spawn_egg", new SpawnEggItem(ModEntities.MOGLER, -13312, -3407872, new FabricItemSettings()));
    public static final Item MARTIAN_RAPTOR_SPAWN_EGG = registerSpawnEgg("martian_raptor_spawn_egg", new SpawnEggItem(ModEntities.MARTIAN_RAPTOR, 5349438, -13312, new FabricItemSettings()));

    /**
     * SPECIAL ITEMS
     */
    public static final Item COAL_TORCH_ITEM = registerItemGroupNormal("coal_torch_item",  new CoalTorchItem(ModBlocks.COAL_TORCH_BLOCK, ModBlocks.WALL_COAL_TORCH_BLOCK, new FabricItemSettings()));

    public static final Item FLAG_ITEM =  registerItemGroupNormal("flag_item", new TallBlockItem(ModBlocks.FLAG_BLOCK, new FabricItemSettings()));


    /**
     * NORMAL ITEMS
     */
    public static final Item CHEESE = registerItemGroupNormal("cheese", new Item(new FabricItemSettings().food(ModFoodComponents.CHEESE)));
    public static final Item HAMMER = registerItemGroupBasics("hammer", new HammerItem(new FabricItemSettings().maxDamage(9)));
    public static final Item IRON_ROD = registerItemGroupBasics("iron_rod", new Item(new FabricItemSettings()));
    public static final Item OXYGEN_GEAR = registerItemGroupBasics("oxygen_gear", new Item(new FabricItemSettings()));
    public static final Item OXYGEN_TANK = registerItemGroupBasics("oxygen_tank", new Item(new FabricItemSettings()));
    public static final Item WHEEL = registerItemGroupBasics("wheel", new Item(new FabricItemSettings()));
    public static final Item ENGINE_FAN = registerItemGroupBasics("engine_fan", new Item(new FabricItemSettings()));
    public static final Item ENGINE_FRAME = registerItemGroupBasics("engine_frame", new Item(new FabricItemSettings()));
    public static final Item ROCKET_NOSE_CONE = registerItemGroupBasics("rocket_nose_cone", new Item(new FabricItemSettings()));
    public static final Item ROCKET_FIN = registerItemGroupBasics("rocket_fin", new Item(new FabricItemSettings()));
    public static final Item STEEL_ENGINE = registerItemGroupBasics("steel_engine", new Item(new FabricItemSettings()));
    public static final Item DESH_ENGINE = registerItemGroupBasics("desh_engine", new Item(new FabricItemSettings()));
    public static final Item OSTRUM_ENGINE = registerItemGroupBasics("ostrum_engine", new Item(new FabricItemSettings()));
    public static final Item CALORITE_ENGINE = registerItemGroupBasics("calorite_engine", new Item(new FabricItemSettings()));
    public static final Item STEEL_TANK = registerItemGroupBasics("steel_tank", new Item(new FabricItemSettings()));
    public static final Item DESH_TANK = registerItemGroupBasics("desh_tank", new Item(new FabricItemSettings()));
    public static final Item OSTRUM_TANK = registerItemGroupBasics("ostrum_tank", new Item(new FabricItemSettings()));
    public static final Item CALORITE_TANK = registerItemGroupBasics("calorite_tank", new Item(new FabricItemSettings()));
    public static final Item SPACE_BALISE = registerItemGroupBasics("space_balise",  new SpaceBaliseItem(new FabricItemSettings().maxCount(1)));

    // INGOTS
    public static final Item STEEL_INGOT = registerItemGroupMaterials("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item DESH_INGOT = registerItemGroupMaterials("desh_ingot", new Item(new FabricItemSettings()));
    public static final Item OSTRUM_INGOT = registerItemGroupMaterials("ostrum_ingot", new Item(new FabricItemSettings()));
    public static final Item CALORITE_INGOT = registerItemGroupMaterials("calorite_ingot", new Item(new FabricItemSettings()));

    public static final Item ICE_SHARD = registerItemGroupMaterials("ice_shard", new Item(new FabricItemSettings()));

    // PLATES
    public static final Item IRON_PLATE = registerItemGroupMaterials("iron_plate", new Item(new FabricItemSettings()));
    public static final Item DESH_PLATE = registerItemGroupMaterials("desh_plate", new Item(new FabricItemSettings()));


    // COMPRESSED
    public static final Item COMPRESSED_STEEL = registerItemGroupMaterials("compressed_steel", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_DESH = registerItemGroupMaterials("compressed_desh", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_OSTRUM = registerItemGroupMaterials("compressed_ostrum", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_CALORITE = registerItemGroupMaterials("compressed_calorite", new Item(new FabricItemSettings()));

    // NUGGETS
    public static final Item STEEL_NUGGET = registerItemGroupMaterials("steel_nugget", new Item(new FabricItemSettings()));
    public static final Item DESH_NUGGET = registerItemGroupMaterials("desh_nugget", new Item(new FabricItemSettings()));
    public static final Item OSTRUM_NUGGET = registerItemGroupMaterials("ostrum_nugget", new Item(new FabricItemSettings()));
    public static final Item CALORITE_NUGGET = registerItemGroupMaterials("calorite_nugget", new Item(new FabricItemSettings()));

    // RAW MATERIALS
    public static final Item RAW_DESH = registerItemGroupMaterials("raw_desh", new Item(new FabricItemSettings()));
    public static final Item RAW_OSTRUM = registerItemGroupMaterials("raw_ostrum", new Item(new FabricItemSettings()));
    public static final Item RAW_CALORITE = registerItemGroupMaterials("raw_calorite", new Item(new FabricItemSettings()));

    /**
     * BUCKET ITEMS
     */
    public static final ModifiedBucketItem FUEL_BUCKET = (ModifiedBucketItem) registerItemGroupNormal("fuel_bucket", new ModifiedBucketItem(ModFluids.FUEL_STILL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1), true));
    public static final ModifiedBucketItem OIL_BUCKET = (ModifiedBucketItem) registerItemGroupNormal("oil_bucket", new ModifiedBucketItem(ModFluids.OIL_STILL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1), false));
    public static final ModifiedBucketItem HYDROGEN_BUCKET = (ModifiedBucketItem) registerItemGroupNormal("hydrogen_bucket", new ModifiedBucketItem(ModFluids.HYDROGEN_STILL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1), false));


    /**
     * URANIUM
     */
    public static final Item URANIUM_INGOT = registerItemGroupMaterials("uranium_ingot", new RadioactiveItem(new FabricItemSettings()));
    public static final Item RAW_URANIUM = registerItemGroupMaterials("raw_uranium", new RadioactiveItem(new FabricItemSettings()));


    /** ROCKET UPGRADE */
    public static final Item BASIC_FUEL_UPGRADE = registerItemGroupBasics("basic_fuel_upgrade", new RocketUpgradeItem(new FabricItemSettings(), 1, 0));
    public static final Item ADVANCED_FUEL_UPGRADE = registerItemGroupBasics("advanced_fuel_upgrade", new RocketUpgradeItem(new FabricItemSettings(), 3, 0));
    public static final Item HYDROGEN_MOTOR_UPGRADE = registerItemGroupBasics("hydrogen_motor_upgrade", new RocketUpgradeItem(new FabricItemSettings(), 0, -2));
    public static final Item URANIUM_MOTOR_UPGRADE = registerItemGroupBasics("uranium_motor_upgrade",  new RocketUpgradeItem(new FabricItemSettings(), 0, 1000000000));



    private static Item registerItemWithoutGroup(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), item);
    }

    private static Item registerItem(String name, Item item, ItemGroup group) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), item);
        addToItemGroup(item1, group);
        return item1;
    }

    private static Item registerItemGroupMaterials(String name, Item item) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), item);
        addToItemGroup(item1, ModItemGroups.MATERIALS_ITEM_GROUP);
        return item1;
    }

    private static Item registerItemGroupNormal(String name, Item item) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), item);
        addToItemGroup(item1, ModItemGroups.NORMAL_ITEM_GROUP);
        return item1;
    }

    private static Item registerItemGroupBasics(String name, Item item) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), item);
        addToItemGroup(item1, ModItemGroups.BASICS_ITEM_GROUP);
        return item1;
    }

    private static Item registerSpawnEgg(String name, Item item) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), item);
        addToItemGroup(item1, ModItemGroups.SPAWN_EGGS_ITEM_GROUP);
        return item1;
    }

    private static void addToItemGroup(Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        BeyondEarth.LOGGER.info("Registering Mod Items for " + BeyondEarth.MOD_ID);
    }
}
