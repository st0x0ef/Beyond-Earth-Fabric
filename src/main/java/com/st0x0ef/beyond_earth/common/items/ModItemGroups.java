package com.st0x0ef.beyond_earth.common.items;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;

public class ModItemGroups {

    public static final ItemGroup NORMAL_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_normal"))
            .icon(() -> new ItemStack(Items.COAL)).build();
    public static final ItemGroup MACHINES_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_machines"))
            .icon(() -> new ItemStack(Items.PISTON)).build();
    public static final ItemGroup BASICS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_basics"))
            .icon(() -> new ItemStack(ModItems.DESH_ENGINE)).build();
    public static final ItemGroup MATERIALS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_materials"))
            .icon(() -> new ItemStack(ModItems.IRON_PLATE)).build();
    public static final ItemGroup GLOBES_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_globes"))
            .icon(() -> new ItemStack(ModBlocks.GLACIO_GLOBE_BLOCK)).build();
    public static final ItemGroup BLOCKS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_blocks"))
            .icon(() -> new ItemStack(ModBlocks.MOON_STONE_BRICKS)).build();
    public static final ItemGroup SPAWN_EGGS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(BeyondEarth.MOD_ID, "tab_spawn_eggs"))
            .icon(() -> new ItemStack(ModItems.ALIEN_SPAWN_EGG)).build();

    public static void registerModItemGroups(){
        BeyondEarth.LOGGER.info("Registering item groups for " + BeyondEarth.MOD_ID);
    }
}
