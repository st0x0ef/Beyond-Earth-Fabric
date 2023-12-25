package com.st0x0ef.beyond_earth.common.keybinds;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class KeyHandler {
    public String key;
    public boolean condition;

    public KeyHandler(String key, boolean condition) {
        this.key = key;
        this.condition = condition;
    }

    public KeyHandler(PacketByteBuf buffer) {
        this.key = buffer.readString();
        this.condition = buffer.readBoolean();
    }

    public static KeyHandler decode(PacketByteBuf buffer) {
        return new KeyHandler(buffer);
    }

    public static PacketByteBuf encode(KeyHandler message, PacketByteBuf buffer) {
        buffer.writeString(message.key);
        buffer.writeBoolean(message.condition);
        return buffer;
    }


    public static void handle(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        KeyHandler message = decode(buf);

        switch (message.key) {
            case "key_up" -> KeyVariables.KEY_UP.put(player.getUuid(), message.condition);
            case "key_down" -> KeyVariables.KEY_DOWN.put(player.getUuid(), message.condition);
            case "key_right" -> KeyVariables.KEY_RIGHT.put(player.getUuid(), message.condition);
            case "key_left" -> KeyVariables.KEY_LEFT.put(player.getUuid(), message.condition);
            case "key_jump" -> KeyVariables.KEY_JUMP.put(player.getUuid(), message.condition);
            //case "rocket_start" -> KeyMethods.startRocket(player);
            case "switch_jet_suit_mode" -> KeyMethods.switchJetSuitMode(player);
        }
    }
}
