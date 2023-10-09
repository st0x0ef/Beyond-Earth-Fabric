package com.st0x0ef.beyond_earth.common.blocks.entities.custom.uranium;

import com.st0x0ef.beyond_earth.common.blocks.entities.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;


public class RawUraniumBlockEntity extends UraniumBaseBlockEntity {

    public RawUraniumBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.URANIUM_RAW_BLOCK_ENTITY, pos, state);
    }


}
