package com.st0x0ef.beyond_earth.client.renderers.entities.flag;


import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.st0x0ef.beyond_earth.common.blocks.custom.FlagBlock;
import com.st0x0ef.beyond_earth.common.blocks.entities.custom.FlagBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.Uuids;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class FlagHeadRenderer implements BlockEntityRenderer<FlagBlockEntity> {

    public int getViewDistance() {
        return 256;
    }


    @Override
    public boolean isInRenderDistance(FlagBlockEntity blockEntity, Vec3d pos) {
        return Vec3d.ofCenter(blockEntity.getPos()).multiply(1.0D, 0.0D, 1.0D).isInRange(pos.multiply(1.0D, 0.0D, 1.0D), this.getViewDistance());
    }

    private static final Map<FlagBlock.ISkullType, FlagHeadModel> MODELS = Util.make(Maps.newHashMap(), (p_209262_0_) -> {

        MinecraftClient minecraft = MinecraftClient.getInstance();
        Map<String, ModelPart> map = Map.of("head", new FlagHeadModel(minecraft.getEntityModelLoader().getModelPart(FlagHeadModel.LAYER_LOCATION)).head);
        ModelPart modelPart = new ModelPart(Collections.emptyList(), map);

        FlagHeadModel genericheadmodel = new FlagHeadModel(modelPart);

        p_209262_0_.put(FlagBlock.Types.PLAYER, genericheadmodel);
    });

    private static final Map<FlagBlock.ISkullType, Identifier> SKINS = Util.make(Maps.newHashMap(), (p_209263_0_) -> {
        p_209263_0_.put(FlagBlock.Types.PLAYER, DefaultSkinHelper.getTexture());
    });


    @Override
    public void render(FlagBlockEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (tileEntityIn.getCachedState().get(FlagBlock.HALF) == DoubleBlockHalf.UPPER) {

            BlockState blockstate = tileEntityIn.getCachedState();
            boolean flag = blockstate.getBlock() instanceof FlagBlock;
            Direction direction = flag ? blockstate.get(FlagBlock.FACING) : null;
            render(direction, blockstate.get(FlagBlock.FACING).asRotation(), ((FlagBlock) blockstate.getBlock()).getSkullType(), tileEntityIn.getPlayerProfile(), 0, matrixStackIn, vertexConsumers, light);
        }
    }

    public static void render(@Nullable Direction directionIn, float p_228879_1_, FlagBlock.ISkullType skullType, @Nullable GameProfile gameProfileIn, float animationProgress, MatrixStack matrixStackIn, VertexConsumerProvider buffer, int combinedLight) {
        FlagHeadModel genericheadmodel = MODELS.get(skullType);
        matrixStackIn.push();
        if (directionIn.getHorizontal() == 0) {
            matrixStackIn.translate(1D, 0.031D, 0.25D);
        }
        else if (directionIn.getHorizontal() == 1) {
            matrixStackIn.translate(0.75D, 0.031D, 1D);
        }
        else if (directionIn.getHorizontal() == 2) {
            matrixStackIn.translate(0D, 0.031D, 0.75D);
        }
        else if (directionIn.getHorizontal() == 3) {
            matrixStackIn.translate(0.25D, 0.031D, 0D);
        }

        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);

        VertexConsumer ivertexbuilder = buffer.getBuffer(getRenderLayer(skullType, gameProfileIn));
        genericheadmodel.setHeadRotation(animationProgress, p_228879_1_, 0.0F);
        genericheadmodel.render(matrixStackIn, ivertexbuilder, combinedLight, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers().draw();
        matrixStackIn.pop();
    }

    private static RenderLayer getRenderLayer(FlagBlock.ISkullType skullType, @Nullable GameProfile gameProfileIn) {
        Identifier resourcelocation = SKINS.get(skullType);
        if (skullType == FlagBlock.Types.PLAYER && gameProfileIn != null) {
            MinecraftClient minecraft = MinecraftClient.getInstance();
            Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.getSkinProvider().getTextures(gameProfileIn);
            return map.containsKey(MinecraftProfileTexture.Type.SKIN) ? RenderLayer.getEntityTranslucent(minecraft.getSkinProvider().loadSkin(map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN)) : RenderLayer.getEntityCutoutNoCullZOffset(DefaultSkinHelper.getTexture(Uuids.getUuidFromProfile(gameProfileIn)));
        } else {
            return RenderLayer.getEntityCutoutNoCullZOffset(resourcelocation);
        }
    }

}
