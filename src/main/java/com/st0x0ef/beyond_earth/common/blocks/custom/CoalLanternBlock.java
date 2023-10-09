package com.st0x0ef.beyond_earth.common.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoalLanternBlock extends LanternBlock {
    public CoalLanternBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(HANGING, false).with(WATERLOGGED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemstack = player.getStackInHand(hand);

        if (!world.getBlockState(pos).get(CoalLanternBlock.HANGING) && /*!Methods.isSpaceLevelWithoutOxygen(world) &&*/ (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            if (!world.isClient) {

                world.setBlockState(pos, Blocks.LANTERN.getDefaultState(), 3);

                this.fireManager(itemstack, player, hand, pos, world);
                return ActionResult.SUCCESS;
            }
        }

        if (world.getBlockState(pos).get(CoalLanternBlock.HANGING) && /*!Methods.isSpaceLevelWithoutOxygen(world) &&*/ (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            if (!world.isClient) {

                world.setBlockState(pos, Blocks.LANTERN.getDefaultState().with(LanternBlock.HANGING, true), 3);

                this.fireManager(itemstack, player, hand, pos, world);
                return ActionResult.SUCCESS;
            }
        }

        if (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE) {
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    public void fireManager(ItemStack itemstack, PlayerEntity playerEntity, Hand hand, BlockPos pos, World world) {
        if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
            world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1, 1);

            itemstack.damage(1, playerEntity, (player) -> {
                player.sendEquipmentBreakStatus(hand.equals(Hand.MAIN_HAND) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            });
        }

        if (itemstack.getItem() == Items.FIRE_CHARGE) {
            world.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1,1);

            if (!playerEntity.getAbilities().creativeMode && !playerEntity.isSpectator()) {
                itemstack.setCount(itemstack.getCount() - 1);
            }
        }
    }
}
