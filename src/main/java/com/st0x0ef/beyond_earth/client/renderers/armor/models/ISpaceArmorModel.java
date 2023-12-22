package com.st0x0ef.beyond_earth.client.renderers.armor.models;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public abstract class ISpaceArmorModel {
    public static class LayerOne<T extends LivingEntity> extends BipedEntityModel<T> {
        public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "space_suit"), "main");
        private final LivingEntity entity;

        public LayerOne(ModelPart root, LivingEntity livingEntity) {
            super(root);
            this.entity = livingEntity;
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData meshdefinition = new ModelData();
            ModelPartData partdefinition = meshdefinition.getRoot();

            ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
                    .uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.75F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0175F, 0.0873F, 0.0F));

            ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
                    .uv(28, 28).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
                    .uv(50, 29).cuboid(-3.0F, 5.0F, -2.5F, 6.0F, 4.0F, 1.0F, new Dilation(0.25F))
                    .uv(0, 55).cuboid(-2.5F, 1.0F, 2.55F, 5.0F, 8.0F, 1.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData rightArm = partdefinition.addChild("right_arm", ModelPartBuilder.create().uv(20, 44).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

            ModelPartData leftArm = partdefinition.addChild("left_arm", ModelPartBuilder.create().uv(32, 0).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

            ModelPartData rightLeg = partdefinition.addChild("right_leg", ModelPartBuilder.create().uv(48, 44).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.4F))
                    .uv(48, 54).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.27F)), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

            ModelPartData leftLeg = partdefinition.addChild("left_leg", ModelPartBuilder.create().uv(48, 44).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.4F))
                    .uv(48, 54).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.27F)), ModelTransform.pivot(2.0F, 12.0F, 0.0F));

            return TexturedModelData.of(meshdefinition, 64, 64);
        }

        public LivingEntity getEntity() {
            return entity;
        }

        public ModelPart getHeadPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("head");
            part.copyTransform(head);
            return part;
        }

        public ModelPart getBodyPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("body");
            part.copyTransform(body);
            return part;
        }

        public ModelPart getRightArmPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("right_arm");
            part.copyTransform(rightArm);
            return part;
        }

        public ModelPart getLeftArmPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("left_arm");
            part.copyTransform(leftArm);
            return part;
        }

        public ModelPart getRightLegPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("right_leg");
            part.copyTransform(rightLeg);
            return part;
        }

        public ModelPart getLeftLegPart() {
            ModelPart part = getTexturedModelData().createModel().getChild("left_leg");
            part.copyTransform(leftLeg);
            return part;
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
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

            if (head.visible && getHeadPart() != null) {
                getHeadPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
            }

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


            /*this.body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            this.rightArm.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            this.leftArm.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            this.rightLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            this.leftLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);*/

            matrices.pop();
        }
    }

    public static class LayerTwo extends LayerOne<LivingEntity> {
        public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "space_suit_pants"), "main");

        public LayerTwo(ModelPart root, LivingEntity livingEntity) {
            super(root, livingEntity);
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
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
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

            if (rightLeg.visible && getRightLegPart() != null) {
                getRightLegPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
            }

            if (leftLeg.visible && getLeftLegPart() != null) {
                getLeftLegPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
            }

            this.rightLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            this.leftLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);

            BeyondEarth.LOGGER.info("rendering");

            matrices.pop();
        }
    }
}

