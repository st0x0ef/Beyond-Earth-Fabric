package com.st0x0ef.beyond_earth.common.blocks.entities;

import com.st0x0ef.beyond_earth.common.blocks.entities.custom.FlagBlockEntity;
import com.st0x0ef.beyond_earth.common.blocks.entities.custom.GlobeTileEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<GlobeTileEntity> GLOBE_TILE_ENTITY;

    public static BlockEntityType<FlagBlockEntity> FLAG_BLOCK_ENTITY;

    public static void registerAllBlockEntities() {
        GLOBE_TILE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "globe"),
                FabricBlockEntityTypeBuilder.create(GlobeTileEntity::new, ModBlocks.EARTH_GLOBE_BLOCK, ModBlocks.GLACIO_GLOBE_BLOCK, ModBlocks.MARS_GLOBE_BLOCK,
                        ModBlocks.MOON_GLOBE_BLOCK, ModBlocks.VENUS_GLOBE_BLOCK ,ModBlocks.MERCURY_GLOBE_BLOCK, ModBlocks.MOON_GLOBE_BLOCK).build());

        FLAG_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "flag"),
                FabricBlockEntityTypeBuilder.create(FlagBlockEntity::new, ModBlocks.FLAG_BLOCK).build());
    }
}
