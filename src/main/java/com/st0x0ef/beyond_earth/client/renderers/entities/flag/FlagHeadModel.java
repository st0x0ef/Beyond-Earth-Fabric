package com.st0x0ef.beyond_earth.client.renderers.entities.flag;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FlagHeadModel extends SkullBlockEntityModel {
    private final ModelPart root;
    protected final ModelPart head;

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "flag"), "main");

    public FlagHeadModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
    }

    public static ModelData createHeadModel() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        partdefinition.addChild("head", ModelPartBuilder.create().uv(8, 8).cuboid(-3.0F, -11.0F, 3.980F, 8.0F, 8.0F, 0.020F).uv(0, 8).cuboid(-3.0F, -11.0F, 4.002F, 8.0F, 8.0F, 0.020F), ModelTransform.NONE);
        return meshdefinition;
    }

    public static TexturedModelData createHumanoidHeadLayer() {
        ModelData meshdefinition = createHeadModel();
        ModelPartData partdefinition = meshdefinition.getRoot();
        partdefinition.getChild("head").addChild("hat", ModelPartBuilder.create().uv(40, 8).cuboid(-3.0F, -11.0F, 3.970F, 8.0F, 8.0F, 0.020F).uv(32, 8).cuboid(-3.0F, -11.0F, 4.020F, 8.0F, 8.0F, 0.020F), ModelTransform.NONE);
        return TexturedModelData.of(meshdefinition, 64, 64);
    }

    public static TexturedModelData createMobHeadLayer() {
        ModelData meshdefinition = createHeadModel();
        return TexturedModelData.of(meshdefinition, 64, 64);
    }

    @Override
    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * ((float) Math.PI / 180F);
        this.head.pitch = pitch * ((float) Math.PI / 180F);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
