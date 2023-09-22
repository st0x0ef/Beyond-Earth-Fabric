package com.st0x0ef.beyond_earth.common.items.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidFillable;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ModifiedBucketItem extends BucketItem {
    private final boolean explodeNether;
    private final Fluid fluid;

    public ModifiedBucketItem(Fluid fluid, Settings settings, boolean explodeNether) {
        super(fluid, settings);
        this.explodeNether = explodeNether;
        this.fluid = fluid;
    }


    @Override
    public boolean placeFluid(@Nullable PlayerEntity player, World level, BlockPos blockPos, @Nullable BlockHitResult hitResult) {
        if (!(this.getFluid() instanceof FlowableFluid)) {
            return false;
        } else {
            BlockState blockstate = level.getBlockState(blockPos);
            Block block = blockstate.getBlock();
            Material material = blockstate.getMaterial();

            boolean flag = blockstate.isReplaceable();
            boolean flag1 = blockstate.isAir() || flag || block instanceof FluidFillable && ((FluidFillable) block).canFillWithFluid(level, blockPos, blockstate, this.getFluid());

            if (!flag1) {
                return hitResult != null && this.placeFluid(player, level, hitResult.getBlockPos().offset(hitResult.getSide()), null);
            } else if (level.getDimension().ultrawarm() && this.getFluid().getDefaultState().getBlockState().getMaterial() == Material.WATER) {
                if (this.explodeNether) {
                    if (!level.isClient()) {
                        level.createExplosion(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 10, true, World.ExplosionSourceType.BLOCK);
                    }
                } else {
                    int i = blockPos.getX();
                    int j = blockPos.getY();
                    int k = blockPos.getZ();
                    level.playSound(player, blockPos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; l++) {
                        level.addParticle(ParticleTypes.LARGE_SMOKE, (double) i + Math.random(), (double) j + Math.random(), (double) k + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }
                return true;
            } else if (block instanceof FluidFillable && ((FluidFillable) block).canFillWithFluid(level, blockPos, blockstate, getFluid())) {
                ((FluidFillable) block).tryFillWithFluid(level, blockPos, blockstate, ((FlowableFluid) this.getFluid()).getStill(false));
                this.playEmptyingSound(player, level, blockPos);
                return true;
            } else {
                if (!level.isClient() && flag && !material.isLiquid()) {
                    level.breakBlock(blockPos, true);
                }

                if (!level.setBlockState(blockPos, this.getFluid().getDefaultState().getBlockState(), 11) && !blockstate.getFluidState().isStill()) {
                    return false;
                } else {
                    this.playEmptyingSound(player, level, blockPos);
                    return true;
                }
            }
        }
    }

    public Fluid getFluid() {
        return fluid;
    }
}
