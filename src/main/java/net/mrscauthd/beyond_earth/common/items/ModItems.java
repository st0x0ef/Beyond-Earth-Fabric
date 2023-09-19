package net.mrscauthd.beyond_earth.common.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;
import net.mrscauthd.beyond_earth.common.items.custom.HammerItem;
import net.mrscauthd.beyond_earth.common.items.custom.ModifiedBucketItem;
import net.mrscauthd.beyond_earth.common.items.custom.RadioactiveItem;

public class ModItems {
    /**
     * NORMAL ITEMS
     */
    // SPECIAL ITEMS
    //public static final RegistryObject<Item> COAL_TORCH_ITEM = ITEMS.register("coal_torch", () -> new CoalTorchItem(BlockRegistry.COAL_TORCH_BLOCK.get(), BlockRegistry.WALL_COAL_TORCH_BLOCK.get(),new Item.Properties().tab(Tabs.tab_basics)));

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

    /**
     * URANIUM
     */
    public static final Item URANIUM_INGOT = registerItemGroupMaterials("uranium_ingot", new RadioactiveItem(new FabricItemSettings()));
    public static final Item RAW_URANIUM = registerItemGroupMaterials("raw_uranium", new RadioactiveItem(new FabricItemSettings()));


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

    private static void addToItemGroup(Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        BeyondEarth.LOGGER.info("Registering Mod Items for " + BeyondEarth.MOD_ID);
    }
}
