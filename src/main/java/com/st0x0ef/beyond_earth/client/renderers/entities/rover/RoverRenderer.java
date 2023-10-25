package com.st0x0ef.beyond_earth.client.renderers.entities.rover;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.client.renderers.entities.VehicleRenderer;
import com.st0x0ef.beyond_earth.common.entity.custom.nonLivingEntities.RoverEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class RoverRenderer extends VehicleRenderer<RoverEntity, RoverModel<RoverEntity>> {
    public static final Identifier TEXTURE = new Identifier(BeyondEarth.MOD_ID, "textures/vehicle/rover.png");
    public RoverRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RoverModel<>(ctx.getPart(RoverModel.LAYER_LOCATION)), 0f);
    }

    @Override
    public Identifier getTexture(RoverEntity entity) {
        return TEXTURE;
    }

    @Override
    public boolean shouldRender(RoverEntity entity, Frustum frustum, double x, double y, double z) {
        return frustum.isVisible(entity.getBoundingBox().expand(4));
    }
}
