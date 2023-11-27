package com.st0x0ef.beyond_earth.common.entity.custom.vehicles;

import net.minecraft.block.Blocks;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class IVehicleEntity extends Entity {
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private int field_7708;

    private float speed;
    private boolean discardFriction = false;
    public float xxa;
    public float yya;
    public float zza;


    public IVehicleEntity(EntityType<?> type, World world) {
        super(type, world);
        this.intersectionChecked = true;
    }

    @Override
    public void initDataTracker() {

    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
    }

    /**
     * Enable Interact with the Entity
     */
    @Override
    public boolean canHit() {
        return true;
    }

    /**
     * Interact with the Entity Gui,Spawn Egg...
     */
    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        return ActionResult.PASS;
    }

    @Override
    public void tick() {
        super.tick();

        /** ROT Anim */
        this.updatePositionAndRotation();
        this.rotAnim();

        /** Movement Physic */
        Vec3d vec3 = this.getVelocity();
        double d1 = vec3.x;
        double d3 = vec3.y;
        double d5 = vec3.z;
        if (Math.abs(vec3.x) < 0.003D) {
            d1 = 0.0D;
        }

        if (Math.abs(vec3.y) < 0.003D) {
            d3 = 0.0D;
        }

        if (Math.abs(vec3.z) < 0.003D) {
            d5 = 0.0D;
        }

        this.setVelocity(d1, d3, d5);
        this.velocityDirty = true;

        this.xxa *= 0.98F;
        this.zza *= 0.98F;
        this.travel(new Vec3d(this.xxa, this.yya, this.zza));
    }

    public void rotAnim() {
        while (this.getYaw() - this.prevYaw < -180.0F) {
            this.prevYaw -= 360.0F;
        }

        while (this.getYaw() - this.prevYaw >= 180.0F) {
            this.prevYaw += 360.0F;
        }
    }

    private void updatePositionAndRotation() {
        if (this.isLogicalSideForUpdatingMovement()) {
            this.field_7708 = 0;
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
        }

        if (this.field_7708 > 0) {
            double d = this.getX() + (this.lerpX - this.getX()) / (double)this.field_7708;
            double e = this.getY() + (this.lerpY - this.getY()) / (double)this.field_7708;
            double f = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.field_7708;
            this.setPosition(d, e, f);
        }
    }

    @Override
    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        this.lerpX = x;
        this.lerpY = y;
        this.lerpZ = z;
        this.lerpYRot = yaw;
        this.lerpXRot = pitch;
        this.lerpSteps = interpolationSteps;
        this.field_7708 = 10;
    }

    @Override
    protected Box calculateBoundingBox() {
        return this.getDimensions(EntityPose.STANDING).getBoxAt(getSyncedPos());
    }

    /*private void tickLerp() {
        if (this.isLogicalSideForUpdatingMovement()) {
            this.lerpSteps = 0;
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
        }

        if (this.lerpSteps > 0) {
            double d0 = this.getX() + (this.lerpX - this.getX()) / (double)this.lerpSteps;
            double d2 = this.getY() + (this.lerpY - this.getY()) / (double)this.lerpSteps;
            double d4 = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.lerpSteps;
            double d6 = MathHelper.wrapDegrees(this.lerpYRot - (double)this.getYaw());
            this.setYaw(this.getYaw() + (float)d6 / (float)this.lerpSteps);
            this.setPitch(this.getPitch() + (float)(this.lerpXRot - (double)this.getPitch()) / (float)this.lerpSteps);
            --this.lerpSteps;
            this.setPos(d0, d2, d4);
            this.setRotation(this.getYaw(), this.getPitch());
        }
    }*/

    /**
     * Movement Physic
     */
    public void travel(Vec3d vec) {
        if (this.isLogicalSideForUpdatingMovement()) {
            double d0 = 0.08D;

            boolean flag = this.getVelocity().y <= 0.0D;

            if (this.isTouchingWater()) {
                double d8 = this.getY();
                float f5 = this.isSprinting() ? 0.9F : this.getWaterSlowDown();
                float f6 = 0.02F;

                this.updateVelocity(f6, vec);
                this.move(MovementType.SELF, this.getVelocity());
                Vec3d vec36 = this.getVelocity();
                if (this.horizontalCollision) {
                    vec36 = new Vec3d(vec36.x, 0.2D, vec36.z);
                }

                this.setVelocity(vec36.multiply(f5, 0.8F, f5));
                Vec3d vec32 = this.getFluidFallingAdjustedMovement(d0, flag, this.getVelocity());
                this.setVelocity(vec32);
                if (this.horizontalCollision && this.doesNotCollide(vec32.x, vec32.y + (double) 0.6F - this.getY() + d8, vec32.z)) {
                    this.setVelocity(vec32.x, 0.3F, vec32.z);
                }
            } else if (this.isInLava()) {
                double d7 = this.getY();
                this.updateVelocity(0.02F, vec);
                this.move(MovementType.SELF, this.getVelocity());
                if (this.getFluidHeight(FluidTags.LAVA) <= this.getSwimHeight()) {
                    this.setVelocity(this.getVelocity().multiply(0.5D, 0.8F, 0.5D));
                    Vec3d vec33 = this.getFluidFallingAdjustedMovement(d0, flag, this.getVelocity());
                    this.setVelocity(vec33);
                } else {
                    this.setVelocity(this.getVelocity().multiply(0.5D));
                }

                if (!this.hasNoGravity()) {
                    this.setVelocity(this.getVelocity().add(0.0D, -d0 / 4.0D, 0.0D));
                }

                Vec3d vec34 = this.getVelocity();
                if (this.horizontalCollision && this.doesNotCollide(vec34.x, vec34.y + (double) 0.6F - this.getY() + d7, vec34.z)) {
                    this.setVelocity(vec34.x, 0.3F, vec34.z);
                }
            } else {
                BlockPos blockpos = this.getVelocityAffectingPos();
                float f3 = this.world.getBlockState(this.getVelocityAffectingPos()).getBlock().getSlipperiness();
                float f4 = this.isOnGround() ? f3 * 0.91F : 0.91F;
                Vec3d vec35 = this.handleRelativeFrictionAndCalculateMovement(vec, f3);
                double d2 = vec35.y;
                if (this.world.isClient && !this.world.isPosLoaded(blockpos.getX(), blockpos.getZ())) {
                    if (this.getY() > (double) this.world.getBottomY()) {
                        d2 = -0.1D;
                    } else {
                        d2 = 0.0D;
                    }
                } else if (!this.hasNoGravity()) {
                    d2 -= d0;
                }

                if (this.shouldDiscardFriction()) {
                    this.setVelocity(vec35.x, d2, vec35.z);
                } else {
                    this.setVelocity(vec35.x * (double) f4, d2 * (double) 0.98F, vec35.z * (double) f4);
                }
            }

            this.setBoundingBox(this.calculateBoundingBox());
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
        }
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float p_21320_) {
        this.speed = p_21320_;
    }

    protected float getWaterSlowDown() {
        return 0.8F;
    }

    public Vec3d getFluidFallingAdjustedMovement(double p_20995_, boolean p_20996_, Vec3d p_20997_) {
        if (!this.hasNoGravity() && !this.isSprinting()) {
            double d0;
            if (p_20996_ && Math.abs(p_20997_.y - 0.005D) >= 0.003D && Math.abs(p_20997_.y - p_20995_ / 16.0D) < 0.003D) {
                d0 = -0.003D;
            } else {
                d0 = p_20997_.y - p_20995_ / 16.0D;
            }

            return new Vec3d(p_20997_.x, d0, p_20997_.z);
        } else {
            return p_20997_;
        }
    }

    public float getFrictionInfluencedSpeed(float p_21331_) {
        return this.getSpeed() * (0.21600002F / (p_21331_ * p_21331_ * p_21331_));
    }

    public Vec3d handleRelativeFrictionAndCalculateMovement(Vec3d p_21075_, float p_21076_) {
        this.updateVelocity(this.getFrictionInfluencedSpeed(p_21076_), p_21075_);
        this.move(MovementType.SELF, this.getVelocity());
        Vec3d vec3 = this.getVelocity();
        if ((this.horizontalCollision) && (this.getBlockStateAtPos().isOf(Blocks.POWDER_SNOW) && PowderSnowBlock.canWalkOnPowderSnow(this))) {
            vec3 = new Vec3d(vec3.x, 0.2D, vec3.z);
        }

        return vec3;
    }

    public boolean shouldDiscardFriction() {
        return this.discardFriction;
    }

    public void setDiscardFriction(boolean p_147245_) {
        this.discardFriction = p_147245_;
    }
}
