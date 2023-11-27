package com.st0x0ef.beyond_earth.client.events;

import com.st0x0ef.beyond_earth.common.keybinds.KeyHandler;
import com.st0x0ef.beyond_earth.common.keybinds.KeyVariables;
import com.st0x0ef.beyond_earth.common.networking.ModPackets;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;
import java.util.UUID;

public class ClientKeyEvents {
    public static void tick() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            PlayerEntity player = mc.player;

            if (mc.options.forwardKey.isPressed() || mc.options.forwardKey.wasPressed()) {
                /** UP */
                sendKeyToServerAndClientHashMap(mc.currentScreen, player, mc.options.forwardKey, KeyVariables.KEY_UP, "key_up", KeyVariables.isHoldingUp(player));
            }

            if (mc.options.backKey.isPressed() || mc.options.backKey.wasPressed()) {
                /** DOWN */
                sendKeyToServerAndClientHashMap(mc.currentScreen, player, mc.options.backKey, KeyVariables.KEY_DOWN, "key_down", KeyVariables.isHoldingDown(player));
            }

            if (mc.options.rightKey.isPressed() || mc.options.rightKey.wasPressed()) {
                /** RIGHT */
                sendKeyToServerAndClientHashMap(mc.currentScreen, player, mc.options.rightKey, KeyVariables.KEY_RIGHT, "key_right", KeyVariables.isHoldingRight(player));
            }

            if (mc.options.leftKey.isPressed() || mc.options.leftKey.wasPressed()) {
                /** LEFT */
                sendKeyToServerAndClientHashMap(mc.currentScreen, player, mc.options.leftKey, KeyVariables.KEY_LEFT, "key_left", KeyVariables.isHoldingLeft(player));
            }

            if (mc.options.jumpKey.isPressed() || mc.options.jumpKey.wasPressed()) {
                /** JUMP */
                sendKeyToServerAndClientHashMap(mc.currentScreen, player, mc.options.jumpKey, KeyVariables.KEY_JUMP, "key_jump", KeyVariables.isHoldingJump(player));
            }
            /** ROCKET START KEY */
            //sendKeyToServerMethod(screen, player, KeyMappingRegistry.ROCKET_START, "rocket_start");

            /** SWITCH JET SUIT MODE KEY */
            //sendKeyToServerMethod(screen, player, KeyMappingRegistry.SWITCH_JET_SUIT_MODE, "switch_jet_suit_mode");
        });
    }

    public static void onDisconnect() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            UUID player = client.player.getUuid();
            if (player != null) {
                KeyVariables.KEY_DOWN.remove(player);
                KeyVariables.KEY_UP.remove(player);
                KeyVariables.KEY_LEFT.remove(player);
                KeyVariables.KEY_RIGHT.remove(player);
                KeyVariables.KEY_JUMP.remove(player);
            }
        });
    }

    /**
     * Send to server and client side!
     * Save key press in KeyVariables
     */
    public static void sendKeyToServerAndClientHashMap(Screen screen, PlayerEntity player, KeyBinding key, Map<UUID, Boolean> variableKey, String keyString, boolean isPressed) {
        if (player == null) {
            return;
        }

        if (!isPressed && key.isPressed()) {
            variableKey.put(player.getUuid(), true);
            ClientPlayNetworking.send(ModPackets.KEY_PACKET, KeyHandler.encode(new KeyHandler(keyString, true), PacketByteBufs.create()));
        }else if (isPressed && !key.isPressed()){
            variableKey.put(player.getUuid(), false);
            ClientPlayNetworking.send(ModPackets.KEY_PACKET, KeyHandler.encode(new KeyHandler(keyString, false), PacketByteBufs.create()));
        }
    }

    /**
     *
     * Send to server side only!
     * Call a Method in KeyHandler.
     *
     * */
    /*public static void sendKeyToServerMethod(InputEvent.Key event, Player player, KeyMapping key, String keyString) {
        if (player == null || !key.isConflictContextAndModifierActive()) {
            return;
        }

        if (key.getKey().getValue() == event.getKey() && event.getAction() == GLFW.GLFW_PRESS) {
            NetworkRegistry.PACKET_HANDLER.sendToServer(new KeyHandler(keyString, true));
        }
    }*/
}
