package com.st0x0ef.beyond_earth.client.renderers.entities.starCrawler;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.StarCrawlerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class StarCrawlerRenderer extends MobEntityRenderer<StarCrawlerEntity, StarCrawlerModel<StarCrawlerEntity>> {
    public static final Identifier TEXTURE = new Identifier(BeyondEarth.MOD_ID, "textures/entity/star_crawler.png");

    public StarCrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new StarCrawlerModel<>(context.getPart(StarCrawlerModel.LAYER_LOCATION)), 0);
    }

    @Override
    public Identifier getTexture(StarCrawlerEntity entity) {
        return TEXTURE;
    }
}
