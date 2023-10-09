package com.st0x0ef.beyond_earth.common.blocks.entities.custom.uranium;

import com.st0x0ef.beyond_earth.common.blocks.entities.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
public class MercuryUraniumOreEntity extends UraniumBaseBlockEntity {

    public MercuryUraniumOreEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MERCURY_URANIUM_ORE_BLOCK_ENTITY, pos, state);
    }
}
