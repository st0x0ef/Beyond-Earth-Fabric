package com.st0x0ef.beyond_earth.client.renderers.entities.alien;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.alien.AlienEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class AlienModel <T extends AlienEntity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "alien"), "main");

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leg0;
    private final ModelPart leg1;
    private final ModelPart arms;
    private final ModelPart head2;
    public AlienModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leg0 = root.getChild("leg0");
        this.leg1 = root.getChild("leg1");
        this.arms = root.getChild("arms");
        this.head2 = root.getChild("head2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
                .uv(32, 0).mirrored().cuboid(-4.5F, -19.0F, -4.5F, 9.0F, 10.0F, 9.0F, new Dilation(0.0F)).mirrored(false)
                .uv(16, 64).mirrored().cuboid(-8.0F, -15.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(70, 2).mirrored().cuboid(-6.0F, -16.0F, -6.0F, 12.0F, 0.0F, 12.0F, new Dilation(0.0F)).mirrored(false)
                .uv(24, 0).mirrored().cuboid(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(16, 20).mirrored().cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 38).mirrored().cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new Dilation(0.5F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg0 = partdefinition.addChild("leg0", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 12.0F, 0.0F));

        ModelPartData leg1 = partdefinition.addChild("leg1", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

        ModelPartData arms = partdefinition.addChild("arms", ModelPartBuilder.create().uv(40, 38).mirrored().cuboid(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(44, 22).mirrored().cuboid(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(44, 22).mirrored().cuboid(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 2.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData head2 = partdefinition.addChild("head2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -10.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

    @Override
    public void setAngles(T e, float f, float f1, float f2, float f3, float f4) {
        this.head.yaw = f3 / (180F / (float) Math.PI);
        this.head.pitch = f4 / (180F / (float) Math.PI);
        this.leg0.pitch = MathHelper.cos(f) * -1.0F * f1;
        this.leg1.pitch = MathHelper.cos(f) * 1.0F * f1;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (child) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
            matrixStack.translate(0, 1.5f, 0);
        }

        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leg0.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        arms.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        head2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
