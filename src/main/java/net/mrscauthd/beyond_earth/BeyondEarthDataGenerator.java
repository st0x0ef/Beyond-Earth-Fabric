package net.mrscauthd.beyond_earth;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mrscauthd.beyond_earth.datagen.ModModelGenerator;
import net.mrscauthd.beyond_earth.datagen.ModTagsGenerator;

public class BeyondEarthDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(ModTagsGenerator.ModBlockTagsGenerator::new);
		pack.addProvider(ModTagsGenerator.ModItemTagsGenerator::new);
		pack.addProvider(ModTagsGenerator.ModFluidTagsGenerator::new);
	}
}
