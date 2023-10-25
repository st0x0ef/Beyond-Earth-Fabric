package com.st0x0ef.beyond_earth.client.renderers.entities.rover;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.nonLivingEntities.RoverEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class RoverItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    /** TEXTURE */
    public static final Identifier TEXTURE = new Identifier(BeyondEarth.MOD_ID, "textures/vehicle/rover.png");

    /** MODEL */
    private RoverModel model;


    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
        matrices.translate(0.0, -1.5, 0.0);

        MinecraftClient mc = MinecraftClient.getInstance();

        VertexConsumer vertexBuilder;

        /** TEXTURE BINDING */
        vertexBuilder = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCullZOffset(TEXTURE));

        if (this.model == null) {
            this.model = new RoverModel(mc.getEntityModelLoader().getModelPart(RoverModel.LAYER_LOCATION));
        }

        this.model.render(matrices, vertexBuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}
