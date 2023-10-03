package com.st0x0ef.beyond_earth.common.blocks.entities.custom;

import com.mojang.authlib.GameProfile;
import com.st0x0ef.beyond_earth.common.blocks.entities.ModBlockEntities;
import io.netty.util.internal.StringUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class FlagBlockEntity extends BlockEntity {
    @Nullable
    private GameProfile owner;

    public FlagBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FLAG_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.owner != null) {
            NbtCompound compoundtag = new NbtCompound();
            NbtHelper.writeGameProfile(compoundtag, this.owner);
            compoundtag.put("FlagOwner", compoundtag);
        }
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        if (tag.contains("FlagOwner", 10)) {
            this.setOwner(NbtHelper.toGameProfile(tag.getCompound("FlagOwner")));
        } else if (tag.contains("ExtraType", 8)) {
            String s = tag.getString("ExtraType");
            if (!StringUtil.isNullOrEmpty(s)) {
                this.setOwner(new GameProfile(null, s));
            }
        }
    }

    @Nullable
    @Environment(EnvType.CLIENT)
    public GameProfile getPlayerProfile() {
        return this.owner;
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbtWithIdentifyingData();
    }

    public void setOwner(@Nullable GameProfile p_59770_) {
        synchronized(this) {
            this.owner = p_59770_;
        }

        this.updateOwnerProfile();
    }

    private void updateOwnerProfile() {
        SkullBlockEntity.loadProperties(this.owner, (p_155747_) -> {
            this.owner = p_155747_;
            this.markDirty();
        });
    }
}
