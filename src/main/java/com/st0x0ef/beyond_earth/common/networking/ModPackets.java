package com.st0x0ef.beyond_earth.common.networking;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.keybinds.KeyHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.impl.networking.GlobalReceiverRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier KEY_PACKET = new Identifier(BeyondEarth.MOD_ID, "key_packet");

    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(KEY_PACKET, KeyHandler::handle);
    }

    public static void registerS2CPackets(){

    }
}
