package com.st0x0ef.beyond_earth.common.blocks.entities.custom.machines;

import com.st0x0ef.beyond_earth.common.blocks.entities.custom.machines.gauge.IGaugeValue;

import java.util.List;

public interface IGaugeValuesProvider {
    List<IGaugeValue> getDisplayGaugeValues();
}
