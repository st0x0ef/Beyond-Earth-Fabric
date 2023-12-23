package com.st0x0ef.beyond_earth.client.keyBinds;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinds {
    private static final String KEY_CATEGORY = "key.categories." + BeyondEarth.MOD_ID;
    private static final String JET_SUIT_SWITCH_MODE = "key." + BeyondEarth.MOD_ID + ".switch_jet_suit_mode";
    private static final String ROCKET_START = "key." + BeyondEarth.MOD_ID + ".rocket_start";

    public static KeyBinding JET_SUIT_SWITCH_MODE_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(JET_SUIT_SWITCH_MODE, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_V, KEY_CATEGORY));
    public static KeyBinding ROCKET_START_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(ROCKET_START, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_SPACE, KEY_CATEGORY));

    public static void registerKeyBinds() {
        BeyondEarth.LOGGER.info("Registering key binds for " + BeyondEarth.MOD_ID);
    }
}
