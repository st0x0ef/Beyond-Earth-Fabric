package net.mrscauthd.beyond_earth.common.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SPAWN_EGGS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_spawn_eggs"))
            .icon(() -> new ItemStack(Items.SHEEP_SPAWN_EGG)).build();
    public static final ItemGroup NORMAL_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_normal"))
            .icon(() -> new ItemStack(Items.COAL)).build();
    public static final ItemGroup GLOBES_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_globes"))
            .icon(() -> new ItemStack(Items.CARTOGRAPHY_TABLE)).build();
    public static final ItemGroup MACHINES_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_machines"))
            .icon(() -> new ItemStack(Items.PISTON)).build();
    public static final ItemGroup BASICS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_basics"))
            .icon(() -> new ItemStack(ModItems.DESH_ENGINE)).build();
    public static final ItemGroup MATERIALS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_materials"))
            .icon(() -> new ItemStack(ModItems.IRON_PLATE)).build();
    public static final ItemGroup BLOCKS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_blocks"))
            .icon(() -> new ItemStack(ModBlocks.MOON_IRON_ORE)).build();

    public static void registerModItemGroups(){
        BeyondEarth.LOGGER.info("Registering item groups for " + BeyondEarth.MOD_ID);
    }
}
