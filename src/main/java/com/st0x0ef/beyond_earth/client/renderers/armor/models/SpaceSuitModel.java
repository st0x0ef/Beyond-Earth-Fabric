package com.st0x0ef.beyond_earth.client.renderers.armor.models;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.armor.ISpaceArmor;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpaceSuitModel<T extends LivingEntity> extends ISpaceArmorModel<T> {

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "space_suit"), "main");

    public SpaceSuitModel(ModelPart root) {
        super(root, null);
    }

    public SpaceSuitModel(ModelPart root, LivingEntity livingEntity) {
        super(root, livingEntity);
    }

    public static ModelData getModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
                .uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.75F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0175F, 0.0873F, 0.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
                .uv(28, 28).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
                .uv(50, 29).cuboid(-3.0F, 5.0F, -2.5F, 6.0F, 4.0F, 1.0F, new Dilation(0.25F))
                .uv(0, 55).cuboid(-2.5F, 1.0F, 2.55F, 5.0F, 8.0F, 1.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightArm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(20, 44).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData leftArm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(32, 0).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData rightLeg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(48, 44).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.4F))
                .uv(48, 54).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.27F)), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

        ModelPartData leftLeg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(48, 44).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.4F))
                .uv(48, 54).cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.27F)), ModelTransform.pivot(2.0F, 12.0F, 0.0F));

        return modelData;
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
