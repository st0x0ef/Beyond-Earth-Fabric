package com.st0x0ef.beyond_earth.client.renderers.armor.renderers;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.client.renderers.armor.models.ISpaceArmorModel;
import com.st0x0ef.beyond_earth.client.renderers.armor.models.JetSuitModel;
import com.st0x0ef.beyond_earth.client.renderers.types.TranslucentArmorType;
import com.st0x0ef.beyond_earth.common.armor.ModArmorMaterials;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class JetSuitRenderer implements ArmorRenderer {
    private JetSuitModel.LayerTwo innerModel;
    private JetSuitModel.LayerOne outerModel;

    //TODO Fix layer alpha rendering
    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, ItemStack stack, LivingEntity livingEntity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        if (innerModel == null || outerModel == null) {
            outerModel = new JetSuitModel.LayerOne(new ModelPart(new ArrayList<>(), Map.of(EntityModelPartNames.HEAD, contextModel.head, EntityModelPartNames.HAT, contextModel.hat, EntityModelPartNames.BODY, contextModel.body, EntityModelPartNames.RIGHT_ARM, contextModel.rightArm, EntityModelPartNames.LEFT_ARM, contextModel.leftArm, EntityModelPartNames.RIGHT_LEG, contextModel.rightLeg, EntityModelPartNames.LEFT_LEG, contextModel.leftLeg)), livingEntity);
            innerModel = new JetSuitModel.LayerTwo(new ModelPart(new ArrayList<>(), Map.of(EntityModelPartNames.HEAD, contextModel.head, EntityModelPartNames.HAT, contextModel.hat, EntityModelPartNames.BODY, contextModel.body, EntityModelPartNames.RIGHT_ARM, contextModel.rightArm, EntityModelPartNames.LEFT_ARM, contextModel.leftArm, EntityModelPartNames.RIGHT_LEG, contextModel.rightLeg, EntityModelPartNames.LEFT_LEG, contextModel.leftLeg)), livingEntity);
        }

        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.CHEST, light, this.getModel(EquipmentSlot.CHEST), contextModel);
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.LEGS, light, this.getModel(EquipmentSlot.LEGS), contextModel);
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.FEET, light, this.getModel(EquipmentSlot.FEET), contextModel);
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.HEAD, light, this.getModel(EquipmentSlot.HEAD), contextModel);
    }


    private void renderArmor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, LivingEntity entity, EquipmentSlot armorSlot, int light, ISpaceArmorModel.LayerOne<LivingEntity> model, BipedEntityModel<LivingEntity> contextModel) {
        ItemStack itemStack = (entity).getEquippedStack(armorSlot);
        Item item = itemStack.getItem();
        if (!(item instanceof ArmorItem armorItem)) {
            return;
        }

        if (armorItem.getSlotType() != armorSlot) {
            return;
        }

        if (!armorItem.getMaterial().equals(ModArmorMaterials.JET_SUIT_MATERIAL)) {
            return;
        }

        contextModel.copyBipedStateTo(model);
        this.setVisible(model, armorSlot);
        boolean usesInnerModel = this.usesInnerModel(armorSlot);
        boolean hasGlint = itemStack.hasGlint();

        model.head.copyTransform(contextModel.head);
        model.hat.copyTransform(contextModel.hat);
        model.body.copyTransform(contextModel.body);
        model.rightArm.copyTransform(contextModel.rightArm);
        model.leftArm.copyTransform(contextModel.leftArm);
        model.rightLeg.copyTransform(contextModel.rightLeg);
        model.leftLeg.copyTransform(contextModel.leftLeg);

        this.renderArmorParts(matrices, light, hasGlint, model, usesInnerModel,1.0f, 1.0f, 1.0f, 1.0f, isHelmet(armorSlot));
    }

    protected void setVisible(ISpaceArmorModel.LayerOne<LivingEntity> bipedModel, EquipmentSlot slot) {
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

    private void renderArmorParts(MatrixStack matrices, int light, boolean glint, ISpaceArmorModel.LayerOne<LivingEntity> model, boolean usesSecondTextureLayer, float red, float green, float blue, float alpha, boolean isHelmet) {
        VertexConsumer vertexConsumer = this.getVertex(TranslucentArmorType.translucentArmor(getArmorTexture(usesSecondTextureLayer)), false, glint);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, red, green, blue, alpha, isHelmet);
    }

    private ISpaceArmorModel.LayerOne<LivingEntity> getModel(EquipmentSlot slot) {
        return usesInnerModel(slot) ? this.innerModel : this.outerModel;
    }

    private boolean usesInnerModel(EquipmentSlot slot) {
        return slot == EquipmentSlot.LEGS;
    }

    private Identifier getArmorTexture(boolean secondTextureLayer) {
        return secondTextureLayer ? new Identifier(BeyondEarth.MOD_ID, "textures/armor/jet_suit_pants.png") : new Identifier(BeyondEarth.MOD_ID, "textures/armor/jet_suit.png");
    }

    public VertexConsumer getVertex(RenderLayer renderType, boolean p_115187_, boolean glint) {
        VertexConsumerProvider p_115185_ = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        return glint ? VertexConsumers.union(p_115185_.getBuffer(p_115187_ ? RenderLayer.getArmorGlint() : RenderLayer.getArmorEntityGlint()), p_115185_.getBuffer(renderType)) : p_115185_.getBuffer(renderType);
    }

    private boolean isHelmet(EquipmentSlot slot) {
        return slot.equals(EquipmentSlot.HEAD);
    }
}
