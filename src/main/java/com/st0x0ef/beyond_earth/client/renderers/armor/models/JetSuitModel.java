package com.st0x0ef.beyond_earth.client.renderers.armor.models;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JetSuitModel {
    public static class LayerOne extends ISpaceArmorModel.LayerOne<LivingEntity> {
        public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "jet_suit"), "main");

        public LayerOne(ModelPart root, LivingEntity livingEntity) {
            super(root, livingEntity);
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
    }
}
