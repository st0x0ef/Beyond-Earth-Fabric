package com.st0x0ef.beyond_earth.client.renderers.entities.pygro;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.PygroEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PygroRenderer extends BipedEntityRenderer<MobEntity, PygroModel<MobEntity>> {
    public static final EntityModelLayer TEXTURE = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "textures/entity/pygro.png"), "main");


    public PygroRenderer(EntityRendererFactory.Context context, EntityModelLayer innerArmor, EntityModelLayer outerArmor) {
        super(context, new PygroModel<>(), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new ArmorEntityModel<>(context.getPart(innerArmor)), new ArmorEntityModel<>(context.getPart(outerArmor)), context.getModelManager()));
    }

    @Override
    public Identifier getTexture(MobEntity entity) {
        return TEXTURE.getId();
    }

    @Override
    protected boolean isShaking(MobEntity entity) {
        return super.isShaking(entity) || entity instanceof PygroEntity && ((PygroEntity) entity).shouldZombify();
    }
}
