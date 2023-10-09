package com.st0x0ef.beyond_earth.common.blocks.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class WallCoalTorchBlock extends CoalTorchBlock{
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, createCuboidShape(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, createCuboidShape(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, createCuboidShape(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, createCuboidShape(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));

    public WallCoalTorchBlock(Settings settings) {
        super(settings);
    }

    @Override
    public String getTranslationKey() {
        return this.asItem().getTranslationKey();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShapeForState(state);
    }

    public static VoxelShape getShapeForState(BlockState state) {
        return SHAPES.get(state.get(FACING));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockpos = pos.offset(direction.getOpposite());
        BlockState blockstate = world.getBlockState(blockpos);
        return blockstate.isSideSolid(world, blockpos, direction, SideShapeType.CENTER);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = this.getDefaultState();
        WorldAccess iworldreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        Direction[] adirection = context.getPlacementDirections();

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.with(FACING, direction1);
                if (blockstate.canPlaceAt(iworldreader, blockpos)) {
                    return blockstate;
                }
            }
        }
        return null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing.getOpposite() == stateIn.get(FACING) && !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

