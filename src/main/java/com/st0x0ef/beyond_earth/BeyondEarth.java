package com.st0x0ef.beyond_earth;

import com.st0x0ef.beyond_earth.client.events.ClientKeyEvents;
import com.st0x0ef.beyond_earth.common.blocks.ModBlocks;
import com.st0x0ef.beyond_earth.common.blocks.entities.ModBlockEntities;
import com.st0x0ef.beyond_earth.common.effect.ModStatusEffects;
import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.entity.custom.sensors.ModSensors;
import com.st0x0ef.beyond_earth.common.items.ModItemGroups;
import com.st0x0ef.beyond_earth.common.items.ModItems;
import com.st0x0ef.beyond_earth.common.networking.ModPackets;
import com.st0x0ef.beyond_earth.common.particles.ModParticles;
import com.st0x0ef.beyond_earth.common.sounds.ModSounds;
import com.st0x0ef.beyond_earth.common.util.ModDamageSources;
import com.st0x0ef.beyond_earth.common.util.ModRegisteries;
import net.fabricmc.api.ModInitializer;

import com.st0x0ef.beyond_earth.common.painting.ModPaintings;
import net.fabricmc.fabric.impl.client.screen.ScreenEventFactory;
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
		ModBlockEntities.registerAllBlockEntities();
		ModRegisteries.registerModStuff();
		ModStatusEffects.registerEffects();
		ModDamageSources.registerDamageSources();
		ModPaintings.registerPaintings();
		ModEntities.registerModEntities();
		ModSensors.registerModMobSensors();
		ModParticles.registerParticles();
		ModPackets.registerC2SPackets();
	}
}
