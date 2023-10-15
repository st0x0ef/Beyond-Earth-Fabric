package com.st0x0ef.beyond_earth.datagen;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {

    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        /** SELF DROP */
        addDrop(ModBlocks.ROCKET_LAUNCH_PAD);
        addDrop(ModBlocks.COAL_TORCH_BLOCK);
        addDrop(ModBlocks.COAL_LANTERN_BLOCK);
        addDrop(ModBlocks.EARTH_GLOBE_BLOCK);
        addDrop(ModBlocks.MOON_GLOBE_BLOCK);
        addDrop(ModBlocks.MARS_GLOBE_BLOCK);
        addDrop(ModBlocks.MERCURY_GLOBE_BLOCK);
        addDrop(ModBlocks.VENUS_GLOBE_BLOCK);
        addDrop(ModBlocks.GLACIO_GLOBE_BLOCK);
        addDrop(ModBlocks.MOON_SAND);
        addDrop(ModBlocks.MARS_SAND);
        addDrop(ModBlocks.VENUS_SAND);
        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.DESH_BLOCK);
        addDrop(ModBlocks.OSTRUM_BLOCK);
        addDrop(ModBlocks.CALORITE_BLOCK);
        addDrop(ModBlocks.RAW_DESH_BLOCK);
        addDrop(ModBlocks.RAW_OSTRUM_BLOCK);
        addDrop(ModBlocks.RAW_CALORITE_BLOCK);
        addDrop(ModBlocks.IRON_PLATING_BLOCK);
        addDrop(ModBlocks.DESH_PILLAR_BLOCK);
        addDrop(ModBlocks.DESH_PLATING_BLOCK);
        addDrop(ModBlocks.BLUE_IRON_PILLAR);
        addDrop(ModBlocks.BARRICADE_BLOCK);
        addDrop(ModBlocks.IRON_MARK_BLOCK);
        addDrop(ModBlocks.METEORITE);
        addDrop(ModBlocks.INFERNAL_SPIRE);
        addDrop(ModBlocks.MOON_STONE);
        addDrop(ModBlocks.CRACKED_MOON_STONE_BRICKS);
        addDrop(ModBlocks.MOON_STONE_BRICKS);
        addDrop(ModBlocks.MOON_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.MARS_STONE);
        addDrop(ModBlocks.CRACKED_MARS_STONE_BRICKS);
        addDrop(ModBlocks.MARS_STONE_BRICKS);
        addDrop(ModBlocks.MARS_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.MERCURY_STONE);
        addDrop(ModBlocks.CRACKED_MERCURY_STONE_BRICKS);
        addDrop(ModBlocks.MERCURY_STONE_BRICKS);
        addDrop(ModBlocks.MERCURY_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.VENUS_STONE);
        addDrop(ModBlocks.CRACKED_VENUS_STONE_BRICKS);
        addDrop(ModBlocks.VENUS_STONE_BRICKS);
        addDrop(ModBlocks.VENUS_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.VENUS_SANDSTONE);
        addDrop(ModBlocks.CRACKED_VENUS_SANDSTONE_BRICKS);
        addDrop(ModBlocks.VENUS_SANDSTONE_BRICKS);
        addDrop(ModBlocks.VENUS_SANDSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.GLACIO_STONE);
        addDrop(ModBlocks.PERMAFROST);
        addDrop(ModBlocks.CRACKED_GLACIO_STONE_BRICKS);
        addDrop(ModBlocks.GLACIO_STONE_BRICKS);
        addDrop(ModBlocks.GLACIO_STONE_BRICK_STAIRS);
        /*addDrop(ModBlocks.FUEL_REFINERY_BLOCK);
        addDrop(ModBlocks.COMPRESSOR_BLOCK);
        addDrop(ModBlocks.COAL_GENERATOR_BLOCK);
        addDrop(ModBlocks.OXYGEN_LOADER_BLOCK);
        addDrop(ModBlocks.SOLAR_PANEL_BLOCK);
        addDrop(ModBlocks.NASA_WORKBENCH_BLOCK);
        addDrop(ModBlocks.OXYGEN_BUBBLE_DISTRIBUTOR_BLOCK);
        addDrop(ModBlocks.WATER_PUMP_BLOCK);*/
        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.RAW_URANIUM_BLOCK);
        addDrop(ModBlocks.GLACIO_WOOD_PLANKS);
        addDrop(ModBlocks.GLACIO_WOOD_TRAPDOOR);
        addDrop(ModBlocks.GLACIO_WOOD_STAIRS);
        addDrop(ModBlocks.GLACIO_FENCE);
        addDrop(ModBlocks.GLACIO_FENCE_GATE);
        addDrop(ModBlocks.GLACIO_BUTTON);
        addDrop(ModBlocks.GLACIO_PRESSURE_PLATE);
        addDrop(ModBlocks.GLACIO_WOOD);
        addDrop(ModBlocks.PERMAFROST_DIRT);
        addDrop(ModBlocks.PERMAFROST_GRASS);


        /** ORE DROP */
        addOreDrop(ModBlocks.MOON_CHEESE_ORE, ModItems.CHEESE);
        addOreDrop(ModBlocks.MOON_DESH_ORE, ModItems.RAW_DESH);
        addOreDrop(ModBlocks.MOON_IRON_ORE, Items.RAW_IRON);
        addOreDrop(ModBlocks.MOON_ICE_SHARD_ORE, ModItems.ICE_SHARD);
        addOreDrop(ModBlocks.MARS_IRON_ORE, Items.RAW_IRON);
        addOreDrop(ModBlocks.MARS_DIAMOND_ORE, Items.DIAMOND);
        addOreDrop(ModBlocks.MARS_OSTRUM_ORE, ModItems.RAW_OSTRUM);
        addOreDrop(ModBlocks.MARS_ICE_SHARD_ORE, ModItems.ICE_SHARD);
        addOreDrop(ModBlocks.MERCURY_IRON_ORE, Items.RAW_IRON);
        addOreDrop(ModBlocks.MERCURY_URANIUM_ORE, ModItems.RAW_URANIUM);
        addOreDrop(ModBlocks.VENUS_COAL_ORE, Items.COAL);
        addOreDrop(ModBlocks.VENUS_GOLD_ORE, Items.RAW_GOLD);
        addOreDrop(ModBlocks.VENUS_DIAMOND_ORE, Items.DIAMOND);
        addOreDrop(ModBlocks.VENUS_CALORITE_ORE, ModItems.RAW_CALORITE);
        addOreDrop(ModBlocks.GLACIO_ICE_SHARD_ORE, ModItems.ICE_SHARD);
        addOreDrop(ModBlocks.GLACIO_COAL_ORE, Items.COAL);
        addDrop(ModBlocks.GLACIO_COPPER_ORE , copperOreDrops(ModBlocks.GLACIO_COPPER_ORE));
        addOreDrop(ModBlocks.GLACIO_IRON_ORE, Items.RAW_IRON);
        addDrop(ModBlocks.GLACIO_LAPIS_ORE, lapisOreDrops(ModBlocks.GLACIO_LAPIS_ORE));
        addOreDrop(ModBlocks.GLACIO_URANIUM_ORE, ModItems.RAW_URANIUM);

        /**SPECIAL DROPS*/
        addSlabDrop(ModBlocks.MOON_STONE_BRICK_SLAB);
        addSlabDrop(ModBlocks.MARS_STONE_BRICK_SLAB);
        addSlabDrop(ModBlocks.MERCURY_STONE_BRICK_SLAB);
        addSlabDrop(ModBlocks.VENUS_STONE_BRICK_SLAB);
        addSlabDrop(ModBlocks.VENUS_SANDSTONE_BRICK_SLAB);
        addSlabDrop(ModBlocks.GLACIO_STONE_BRICK_SLAB);
        addSlabDrop(ModBlocks.GLACIO_WOOD_SLAB);
        addDrop(ModBlocks.GLACIO_WOOD_DOOR, doorDrops(ModBlocks.GLACIO_WOOD_DOOR));
    }

    private void addSlabDrop(Block block) {
        addDrop(block, slabDrops(block));
    }

    private void addOreDrop(Block block, Item item) {
        addDrop(block, oreDrops(block, item));
    }
}
