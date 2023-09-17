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
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.common.blocks.custom.GlobeBlock;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;
import net.mrscauthd.beyond_earth.common.items.ModItemGroups;
import net.mrscauthd.beyond_earth.common.items.custom.GlobeItem;

public class ModBlocks {
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
    public static final PillarBlock IRON_MARK_BLOCK = (PillarBlock) registerBlock("iron_mark_block", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final PillarBlock DESH_PILLAR_BLOCK = (PillarBlock) registerBlock("desh_pillar", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block DESH_PLATING_BLOCK = registerBlock("desh_plating_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final PillarBlock BLUE_IRON_PILLAR = (PillarBlock) registerBlock("blue_iron_pillar", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).luminance(15).requiresTool()));
    public static final PillarBlock INFERNAL_SPIRE = (PillarBlock) registerBlock("infernal_spire", new PillarBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final PillarBlock BARRICADE_BLOCK = (PillarBlock) registerBlock("barricade_block", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final PillarBlock RED_BARRICADE_BLOCK = (PillarBlock) registerBlock("red_barricade_block", new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(5f, 2.5f).requiresTool()));
    public static final Block METEORITE = registerBlock("meteorite", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));


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
    public static final Block MERCURY_STONE = registerBlock("mercury_stone", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_MERCURY_STONE_BRICKS = registerBlock("cracked_mercury_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block MERCURY_STONE_BRICKS = registerBlock("mercury_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock MERCURY_STONE_BRICK_SLAB = (SlabBlock) registerBlock("mercury_stone_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock MERCURY_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("mercury_stone_brick_stairs", new StairsBlock(MERCURY_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(MERCURY_STONE_BRICKS).requiresTool()));

    // VENUS BLOCKS
    public static final PillarBlock VENUS_STONE = (PillarBlock) registerBlock("venus_stone", new PillarBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_VENUS_STONE_BRICKS = registerBlock("cracked_venus_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block VENUS_STONE_BRICKS = registerBlock("venus_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock VENUS_STONE_BRICK_SLAB = (SlabBlock) registerBlock("venus_stone_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock VENUS_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("venus_stone_brick_stairs", new StairsBlock(VENUS_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(VENUS_STONE_BRICKS).requiresTool()));

    // VENUS SANDSTONE BLOCKS
    public static final Block VENUS_SANDSTONE = registerBlock("venus_sandstone", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_VENUS_SANDSTONE_BRICKS = registerBlock("cracked_venus_sandstone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block VENUS_SANDSTONE_BRICKS = registerBlock("venus_sandstone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock VENUS_SANDSTONE_BRICK_SLAB = (SlabBlock) registerBlock("venus_sandstone_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock VENUS_SANDSTONE_BRICK_STAIRS = (StairsBlock) registerBlock("venus_sandstone_brick_stairs", new StairsBlock(VENUS_SANDSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(VENUS_SANDSTONE_BRICKS).requiresTool()));

    // GLACIO BLOCKS
    public static final Block PERMAFROST = registerBlock("permafrost", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block GLACIO_STONE = registerBlock("glacio_stone", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block CRACKED_GLACIO_STONE_BRICKS = registerBlock("cracked_glacio_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final Block GLACIO_STONE_BRICKS = registerBlock("glacio_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final SlabBlock GLACIO_STONE_BRICK_SLAB = (SlabBlock) registerBlock("glacio_stone_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 1f).requiresTool()));
    public static final StairsBlock GLACIO_STONE_BRICK_STAIRS = (StairsBlock) registerBlock("glacio_stone_brick_stairs", new StairsBlock(VENUS_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(VENUS_STONE_BRICKS).requiresTool()));

    // GLACIO WOOD SET
    public static final BlockSetType GLACIO_BLOCK_SET_TYPE = new BlockSetType("glacio");
    public static final WoodType GLACIO_WOOD_TYPE = new WoodType("glacio", GLACIO_BLOCK_SET_TYPE);
    public static final Block GLACIO_WOOD_LOG = registerBlock("glacio_wood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).requiresTool()));
    public static final Block GLACIO_WOOD = registerBlock("glacio_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).requiresTool()));
    public static final Block GLACIO_WOOD_LEAVES = registerBlock("glacio_tree_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).requiresTool()));
    public static final Block GLACIO_WOOD_PLANKS = registerBlock("glacio_wood_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).requiresTool()));
    //public static final Block GLACIO_TREE_SAPLING = registerBlock("glacio_tree_sapling",  new GlacioTreeSapling(new GlacioTreeGrower(), FabricBlockSettings.copy(Blocks.SPRUCE_SAPLING).requiresTool().noCollision()));
    public static final Block GLACIO_WOOD_DOOR = registerBlock("glacio_wood_door",  new DoorBlock(FabricBlockSettings.of(Material.WOOD, GLACIO_WOOD_PLANKS.getDefaultMapColor()).strength(3.0F).nonOpaque(), GLACIO_BLOCK_SET_TYPE));
    public static final Block GLACIO_WOOD_TRAPDOOR = registerBlock("glacio_wood_trapdoor",  new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD, GLACIO_WOOD_PLANKS.getDefaultMapColor()).strength(3.0F).nonOpaque(), GLACIO_BLOCK_SET_TYPE));
    public static final Block GLACIO_WOOD_STAIRS = registerBlock("glacio_wood_stairs", new StairsBlock(GLACIO_WOOD_PLANKS.getDefaultState(), FabricBlockSettings.copy(GLACIO_WOOD_PLANKS)));
    public static final Block GLACIO_WOOD_SLAB = registerBlock("glacio_wood_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block GLACIO_FENCE = registerBlock("glacio_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block GLACIO_FENCE_GATE = registerBlock("glacio_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE), GLACIO_WOOD_TYPE));
    public static final Block GLACIO_BUTTON = registerBlock("glacio_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE), GLACIO_BLOCK_SET_TYPE, 30,true));
    public static final Block GLACIO_PRESSURE_PLATE = registerBlock("glacio_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.copy(Blocks.OAK_FENCE), GLACIO_BLOCK_SET_TYPE));



    // PERMAFROST GRASS
    //public static final Block PERMAFROST_GRASS = registerBlock("permafrost_grass",  new PermafrostGrass(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block PERMAFROST_DIRT = registerBlock("permafrost_dirt", new Block(FabricBlockSettings.copy(Blocks.DIRT)));

    /**
     * FALLING BLOCKS
     */
    public static final Block MOON_SAND = registerBlock("moon_sand", new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f)));
    public static final Block MARS_SAND = registerBlock("mars_sand", new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f)));
    public static final Block VENUS_SAND = registerBlock("venus_sand", new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).strength(0.5f, 0.5f)));


    /**
     * ORES
     */
    public static final Block MOON_CHEESE_ORE = registerBlock("moon_cheese_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MOON_DESH_ORE = registerBlock("moon_desh_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MOON_IRON_ORE = registerBlock("moon_iron_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MOON_ICE_SHARD_ORE = registerBlock("moon_ice_shard_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block MARS_IRON_ORE = registerBlock("mars_iron_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MARS_DIAMOND_ORE = registerBlock("mars_diamond_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block MARS_OSTRUM_ORE = registerBlock("mars_ostrum_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block MARS_ICE_SHARD_ORE = registerBlock("mars_ice_shard_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block MERCURY_IRON_ORE = registerBlock("mercury_iron_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block VENUS_COAL_ORE = registerBlock("venus_coal_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block VENUS_GOLD_ORE = registerBlock("venus_gold_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block VENUS_DIAMOND_ORE = registerBlock("venus_diamond_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block VENUS_CALORITE_ORE = registerBlock("venus_calorite_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block GLACIO_ICE_SHARD_ORE = registerBlock("glacio_ice_shard_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block GLACIO_COAL_ORE = registerBlock("glacio_coal_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block GLACIO_COPPER_ORE = registerBlock("glacio_copper_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block GLACIO_IRON_ORE = registerBlock("glacio_iron_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block GLACIO_LAPIS_ORE = registerBlock("glacio_lapis_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).requiresTool(), UniformIntProvider.create(2, 5)));

    /**
     * GLOBE BLOCKS
     */
    public static final GlobeBlock EARTH_GLOBE_BLOCK = registerGlobeBlock("earth_globe", new GlobeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5F).nonOpaque().requiresTool(), new Identifier(BeyondEarth.MOD_ID, "textures/block/globes/earth_globe.png")));
    public static final GlobeBlock MOON_GLOBE_BLOCK = registerGlobeBlock("moon_globe", new GlobeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5F).nonOpaque().requiresTool(), new Identifier(BeyondEarth.MOD_ID, "textures/block/globes/moon_globe.png")));
    public static final GlobeBlock MARS_GLOBE_BLOCK = registerGlobeBlock("mars_globe", new GlobeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5F).nonOpaque().requiresTool(), new Identifier(BeyondEarth.MOD_ID, "textures/block/globes/mars_globe.png")));
    public static final GlobeBlock MERCURY_GLOBE_BLOCK = registerGlobeBlock("mercury_globe", new GlobeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5F).nonOpaque().requiresTool(), new Identifier(BeyondEarth.MOD_ID, "textures/block/globes/mercury_globe.png")));
    public static final GlobeBlock VENUS_GLOBE_BLOCK = registerGlobeBlock("venus_globe", new GlobeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5F).nonOpaque().requiresTool(), new Identifier(BeyondEarth.MOD_ID, "textures/block/globes/venus_globe.png")));
    public static final GlobeBlock GLACIO_GLOBE_BLOCK = registerGlobeBlock("glacio_globe", new GlobeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5F).nonOpaque().requiresTool(), new Identifier(BeyondEarth.MOD_ID, "textures/block/globes/glacio_globe.png")));


    //LIQUID BLOCKS
    public static final FluidBlock FUEL_BLOCK = (FluidBlock) registerBlockWithoutBlockItem("fuel", new FluidBlock(ModFluids.FUEL_STILL, FabricBlockSettings.of(Material.WATER).noCollision().nonOpaque().strength(100).dropsNothing()));
    public static final FluidBlock OIL_BLOCK = (FluidBlock) registerBlockWithoutBlockItem("oil", new FluidBlock(ModFluids.OIL_STILL, FabricBlockSettings.of(Material.WATER).noCollision().nonOpaque().strength(100).dropsNothing()));


    private static Block registerBlock(String name, Block block) {
        Item item = registerBlockItem(name, block);
        addBlockItemToGroup(item, ModItemGroups.BLOCKS_ITEM_GROUP);
        return Registry.register(Registries.BLOCK, new Identifier(BeyondEarth.MOD_ID, name), block);
    }

    private static GlobeBlock registerGlobeBlock(String name, GlobeBlock block) {
        Item item = registerGlobeBlockItem(name, block);
        addBlockItemToGroup(item, ModItemGroups.GLOBES_ITEM_GROUP);
        return Registry.register(Registries.BLOCK, new Identifier(BeyondEarth.MOD_ID, name), block);
    }

    private static BlockItem registerGlobeBlockItem(String name, GlobeBlock block) {
        return Registry.register(Registries.ITEM, new Identifier(BeyondEarth.MOD_ID, name), new GlobeItem(block, new FabricItemSettings().rarity(Rarity.EPIC), block.texture));
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
        BeyondEarth.LOGGER.info("Registering blocks for " + BeyondEarth.MOD_ID);
    }
}
