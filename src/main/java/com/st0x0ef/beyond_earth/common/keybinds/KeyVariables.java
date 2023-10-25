package com.st0x0ef.beyond_earth.common.keybinds;

import net.minecraft.entity.player.PlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KeyVariables {
    public static final Map<UUID, Boolean> KEY_UP = new HashMap<>();
    public static final Map<UUID, Boolean> KEY_DOWN = new HashMap<>();
    public static final Map<UUID, Boolean> KEY_RIGHT = new HashMap<>();
    public static final Map<UUID, Boolean> KEY_LEFT = new HashMap<>();
    public static final Map<UUID, Boolean> KEY_JUMP = new HashMap<>();

    public static boolean isHoldingUp(PlayerEntity player) {
        return player != null && KEY_UP.getOrDefault(player.getUuid(), false);
    }

    public static boolean isHoldingDown(PlayerEntity player) {
        return player != null && KEY_DOWN.getOrDefault(player.getUuid(), false);
    }

    public static boolean isHoldingRight(PlayerEntity player) {
        return player != null && KEY_RIGHT.getOrDefault(player.getUuid(), false);
    }

    public static boolean isHoldingLeft(PlayerEntity player) {
        return player != null && KEY_LEFT.getOrDefault(player.getUuid(), false);
    }

    public static boolean isHoldingJump(PlayerEntity player) {
        return player != null && KEY_JUMP.getOrDefault(player.getUuid(), false);
    }
}
