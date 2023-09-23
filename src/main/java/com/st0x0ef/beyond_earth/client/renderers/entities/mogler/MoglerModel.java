package com.st0x0ef.beyond_earth.client.renderers.entities.mogler;

import com.google.common.collect.ImmutableList;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.client.renderers.entities.pygro.PygroModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.Hoglin;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class MoglerModel <T extends MobEntity & Hoglin> extends AnimalModel<T> {

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "mogler"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;

    public MoglerModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -15.0F, -13.0F, 16.0F, 9.0F, 32.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(85, 30).cuboid(-9.0F, -20.0F, 12.0F, 18.0F, 9.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 41).cuboid(-10.0F, -18.0F, 5.0F, 20.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(58, 52).cuboid(-11.0F, -18.0F, 2.0F, 22.0F, 9.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(64, 0).cuboid(-12.0F, -22.0F, -4.0F, 24.0F, 11.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(0, 66).cuboid(-10.0F, -26.0F, -3.0F, 20.0F, 11.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.829F, 0.0F, 0.0F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(0, 22).cuboid(-7.5F, -8.5F, -1.75F, 15.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.5F, -20.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(62, 75).cuboid(-9.0F, -8.5F, -1.75F, 18.0F, 13.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.5F, -20.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData jaw2 = head.addChild("jaw2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -11.5F, -20.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r8 = jaw2.addChild("cube_r8", ModelPartBuilder.create().uv(96, 99).cuboid(5.25F, -1.5F, -0.75F, 5.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

        ModelPartData jaw1 = head.addChild("jaw1", ModelPartBuilder.create(), ModelTransform.of(0.0F, -11.5F, -20.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r9 = jaw1.addChild("cube_r9", ModelPartBuilder.create().uv(0, 110).cuboid(-10.25F, -1.5F, -0.75F, 5.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

        ModelPartData leg1 = partdefinition.addChild("leg1", ModelPartBuilder.create().uv(64, 99).cuboid(-3.5F, -3.5F, -4.5F, 7.0F, 13.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.5F, 14.5F, -6.5F));

        ModelPartData leg2 = partdefinition.addChild("leg2", ModelPartBuilder.create().uv(32, 90).cuboid(-3.5F, -3.5F, -4.5F, 7.0F, 13.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(9.5F, 14.5F, -6.5F));

        ModelPartData leg3 = partdefinition.addChild("leg3", ModelPartBuilder.create().uv(0, 88).cuboid(-3.5F, -3.5F, -4.5F, 7.0F, 13.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(9.5F, 14.5F, 12.5F));

        ModelPartData leg4 = partdefinition.addChild("leg4", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -3.5F, -4.5F, 7.0F, 13.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.5F, 14.5F, 12.5F));

        return TexturedModelData.of(meshdefinition, 256, 256);
    }
    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body, this.leg1, this.leg2, this.leg3, this.leg4);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float animationProgress, float headYaw, float headPitch) {
        this.head.yaw = headYaw * ((float)Math.PI / 180F);
        int i = entity.getMovementCooldownTicks();
        float f = 1.0F - (float) MathHelper.abs(10 - 2 * i) / 10.0F;
        this.head.pitch = MathHelper.lerp(f, 0.0F, -1.14906584F);

        this.leg1.pitch = MathHelper.cos(limbSwing) * 1.2F * limbSwingAmount;
        this.leg2.pitch = MathHelper.cos(limbSwing + (float)Math.PI) * 1.2F * limbSwingAmount;
        this.leg3.pitch = this.leg1.pitch;
        this.leg4.pitch = this.leg2.pitch;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        if (child) {
            matrices.scale(0.5f, 0.5f, 0.5f);
            matrices.translate(0, 1.5f, 0);
        }
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg1.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg2.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg3.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg4.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
