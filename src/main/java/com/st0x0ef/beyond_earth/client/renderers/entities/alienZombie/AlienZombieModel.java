package com.st0x0ef.beyond_earth.client.renderers.entities.alienZombie;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.AlienZombieEntity;
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
public class AlienZombieModel<T extends AlienZombieEntity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "alien_zombie"), "main");

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leg0;
    private final ModelPart leg1;
    private final ModelPart arm1;
    private final ModelPart arm2;
    private final ModelPart monsterarm1;
    private final ModelPart monsterarm2;
    private final ModelPart monsterarm3;
    private final ModelPart monsterarm4;

    public AlienZombieModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leg0 = root.getChild("leg0");
        this.leg1 = root.getChild("leg1");
        this.arm1 = root.getChild("arm1");
        this.arm2 = root.getChild("arm2");
        this.monsterarm1 = root.getChild("monsterarm1");
        this.monsterarm2 = root.getChild("monsterarm2");
        this.monsterarm3 = root.getChild("monsterarm3");
        this.monsterarm4 = root.getChild("monsterarm4");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 2.0F, -6.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(88, 59).mirrored().cuboid(-0.5095F, -2.211F, -0.6496F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.25F, 4.1027F, -5.534F, 1.0036F, 0.48F, -0.8727F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(88, 59).cuboid(-1.7975F, -1.8508F, -0.9483F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.75F, 4.1027F, -5.534F, 1.0036F, -0.48F, 0.8727F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(88, 54).cuboid(-1.5F, -1.75F, -0.75F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.8527F, -7.434F, -0.3927F, 0.0F, 0.0F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(33, 0).mirrored().cuboid(-4.5F, -3.9804F, -4.3483F, 9.0F, 10.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -14.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(40, 53).mirrored().cuboid(-3.0F, 2.8551F, 0.3492F, 7.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, -5.0F, 0.0F, -1.0036F, 0.0F, 0.0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.1927F, 0.7599F));

        ModelPartData nose_r1 = nose.addChild("nose_r1", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(-1.0F, -0.5896F, 1.4131F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.0F, -6.0F, -1.0036F, 0.0F, 0.0F));

        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(16, 20).mirrored().cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 38).mirrored().cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 20.0F, 6.0F, new Dilation(0.5F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, -3.0F, 0.2182F, 0.0F, 0.0F));

        ModelPartData leg0 = partdefinition.addChild("leg0", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 12.0F, 0.0F));

        ModelPartData leg1 = partdefinition.addChild("leg1", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

        ModelPartData arm1 = partdefinition.addChild("arm1", ModelPartBuilder.create().uv(44, 22).mirrored().cuboid(-8.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 4.0F, -1.5F, 0.0436F, 0.0F, 0.0F));

        ModelPartData arm2 = partdefinition.addChild("arm2", ModelPartBuilder.create().uv(44, 22).mirrored().cuboid(4.0F, -2.0F, -5.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.0F, -1.5F));

        ModelPartData monsterarm1 = partdefinition.addChild("monsterarm1", ModelPartBuilder.create().uv(30, 46).cuboid(-17.0F, -1.0F, -1.0F, 17.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.9599F));

        ModelPartData cube_r4 = monsterarm1.addChild("cube_r4", ModelPartBuilder.create().uv(34, 46).cuboid(-15.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(-16.25F, 0.0F, 0.75F, 0.0F, -1.1345F, 0.0F));

        ModelPartData monsterarm2 = partdefinition.addChild("monsterarm2", ModelPartBuilder.create().uv(30, 46).cuboid(-17.0F, -1.0F, -1.0F, 17.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -0.25F, -3.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube_r5 = monsterarm2.addChild("cube_r5", ModelPartBuilder.create().uv(34, 46).cuboid(-15.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(-16.25F, 0.0F, 0.75F, 0.0F, -1.1345F, 0.0F));

        ModelPartData monsterarm3 = partdefinition.addChild("monsterarm3", ModelPartBuilder.create().uv(30, 46).cuboid(-17.0F, -1.0F, -1.0F, 17.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.1817F));

        ModelPartData cube_r6 = monsterarm3.addChild("cube_r6", ModelPartBuilder.create().uv(34, 46).cuboid(-15.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(-16.25F, 0.0F, 0.75F, 0.0F, -1.1345F, 0.0F));

        ModelPartData monsterarm4 = partdefinition.addChild("monsterarm4", ModelPartBuilder.create().uv(30, 46).cuboid(-17.0F, -1.0F, -1.0F, 17.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -0.25F, -3.0F, 0.0F, 0.0F, -2.7489F));

        ModelPartData cube_r7 = monsterarm4.addChild("cube_r7", ModelPartBuilder.create().uv(30, 46).cuboid(-15.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(-16.25F, 0.0F, 0.75F, 0.0F, -1.1345F, 0.0F));

        return TexturedModelData.of(meshdefinition, 96, 64);
    }

    @Override
    public void setAngles(T entity, float f, float f1, float f2, float f3, float f4) {
        //base
        this.arm2.yaw = 0.0F;
        this.arm1.yaw = 0.0F;
        this.arm2.roll = 0.0F;
        this.arm1.roll = 0.0F;
        this.arm2.pitch = 0.0F;
        this.arm1.pitch = 0.0F;

        this.arm2.roll -= MathHelper.cos(f2 * 0.04F) * 0.04F + 0.04F;
        this.arm1.roll += MathHelper.cos(f2 * 0.04F) * 0.04F + 0.04F;

        //base end

        this.head.yaw = f3 / (180F / (float) Math.PI);
        this.head.pitch = f4 / (180F / (float) Math.PI);
        this.leg0.pitch = MathHelper.cos(f) * -1.0F * f1;
        this.leg1.pitch = MathHelper.cos(f) * 1.0F * f1;
        this.monsterarm1.yaw = MathHelper.cos(f * 0.3662F + (float) Math.PI) * f1 / 2;
        this.monsterarm4.yaw = MathHelper.cos(f * 0.3662F + (float) Math.PI) * f1 / 2;
        this.monsterarm3.yaw = MathHelper.cos(f * 0.3662F + (float) Math.PI) * f1 / 2;
        this.monsterarm2.yaw = MathHelper.cos(f * 0.3662F + (float) Math.PI) * f1 / 2;
        this.arm1.pitch = 30f;
        this.arm2.pitch = 30f;

        this.arm2.pitch -= MathHelper.cos(f2 * 0.04F) * 0.04F + 0.04F;
        this.arm1.pitch += MathHelper.cos(f2 * 0.04F) * 0.04F + 0.04F;
    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leg0.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leg1.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        arm1.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        arm2.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        monsterarm1.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        monsterarm2.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        monsterarm3.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        monsterarm4.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
