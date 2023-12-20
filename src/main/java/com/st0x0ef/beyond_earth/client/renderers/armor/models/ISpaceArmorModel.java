package com.st0x0ef.beyond_earth.client.renderers.armor.models;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

import java.util.Arrays;

@Environment(EnvType.CLIENT)
public abstract class ISpaceArmorModel <T extends LivingEntity> extends BipedEntityModel<T> {
    private final LivingEntity entity;
    public ISpaceArmorModel(ModelPart root, LivingEntity livingEntity) {
        super(root);
        this.entity = livingEntity;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public ModelPart getHeadPart() {
        return null;
    }
    public ModelPart getBodyPart() {
        return null;
    }
    public ModelPart getRightArmPart() {
        return null;
    }
    public ModelPart getLeftArmPart() {
        return null;
    }
    public ModelPart getRightLegPart() {
        return null;
    }
    public ModelPart getLeftLegPart() {
        return null;
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

        if (head.visible) {
            getHeadPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }

        if (body.visible) {
            getBodyPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }

        if (rightArm.visible) {
            getRightArmPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }

        if (leftArm.visible) {
            getLeftArmPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }

        if (rightLeg.visible) {
            getRightLegPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }

        if (leftLeg.visible) {
            getLeftLegPart().render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }


        this.body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        this.rightArm.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        this.leftArm.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        this.rightLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        this.leftLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);

        matrices.pop();
    }
}
