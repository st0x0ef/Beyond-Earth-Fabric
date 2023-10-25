package com.st0x0ef.beyond_earth.common.util.fluid;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;

public class FluidMultiTank extends SingleVariantStorage<FluidVariant> {

    @Override
    protected FluidVariant getBlankVariant() {
        return null;
    }

    @Override
    protected long getCapacity(FluidVariant variant) {
        return 0;
    }
}
