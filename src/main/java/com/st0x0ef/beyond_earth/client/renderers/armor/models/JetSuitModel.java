package com.st0x0ef.beyond_earth.client.renderers.armor.models;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.armor.JetSuit;
import com.st0x0ef.beyond_earth.common.util.Methods;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class JetSuitModel {
    public static class LayerOne extends ISpaceArmorModel.LayerOne<LivingEntity> {
        public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "jet_suit"), "main");

        public LayerOne(ModelPart root, LivingEntity livingEntity, ItemStack itemStack) {
            super(root, livingEntity, itemStack);
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData meshdefinition = new ModelData();
            ModelPartData partdefinition = meshdefinition.getRoot();

            ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
                    .uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.75F))
                    .uv(0, 32).cuboid(3.0F, -13.0F, 1.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0175F, 0.0873F, 0.0F));

            ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
                    .uv(28, 28).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
                    .uv(50, 29).cuboid(-3.0F, 5.0F, -2.5F, 6.0F, 4.0F, 1.0F, new Dilation(0.25F))
                    .uv(0, 55).cuboid(-2.5F, 1.0F, 2.75F, 5.0F, 8.0F, 1.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(32, 31).cuboid(-2.0F, -5.0F, 0.75F, 0.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, 2.0F, 0.0F, -0.3491F, 0.0F));

            ModelPartData body_r2 = body.addChild("body_r2", ModelPartBuilder.create().uv(32, 31).cuboid(2.0F, -5.0F, 0.75F, 0.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, 2.0F, 0.0F, 0.3491F, 0.0F));

            ModelPartData rightArm = partdefinition.addChild("right_arm", ModelPartBuilder.create().uv(20, 44).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F)).uv(48, 8).cuboid(-3.0F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

            ModelPartData leftArm = partdefinition.addChild("left_arm", ModelPartBuilder.create().uv(32, 0).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F)).uv(48, 0).cuboid(-1.0F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

            ModelPartData rightLeg = partdefinition.addChild("right_leg", ModelPartBuilder.create().uv(48, 44).cuboid(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F))
                    .uv(48, 54).cuboid(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.27F)), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

            ModelPartData leftLeg = partdefinition.addChild("left_leg", ModelPartBuilder.create().uv(48, 44).cuboid(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F))
                    .uv(48, 54).cuboid(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.27F)), ModelTransform.pivot(2.0F, 12.0F, 0.0F));

            return TexturedModelData.of(meshdefinition, 64, 64);
        }


        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, boolean isHelmet) {
            BipedEntityModel livingModel = (BipedEntityModel<LivingEntity>) ((LivingEntityRenderer) MinecraftClient.getInstance().getEntityRenderDispatcher().getRenderer(this.getEntity())).getModel();

            this.handSwingProgress = livingModel.handSwingProgress;
            this.riding = livingModel.riding;
            this.child = livingModel.child;
            this.leftArmPose = livingModel.leftArmPose;
            this.rightArmPose = livingModel.rightArmPose;
            this.sneaking = livingModel.sneaking;
            this.head.copyTransform(livingModel.head);
            this.body.copyTransform(livingModel.body);
            this.rightArm.copyTransform(livingModel.rightArm);
            this.leftArm.copyTransform(livingModel.leftArm);
            this.rightLeg.copyTransform(livingModel.rightLeg);
            this.leftLeg.copyTransform(livingModel.leftLeg);

            matrices.push();

            if (this.child) {
                matrices.scale(0.5f, 0.5f, 0.5f);
                matrices.translate(0, 1.5f, 0);
            }

            if (isHelmet && getHeadPart() != null && head.visible) {
                getHeadPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
            } else {
                if (body.visible && getBodyPart() != null) {
                    getBodyPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
                }

                if (rightArm.visible && getRightArmPart() != null) {
                    getRightArmPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
                }

                if (leftArm.visible && getLeftArmPart() != null) {
                    getLeftArmPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
                }

                if (rightLeg.visible && getRightLegPart() != null) {
                    getRightLegPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
                }

                if (leftLeg.visible && getLeftLegPart() != null) {
                    getLeftLegPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
                }

                /** RENDER FIRE */
                if (Methods.isLivingInJetSuit(this.getEntity()) && this.item.getItem() instanceof JetSuit.Suit jetSuitItem) {
                    //TODO fix fire rendering while not flying

                    if (this.getEntity() instanceof ClientPlayerEntity) {
                        if (jetSuitItem.spacePressTime > 0) {
                            renderFireOnHandsAndFeeds(matrices, jetSuitItem);
                        }
                    }
                }
            }

            matrices.pop();
        }


        public void renderFireOnHandsAndFeeds(MatrixStack poseStack, JetSuit.Suit item) {
            this.renderFire(poseStack, getRightArmPart(), item, 0.2F, -0.75F, 2.55F, -0.49F);
            this.renderFire(poseStack, getLeftArmPart(), item, 0.2F, -0.25F, 2.55F, -0.5F);

            this.renderFire(poseStack, getRightLegPart(), item, 0.2F, -0.55F, 3.0F, -0.49F);
            this.renderFire(poseStack, getLeftLegPart(), item, 0.2F, -0.45F, 3.0F, -0.5F);
        }

        public void renderFire(MatrixStack poseStack, ModelPart modelPart, JetSuit.Suit item, float scale, float x, float y, float z) {
            MinecraftClient mc = MinecraftClient.getInstance();
            BlockRenderManager blockRenderer = mc.getBlockRenderManager();
            VertexConsumerProvider vertexConsumers = mc.getBufferBuilders().getEntityVertexConsumers();

            float speed = MathHelper.clamp(item.spacePressTime, 0.0F, 3.8F);

            poseStack.push();
            poseStack.translate(modelPart.pivotX / 16.0F, modelPart.pivotY / 16.0F, modelPart.pivotZ / 16.0F);

            poseStack.scale(scale, scale, scale);

            poseStack.multiply(RotationAxis.POSITIVE_Z.rotation(modelPart.roll));
            poseStack.multiply(RotationAxis.POSITIVE_Y.rotation(modelPart.yaw));
            poseStack.multiply(RotationAxis.POSITIVE_X.rotation(modelPart.pitch));

            poseStack.translate(x, y, z);

            poseStack.scale(1, 1 + speed, 1);
            blockRenderer.renderBlockAsEntity(Blocks.SOUL_FIRE.getDefaultState(), poseStack, vertexConsumers, 15728880, OverlayTexture.DEFAULT_UV);

            poseStack.pop();
        }

        @Override
        public ModelPart getHeadPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("head");
            part.copyTransform(head);
            return part;
        }

        @Override
        public ModelPart getBodyPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("body");
            part.copyTransform(body);
            return part;
        }

        @Override
        public ModelPart getRightArmPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("right_arm");
            part.copyTransform(rightArm);
            return part;
        }

        @Override
        public ModelPart getLeftArmPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("left_arm");
            part.copyTransform(leftArm);
            return part;
        }

        @Override
        public ModelPart getRightLegPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("right_leg");
            part.copyTransform(rightLeg);
            return part;
        }

        @Override
        public ModelPart getLeftLegPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("left_leg");
            part.copyTransform(leftLeg);
            return part;
        }
    }


    public static class LayerTwo extends JetSuitModel.LayerOne {
        public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "jet_suit_pants"), "main");

        public LayerTwo(ModelPart root, LivingEntity livingEntity, ItemStack stack) {
            super(root, livingEntity, stack);
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData meshdefinition = new ModelData();
            ModelPartData partdefinition = meshdefinition.getRoot();

            ModelPartData rightLeg = partdefinition.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.6F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

            ModelPartData leftLeg = partdefinition.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.6F)).mirrored(false), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

            return TexturedModelData.of(meshdefinition, 64, 32);
        }

        @Override
        public ModelPart getRightLegPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("right_leg");
            part.copyTransform(rightLeg);
            return part;
        }

        @Override
        public ModelPart getLeftLegPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("left_leg");
            part.copyTransform(leftLeg);
            return part;
        }

        @Override
        public ModelPart getBodyPart() {
            return null;
        }
    }
}

