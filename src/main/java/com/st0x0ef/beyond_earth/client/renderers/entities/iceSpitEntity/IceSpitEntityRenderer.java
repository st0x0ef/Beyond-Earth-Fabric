package com.st0x0ef.beyond_earth.client.renderers.entities.iceSpitEntity;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.IceSpitEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class IceSpitEntityRenderer extends ProjectileEntityRenderer<IceSpitEntity> {
    public IceSpitEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(IceSpitEntity entity) {
        return new Identifier(BeyondEarth.MOD_ID, "");
    }
}
