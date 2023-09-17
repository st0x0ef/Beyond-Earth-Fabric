package net.mrscauthd.beyond_earth.client.renderers.entities.globe;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.common.blocks.entities.GlobeTileEntity;

@Environment(EnvType.CLIENT)
public class GlobeModel<T extends GlobeTileEntity> extends Model {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "globe"), "main");
    public final ModelPart globe;
    public GlobeModel(ModelPart root) {
        super(RenderLayer::getEntityCutout);
        this.globe = root.getChild("globe");
    }

    public static TexturedModelData createLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData globe = partdefinition.addChild("globe", ModelPartBuilder.create().uv(0, 16).cuboid(-7.0F, -16.0F, 1.0F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F)).uv(0, 28).cuboid(-4.0F, -1.0F, -2.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F)).uv(0, 35).cuboid(-3.0F, -5.0F, -1.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-2.0F, -4.0F, 0.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 24.0F, -1.0F));

        ModelPartData planet = globe.addChild("planet", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -10.0F, 1.0F));

        ModelPartData cube_r1 = planet.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 64, 64);
    }

    public void setupAnim(T entity, float partialTicks) {
        this.globe.getChild("planet").yaw = MathHelper.lerp(partialTicks, entity.getYaw0(), entity.getYaw());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        globe.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
