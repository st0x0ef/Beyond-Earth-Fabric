package net.mrscauthd.beyond_earth.common.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.common.items.ModItemGroups;

public class ModBlocks {
    /** ORES */
    public static final Block MOON_CHEESE_ORE = registerBlock("moon_cheese_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MOON_DESH_ORE = registerBlock("moon_desh_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MOON_IRON_ORE = registerBlock("moon_iron_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MOON_ICE_SHARD_ORE = registerBlock("moon_ice_shard_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block MARS_IRON_ORE = registerBlock("mars_iron_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MARS_DIAMOND_ORE = registerBlock("mars_diamond_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block MARS_OSTRUM_ORE = registerBlock("mars_ostrum_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MARS_ICE_SHARD_ORE = registerBlock("mars_ice_shard_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block MERCURY_IRON_ORE = registerBlock("mercury_iron_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block VENUS_COAL_ORE = registerBlock("venus_coal_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block VENUS_GOLD_ORE = registerBlock("venus_gold_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block VENUS_DIAMOND_ORE = registerBlock("venus_diamond_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block VENUS_CALORITE_ORE = registerBlock("venus_calorite_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block GLACIO_ICE_SHARD_ORE = registerBlock("glacio_ice_shard_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block GLACIO_COAL_ORE = registerBlock("glacio_coal_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block GLACIO_COPPER_ORE = registerBlock("glacio_copper_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block GLACIO_IRON_ORE = registerBlock("glacio_iron_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block GLACIO_LAPIS_ORE = registerBlock("glacio_lapis_ore",  new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(2, 5)));


    /** FALLING BLOCKS */
    public static final Block MOON_SAND = registerBlock("moon_sand",  new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f)));
    public static final Block MARS_SAND = registerBlock("mars_sand",  new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f)));
    public static final Block VENUS_SAND = registerBlock("venus_sand",  new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f)));


    /**
     * NORMAL BLOCKS
     */
    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block DESH_BLOCK = registerBlock("desh_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block OSTRUM_BLOCK = registerBlock("ostrum_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block CALORITE_BLOCK = registerBlock("calorite_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block RAW_DESH_BLOCK = registerBlock("raw_desh_block", new Block(FabricBlockSettings.of(Material.METAL).strength(1.5f, 1f).requiresTool()));
    public static final Block RAW_OSTRUM_BLOCK = registerBlock("raw_ostrum_block", new Block(FabricBlockSettings.of(Material.METAL).strength(1.5f, 1f).requiresTool()));
    public static final Block RAW_CALORITE_BLOCK = registerBlock("raw_calorite_block", new Block(FabricBlockSettings.of(Material.METAL).strength(1.5f, 1f).requiresTool()));
    public static final Block IRON_PLATING_BLOCK = registerBlock("iron_plating_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final PillarBlock DESH_PILLAR_BLOCK = (PillarBlock) registerBlock("desh_pillar", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block DESH_PLATING_BLOCK = registerBlock("desh_plating_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final PillarBlock BLUE_IRON_PILLAR = (PillarBlock) registerBlock("blue_iron_pillar", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).luminance(15).requiresTool()));
    public static final PillarBlock BARRICADE_BLOCK = (PillarBlock) registerBlock("barricade_block", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final PillarBlock IRON_MARK_BLOCK = (PillarBlock) registerBlock("iron_mark_block", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));

    // NATURAL BLOCKS (without category)
    public static final Block METEORITE = registerBlock("meteorite", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final PillarBlock INFERNAL_SPIRE = (PillarBlock) registerBlock("infernal_spire", new PillarBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));

    // MOON BLOCKS
    public static final Block MOON_STONE = registerBlock("moon_stone", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_MOON_STONE_BRICKS = registerBlock("cracked_moon_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block MOON_STONE_BRICKS = registerBlock("moon_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock MOON_STONE_BRICK_SLAB = (SlabBlock) registerBlock("moon_stone_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock MOON_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("moon_stone_brick_stairs", new StairsBlock(MOON_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(MOON_STONE_BRICKS).requiresTool()));

    // MARS BLOCKS
    public static final Block MARS_STONE = registerBlock("mars_stone", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_MARS_STONE_BRICKS = registerBlock("cracked_mars_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block MARS_STONE_BRICKS = registerBlock("mars_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock MARS_STONE_BRICK_SLAB = (SlabBlock) registerBlock("mars_stone_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock MARS_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("mars_stone_brick_stairs", new StairsBlock(MARS_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(MARS_STONE_BRICKS).requiresTool()));

    // MERCURY BLOCKS
    public static final Block MERCURY_STONE = registerBlock("mercury_stone",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_MERCURY_STONE_BRICKS = registerBlock("cracked_mercury_stone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block MERCURY_STONE_BRICKS = registerBlock("mercury_stone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock MERCURY_STONE_BRICK_SLAB = (SlabBlock) registerBlock("mercury_stone_brick_slab",  new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock MERCURY_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("mercury_stone_brick_stairs",  new StairsBlock( MERCURY_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(MERCURY_STONE_BRICKS).requiresTool()));

    // VENUS BLOCKS
    public static final PillarBlock VENUS_STONE = (PillarBlock) registerBlock("venus_stone",  new PillarBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_VENUS_STONE_BRICKS = registerBlock("cracked_venus_stone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block VENUS_STONE_BRICKS = registerBlock("venus_stone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock VENUS_STONE_BRICK_SLAB = (SlabBlock) registerBlock("venus_stone_brick_slab",  new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock VENUS_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("venus_stone_brick_stairs",  new StairsBlock( VENUS_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(VENUS_STONE_BRICKS).requiresTool()));

    // VENUS SANDSTONE BLOCKS
    public static final Block VENUS_SANDSTONE = registerBlock("venus_sandstone",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_VENUS_SANDSTONE_BRICKS = registerBlock("cracked_venus_sandstone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block VENUS_SANDSTONE_BRICKS = registerBlock("venus_sandstone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock VENUS_SANDSTONE_BRICK_SLAB = (SlabBlock) registerBlock("venus_sandstone_brick_slab",  new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock VENUS_SANDSTONE_BRICK_STAIRS = (StairsBlock) registerBlock("venus_sandstone_brick_stairs",  new StairsBlock( VENUS_SANDSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(VENUS_SANDSTONE_BRICKS).requiresTool()));

    // GLACIO BLOCKS
    public static final Block GLACIO_STONE = registerBlock("glacio_stone",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block PERMAFROST = registerBlock("permafrost",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_GLACIO_STONE_BRICKS = registerBlock("cracked_glacio_stone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block GLACIO_STONE_BRICKS = registerBlock("glacio_stone_bricks",  new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock GLACIO_STONE_BRICK_SLAB = (SlabBlock) registerBlock("glacio_stone_brick_slab",  new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock GLACIO_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("glacio_stone_brick_stairs",  new StairsBlock( VENUS_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(VENUS_STONE_BRICKS).requiresTool()));


    private static Block registerBlock(String name, Block block) {
        Item item = registerBlockItem(name, block);
        addBlockItemToGroup(item, ModItemGroups.BLOCKS_ITEM_GROUP);
        return Registry.register(Registries.BLOCK, new Identifier(BeyondEarth.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BeyondEarth.MOD_ID, name), block);
    }

    private static void addBlockItemToGroup(Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> content.add(item));
    }

    public static void registerModBlocks() {
        BeyondEarth.LOGGER.info("Registering Mod blocks for " + BeyondEarth.MOD_ID);
    }
}
