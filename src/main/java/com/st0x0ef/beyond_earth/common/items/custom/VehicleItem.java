package com.st0x0ef.beyond_earth.common.items.custom;

import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.WorldView;

public class VehicleItem extends Item {
    public VehicleItem(Settings settings) {
        super(settings);
    }
    protected static double getYOffset(WorldView reader, BlockPos pos, boolean p_20628_, Box p_20629_) {
        Box aabb = new Box(pos);
        if (p_20628_) {
            aabb = aabb.stretch(0.0D, -1.0D, 0.0D);
        }

        Iterable<VoxelShape> iterable = reader.getCollisions(null, aabb);
        return 1.0D + VoxelShapes.calculateMaxOffset(Direction.Axis.Y, p_20629_, iterable, p_20628_ ? -2.0D : -1.0D);
    }

}
