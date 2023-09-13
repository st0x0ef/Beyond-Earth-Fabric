package net.mrscauthd.beyond_earth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.mrscauthd.beyond_earth.common.items.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CALORITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_STEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_DESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_OSTRUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_CALORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALORITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_DESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_OSTRUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CALORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXYGEN_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXYGEN_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENGINE_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENGINE_FAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCKET_NOSE_CONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALORITE_ENGINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESH_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSTRUM_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALORITE_TANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCKET_FIN, Models.GENERATED);
    }
}
