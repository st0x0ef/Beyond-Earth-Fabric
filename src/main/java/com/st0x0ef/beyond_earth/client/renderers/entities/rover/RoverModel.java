package com.st0x0ef.beyond_earth.client.renderers.entities.rover;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.vehicles.RoverEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.SmoothUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class RoverModel <T extends RoverEntity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(BeyondEarth.MOD_ID, "rover"), "main");

    private final ModelPart rover;

    public RoverModel(ModelPart root) {
        this.rover = root.getChild("rover");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData rover = partdefinition.addChild("rover", ModelPartBuilder.create().uv(0, 0).cuboid(-15.0F, -10.0F, -16.0F, 30.0F, 3.0F, 43.0F, new Dilation(0.0F))
                .uv(88, 64).cuboid(-18.0F, -9.6F, -17.0F, 36.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(88, 64).cuboid(-18.0F, -9.6F, 25.0F, 36.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 46).cuboid(-11.0F, -13.0F, -29.0F, 22.0F, 3.0F, 22.0F, new Dilation(0.0F))
                .uv(66, 53).cuboid(6.0F, -24.0F, -3.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(7.0F, -22.0F, -17.0F, 8.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(139, 28).cuboid(6.0F, -20.0F, -10.0F, 10.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(139, 28).cuboid(-16.0F, -20.0F, -10.0F, 10.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-15.0F, -22.0F, -17.0F, 8.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(103, 0).cuboid(-9.0F, -35.0F, -23.0F, 2.0F, 22.0F, 2.0F, new Dilation(0.0F))
                .uv(103, 24).cuboid(-14.0F, -14.0F, 4.0F, 12.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(32, 24).cuboid(-9.0F, -23.0F, 17.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 71).cuboid(-15.0F, -33.0F, 21.0F, 30.0F, 23.0F, 2.0F, new Dilation(0.0F))
                .uv(66, 46).cuboid(-15.0F, -12.0F, 23.0F, 30.0F, 2.0F, 16.0F, new Dilation(0.0F))
                .uv(64, 71).cuboid(-9.0F, -22.0F, 24.0F, 18.0F, 10.0F, 14.0F, new Dilation(0.0F))
                .uv(0, 96).cuboid(-9.0F, -24.0F, 24.0F, 18.0F, 2.0F, 14.0F, new Dilation(0.0F))
                .uv(32, 24).cuboid(7.0F, -23.0F, 17.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
                .uv(103, 24).cuboid(2.0F, -14.0F, 4.0F, 12.0F, 2.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 24.0F, -4.0F));

        ModelPartData cube_r1 = rover.addChild("cube_r1", ModelPartBuilder.create().uv(50, 101).cuboid(2.5F, -1.0F, -10.0F, 12.0F, 2.0F, 14.0F, new Dilation(0.0F))
                .uv(50, 101).cuboid(-13.5F, -1.0F, -10.0F, 12.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -23.0F, 18.0F, 1.2217F, 0.0F, 0.0F));

        ModelPartData cube_r2 = rover.addChild("cube_r2", ModelPartBuilder.create().uv(0, 55).cuboid(-5.0F, -5.0F, -0.5F, 10.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -21.0F, 1.5F, 0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r3 = rover.addChild("cube_r3", ModelPartBuilder.create().uv(64, 71).cuboid(-1.0F, -3.5F, -3.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.5F, 0.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData wheels = rover.addChild("wheels", ModelPartBuilder.create(), ModelTransform.pivot(-16.0F, 0.0F, 21.0F));

        ModelPartData wheel = wheels.addChild("wheel", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -8.0F, 5.5F));

        ModelPartData bone18 = wheel.addChild("bone18", ModelPartBuilder.create().uv(126, 0).cuboid(-1.5F, -11.9355F, -1.3787F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(-1.5F, 17.763F, -31.0772F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(33.5F, 17.763F, -31.0772F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(33.5F, -11.9355F, -1.3787F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -4.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bone19 = wheel.addChild("bone19", ModelPartBuilder.create().uv(126, 0).cuboid(-1.5F, 6.2787F, -7.0355F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(-1.5F, 35.9772F, 22.663F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(33.5F, 35.9772F, 22.663F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(33.5F, 6.2787F, -7.0355F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -4.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData bone20 = wheel.addChild("bone20", ModelPartBuilder.create(), ModelTransform.of(-0.5F, 0.0F, -4.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData bone21 = wheel.addChild("bone21", ModelPartBuilder.create().uv(126, 0).cuboid(-1.5F, -9.9F, 0.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(-1.5F, -9.9F, -41.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(33.5F, -9.9F, -41.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(126, 0).cuboid(33.5F, -9.9F, 0.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.5F, -4.0F));

        ModelPartData wheel1 = wheels.addChild("wheel1", ModelPartBuilder.create(), ModelTransform.pivot(34.0F, -8.0F, -36.5F));

        ModelPartData bone10 = wheel1.addChild("bone10", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 4.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bone9 = wheel1.addChild("bone9", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 4.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData bone8 = wheel1.addChild("bone8", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 4.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData bone7 = wheel1.addChild("bone7", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.9F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 3.9F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(1.5F, -5.1F, -4.5F, 0.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, 0.5F, 0.0F));

        ModelPartData wheel2 = wheels.addChild("wheel2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -8.0F, -36.5F));

        ModelPartData bone2 = wheel2.addChild("bone2", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 4.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bone3 = wheel2.addChild("bone3", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 4.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData bone4 = wheel2.addChild("bone4", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 4.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData bone5 = wheel2.addChild("bone5", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.9F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 3.9F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(1.5F, -5.1F, -4.5F, 0.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.5F, 0.0F));

        ModelPartData wheel3 = wheels.addChild("wheel3", ModelPartBuilder.create(), ModelTransform.pivot(34.0F, -8.0F, 5.5F));

        ModelPartData bone6 = wheel3.addChild("bone6", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -11.2284F, -0.6716F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 1.5716F, -0.6716F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 0.0F, -4.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bone11 = wheel3.addChild("bone11", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -11.2284F, -6.3284F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 1.5716F, -6.3284F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 0.0F, -4.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData bone12 = wheel3.addChild("bone12", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -12.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 0.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 0.0F, -4.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData bone13 = wheel3.addChild("bone13", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.9F, 0.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 3.9F, 0.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(1.5F, -5.1F, -0.5F, 0.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, 0.5F, -4.0F));

        ModelPartData wheel4 = wheels.addChild("wheel4", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -8.0F, 5.5F));

        ModelPartData bone14 = wheel4.addChild("bone14", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -11.2284F, -0.6716F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 1.5716F, -0.6716F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -4.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bone15 = wheel4.addChild("bone15", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -11.2284F, -6.3284F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 1.5716F, -6.3284F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -4.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData bone16 = wheel4.addChild("bone16", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -12.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 0.4F, -3.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -4.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData bone17 = wheel4.addChild("bone17", ModelPartBuilder.create().uv(111, 0).cuboid(-0.5F, -8.9F, 0.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(111, 0).cuboid(-0.5F, 3.9F, 0.5F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(1.5F, -5.1F, -0.5F, 0.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.5F, -4.0F));

        ModelPartData antenna = rover.addChild("antenna", ModelPartBuilder.create().uv(28, 0).cuboid(10.9319F, -0.6943F, 0.7497F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(4.9319F, -1.1943F, 0.2497F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 40).cuboid(-6.0681F, 0.8057F, 1.7497F, 17.0F, 0.0F, 1.0F, new Dilation(0.0F))
                .uv(66, 46).cuboid(0.9319F, -0.1943F, 0.2497F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 8).cuboid(4.9319F, -7.1943F, -5.7503F, 0.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -35.275F, -22.0F, 0.0F, 0.6545F, -0.3927F));

        ModelPartData cube_r4 = antenna.addChild("cube_r4", ModelPartBuilder.create().uv(0, 40).cuboid(-8.5F, 0.0F, -0.5F, 17.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.4319F, 0.8057F, 2.2497F, -1.6144F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 256, 256);
    }
    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        //BeyondEarth.LOGGER.info("entityYaw:" + entity.getYaw() + ", entityprevYaw:" + entity.prevYaw + ", roverYaw:" + rover.yaw/*", limbAngle: " + limbAngle + ", limbDistance: " + limbDistance + ", animationProgress: " + animationProgress + ", headYaw: " + headYaw + ", headPitch: " + headPitch*/);
        //this.rover.yaw = (float) Math.toRadians(headYaw);

        this.rover.getChild("wheels").getChild("wheel1").pitch = limbDistance / (180F / (float) Math.PI);
        this.rover.getChild("wheels").getChild("wheel2").pitch = limbDistance / (180F / (float) Math.PI);
        this.rover.getChild("wheels").getChild("wheel3").pitch = limbDistance / (180F / (float) Math.PI);
        this.rover.getChild("wheels").getChild("wheel4").pitch = limbDistance / (180F / (float) Math.PI);

        if (entity.getforward()) {
            this.rover.getChild("wheels").getChild("wheel1").pitch = limbAngle / 4;
            this.rover.getChild("wheels").getChild("wheel2").pitch = limbAngle / 4;
            this.rover.getChild("wheels").getChild("wheel3").pitch = limbAngle / 4;
            this.rover.getChild("wheels").getChild("wheel4").pitch = limbAngle / 4;
        }

        if (!entity.getforward()) {
            this.rover.getChild("wheels").getChild("wheel1").pitch = limbAngle / 4;
            this.rover.getChild("wheels").getChild("wheel2").pitch = limbAngle / 4;
            this.rover.getChild("wheels").getChild("wheel3").pitch = limbAngle / 4;
            this.rover.getChild("wheels").getChild("wheel4").pitch = limbAngle / 4;
        }

        this.rover.getChild("antenna").yaw = animationProgress / 20f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.rover.render(matrices, vertices, light, overlay);
    }
}
