package com.st0x0ef.beyond_earth.common.blocks.custom;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RocketLaunchPadBlock extends Block implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty STAGE = Properties.LIT;

    public static final VoxelShape SHAPE_HIGH = VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1);
    public static final VoxelShape SHAPE_NORMAL = VoxelShapes.cuboid(0, 0, 0, 1, 0.187, 1);


    public RocketLaunchPadBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(STAGE, false));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        boolean flag = context.getWorld().getFluidState(context.getBlockPos()).isOf(Fluids.WATER);
        return this.getDefaultState().with(WATERLOGGED, flag);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, STAGE);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.getBlockState(pos.down()).isOf(state.getBlock());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(STAGE)) {
            return SHAPE_HIGH;
        } else {
            return SHAPE_NORMAL;
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        world.scheduleBlockTick(pos, this, 1);

    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        int y = pos.getY();

        /** POS FOR 3x3 */
        int x = pos.getX() - 1;
        int z = pos.getZ() - 1;

        /** POS FOR 5x5 */
        int x2 = pos.getX() - 2;
        int z2 = pos.getZ() - 2;

        /** LISTS */
        List<Boolean> flag1 = new ArrayList<>();
        List<Boolean> flag2 = new ArrayList<>();

        /** CHECK IF LAUNCH PAD 3x3 */
        for (int i1 = x; i1 < x + 3; i1++) {
            for (int f2 = z; f2 < z + 3; f2++) {
                BlockPos pos2 = new BlockPos(i1, y, f2);

                flag1.add(level.getBlockState(pos2).isOf(ModBlocks.ROCKET_LAUNCH_PAD));
            }
        }

        /** CHECK IF LAUNCH PAD 5x5 (STAGE == FALSE) */
        for (int i1 = x2; i1 < x2 + 5; i1++) {
            for (int f2 = z2; f2 < z2 + 5; f2++) {
                BlockPos pos2 = new BlockPos(i1, y, f2);

                if (level.getBlockState(pos2).isOf(ModBlocks.ROCKET_LAUNCH_PAD) && !pos2.equals(pos)) {
                    flag2.add(level.getBlockState(pos2).get(STAGE));
                }
            }
        }

        /** VARIABLE SETTER */
        if (!flag1.contains(false)) {
            if (!state.get(STAGE) && !flag2.contains(true)) {
                level.setBlockState(pos, state.with(STAGE, true), 2);
            }
        } else {
            if (state.get(STAGE)) {
                level.setBlockState(pos, state.with(STAGE, false), 2);
            }
        }

        level.scheduleBlockTick(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), this, 1);
    }
}
