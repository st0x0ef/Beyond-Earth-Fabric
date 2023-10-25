package com.st0x0ef.beyond_earth.common.items.custom;

import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.entity.custom.nonLivingEntities.RoverEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.st0x0ef.beyond_earth.common.armor.ISpaceArmor.FUEL_TAG;

public class RoverItem extends VehicleItem {
    public RoverItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(itemStack, world, tooltip, context);

        int fuel = itemStack.getOrCreateNbt().getInt(FUEL_TAG);
        //int capacity = Config.ROVER_FUEL_BUCKETS.get() * FluidUtil2.BUCKET_SIZE;
        //tooltip.add(GaugeTextHelper.buildFuelStorageTooltip(GaugeValueHelper.getFuel(fuel, capacity), ChatFormatting.GRAY));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        if (world.isClient) {
            return ActionResult.PASS;
        }

        BlockPos pos = context.getBlockPos();
        Hand hand = context.getHand();
        ItemStack itemStack = context.getStack();
        World level = context.getWorld();

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        ItemPlacementContext blockplacecontext = new ItemPlacementContext(context);
        BlockPos blockpos = blockplacecontext.getBlockPos();
        Vec3d vec3 = Vec3d.ofBottomCenter(blockpos);
        Box aabb = ModEntities.ROVER.getDimensions().getBoxAt(vec3.x, vec3.y, vec3.z);

        if (level.isSpaceEmpty(aabb)) {

            Box scanAbove = new Box(x, y, z, x + 1, y + 1, z + 1);
            List<Entity> entities = player.getEntityWorld().getNonSpectatingEntities(Entity.class, scanAbove);

            if (entities.isEmpty()) {
                RoverEntity rover = new RoverEntity(ModEntities.ROVER, world);

                rover.setPos((double) pos.getX() + 0.5D, pos.getY() + 1, (double) pos.getZ() + 0.5D);
                double d0 = getYOffset(world, pos, true, rover.getBoundingBox());

                /** ROTATION */
                float f = (float) MathHelper.floor((MathHelper.wrapDegrees(context.getPlayerYaw() - 180.0F) + 5.626F) / 11.25F) * 11.25F;

                rover.refreshPositionAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() + d0 + 2, (double) pos.getZ() + 0.5D, f + 180.0F, 0.0F);

                //rover.prevYaw = rover.getYaw();
                rover.setYaw(rover.prevYaw);

                world.spawnEntity(rover);

                rover.getDataTracker().set(RoverEntity.FUEL, itemStack.getOrCreateNbt().getInt(FUEL_TAG));

                if (!player.getAbilities().creativeMode) {
                    player.setStackInHand(hand, ItemStack.EMPTY);
                } else {
                    player.swingHand(context.getHand(), true);
                }

                roverPlaceSound(pos, world);
            }
        }

        return super.useOnBlock(context);
    }

    public static void roverPlaceSound(BlockPos pos, World world) {
        world.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1, 1);
    }
}
