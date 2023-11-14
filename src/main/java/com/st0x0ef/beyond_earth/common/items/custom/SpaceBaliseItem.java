package com.st0x0ef.beyond_earth.common.items.custom;

import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class SpaceBaliseItem extends Item {

    public SpaceBaliseItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World level = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (blockState.isOf(ModBlocks.ROCKET_LAUNCH_PAD)) {
            ItemStack stack = Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getHand());

            NbtCompound coords = stack.getOrCreateSubNbt("coords");
            coords.putInt("x", blockPos.getX());
            coords.putInt("y", blockPos.getY());
            coords.putInt("z", blockPos.getZ());
            coords.putString("level", level.getRegistryKey().getRegistry().getPath());
            coords.putString("levelNamespace", level.getRegistryKey().getRegistry().getNamespace());
            coords.putString("levelValuePath", level.getRegistryKey().getValue().getPath());
            coords.putString("levelValueNamespace", level.getRegistryKey().getValue().getNamespace());
            coords.putBoolean("coordsSet", true);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if (stack.getOrCreateSubNbt("coodrs") != null && stack.getOrCreateSubNbt("coords").getBoolean("coordsSet")) {
            return true;
        }

        return super.hasGlint(stack);
    }

    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!level.isClient) {
            NbtCompound coords = stack.getSubNbt("coords");

            if (coords == null) {
                player.sendMessage(Text.literal("No coords found"));
                return TypedActionResult.fail(stack);
            } else if (!level.getBlockState(new BlockPos(coords.getInt("x"), coords.getInt("y"), coords.getInt("z"))).isOf(ModBlocks.ROCKET_LAUNCH_PAD)) {
                player.sendMessage(Text.translatable("message.beyond_earth.space_balise.no_launch_pad", coords.getInt("x"), coords.getInt("y"), coords.getInt("z"), coords.getString("level")));
                coords.putBoolean("coordsSet", false);
            } else {
                player.sendMessage(Text.translatable("message.beyond_earth.space_balise.launch_pad_coordinates", coords.getInt("x"), coords.getInt("y"), coords.getInt("z"), coords.get("levelValuePath")));
            }

            player.getItemCooldownManager().set(stack.getItem(), 20);
        }
        return TypedActionResult.success(stack, true);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound coords = stack.getSubNbt("coords");
        if (coords == null) {
            tooltip.add(Text.translatable("message.beyond_earth.space_balise.right_click"));
        } else {
            if (coords.getBoolean("coordsSet")) {
                tooltip.add(Text.translatable("message.beyond_earth.space_balise.launch_pad_coordinates", coords.getInt("x"), coords.getInt("y"), coords.getInt("z"), coords.get("levelValuePath")));
            } else {
                tooltip.add(Text.translatable("message.beyond_earth.space_balise.right_click"));
            }
        }
    }
}
