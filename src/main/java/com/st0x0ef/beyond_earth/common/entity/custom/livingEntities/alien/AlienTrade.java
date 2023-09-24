package com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.alien;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AlienTrade implements TradeOffers.Factory {
    public static final int MAX_USES = 9999;
    public static final Map<VillagerProfession, Int2ObjectMap<TradeOffers.Factory[]>> TRADES = new HashMap<>();


    @Nullable
    @Override
    public TradeOffer create(Entity entity, Random random) {
        return null;
    }
}
