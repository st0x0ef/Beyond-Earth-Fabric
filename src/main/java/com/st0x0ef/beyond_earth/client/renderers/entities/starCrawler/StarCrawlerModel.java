package com.st0x0ef.beyond_earth.client.renderers.entities.starCrawler;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.StarCrawlerEntity;
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
public class StarCrawlerModel <T extends StarCrawlerEntity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "star_crawler"), "main");

    private final ModelPart body;
    private final ModelPart arm1g;
    private final ModelPart arm2g;
    private final ModelPart arm3g;
    private final ModelPart arm4g;

    public StarCrawlerModel(ModelPart root) {
        this.body = root.getChild("body");
        this.arm1g = root.getChild("arm1g");
        this.arm2g = root.getChild("arm2g");
        this.arm3g = root.getChild("arm3g");
        this.arm4g = root.getChild("arm4g");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData Body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -13.0F, -8.0F, 16.0F, 10.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 26).cuboid(-7.0F, -9.0F, -7.0F, 14.0F, 9.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData arm1g = partdefinition.addChild("arm1g", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.3F, 6.75F));

        ModelPartData Arm1 = arm1g.addChild("Arm1", ModelPartBuilder.create().uv(48, 48).cuboid(-6.0F, -5.2F, 0.25F, 12.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(42, 26).cuboid(-5.0F, 2.8F, -1.75F, 10.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = Arm1.addChild("cube_r1", ModelPartBuilder.create().uv(48, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, 4.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r2 = Arm1.addChild("cube_r2", ModelPartBuilder.create().uv(58, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 3.0F, 3.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Limb1 = arm1g.addChild("Limb1", ModelPartBuilder.create().uv(48, 0).cuboid(-5.0F, -4.3F, 0.25F, 10.0F, 7.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 64).cuboid(-4.0F, 2.7F, -0.75F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 7.0F));

        ModelPartData cube_r3 = Limb1.addChild("cube_r3", ModelPartBuilder.create().uv(59, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 3.0F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r4 = Limb1.addChild("cube_r4", ModelPartBuilder.create().uv(57, 16).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 3.0F, 4.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Hand1 = arm1g.addChild("Hand1", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -3.3F, 0.25F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F))
                .uv(25, 55).cuboid(-3.0F, 2.7F, -0.75F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.1F, 15.0F));

        ModelPartData cube_r5 = Hand1.addChild("cube_r5", ModelPartBuilder.create().uv(39, 49).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 2.9F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r6 = Hand1.addChild("cube_r6", ModelPartBuilder.create().uv(49, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.9F, 4.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData arm2g = partdefinition.addChild("arm2g", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.4F, -7.75F));

        ModelPartData Arm2 = arm2g.addChild("Arm2", ModelPartBuilder.create().uv(48, 48).cuboid(-6.0F, -5.2F, 0.25F, 12.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(42, 26).cuboid(-5.0F, 2.8F, -1.75F, 10.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.1F, 1.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData cube_r7 = Arm2.addChild("cube_r7", ModelPartBuilder.create().uv(48, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, 4.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r8 = Arm2.addChild("cube_r8", ModelPartBuilder.create().uv(58, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 3.0F, 3.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Limb2 = arm2g.addChild("Limb2", ModelPartBuilder.create().uv(48, 0).cuboid(-5.0F, -4.3F, 0.25F, 10.0F, 7.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 64).cuboid(-4.0F, 2.7F, -0.75F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.1F, -6.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData cube_r9 = Limb2.addChild("cube_r9", ModelPartBuilder.create().uv(59, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 3.0F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r10 = Limb2.addChild("cube_r10", ModelPartBuilder.create().uv(57, 16).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 3.0F, 4.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Hand2 = arm2g.addChild("Hand2", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -3.3F, -4.75F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F))
                .uv(25, 55).cuboid(-3.0F, 2.7F, -3.75F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -19.0F));

        ModelPartData cube_r11 = Hand2.addChild("cube_r11", ModelPartBuilder.create().uv(39, 49).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 2.9F, 0.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r12 = Hand2.addChild("cube_r12", ModelPartBuilder.create().uv(49, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.9F, -0.75F, 0.0F, 0.0F, 0.3491F));

        ModelPartData arm3g = partdefinition.addChild("arm3g", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, 24.0F, 0.0F));

        ModelPartData Arm3 = arm3g.addChild("Arm3", ModelPartBuilder.create().uv(48, 48).cuboid(-6.0F, -5.2F, 0.25F, 12.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(42, 26).cuboid(-5.0F, 2.8F, -1.75F, 10.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -5.7F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r13 = Arm3.addChild("cube_r13", ModelPartBuilder.create().uv(48, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, 4.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r14 = Arm3.addChild("cube_r14", ModelPartBuilder.create().uv(58, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 3.0F, 3.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Limb3 = arm3g.addChild("Limb3", ModelPartBuilder.create().uv(48, 0).cuboid(-5.0F, -4.3F, 0.25F, 10.0F, 7.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 64).cuboid(-4.0F, 2.7F, -0.75F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-6.75F, -5.7F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r15 = Limb3.addChild("cube_r15", ModelPartBuilder.create().uv(59, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 3.0F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r16 = Limb3.addChild("cube_r16", ModelPartBuilder.create().uv(57, 16).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 3.0F, 4.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Hand3 = arm3g.addChild("Hand3", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -3.3F, 0.25F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F))
                .uv(25, 55).cuboid(-3.0F, 2.7F, -0.75F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-14.75F, -5.6F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r17 = Hand3.addChild("cube_r17", ModelPartBuilder.create().uv(39, 49).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 2.9F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r18 = Hand3.addChild("cube_r18", ModelPartBuilder.create().uv(49, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.9F, 4.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData arm4g = partdefinition.addChild("arm4g", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, 24.0F, 0.0F));

        ModelPartData Arm4 = arm4g.addChild("Arm4", ModelPartBuilder.create().uv(48, 48).cuboid(-6.0F, -5.2F, 0.25F, 12.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(42, 26).cuboid(-5.0F, 2.8F, -1.75F, 10.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-1.25F, -5.7F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r19 = Arm4.addChild("cube_r19", ModelPartBuilder.create().uv(48, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, 4.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r20 = Arm4.addChild("cube_r20", ModelPartBuilder.create().uv(58, 64).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 3.0F, 3.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Limb4 = arm4g.addChild("Limb4", ModelPartBuilder.create().uv(48, 0).cuboid(-5.0F, -4.3F, 0.25F, 10.0F, 7.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 64).cuboid(-4.0F, 2.7F, -0.75F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(5.75F, -5.7F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r21 = Limb4.addChild("cube_r21", ModelPartBuilder.create().uv(59, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 3.0F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r22 = Limb4.addChild("cube_r22", ModelPartBuilder.create().uv(57, 16).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 3.0F, 4.25F, 0.0F, 0.0F, 0.3491F));

        ModelPartData Hand4 = arm4g.addChild("Hand4", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -3.3F, 0.25F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F))
                .uv(25, 55).cuboid(-3.0F, 2.7F, -0.75F, 6.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(13.75F, -5.6F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r23 = Hand4.addChild("cube_r23", ModelPartBuilder.create().uv(39, 49).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 2.9F, 5.25F, 0.0F, 3.1416F, -0.3491F));

        ModelPartData cube_r24 = Hand4.addChild("cube_r24", ModelPartBuilder.create().uv(49, 38).cuboid(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.9F, 4.25F, 0.0F, 0.0F, 0.3491F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

    @Override
    public void setAngles(T entity, float f, float f1, float f2, float f3, float f4) {
        this.arm1g.getChild("Hand1").yaw = MathHelper.cos(f * 0.6662F) * f1;
        this.arm2g.getChild("Hand2").yaw = MathHelper.cos(f * 0.6662F) * f1;
        this.arm3g.getChild("Hand3").yaw = 80.115f + MathHelper.cos(f * 0.6662F) * f1;
        this.arm4g.getChild("Hand4").yaw = -80.115f + MathHelper.cos(f * 0.6662F) * f1;

        // arm
        this.arm1g.yaw = MathHelper.cos(f * 0.6662F) * f1;
        this.arm2g.yaw = MathHelper.cos(f * 0.6662F) * f1;
        this.arm3g.yaw = MathHelper.cos(f * 0.6662F) * f1;
        this.arm4g.yaw = MathHelper.cos(f * 0.6662F) * f1;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        arm1g.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        arm2g.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        arm3g.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        arm4g.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
