package com.st0x0ef.beyond_earth.common.entity.custom.sensors;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.sensors.custom.PygroMobSensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModSensors {
    /**
     * SENSORS
     */
    public static final SensorType<PygroMobSensor> PYGRO_SENSOR = Registry.register(Registries.SENSOR_TYPE, new Identifier(BeyondEarth.MOD_ID, "pygro_sensor"), new SensorType<>(PygroMobSensor::new));

    public static void registerModMobSensors() {
        BeyondEarth.LOGGER.info("Registering sensors for " + BeyondEarth.MOD_ID);
    }
}
