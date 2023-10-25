package com.st0x0ef.beyond_earth.common.util;

import com.st0x0ef.beyond_earth.BeyondEarth;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Methods {
    public static final Identifier SPACE_STATION = new Identifier(BeyondEarth.MOD_ID, "space_station");

    public static void setEntityRotation(Entity vehicle, float rotation) {
        vehicle.setYaw(vehicle.getYaw() + rotation);
        vehicle.setBodyYaw(vehicle.getYaw());
        vehicle.prevYaw = vehicle.getYaw();
    }
}
