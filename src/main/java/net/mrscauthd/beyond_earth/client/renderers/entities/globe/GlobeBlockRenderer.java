package net.mrscauthd.beyond_earth.client.renderers.entities.globe;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.mrscauthd.beyond_earth.common.blocks.custom.GlobeBlock;
import net.mrscauthd.beyond_earth.common.blocks.entities.GlobeTileEntity;

@Environment(EnvType.CLIENT)
public class GlobeBlockRenderer<T extends GlobeTileEntity> implements BlockEntityRenderer<GlobeTileEntity>, BlockEntityRendererFactory<T> {
    private GlobeModel model;

    public GlobeBlockRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(GlobeTileEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState state = entity.getWorld().getBlockState(entity.getPos());

        if (!(state.getBlock() instanceof GlobeBlock)) {
            return;
        }

        MinecraftClient mc = MinecraftClient.getInstance();
        BlockState blockstate = entity.getCachedState();
        Direction direction = blockstate.get(GlobeBlock.FACING);

        matrices.push();

        matrices.translate(0.5D, 1.5D, 0.5D);
        matrices.scale(-1.0F, -1.0F, 1.0F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(direction.asRotation()));

        if (this.model == null) {
            this.model = new GlobeModel(mc.getEntityModelLoader().getModelPart(GlobeModel.LAYER_LOCATION));
        }

        /** Animation */
        this.model.setupAnim(entity, tickDelta);

        VertexConsumer vertexBuilder = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(((GlobeBlock) state.getBlock()).texture));

        this.model.render(matrices, vertexBuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        mc.getBufferBuilders().getEntityVertexConsumers().draw();

        matrices.pop();
    }

    @Override
    public BlockEntityRenderer<T> create(Context ctx) {
        return this::render;
    }
}
