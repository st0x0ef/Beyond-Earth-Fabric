package com.st0x0ef.beyond_earth.common.items.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HammerItem extends Item {
	public HammerItem(FabricItemSettings settings) {
		super(settings);
	}

	@Override
	public boolean hasRecipeRemainder() {
		return true;
	}

	@Override
	public ItemStack getRecipeRemainder(ItemStack itemStack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamage(itemStack.getDamage() + 1);
		if (retval.getDamage() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}
}
