package com.st0x0ef.beyond_earth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.items.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // SPECIAL BLOCKS
        blockStateModelGenerator.registerLantern(ModBlocks.COAL_LANTERN_BLOCK);
        blockStateModelGenerator.registerTorch(ModBlocks.COAL_TORCH_BLOCK, ModBlocks.WALL_COAL_TORCH_BLOCK);

        // ORES
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_CHEESE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_DESH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_ICE_SHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARS_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARS_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARS_OSTRUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARS_ICE_SHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MERCURY_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENUS_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENUS_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENUS_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENUS_CALORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_ICE_SHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_LAPIS_ORE);

        // FALLING BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARS_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENUS_SAND);

        // NORMAL BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DESH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OSTRUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALORITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_DESH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_OSTRUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_CALORITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_PLATING_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DESH_PLATING_BLOCK);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.DESH_PILLAR_BLOCK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.BLUE_IRON_PILLAR, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.BARRICADE_BLOCK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.RED_BARRICADE_BLOCK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.IRON_MARK_BLOCK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);

        // NATURAL BLOCKS (without category)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEORITE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.INFERNAL_SPIRE, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);

        // MOON BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_MOON_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool moonStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOON_STONE_BRICKS);
        moonStonePool.slab(ModBlocks.MOON_STONE_BRICK_SLAB);
        moonStonePool.stairs(ModBlocks.MOON_STONE_BRICK_STAIRS);

        // MARS BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARS_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_MARS_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool marsStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARS_STONE_BRICKS);
        marsStonePool.slab(ModBlocks.MARS_STONE_BRICK_SLAB);
        marsStonePool.stairs(ModBlocks.MARS_STONE_BRICK_STAIRS);

        // MERCURY BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MERCURY_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_MERCURY_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool mercuryStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MERCURY_STONE_BRICKS);
        mercuryStonePool.slab(ModBlocks.MERCURY_STONE_BRICK_SLAB);
        mercuryStonePool.stairs(ModBlocks.MERCURY_STONE_BRICK_STAIRS);

        // VENUS BLOCKS
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VENUS_STONE, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_VENUS_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool venusStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VENUS_STONE_BRICKS);
        venusStonePool.slab(ModBlocks.VENUS_STONE_BRICK_SLAB);
        venusStonePool.stairs(ModBlocks.VENUS_STONE_BRICK_STAIRS);

        // VENUS SANDSTONE BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENUS_SANDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_VENUS_SANDSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool venusSandStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VENUS_SANDSTONE_BRICKS);
        venusSandStonePool.slab(ModBlocks.VENUS_SANDSTONE_BRICK_SLAB);
        venusSandStonePool.stairs(ModBlocks.VENUS_SANDSTONE_BRICK_STAIRS);

        // GLACIO BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PERMAFROST);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_GLACIO_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool glacioStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLACIO_STONE_BRICKS);
        glacioStonePool.slab(ModBlocks.GLACIO_STONE_BRICK_SLAB);
        glacioStonePool.stairs(ModBlocks.GLACIO_STONE_BRICK_STAIRS);
        blockStateModelGenerator.registerLog(ModBlocks.GLACIO_WOOD_LOG).log(ModBlocks.GLACIO_WOOD_LOG).wood(ModBlocks.GLACIO_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_WOOD_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PERMAFROST_DIRT);
        BlockStateModelGenerator.BlockTexturePool glacioPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLACIO_WOOD_PLANKS);
        glacioPlanksPool.stairs(ModBlocks.GLACIO_WOOD_STAIRS);
        glacioPlanksPool.slab(ModBlocks.GLACIO_WOOD_SLAB);
        glacioPlanksPool.fence(ModBlocks.GLACIO_FENCE);
        glacioPlanksPool.fenceGate(ModBlocks.GLACIO_FENCE_GATE);
        glacioPlanksPool.button(ModBlocks.GLACIO_BUTTON);
        glacioPlanksPool.pressurePlate(ModBlocks.GLACIO_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.GLACIO_WOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GLACIO_WOOD_TRAPDOOR);

        // URANIUM
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MERCURY_URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLACIO_URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_URANIUM_BLOCK);

        // FLUIDS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FUEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OIL_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CALORITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_STEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_DESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_OSTRUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_CALORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALORITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_DESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_OSTRUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CALORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXYGEN_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXYGEN_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENGINE_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENGINE_FAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCKET_NOSE_CONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALORITE_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALORITE_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCKET_FIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FUEL_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.OIL_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADVANCED_FUEL_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BASIC_FUEL_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HYDROGEN_MOTOR_UPGRADE, Models.GENERATED);
    }
}
