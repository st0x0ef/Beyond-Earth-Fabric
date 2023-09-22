package com.st0x0ef.beyond_earth.client.renderers.entities.pygro;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinActivity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class PygroModel<T extends MobEntity> extends PlayerEntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "pygro"), "main");

    public final ModelPart rightEar = this.head.getChild("right_ear");
    private final ModelPart leftEar = this.head.getChild("left_ear");

    private final ModelTransform bodyDefault = this.body.getTransform();
    private final ModelTransform headDefault = this.head.getTransform();
    private final ModelTransform leftArmDefault = this.leftArm.getTransform();
    private final ModelTransform rightArmDefault = this.rightArm.getTransform();


    public PygroModel() {
        super(createBodyLayer().createModel(), false);
    }

    public static TexturedModelData createBodyLayer() {
        return TexturedModelData.of(PygroModel.getTexturedModelData(Dilation.NONE), 64, 64);
    }

    public static ModelData getTexturedModelData(Dilation dilation) {
        ModelData meshdefinition = PlayerEntityModel.getTexturedModelData(dilation, false);
        ModelPartData partdefinition = meshdefinition.getRoot();
        partdefinition.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation), ModelTransform.NONE);
        ModelPartData partdefinition1 = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, dilation).uv(31, 1).cuboid(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, dilation).uv(2, 4).cuboid(2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, dilation).uv(2, 0).cuboid(-3.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, dilation), ModelTransform.NONE);
        partdefinition1.addChild("left_ear", ModelPartBuilder.create().uv(39, 6).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, dilation), ModelTransform.of(4.5F, -6.0F, 0.0F, 0.0F, 0.0F, (-(float) Math.PI / 6F)));
        partdefinition1.addChild("right_ear", ModelPartBuilder.create().uv(39, 6).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, dilation), ModelTransform.of(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, ((float) Math.PI / 6F)));
        partdefinition.addChild("hat", ModelPartBuilder.create(), ModelTransform.NONE);

        //EYES
        ModelPartData eyes = partdefinition1.addChild("eyesg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        eyes.addChild("eyes", ModelPartBuilder.create().uv(46, 0).cuboid(-4.5F, -4.5F, -0.75F, 9.0F, 7.0F, 0.0F, Dilation.NONE), ModelTransform.of(0.0F, -7.5F, -4.0F, 0.3054F, 0.0F, 0.0F));

        //NOSE 1
        ModelPartData fang = partdefinition1.addChild("noseg1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        fang.addChild("nose1", ModelPartBuilder.create().uv(33, 2).cuboid(-1.25F, -1.35F, -0.5F, 3.0F, 3.0F, 1.0F, Dilation.NONE), ModelTransform.of(-2.0F, -25.0F, -4.5F, 0.0631F, 0.3435F, 0.1855F));

        //NOSE 2
        ModelPartData fang2 = partdefinition1.addChild("noseg2", ModelPartBuilder.create(), ModelTransform.pivot(4.5F, 24.0F, 0.0F));
        fang2.addChild("nose2", ModelPartBuilder.create().uv(33, 2).cuboid(-2.15F, -1.45F, -0.35F, 3.0F, 3.0F, 1.0F, Dilation.NONE), ModelTransform.of(-2.0F, -25.0F, -4.5F, 0.0631F, -0.3435F, -0.1855F));
        return meshdefinition;
    }


    @Override
    public void setAngles(T livingEntity, float f, float g, float h, float i, float j) {
        this.body.setTransform(this.bodyDefault);
        this.head.setTransform(this.headDefault);
        this.leftArm.setTransform(this.leftArmDefault);
        this.rightArm.setTransform(this.rightArmDefault);
        super.setAngles(livingEntity, f, g, h, i, j);
        //float f = ((float)Math.PI / 6F);
        float f1 = h * 0.1F + f * 0.5F;
        float f2 = 0.08F + g * 0.4F;
        this.leftEar.roll = (-(float) Math.PI / 6F) - MathHelper.cos(f1 * 1.2F) * f2;
        this.rightEar.roll = ((float) Math.PI / 6F) + MathHelper.cos(f1) * f2;
        if (livingEntity instanceof AbstractPiglinEntity abstractpiglin) {
            PiglinActivity piglinarmpose = abstractpiglin.getActivity();
            if (piglinarmpose == PiglinActivity.DANCING) {
                float f3 = h / 60.0F;
                this.rightEar.roll = ((float) Math.PI / 6F) + ((float) Math.PI / 180F) * MathHelper.sin(f3 * 30.0F) * 10.0F;
                this.leftEar.roll = (-(float) Math.PI / 6F) - ((float) Math.PI / 180F) * MathHelper.cos(f3 * 30.0F) * 10.0F;
                this.head.pivotX = MathHelper.sin(f3 * 10.0F);
                this.head.pivotY = MathHelper.sin(f3 * 40.0F) + 0.4F;
                this.rightArm.roll = ((float) Math.PI / 180F) * (70.0F + MathHelper.cos(f3 * 40.0F) * 10.0F);
                this.leftArm.roll = this.rightArm.roll * -1.0F;
                this.rightArm.pivotY = MathHelper.sin(f3 * 40.0F) * 0.5F + 1.5F;
                this.leftArm.pivotY = MathHelper.sin(f3 * 40.0F) * 0.5F + 1.5F;
                this.body.pivotY = MathHelper.sin(f3 * 40.0F) * 0.35F;
            } else if (piglinarmpose == PiglinActivity.ATTACKING_WITH_MELEE_WEAPON && this.handSwingProgress == 0.0F) {
                this.holdWeaponHigh(livingEntity);
            } else if (piglinarmpose == PiglinActivity.CROSSBOW_HOLD) {
                CrossbowPosing.hold(this.rightArm, this.leftArm, this.head, !livingEntity.isLeftHanded());
            } else if (piglinarmpose == PiglinActivity.CROSSBOW_CHARGE) {
                CrossbowPosing.charge(this.rightArm, this.leftArm, livingEntity, !livingEntity.isLeftHanded());
            } else if (piglinarmpose == PiglinActivity.ADMIRING_ITEM) {
                this.head.pitch = 0.5F;
                this.head.yaw = 0.0F;
                if (livingEntity.isLeftHanded()) {
                    this.rightArm.yaw = -0.5F;
                    this.rightArm.pitch = -0.9F;
                } else {
                    this.leftArm.yaw = 0.5F;
                    this.leftArm.pitch = -0.9F;
                }
            }
        } else if (livingEntity.getType() == EntityType.ZOMBIFIED_PIGLIN) {
            CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, livingEntity.isAttacking(), this.handSwingProgress, h);
        }

        this.leftPants.copyTransform(this.leftLeg);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightSleeve.copyTransform(this.rightArm);
        this.jacket.copyTransform(this.body);
        this.hat.copyTransform(this.head);
    }

    private void holdWeaponHigh(T livingEntity) {
        if (livingEntity.isLeftHanded()) {
            this.leftArm.pitch = -1.8F;
        } else {
            this.rightArm.pitch = -1.8F;
        }
    }

    @Override
    protected void animateArms(T entity, float animationProgress) {
        if (this.handSwingProgress > 0.0F && entity instanceof PiglinEntity && ((PiglinEntity) entity).getActivity() == PiglinActivity.ATTACKING_WITH_MELEE_WEAPON) {
            CrossbowPosing.meleeAttack(this.rightArm, this.leftArm, entity, this.handSwingProgress, animationProgress);
        } else {
            super.animateArms(entity, animationProgress);
        }
    }

    /*@Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(createBodyLayer().createModel()).forEach((modelRenderer) ->
                modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha));
    }*/
}
