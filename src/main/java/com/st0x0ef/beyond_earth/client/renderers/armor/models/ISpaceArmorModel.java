package com.st0x0ef.beyond_earth.client.renderers.armor.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class ISpaceArmorModel <T extends LivingEntity> extends BipedEntityModel<T> {
    public ISpaceArmorModel(ModelPart root) {
        super(root);
    }
}
