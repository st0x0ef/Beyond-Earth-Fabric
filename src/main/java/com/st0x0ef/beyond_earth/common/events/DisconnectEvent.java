package com.st0x0ef.beyond_earth.common.events;

import com.st0x0ef.beyond_earth.common.keybinds.KeyVariables;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

import java.util.UUID;

public class DisconnectEvent {
    public static void onDisconnect() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            UUID player = handler.player.getUuid();
            if (player != null) {
                KeyVariables.KEY_DOWN.remove(player);
                KeyVariables.KEY_UP.remove(player);
                KeyVariables.KEY_LEFT.remove(player);
                KeyVariables.KEY_RIGHT.remove(player);
                KeyVariables.KEY_JUMP.remove(player);
            }
        });
    }
}
