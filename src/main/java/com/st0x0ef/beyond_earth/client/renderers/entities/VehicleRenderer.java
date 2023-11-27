package com.st0x0ef.beyond_earth.client.renderers.entities;

import com.google.common.collect.Lists;
import com.st0x0ef.beyond_earth.common.entity.custom.vehicles.IVehicleEntity;
import com.st0x0ef.beyond_earth.common.entity.custom.vehicles.RoverEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

import java.util.List;

@Environment(EnvType.CLIENT)
public abstract class VehicleRenderer <T extends IVehicleEntity, M extends EntityModel<T>> extends EntityRenderer<T> implements FeatureRendererContext<T, M> {
    protected M model;
    protected final List<FeatureRenderer<T, M>> layers = Lists.newArrayList();

    public final boolean addLayer(FeatureRenderer<T, M> p_115327_) {
        return this.layers.add(p_115327_);
    }

    protected VehicleRenderer(EntityRendererFactory.Context ctx, M p_174290_, float p_174291_) {
        super(ctx);
        this.model = p_174290_;
        this.shadowRadius = p_174291_;
    }

    @Override
    public M getModel() {
        return this.model;
    }

    @Override
    public void render(T entity, float p_115309_, float p_115310_, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int p_115313_) {
        matrices.push();

        boolean shouldSit = entity.hasVehicle() && (entity.getVehicle() != null && entity.getVehicle().hasPlayerRider());
        this.model.riding = shouldSit;
        float f = MathHelper.lerpAngleDegrees(p_115310_, entity.prevYaw, entity.getYaw());
        float f1 = MathHelper.lerpAngleDegrees(p_115310_, entity.prevYaw, entity.getYaw());
        float f2 = f1 - f;


        if (shouldSit && entity.getVehicle() instanceof LivingEntity livingentity) {
            f = MathHelper.lerpAngleDegrees(p_115310_, livingentity.prevBodyYaw, livingentity.getBodyYaw());
            f2 = f1 - f;
            float f3 = MathHelper.wrapDegrees(f2);
            if (f3 < -85.0F) {
                f3 = -85.0F;
            }

            if (f3 >= 85.0F) {
                f3 = 85.0F;
            }

            f = f1 - f3;
            if (f3 * f3 > 2500.0F) {
                f += f3 * 0.2F;
            }

            f2 = f1 - f;
        }

        float f6 = MathHelper.lerp(p_115310_, entity.prevYaw, entity.getPitch());

        float f7 = this.getBob(entity, p_115310_);
        this.setupRotations(entity, matrices, f7, (float) f1, p_115310_);
        matrices.scale(-1.0F, -1.0F, 1.0F);
        this.scale(entity, matrices, p_115310_);
        matrices.translate(0.0D, -1.501F, 0.0D);
        float f8 = 0.0F;
        float f5 = 0.0F;
        if (entity instanceof RoverEntity) {
            f8 = MathHelper.lerp(p_115310_, ((RoverEntity) entity).animationSpeedOld, ((RoverEntity) entity).animationSpeed);
            f5 = ((RoverEntity) entity).animationPosition - ((RoverEntity) entity).animationSpeed * (1.0F - p_115310_);

            if (f8 > 1.0F) {
                f8 = 1.0F;
            }
        }

        this.model.animateModel(entity, f5, f8, p_115310_);
        this.model.setAngles(entity, f5, f8, f7, f2, f6);
        MinecraftClient minecraft = MinecraftClient.getInstance();
        boolean flag = this.isBodyVisible(entity);
        boolean flag1 = !flag && !entity.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.hasOutline(entity);
        RenderLayer rendertype = this.getRenderType(entity, flag, flag1, flag2);
        if (rendertype != null) {
            VertexConsumer vertexconsumer = vertexConsumers.getBuffer(rendertype);
            int i = getOverlayCoords(entity, this.getWhiteOverlayProgress(entity, p_115310_));
            this.model.render(matrices, vertexconsumer, p_115313_, i, 1.0F, 1.0F, 1.0F, flag1 ? 0.15F : 1.0F);
        }

        if (!entity.isSpectator()) {
            for(FeatureRenderer<T, M> renderlayer : this.layers) {
                renderlayer.render(matrices, vertexConsumers, p_115313_, entity, f5, f8, p_115310_, f7, f2, f6);
            }
        }

        matrices.pop();
        super.render(entity, p_115309_, p_115310_, matrices, vertexConsumers, p_115313_);
    }


    public RenderLayer getRenderType(T entity, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
        Identifier resourcelocation = getTexture(entity);
        if (p_115324_) {
            return RenderLayer.getItemEntityTranslucentCull(resourcelocation);
        } else if (p_115323_) {
            return this.model.getLayer(resourcelocation);
        } else {
            return p_115325_ ? RenderLayer.getOutline(resourcelocation) : null;
        }
    }


    protected boolean isBodyVisible(T p_115341_) {
        return !p_115341_.isInvisible();
    }

    protected boolean isShaking(T p_115304_) {
        return false;
    }

    public static int getOverlayCoords(Entity p_115339_, float p_115340_) {
        return OverlayTexture.packUv(OverlayTexture.getU(p_115340_), OverlayTexture.getV(false));
    }

    protected float getWhiteOverlayProgress(T p_115334_, float p_115335_) {
        return 0.0F;
    }

    protected void setupRotations(T entity, MatrixStack matrixStack, float f, float f1, float f2) {
        if (this.isShaking(entity)) {
            if (!MinecraftClient.getInstance().isPaused()) {
                double shakeDirection1 = (f2 * (entity.world.random.nextBoolean() ? 1 : -1)) / 50;
                double shakeDirection2 = (f2 * (entity.world.random.nextBoolean() ? 1 : -1)) / 50;
                double shakeDirection3 = (f2 * (entity.world.random.nextBoolean() ? 1 : -1)) / 50;
                matrixStack.translate(shakeDirection1, shakeDirection2, shakeDirection3);
            }
        }

        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180 - f1));
    }

    protected float getBob(T p_115305_, float p_115306_) {
        return (float)p_115305_.age + p_115306_;
    }

    protected void scale(T p_115314_, MatrixStack p_115315_, float p_115316_) {
    }
}
