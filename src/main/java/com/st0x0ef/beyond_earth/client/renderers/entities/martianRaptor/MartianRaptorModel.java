package com.st0x0ef.beyond_earth.client.renderers.entities.martianRaptor;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.MartianRaptorEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class MartianRaptorModel<T extends MartianRaptorEntity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "martian_raptor"), "main");

    private final ModelPart body;
    private final ModelPart leg1;
    private final ModelPart leg2;

    private final boolean Eat = false;
    private final float Anim = 0;
    private final boolean AttackCheck = false;

    public MartianRaptorModel(ModelPart root) {
        this.body = root.getChild("body");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData leg1 = partdefinition.addChild("leg1", ModelPartBuilder.create().uv(14, 69).cuboid(-2.0F, 11.7065F, -5.0813F, 5.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 9.0F, 4.0F));

        ModelPartData cube_r1 = leg1.addChild("cube_r1", ModelPartBuilder.create().uv(36, 64).cuboid(-2.5F, -7.0F, -2.5F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 7.7065F, 2.4187F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r2 = leg1.addChild("cube_r2", ModelPartBuilder.create().uv(0, 58).cuboid(-2.5F, -6.0F, -2.5F, 5.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.2935F, 2.4187F, 0.6545F, 0.0F, 0.0F));

        ModelPartData leg2 = partdefinition.addChild("leg2", ModelPartBuilder.create().uv(14, 69).mirrored().cuboid(-3.0F, 11.7065F, -5.0813F, 5.0F, 3.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-6.0F, 9.0F, 4.0F));

        ModelPartData cube_r3 = leg2.addChild("cube_r3", ModelPartBuilder.create().uv(36, 64).mirrored().cuboid(-2.5F, -7.0F, -2.5F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 7.7065F, 2.4187F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r4 = leg2.addChild("cube_r4", ModelPartBuilder.create().uv(0, 58).mirrored().cuboid(-2.5F, -6.0F, -2.5F, 5.0F, 12.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, -0.2935F, 2.4187F, 0.6545F, 0.0F, 0.0F));

        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -24.0F, -6.0F, 8.0F, 10.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -19.0F, -3.0F));

        ModelPartData bone2 = head.addChild("bone2", ModelPartBuilder.create().uv(34, 34).cuboid(-5.0F, -4.0F, 0.0F, 10.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData bone = bone2.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(0.25F, -6.75F, 6.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData cube_r5 = bone.addChild("cube_r5", ModelPartBuilder.create().uv(0, 42).cuboid(-6.0F, -5.5F, -4.5F, 10.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.2012F, 0.0F, -0.1198F, -0.0436F, 0.6981F, 0.0F));

        ModelPartData cube_r6 = bone.addChild("cube_r6", ModelPartBuilder.create().uv(0, 42).mirrored().cuboid(-4.0F, -5.5F, -4.5F, 10.0F, 11.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7988F, 0.0F, -0.1198F, -0.0436F, -0.6981F, 0.0F));

        ModelPartData mouth1 = bone2.addChild("mouth1", ModelPartBuilder.create(), ModelTransform.pivot(-2.1711F, 4.4542F, 3.0357F));

        ModelPartData cube_r7 = mouth1.addChild("cube_r7", ModelPartBuilder.create().uv(52, 71).cuboid(-1.5789F, -1.5855F, -2.25F, 3.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData mouth2 = bone2.addChild("mouth2", ModelPartBuilder.create(), ModelTransform.pivot(1.8289F, 4.4542F, 3.0357F));

        ModelPartData cube_r8 = mouth2.addChild("cube_r8", ModelPartBuilder.create().uv(52, 71).mirrored().cuboid(-1.0789F, -1.4145F, -2.25F, 3.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -19.0F, 9.0F));

        ModelPartData cube_r9 = tail.addChild("cube_r9", ModelPartBuilder.create().uv(20, 50).cuboid(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.1366F, 17.1501F, 0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r10 = tail.addChild("cube_r10", ModelPartBuilder.create().uv(31, 0).cuboid(-3.0F, -2.5F, -5.0F, 6.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.8909F, 9.0849F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r11 = tail.addChild("cube_r11", ModelPartBuilder.create().uv(63, 7).cuboid(-2.5F, -1.0F, -1.5F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.4973F, 16.5505F, 1.7017F, 0.0F, 0.0F));

        ModelPartData cube_r12 = tail.addChild("cube_r12", ModelPartBuilder.create().uv(61, 31).cuboid(-3.5F, -1.0F, -2.5F, 7.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.7473F, 12.5505F, 1.6144F, 0.0F, 0.0F));

        ModelPartData cube_r13 = tail.addChild("cube_r13", ModelPartBuilder.create().uv(24, 26).cuboid(-10.5F, -2.0F, -5.5F, 8.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, 2.7065F, 5.4187F, 1.1345F, 0.0F, 0.0F));

        ModelPartData cube_r14 = tail.addChild("cube_r14", ModelPartBuilder.create().uv(53, 0).cuboid(-10.5F, -2.0F, -5.5F, 8.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, 3.7065F, 9.4187F, 1.3526F, 0.0F, 0.0F));

        ModelPartData cube_r15 = tail.addChild("cube_r15", ModelPartBuilder.create().uv(0, 25).cuboid(-3.5F, -3.5F, -5.0F, 7.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.4079F, 1.7286F, -0.6545F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

        float i = entity.getAttackTicksLeft();
        float f = 1.0F - MathHelper.abs(10 - 2 * i) / 10.0F;

        this.body.getChild("head").getChild("bone2").getChild("mouth1").roll = MathHelper.lerp(f, 0.0F, -1.14906584F);
        this.body.getChild("head").getChild("bone2").getChild("mouth2").roll = -MathHelper.lerp(f, 0.0F, -1.14906584F);

        this.leg1.pitch = MathHelper.cos(limbAngle) * -1.0F * limbDistance;
        this.leg2.pitch = MathHelper.cos(limbAngle) * 1.0F * limbDistance;

        this.body.getChild("head").yaw = headYaw / (180F / (float) Math.PI);
        this.body.getChild("head").pitch = headPitch / (180F / (float) Math.PI);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg1.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg2.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
