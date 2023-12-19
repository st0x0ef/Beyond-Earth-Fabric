package com.st0x0ef.beyond_earth.client.renderers.armor;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.client.renderers.armor.models.ISpaceArmorModel;
import com.st0x0ef.beyond_earth.common.armor.ISpaceArmor;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class SpaceSuitRenderer<A extends ISpaceArmorModel<LivingEntity>> implements ArmorRenderer {

    private A innerModel;
    private A outerModel;

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, ItemStack stack, LivingEntity livingEntity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.CHEST, light, this.getModel(EquipmentSlot.CHEST), contextModel);
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.LEGS, light, this.getModel(EquipmentSlot.LEGS), contextModel);
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.FEET, light, this.getModel(EquipmentSlot.FEET), contextModel);
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.HEAD, light, this.getModel(EquipmentSlot.HEAD), contextModel);
    }


    private void renderArmor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, LivingEntity entity, EquipmentSlot armorSlot, int light, A model, BipedEntityModel<LivingEntity> contextModel) {
        ItemStack itemStack = (entity).getEquippedStack(armorSlot);
        Item item = itemStack.getItem();
        if (!(item instanceof ArmorItem armorItem)) {
            return;
        }
        if (armorItem.getSlotType() != armorSlot) {
            return;
        }


        contextModel.copyBipedStateTo(model);
        this.setVisible(model, armorSlot);
        boolean bl = this.usesInnerModel(armorSlot);
        boolean bl2 = itemStack.hasGlint();

        model.head.copyTransform(contextModel.head);
        model.hat.copyTransform(contextModel.hat);
        model.body.copyTransform(contextModel.body);
        model.rightArm.copyTransform(contextModel.rightArm);
        model.leftArm.copyTransform(contextModel.leftArm);
        model.rightLeg.copyTransform(contextModel.rightLeg);
        model.leftLeg.copyTransform(contextModel.leftLeg);

        this.renderArmorParts(matrices, vertexConsumers, light, armorItem, bl2, model, 1.0f, 1.0f, 1.0f, null);
        /*BipedEntityModel livingModel = (BipedEntityModel<LivingEntity>) ((LivingEntityRenderer) MinecraftClient.getInstance().getEntityRenderDispatcher().getRenderer(entity)).getModel();

        model.handSwingProgress = livingModel.handSwingProgress;
        model.riding = livingModel.riding;
        model.child = livingModel.child;
        model.leftArmPose = livingModel.leftArmPose;
        model.rightArmPose = livingModel.rightArmPose;
        model.sneaking = livingModel.sneaking;
        model.head.copyTransform(livingModel.head);
        model.body.copyTransform(livingModel.body);
        model.rightArm.copyTransform(livingModel.rightArm);
        model.leftArm.copyTransform(livingModel.leftArm);
        model.rightLeg.copyTransform(livingModel.rightLeg);
        model.leftLeg.copyTransform(livingModel.leftLeg);

        matrices.push();
        if (model.child) {
            matrices.scale(0.5f, 0.5f, 0.5f);
            matrices.translate(0, 1.5f, 0);
        }

        if (armorItem instanceof ISpaceArmor iSpaceArmor) {
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(this.getArmorTexture(iSpaceArmor, null)), false, false);
            model.head.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1.0f);
            model.body.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1.0f);
            model.rightArm.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1.0f);
            model.leftArm.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1.0f);
            model.rightLeg.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1.0f);
            model.leftLeg.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1.0f);
        }
        matrices.pop();*/
    }

    protected void setVisible(A bipedModel, EquipmentSlot slot) {
        bipedModel.setVisible(false);
        switch (slot) {
            case HEAD -> {
                bipedModel.head.visible = true;
                bipedModel.hat.visible = true;
            }
            case CHEST -> {
                bipedModel.body.visible = true;
                bipedModel.rightArm.visible = true;
                bipedModel.leftArm.visible = true;
            }
            case LEGS -> {
                bipedModel.body.visible = true;
                bipedModel.rightLeg.visible = true;
                bipedModel.leftLeg.visible = true;
            }
            case FEET -> {
                bipedModel.rightLeg.visible = true;
                bipedModel.leftLeg.visible = true;
            }
        }
    }

    private void renderArmorParts(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArmorItem item, boolean glint, A model, float red, float green, float blue, @Nullable String overlay) {
        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(this.getArmorTexture(item, overlay)), false, glint);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, red, green, blue, 1.0f);
    }

    private A getModel(EquipmentSlot slot) {
        return usesInnerModel(slot) ? this.innerModel : this.outerModel;
    }

    private boolean usesInnerModel(EquipmentSlot slot) {
        return slot == EquipmentSlot.LEGS;
    }

    private Identifier getArmorTexture(ArmorItem item, @Nullable String overlay) {
        /*String string = "textures/models/armor/" + item.getMaterial().getName() + "_layer_" + 1 + (String) (overlay == null ? "" : "_" + overlay) + ".png";
        return ARMOR_TEXTURE_CACHE.computeIfAbsent(string, Identifier::new);*/
        return new Identifier(BeyondEarth.MOD_ID, "textures/armor/space_suit.png");
    }
}
