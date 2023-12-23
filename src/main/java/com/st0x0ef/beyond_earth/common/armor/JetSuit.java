package com.st0x0ef.beyond_earth.common.armor;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.keybinds.KeyVariables;
import com.st0x0ef.beyond_earth.common.util.Methods;
import com.st0x0ef.beyond_earth.common.util.ModTags;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JetSuit {
    public static class Helmet extends ISpaceArmor.Helmet {
        public Helmet(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, properties);
        }
    }

    public static class Suit extends ISpaceArmor.Chestplate {
        public static final String TAG_MODE = BeyondEarth.MOD_ID + ":jet_suit_mode";
        public float spacePressTime;

        public Suit(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, properties);
        }

        //TODO IMPROVE FIRE MATH
        //TODO FINISH ANIMATIONS
        //TODO ADD ENERGY CAP
        //TODO REWORK OVERLAY

        public enum ModeType {
            DISABLED(Text.translatable("general." + BeyondEarth.MOD_ID + ".jet_suit_disabled_mode"), Formatting.RED, 0),
            NORMAL(Text.translatable("general." + BeyondEarth.MOD_ID + ".jet_suit_normal_mode"), Formatting.GREEN, 1),
            HOVER(Text.translatable("general." + BeyondEarth.MOD_ID + ".jet_suit_hover_mode"), Formatting.GREEN, 2),
            ELYTRA(Text.translatable("general." + BeyondEarth.MOD_ID + ".jet_suit_elytra_mode"), Formatting.GREEN, 3);

            private final int mode;
            private final Formatting chatFormatting;
            private final Text component;

            ModeType(Text component, Formatting chatFormatting, int mode) {
                this.mode = mode;
                this.chatFormatting = chatFormatting;
                this.component = component;
            }

            public int getMode() {
                return this.mode;
            }

            public Formatting getChatFormatting() {
                return this.chatFormatting;
            }

            public Text getTranslationKey() {
                return this.component;
            }
        }

        public int getMode(ItemStack itemStack) {
            return itemStack.getOrCreateNbt().getInt(TAG_MODE);
        }

        public ModeType getModeType(ItemStack itemStack) {
            int mode = this.getMode(itemStack);

            if (mode == 1) {
                return ModeType.NORMAL;
            } else if (mode == 2) {
                return ModeType.HOVER;
            } else if (mode == 3) {
                return ModeType.ELYTRA;
            }

            return ModeType.DISABLED;
        }

        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
            super.inventoryTick(stack, world, entity, slot, selected);

            if (!(entity instanceof PlayerEntity player)) return;

            /** JET SUIT FAST BOOST */
            if (player.isSprinting()) {
                //this.boost(player, 1.3, true);
            }

            /** JET SUIT SLOW BOOST */
            if (player.forwardSpeed > 0 && !player.isSprinting()) {
                //this.boost(player, 0.9, false);
            }

            /** NORMAL FLY MOVEMENT */
            this.normalFlyModeMovement(player, stack);

            /** CALCULATE PRESS SPACE TIME */
            //this.calculateSpacePressTime(player, stack);
        }

        public void normalFlyModeMovement(PlayerEntity player, ItemStack stack) {
            if (!player.getAbilities().flying && !player.hasVehicle() && Methods.isLivingInJetSuit(player)) {

                /** HOVER FLY */
                //if (this.getMode(stack) == ModeType.HOVER.getMode() && !player.hasEffect(MobEffects.SLOW_FALLING)) {
                //   double gravity = player.getAttributeBaseValue(EntityAttributes)).getBaseValue();
                //   Vec3d vec3 = player.getVelocity();

                /** MAIN MOVEMENT */
                if (!player.isOnGround() && (!player.isSubmergedIn(FluidTags.LAVA) || !player.isSubmergedIn(FluidTags.WATER))) {
                    //    player.setVelocity(vec3.x, vec3.y + gravity - 0.005, vec3.z);
                    player.onLanding();
                    //Methods.disableFlyAntiCheat(player, true);
                }

                /** MOVE UP */
                if (KeyVariables.isHoldingJump(player)) {
                    player.updateVelocity(2.0F, new Vec3d(0, 0.008, 0));
                    //Methods.disableFlyAntiCheat(player, true);
                }

                /** MOVE DOWN */
                if (!player.isOnGround() && player.isSneaking()) {
                    player.updateVelocity(2.0F, new Vec3d(0, -0.008, 0));

                    if (player instanceof ClientPlayerEntity localPlayer) {
                        localPlayer.setSneaking(false);
                    }
                }

                /** MOVE FORWARD AND BACKWARD */
                if (!player.isOnGround()) {
                    if (KeyVariables.isHoldingUp(player)) {
                        player.updateVelocity(1.0F, new Vec3d(0, 0, 0.01));
                    } else if (KeyVariables.isHoldingDown(player)) {
                        player.updateVelocity(1.0F, new Vec3d(0, 0, -0.01));
                    }
                }

                /** MOVE SIDEWAYS */
                if (!player.isOnGround()) {
                    if (KeyVariables.isHoldingRight(player)) {
                        player.updateVelocity(1.0F, new Vec3d(-0.01, 0, 0));
                    } else if (KeyVariables.isHoldingLeft(player)) {
                        player.updateVelocity(1.0F, new Vec3d(0.01, 0, 0));
                    }
                }
            }

            /** NORMAL FLY */
            if (this.getMode(stack) == ModeType.NORMAL.getMode()) {

                /** MOVE UP */
                if (KeyVariables.isHoldingJump(player)) {
                    player.updateVelocity(1.2F, new Vec3d(0, 0.1, 0));
                    player.onLanding();
                    //Methods.disableFlyAntiCheat(player, true);
                }

                /** MOVE FORWARD AND BACKWARD */
                if (!player.isOnGround()) {
                    if (KeyVariables.isHoldingUp(player)) {
                        player.updateVelocity(1.0F, new Vec3d(0, 0, 0.03));
                    } else if (KeyVariables.isHoldingDown(player)) {
                        player.updateVelocity(1.0F, new Vec3d(0, 0, -0.03));
                    }
                }

                /** MOVE SIDEWAYS */
                if (!player.isOnGround()) {
                    if (KeyVariables.isHoldingRight(player)) {
                        player.updateVelocity(1.0F, new Vec3d(-0.03, 0, 0));
                    } else if (KeyVariables.isHoldingLeft(player)) {
                        player.updateVelocity(1.0F, new Vec3d(0.03, 0, 0));
                    }
                }
            }
        }

        @Override
        public int getOxygenCapacity() {
            return 60000;
        }
    }

    public static class Pants extends ISpaceArmor.Leggings {

        public Pants(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, properties);
        }

        @Override
        public int getFuelCapacity() {
            return 1000;
        }
    }

    public static class Boots extends ISpaceArmor.Boots {

        public Boots(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, properties);
        }
    }
}
