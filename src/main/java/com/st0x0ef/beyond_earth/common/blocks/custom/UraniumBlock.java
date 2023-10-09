package com.st0x0ef.beyond_earth.common.blocks.custom;

import com.st0x0ef.beyond_earth.common.blocks.entities.custom.uranium.UraniumBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UraniumBlock extends BlockWithEntity {
    public UraniumBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new UraniumBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof UraniumBlockEntity entity) {
                entity.tick();
            }
        };
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
