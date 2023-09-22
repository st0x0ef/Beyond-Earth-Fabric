package com.st0x0ef.beyond_earth.client.renderers.entities.globe;

import com.st0x0ef.beyond_earth.common.items.custom.GlobeItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EarthGlobeItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    private Identifier texture;
    private GlobeModel model;


    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        matrices.translate(0.5D, 1.5D, 0.5D);
        matrices.scale(-1.0F, -1.0F, 1.0F);

        MinecraftClient mc = MinecraftClient.getInstance();
        ClientWorld level = mc.world;

        if (this.model == null) {
            this.model = new GlobeModel(mc.getEntityModelLoader().getModelPart(GlobeModel.LAYER_LOCATION));
        }

        if (texture == null && stack.getItem() instanceof GlobeItem item) {
            texture = item.getTexture();
        }

        VertexConsumer vertexBuilder = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCullZOffset(texture));

        /** Animation */
        if (level != null) {
            if (!mc.isPaused()) {
                model.globe.getChild("planet").yaw = (level.getTime() + mc.getTickDelta()) / -20;
            }
        }

        this.model.render(matrices, vertexBuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}
