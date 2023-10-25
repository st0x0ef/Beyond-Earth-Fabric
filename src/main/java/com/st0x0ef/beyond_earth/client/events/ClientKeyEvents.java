package com.st0x0ef.beyond_earth.client.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ClientKeyEvents {
    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.options.forwardKey.wasPressed()) {
                //ClientPlayNetworking.send();
            }
        });
    }

    /*public static void sendKeyToServerAndClientHashMap(MinecraftClient client, PlayerEntity player, JTextComponent.KeyBinding key, Map<UUID, Boolean> variableKey, String keyString, boolean isPressed) {
        if (player == null) {
            return;
        }

        if ((key.key.getKeyChar() == event.getKey() && event.getAction() == GLFW.GLFW_RELEASE && isPressed) || (!key.isConflictContextAndModifierActive() && isPressed)) {
            variableKey.put(player.getUUID(), false);
            RunArgs.Network..PACKET_HANDLER.sendToServer(new KeyHandler(keyString, false));
        }

        if (key.getKey().getValue() == event.getKey() && event.getAction() == GLFW.GLFW_PRESS && key.isConflictContextAndModifierActive() && !isPressed) {
            variableKey.put(player.getUUID(), true);
            NetworkRegistry.PACKET_HANDLER.sendToServer(new KeyHandler(keyString, true));
        }
    }*/
}
