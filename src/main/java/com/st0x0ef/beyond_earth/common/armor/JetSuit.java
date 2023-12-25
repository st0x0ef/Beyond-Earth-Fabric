package com.st0x0ef.beyond_earth.common.armor;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.keybinds.KeyVariables;
import com.st0x0ef.beyond_earth.common.sounds.ModSounds;
import com.st0x0ef.beyond_earth.common.util.Methods;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class JetSuit {
    public static class Helmet extends ISpaceArmor.Helmet {
        public Helmet(ArmorMaterial armorMaterial, Settings properties) {
            super(armorMaterial, properties);
        }
    }

    public static class Suit extends ISpaceArmor.Chestplate implements FabricElytraItem {
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

        @Override
        public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
            if (getMode(chestStack) != ModeType.ELYTRA.mode) {
                return false;
            }

            boolean isLivingInJetSuit = Methods.isLivingInJetSuit(entity);
            boolean isElytraMode = this.getMode(chestStack) == ModeType.ELYTRA.getMode();

            if (tickElytra) {
                doVanillaElytraTick(entity, chestStack);

                if (isLivingInJetSuit && isElytraMode && entity instanceof PlayerEntity player) {
                    if (chestStack.getOrCreateNbt().getByte("elytraModeTick") == 0) {
                        chestStack.getOrCreateNbt().putByte("elytraModeTick", (byte) 1);
                    } else {
                        byte b = chestStack.getOrCreateNbt().getByte("elytraModeTick");

                        if (b > 10 && KeyVariables.isHoldingJump(player)) {
                            chestStack.getOrCreateNbt().putByte("elytraModeTick", (byte) 0);
                            return false;
                        } else if (b > 10) {
                            return true;
                        }

                        chestStack.getOrCreateNbt().putByte("elytraModeTick", (byte) (b + 1));
                    }
                }

                return true;
            }

            return isLivingInJetSuit && isElytraMode;
        }

        @Override
        public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
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

            BeyondEarth.LOGGER.info(getModeType(stack).getTranslationKey().getString());

            /** JET SUIT FAST BOOST */
            if (player.isSprinting()) {
                this.boost(player, 1.3, true);
            }

            /** JET SUIT SLOW BOOST */
            if (player.forwardSpeed > 0 && !player.isSprinting()) {
                this.boost(player, 0.9, false);
            }

            /** NORMAL FLY MOVEMENT */
            this.normalFlyModeMovement(player, stack);

            /** CALCULATE PRESS SPACE TIME */
            this.calculateSpacePressTime(player, stack);
        }

        public void normalFlyModeMovement(PlayerEntity player, ItemStack stack) {
            if (!player.getAbilities().flying && !player.hasVehicle() && Methods.isLivingInJetSuit(player)) {
                /** HOVER FLY */
                if (this.getMode(stack) == ModeType.HOVER.getMode() && !player.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
                    double gravity = LivingEntity.GRAVITY;
                    Vec3d vec3 = player.getVelocity();

                    /** MAIN MOVEMENT */
                    if (!player.isOnGround() && (!player.isSubmergedIn(FluidTags.LAVA) || !player.isSubmergedIn(FluidTags.WATER))) {
                        player.setVelocity(vec3.x, vec3.y + gravity - 0.005, vec3.z);
                        player.onLanding();
                        tryDisableAntiCheat(player, true);
                    }

                    /** MOVE UP */
                    if (KeyVariables.isHoldingJump(player)) {
                        player.updateVelocity(2.0F, new Vec3d(0, 0.008, 0));
                        tryDisableAntiCheat(player, true);
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
                        tryDisableAntiCheat(player, true);
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
        }

        private void tryDisableAntiCheat(PlayerEntity player, boolean bl) {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                Methods.disableFlyAntiCheat(serverPlayer, bl);
            }
        }

        public void switchJetSuitMode(ItemStack itemStack, PlayerEntity player) {
            NbtCompound compoundTag = itemStack.getOrCreateNbt();

            if (this.getMode(itemStack) < 3) {
                compoundTag.putInt(JetSuit.Suit.TAG_MODE, this.getMode(itemStack) + 1);
            } else {
                compoundTag.putInt(JetSuit.Suit.TAG_MODE, 0);
            }


            if (itemStack.getItem() instanceof JetSuit.Suit jetSuitItem) {
                Text modeText = jetSuitItem.getModeType(itemStack).getTranslationKey();
                Formatting chatFormatting = jetSuitItem.getModeType(itemStack).getChatFormatting();

                Text text = Text.translatable("general." + BeyondEarth.MOD_ID + ".jet_suit_mode").append(": ").formatted(chatFormatting).append(modeText.copy().formatted(Formatting.GRAY));
                player.sendMessage(text, true);
            }
        }

        public void calculateSpacePressTime(PlayerEntity player, ItemStack itemStack) {
            int mode = this.getMode(itemStack);

            if (Methods.isLivingInJetSuit(player)) {

                /** NORMAL MODE */
                if (mode == ModeType.NORMAL.getMode()) {
                    if (KeyVariables.isHoldingJump(player)) {
                        if (this.spacePressTime < 2.2F) {
                            this.spacePressTime = this.spacePressTime + 0.2F;
                        }
                    } else if (this.spacePressTime > 0.0F) {
                        this.spacePressTime = this.spacePressTime - 0.2F;
                    }
                }

                /** HOVER MODE */
                if (mode == ModeType.HOVER.getMode()) {
                    if (!player.isOnGround() && this.spacePressTime < 0.6F) {
                        this.spacePressTime = this.spacePressTime + 0.2F;
                    } else if (KeyVariables.isHoldingJump(player)) {
                        if (this.spacePressTime < 1.4F) {
                            this.spacePressTime = this.spacePressTime + 0.2F;
                        }
                    } else if (this.spacePressTime > 0.6F) {
                        this.spacePressTime = this.spacePressTime - 0.2F;
                    }
                }

                /** ELYTRA MODE */
                if (mode == ModeType.ELYTRA.getMode()) {
                    if (KeyVariables.isHoldingUp(player) && player.isFallFlying()) {
                        if (player.isSprinting()) {
                            if (this.spacePressTime < 2.8F) {
                                this.spacePressTime = this.spacePressTime + 0.2F;
                            }
                        } else {
                            if (this.spacePressTime < 2.2F) {
                                this.spacePressTime = this.spacePressTime + 0.2F;
                            }
                        }
                    } else if (this.spacePressTime > 0.0F) {
                        this.spacePressTime = this.spacePressTime - 0.2F;
                    }
                }
            }
        }

        public void boost(PlayerEntity player, double boost, boolean sonicBoom) {
            Vec3d vec31 = player.getRotationVector();

            if (Methods.isLivingInJetSuit(player) && player.isFallFlying()) {
                Vec3d vec32 = player.getVelocity();
                player.setVelocity(vec32.add(vec31.x * 0.1D + (vec31.x * boost - vec32.x) * 0.5D, vec31.y * 0.1D + (vec31.y * boost - vec32.y) * 0.5D, vec31.z * 0.1D + (vec31.z * boost - vec32.z) * 0.5D));

                if (sonicBoom) {
                    Vec3d vec33 = player.getRotationVector().multiply(6.5D);
                    if (player.world instanceof ServerWorld) {
                        for (ServerPlayerEntity p : ((ServerWorld) player.world).getServer().getPlayerManager().getPlayerList()) {
                            ((ServerWorld) player.world).spawnParticles(p, ParticleTypes.FLASH, true, player.getX() - vec33.x, player.getY() - vec33.y, player.getZ() - vec33.z, 1, 0, 0, 0, 0.001);
                        }
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
