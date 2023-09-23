package com.st0x0ef.beyond_earth.client.renderers.entities.mogler;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.MoglerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MoglerRenderer extends MobEntityRenderer<MoglerEntity, EntityModel<MoglerEntity>> {
    private static final Identifier HOGLIN_LOCATION = new Identifier(BeyondEarth.MOD_ID,"textures/entity/mogler.png");

    public MoglerRenderer(EntityRendererFactory.Context context) {
        super(context, new MoglerModel<>(context.getPart(MoglerModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public Identifier getTexture(MoglerEntity entity) {
        return HOGLIN_LOCATION;
    }

    @Override
    protected boolean isShaking(MoglerEntity entity) {
        return super.isShaking(entity) || entity.canConvert();

    }
}
