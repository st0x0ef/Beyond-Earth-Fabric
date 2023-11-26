package com.st0x0ef.beyond_earth.client.renderers.entities;

import com.google.common.collect.Lists;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.nonLivingEntities.IVehicleEntity;
import com.st0x0ef.beyond_earth.common.entity.custom.nonLivingEntities.RoverEntity;
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
    public void render(T entity, float p_115309_, float p_115310_, MatrixStack p_115311_, VertexConsumerProvider p_115312_, int p_115313_) {
        p_115311_.push();

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
        this.setupRotations(entity, p_115311_, f7, f, p_115310_);
        p_115311_.scale(-1.0F, -1.0F, 1.0F);
        this.scale(entity, p_115311_, p_115310_);
        p_115311_.translate(0.0D, -1.501F, 0.0D);
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
            VertexConsumer vertexconsumer = p_115312_.getBuffer(rendertype);
            int i = getOverlayCoords(entity, this.getWhiteOverlayProgress(entity, p_115310_));
            this.model.render(p_115311_, vertexconsumer, p_115313_, i, 1.0F, 1.0F, 1.0F, flag1 ? 0.15F : 1.0F);
        }

        if (!entity.isSpectator()) {
            for(FeatureRenderer<T, M> renderlayer : this.layers) {
                renderlayer.render(p_115311_, p_115312_, p_115313_, entity, f5, f8, p_115310_, f7, f2, f6);
            }
        }

        p_115311_.pop();
        super.render(entity, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
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

    protected void setupRotations(T p_115317_, MatrixStack p_115318_, float p_115319_, float p_115320_, float p_115321_) {
        if (this.isShaking(p_115317_)) {
            if (!MinecraftClient.getInstance().isPaused()) {
                double shakeDirection1 = (p_115321_ * (p_115317_.world.random.nextBoolean() ? 1 : -1)) / 50;
                double shakeDirection2 = (p_115321_ * (p_115317_.world.random.nextBoolean() ? 1 : -1)) / 50;
                double shakeDirection3 = (p_115321_ * (p_115317_.world.random.nextBoolean() ? 1 : -1)) / 50;
                p_115318_.translate(shakeDirection1, shakeDirection2, shakeDirection3);
            }
        }
        p_115318_.multiply(RotationAxis.POSITIVE_Y.rotation(180.0F - p_115320_));
    }

    protected float getBob(T p_115305_, float p_115306_) {
        return (float)p_115305_.age + p_115306_;
    }

    protected void scale(T p_115314_, MatrixStack p_115315_, float p_115316_) {
    }
}
