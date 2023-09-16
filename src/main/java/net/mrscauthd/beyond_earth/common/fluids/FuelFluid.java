package net.mrscauthd.beyond_earth.common.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;
import net.mrscauthd.beyond_earth.common.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FuelFluid extends FlowableFluid {
    public Fluid getFlowing() {
        return ModFluids.FUEL_FLOWING;
    }

    public Fluid getStill() {
        return ModFluids.FUEL_STILL;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    public Item getBucketItem() {
        return ModItems.FUEL_BUCKET;
    }

    @Override
    protected void randomDisplayTick(World level, BlockPos blockPos, FluidState state, net.minecraft.util.math.random.Random randomSource) {
        super.randomDisplayTick(level, blockPos, state, randomSource);
        if (!state.isStill() && !state.get(FALLING)) {
            if (randomSource.nextInt(64) == 0) {
                level.playSound((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, randomSource.nextFloat() * 0.25F + 0.75F, randomSource.nextFloat() + 0.5F, false);
            }
        } else if (randomSource.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.UNDERWATER, (double) blockPos.getX() + randomSource.nextDouble(), (double) blockPos.getY() + randomSource.nextDouble(), (double) blockPos.getZ() + randomSource.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Nullable
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    public int getFlowSpeed(WorldView world) {
        return 4;
    }

    public BlockState toBlockState(FluidState state) {
        return ModBlocks.FUEL_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }
    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.FUEL_STILL || fluid == ModFluids.FUEL_FLOWING;
    }
    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }
    @Override
    public int getTickRate(WorldView world) {
        return 8;
    }

    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
    }
    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }
    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    public static class Flowing extends FuelFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends FuelFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
