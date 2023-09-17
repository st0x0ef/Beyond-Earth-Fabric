package net.mrscauthd.beyond_earth.common.blocks.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GlobeTileEntity extends BlockEntity {
    private float rotationalInertia = 0.0f;
    private float yaw = 0.0f;
    private float yaw0 = 0.0f;

    public GlobeTileEntity( BlockPos pos, BlockState state) {
        super(ModBlockEntities.GLOBE_TILE_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.rotationalInertia = nbt.getFloat("inertia");
        this.yaw = nbt.getFloat("yaw");
        this.yaw0 = nbt.getFloat("yaw0");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putFloat("inertia", this.rotationalInertia);
        nbt.putFloat("yaw", this.yaw);
        nbt.putFloat("yaw0", this.yaw0);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Override
    public void markDirty() {
        super.markDirty();

        World level = this.getWorld();

        if (level instanceof ServerWorld serverLevel) {

            for (ServerPlayerEntity p : serverLevel.getServer().getPlayerManager().getPlayerList()) {
                p.networkHandler.sendPacket(this.toUpdatePacket());
            }
        }
    }

    public void tick() {
        if (this.getRotationalInertia() > 0) {
            this.setRotationalInertia(this.getRotationalInertia() - 0.0075f);

            if (this.getRotationalInertia() < 0) {
                this.setRotationalInertia(0);
            }

            this.setYaw0(this.getYaw());
            this.setYaw(this.getYaw() - this.getRotationalInertia());

            if (this.getRotationalInertia() == 0) {
                if (!this.getWorld().isClient()) {
                    this.markDirty();
                }
            }
        }
    }



    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public float getRotationalInertia() {
        return this.rotationalInertia;
    }

    public void setRotationalInertia(float value) {
        this.rotationalInertia = value;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float value) {
        this.yaw = value;
    }

    public float getYaw0() {
        return this.yaw0;
    }

    public void setYaw0(float value) {
        this.yaw0 = value;
    }
}
