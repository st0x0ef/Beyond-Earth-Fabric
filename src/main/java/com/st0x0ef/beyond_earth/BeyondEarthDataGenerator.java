package com.st0x0ef.beyond_earth;

import com.st0x0ef.beyond_earth.datagen.ModModelGenerator;
import com.st0x0ef.beyond_earth.datagen.ModTagsGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
