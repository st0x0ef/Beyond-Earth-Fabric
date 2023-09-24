package com.st0x0ef.beyond_earth.client.renderers.entities.martianRaptor;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.MartianRaptorEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MartianRaptorRenderer extends MobEntityRenderer<MartianRaptorEntity, EntityModel<MartianRaptorEntity>> {

    public static final Identifier TEXTURE = new Identifier(BeyondEarth.MOD_ID, "textures/entity/martian_raptor.png");

    public MartianRaptorRenderer(EntityRendererFactory.Context context) {
        super(context, new MartianRaptorModel<>(context.getPart(MartianRaptorModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(MartianRaptorEntity entity) {
        return TEXTURE;
    }
}
