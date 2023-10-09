package com.st0x0ef.beyond_earth.common.blocks.custom;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class CoalTorchBlock extends TorchBlock {
    public CoalTorchBlock(Settings settings) {
        super(settings, new DustParticleEffect(new Vector3f(), 0));
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemstack = player.getStackInHand(hand);

        if (level.getBlockState(pos).getBlock() == ModBlocks.WALL_COAL_TORCH_BLOCK && /*!Methods.isSpaceLevelWithoutOxygen(level) &&*/ (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            if (!level.isClient) {

                state = level.getBlockState(pos);

                level.setBlockState(pos, Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, state.get(WallCoalTorchBlock.FACING)), 3);

                this.flintManager(itemstack, player, hand, pos, level);
                return ActionResult.SUCCESS;
            }
        }

        if (level.getBlockState(pos).getBlock() == ModBlocks.COAL_TORCH_BLOCK /*&& !Methods.isSpaceLevelWithoutOxygen(level)*/ && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            if (!level.isClient) {

                level.setBlockState(pos, Blocks.TORCH.getDefaultState(), 3);

                this.flintManager(itemstack, player, hand, pos, level);
                return ActionResult.SUCCESS;
            }
        }

        if (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE) {
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {}

    public void flintManager(ItemStack itemstack, PlayerEntity playerEntity, Hand hand, BlockPos pos, World world) {
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
