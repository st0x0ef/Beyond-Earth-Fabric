package com.st0x0ef.beyond_earth.client.renderers.entities.alienZombie;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.AlienZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AlienZombieRenderer extends MobEntityRenderer<AlienZombieEntity, EntityModel<AlienZombieEntity>> {
    public static final Identifier TEXTURE = new Identifier(BeyondEarth.MOD_ID, "textures/entity/alien_zombie.png");


    public AlienZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new AlienZombieModel<>(context.getPart(AlienZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(AlienZombieEntity entity) {
        return TEXTURE;
    }
}
