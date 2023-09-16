package net.mrscauthd.beyond_earth;

import net.fabricmc.api.ModInitializer;

import net.mrscauthd.beyond_earth.common.blocks.ModBlocks;
import net.mrscauthd.beyond_earth.common.fluids.ModFluids;
import net.mrscauthd.beyond_earth.common.items.ModItemGroups;
import net.mrscauthd.beyond_earth.common.items.ModItems;
import net.mrscauthd.beyond_earth.common.sounds.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeyondEarth implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("beyond_earth");
	public static final String MOD_ID = "beyond_earth";

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerModSounds();
	}
}
