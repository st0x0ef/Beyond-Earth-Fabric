package com.st0x0ef.beyond_earth.common.blocks.custom;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SnowyBlock;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class PermafrostGrass extends SnowyBlock {
    public PermafrostGrass(Settings settings) {
        super(settings);
    }

    private static boolean canBeGrass(BlockState state, WorldView reader, BlockPos pos) {
        BlockPos above = pos.up();
        BlockState blockstate = reader.getBlockState(above);
        if (blockstate.isOf(Blocks.SNOW) && blockstate.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(reader, state, pos, blockstate, above, Direction.UP, blockstate.getOpacity(reader, above));
            return i < reader.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState state, WorldView reader, BlockPos pos) {
        BlockPos above = pos.up();
        return canBeGrass(state, reader, pos) && !reader.getFluidState(above).isIn(FluidTags.WATER);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        BlockPos above = pos.up();
        if (!level.isClient && !this.isAreaLoaded(level ,pos, 3)) {
            if (!level.getBlockState(above).isAir()) {
                level.setBlockState(pos, ModBlocks.PERMAFROST_DIRT.getDefaultState());
            }
        } else {
            if (!this.isAreaLoaded(level ,pos, 3)) return;
            if (level.getLightLevel(above) >= 9) {
                BlockState blockstate = this.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (level.getBlockState(blockpos).isOf(ModBlocks.PERMAFROST_DIRT) && canPropagate(blockstate, level, blockpos)) {
                        level.setBlockState(blockpos, blockstate.with(SNOWY, level.getBlockState(blockpos.up()).isOf(Blocks.SNOW)));
                    }
                }
            }
        }
    }

    private boolean isAreaLoaded(ServerWorld serverWorld, BlockPos center, int range) {
        return serverWorld.isRegionLoaded(center.add(-range, -range, -range), center.add(range, range, range));
    }
}
