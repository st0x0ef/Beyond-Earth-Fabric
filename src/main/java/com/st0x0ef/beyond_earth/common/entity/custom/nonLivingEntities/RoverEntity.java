package com.st0x0ef.beyond_earth.common.entity.custom.nonLivingEntities;

import com.google.common.collect.Sets;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.items.ModItems;
import com.st0x0ef.beyond_earth.common.keybinds.KeyVariables;
import com.st0x0ef.beyond_earth.common.util.ImplementedInventory;
import com.st0x0ef.beyond_earth.common.util.Methods;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class RoverEntity extends IVehicleEntity implements ImplementedInventory /* implements IGaugeValuesProvider */ {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    private double speed = 0;

    public float flyingSpeed = 0.02F;
    public float animationSpeedOld;
    public float animationSpeed;
    public float animationPosition;

    private final float FUEL_USE_TICK = 8;
    private float FUEL_TIMER = 0;

    public static final TrackedData<Integer> FUEL = DataTracker.registerData(RoverEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public static final TrackedData<Boolean> FORWARD = DataTracker.registerData(RoverEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public static final int DEFAULT_FUEL_BUCKETS = 3;

    public RoverEntity(EntityType<?> type, World world) {
        super(type, world);
        this.dataTracker.startTracking(FUEL, 2000);
        this.dataTracker.startTracking(FORWARD, false);
    }

    /*public int getFuelCapacity() {
        return Config.ROVER_FUEL_BUCKETS.get() * FluidUtil2.BUCKET_SIZE;
    }

    public IGaugeValue getFuelGauge() {
        int fuel = this.dataTracker.get(FUEL);
        int capacity = this.getFuelCapacity();
        return GaugeValueHelper.getFuel(fuel, capacity);*/

    /*@Override
    public List<IGaugeValue> getDisplayGaugeValues() {
        return Collections.singletonList(this.getFuelGauge());
    }*/

    @Override
    public boolean isPushable() {
        return false;
    }


    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void pushAwayFrom(Entity entity) {}

    @Deprecated
    public boolean canBeRiddenInWater() {
        return true;
    }


    @Override
    public double getMountedHeightOffset() {
        return super.getMountedHeightOffset() - 0.15;
    }

    @Override
    public void onPassengerLookAround(Entity passenger) {
        this.applyYawToEntity(passenger);
    }

    @Override
    public Vec3d updatePassengerForDismount(LivingEntity livingEntity) {
        Vec3d[] avector3d = new Vec3d[]{getPassengerDismountOffset(this.getWidth(), livingEntity.getWidth(), livingEntity.getYaw()), getPassengerDismountOffset(this.getWidth(), livingEntity.getWidth(), livingEntity.getYaw() - 22.5F), getPassengerDismountOffset(this.getWidth(), livingEntity.getWidth(), livingEntity.getYaw() + 22.5F), getPassengerDismountOffset(this.getWidth(), livingEntity.getWidth(), livingEntity.getYaw() - 45.0F), getPassengerDismountOffset(this.getWidth(), livingEntity.getWidth(), livingEntity.getYaw() + 45.0F)};
        Set<BlockPos> set = Sets.newLinkedHashSet();
        double d0 = this.getBoundingBox().maxY;
        double d1 = this.getBoundingBox().minY - 0.5D;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (Vec3d vector3d : avector3d) {
            blockpos$mutable.set(this.getX() + vector3d.x, d0, this.getZ() + vector3d.z);

            for (double d2 = d0; d2 > d1; --d2) {
                set.add(blockpos$mutable.toImmutable());
                blockpos$mutable.move(Direction.DOWN);
            }
        }

        for (BlockPos blockpos : set) {
            if (!this.world.getFluidState(blockpos).isIn(FluidTags.LAVA)) {
                double d3 = this.world.getDismountHeight(blockpos);
                if (Dismounting.canDismountInBlock(d3)) {
                    Vec3d vector3d1 = Vec3d.ofCenter(blockpos, d3);

                    for (EntityPose pose : livingEntity.getPoses()) {
                        Box axisalignedbb = livingEntity.getBoundingBox(pose);
                        if (Dismounting.canDismountInBlock(this.world.getDismountHeight(blockpos))) {
                            livingEntity.setPose(pose);
                            return vector3d1;
                        }
                    }
                }
            }
        }

        return new Vec3d(this.getX(), this.getBoundingBox().maxY, this.getZ());
    }

    protected void applyYawToEntity(Entity entityToUpdate) {
        entityToUpdate.setBodyYaw(this.getYaw());
        float f = MathHelper.wrapDegrees(entityToUpdate.getYaw() - this.getYaw());
        float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
        entityToUpdate.prevYaw += f1 - f;
        entityToUpdate.setYaw(entityToUpdate.getYaw() + f1 - f);
        entityToUpdate.setHeadYaw(entityToUpdate.getYaw());
    }

    @Override
    protected void removePassenger(Entity passenger) {
        if (passenger.isSneaking() && !passenger.world.isClient) {
            if (passenger instanceof ServerPlayerEntity) {
                this.setSpeed(0f);
            }
        }
        super.removePassenger(passenger);
    }

    @Nullable
    @Override
    public ItemStack getPickBlockStack() {
        ItemStack itemStack = new ItemStack(ModItems.ROVER_ITEM, 1);
        itemStack.getOrCreateNbt().putInt(BeyondEarth.MOD_ID + ":fuel", this.dataTracker.get(FUEL));

        return itemStack;
    }

    @Override
    public void kill() {
        this.spawnRoverItem();
        this.dropEquipment();

        if (!this.world.isClient) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source.getSource() != null && source.getSource().isSneaking() && !this.hasPassengers()) {
            this.spawnRoverItem();
            this.dropEquipment();

            if (!this.world.isClient) {
                this.remove(RemovalReason.DISCARDED);
            }
            return true;
        }

        return false;
    }

    protected void spawnRoverItem() {
        ItemStack itemStack = new ItemStack(ModItems.ROVER_ITEM, 1);
        itemStack.getOrCreateNbt().putInt(BeyondEarth.MOD_ID + ":fuel", this.dataTracker.get(FUEL));

        ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), itemStack);
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity(entityToSpawn);
    }

    protected void dropEquipment() {
        for (ItemStack itemstack : inventory) {
            if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
                this.dropStack(itemstack);
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);

        nbt.putInt("fuel", this.dataTracker.get(FUEL));
        nbt.putBoolean("forward", this.dataTracker.get(FORWARD));

    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);

        this.dataTracker.set(FUEL, nbt.getInt("fuel"));
        this.dataTracker.set(FORWARD, nbt.getBoolean("forward"));

    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public PlayerEntity getFirstPlayerPassenger() {
        if (!this.getPassengerList().isEmpty() && this.getPassengerList().get(0) instanceof PlayerEntity player) {
            return player;
        }

        return null;
    }

    public void rotateRover() {
        PlayerEntity player = this.getFirstPlayerPassenger();

        if (player != null && player.getVehicle() instanceof RoverEntity) {
            try {
                if ((KeyVariables.isHoldingRight(player) && KeyVariables.isHoldingLeft(player)) || player.getVehicle().getDataTracker().get(RoverEntity.FUEL) == 0 || player.getVehicle().isSubmergedIn(FluidTags.WATER)) {
                    return;
                }

                if (this.getforward()) {
                    if (KeyVariables.isHoldingRight(player)) {
                        Methods.setEntityRotation(this, 1);
                    }
                } else {
                    if (KeyVariables.isHoldingRight(player)) {
                        Methods.setEntityRotation(this, -1);
                    }
                }

                if (this.getforward()) {
                    if (KeyVariables.isHoldingLeft(player)) {
                        Methods.setEntityRotation(this, -1);
                    }
                } else {
                    if (KeyVariables.isHoldingLeft(player)) {
                        Methods.setEntityRotation(this, 1);
                    }
                }
            } catch (NullPointerException e) {
                throw new NullPointerException();
            }
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        super.interact(player, hand);

        ActionResult result = ActionResult.success(this.world.isClient);


        if (!this.world.isClient) {
            if (player.isSneaking()) {
                this.dataTracker.set(FUEL, 3000);
                player.sendMessage(Text.of("fuel" + this.dataTracker.get(FUEL).toString()));
                /*NetworkHooks.openScreen((ServerPlayerEntity) player, new MenuProvider() {
                    @Override
                    public Text getDisplayName() {
                        return RoverEntity.this.getDisplayName();
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeVarInt(RoverEntity.this.getId());
                        return new RoverMenu.GuiContainer(id, inventory, packetBuffer);
                    }
                }, buf -> {
                    buf.writeVarInt(this.getId());
                });*/

                return ActionResult.CONSUME;
            }

            player.startRiding(this);
            return ActionResult.CONSUME;
        }

        return result;
    }

    public boolean getforward() {
        return this.dataTracker.get(FORWARD);
    }

    @Override
    public void tick() {
        super.tick();
        this.onLanding();
        this.rotateRover();

        //Fuel Load up
        if (this.inventory.get(0).getItem() instanceof BucketItem) {
            /*if (((BucketItem) this.inventory.get(0).getItem()).getFluid().is(TagRegistry.FLUID_VEHICLE_FUEL_TAG)) {
                if (this.entityData.get(FUEL) + FluidUtil2.BUCKET_SIZE <= Config.ROVER_FUEL_BUCKETS.get() * FluidUtil2.BUCKET_SIZE) {
                    this.getEntityData().set(FUEL, (this.getEntityData().get(FUEL) + FluidUtil2.BUCKET_SIZE));
                    this.inventory.setStackInSlot(0, new ItemStack(Items.BUCKET));
                }
            }*/
        }

        if (this.getPassengerList().isEmpty()) {
            return;
        }

        if (!(this.getPassengerList().get(0) instanceof PlayerEntity passanger)) {
            return;
        }

        if (this.isSubmergedIn(FluidTags.WATER)) {
            return;
        }

        FUEL_TIMER++;

        passanger.onLanding();

        if (passanger.forwardSpeed > 0.01 && this.dataTracker.get(FUEL) != 0) {

            if (FUEL_TIMER > FUEL_USE_TICK) {
                this.dataTracker.set(FUEL, this.dataTracker.get(FUEL) - 1);
                FUEL_TIMER = 0;
            }
            this.dataTracker.set(FORWARD, true);
        } else if (passanger.forwardSpeed < -0.01 && this.dataTracker.get(FUEL) != 0) {

            if (FUEL_TIMER > FUEL_USE_TICK) {
                this.dataTracker.set(FUEL, this.dataTracker.get(FUEL) - 1);
                FUEL_TIMER = 0;
            }
            this.dataTracker.set(FORWARD, false);
        }
    }

    @Override
    public float getFrictionInfluencedSpeed(float p_21331_) {
        return this.isOnGround() ? this.getSpeed() * (0.21600002F / (p_21331_ * p_21331_ * p_21331_)) : this.flyingSpeed;
    }

    @Override
    public void travel(Vec3d vec) {
        this.calculateEntityAnimation(this, this instanceof Flutterer);

        if (!this.getPassengerList().isEmpty() && this.getPassengerList().get(0) instanceof PlayerEntity passanger) {

            this.flyingSpeed = this.getSpeed() * 0.15F;
            this.setStepHeight(1.0F);

            double pmovement = passanger.forwardSpeed;

            if (pmovement == 0 || this.dataTracker.get(FUEL) == 0 || this.isSubmergedIn(FluidTags.WATER)) {
                pmovement = 0;
                this.setSpeed(0f);

                if (speed != 0 && speed > 0.02) {
                    speed = speed - 0.02;
                }
            }

            if (this.dataTracker.get(FORWARD) && this.dataTracker.get(FUEL) != 0) {
                if (this.getSpeed() >= 0.01) {
                    if (speed <= 0.32) {
                        speed = speed + 0.02;
                    }
                }

                if (this.getSpeed() < 0.25) {
                    this.setSpeed(this.getSpeed() + 0.02F);
                }

            }

            if (!this.dataTracker.get(FORWARD)) {

                if (this.dataTracker.get(FUEL) != 0 && !this.isSubmergedIn(FluidTags.WATER)) {

                    if (this.getSpeed() <= 0.04) {
                        this.setSpeed(this.getSpeed() + 0.02f);
                    }
                }

                if (this.getSpeed() >= 0.08) {
                    this.setSpeed(0f);
                }
            }

            if (this.dataTracker.get(FORWARD)) {
                this.setWellRotationPlus(4.0f, 0.4f);
            } else {
                this.setWellRotationMinus(8.0f, 0.8f);
            }

            super.travel(new Vec3d(0, 0, pmovement));
            return;
        }

        super.travel(new Vec3d(0, 0, 0));
    }

    public void setWellRotationMinus(float rotation1, float rotation2) {
        this.animationSpeedOld = this.animationSpeed;
        double d1 = this.getX() - this.prevX;
        double d0 = this.getZ() - this.prevZ;
        float f1 = -MathHelper.sqrt((float) (d1 * d1 + d0 * d0)) * rotation1;
        if (f1 > 1.0F)
            f1 = 1.0F;
        this.animationSpeed += (f1 - this.animationSpeed) * rotation2;
        this.animationPosition += this.animationSpeed;
    }

    public void setWellRotationPlus(float rotation1, float rotation2) {
        this.animationSpeedOld = this.animationSpeed;
        double d1 = this.getX() - this.prevX;
        double d0 = this.getZ() - this.prevZ;
        float f1 = MathHelper.sqrt((float) (d1 * d1 + d0 * d0)) * rotation1;
        if (f1 > 1.0F)
            f1 = 1.0F;
        this.animationSpeed += (f1 - this.animationSpeed) * rotation2;
        this.animationPosition += this.animationSpeed;
    }

    public void calculateEntityAnimation(RoverEntity p_21044_, boolean p_21045_) {
        p_21044_.animationSpeedOld = p_21044_.animationSpeed;
        double d0 = p_21044_.getX() - p_21044_.prevX;
        double d1 = p_21045_ ? p_21044_.getY() - p_21044_.prevY : 0.0D;
        double d2 = p_21044_.getZ() - p_21044_.prevZ;
        float f = (float) Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2) * 4.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        p_21044_.animationSpeed += (f - p_21044_.animationSpeed) * 0.4F;
        p_21044_.animationPosition += p_21044_.animationSpeed;
    }

}
