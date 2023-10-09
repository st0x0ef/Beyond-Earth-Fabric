package com.st0x0ef.beyond_earth.common.items.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class CoalTorchItem extends BlockItem {
    protected final Block wallBlock;
    public CoalTorchItem(Block floorBlock, Block wallBlockIn, Settings settings) {
        super(floorBlock, settings);
        this.wallBlock = wallBlockIn;
    }

    @Nullable
    @Override
    protected BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = this.wallBlock.getPlacementState(context);
        BlockState blockstate1 = null;
        WorldAccess iworldreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();

        for(Direction direction : context.getPlacementDirections()) {
            if (direction != Direction.UP) {
                BlockState blockstate2 = direction == Direction.DOWN ? this.getBlock().getPlacementState(context) : blockstate;
                if (blockstate2 != null && blockstate2.canPlaceAt(iworldreader, blockpos)) {
                    blockstate1 = blockstate2;
                    break;
                }
            }
        }
        return blockstate1 != null && iworldreader.canPlace(blockstate1, blockpos, ShapeContext.absent()) ? blockstate1 : null;
    }

    @Override
    public void appendBlocks(Map<Block, Item> map, Item item) {
        super.appendBlocks(map, item);
        map.put(this.wallBlock, item);
    }
}
