package net.mrscauthd.beyond_earth.common.util;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.entry.RegistryEntry;
import net.mrscauthd.beyond_earth.BeyondEarth;

public class ModDamageSources {
    public static final DamageType RADIATION_TYPE = new DamageType("radiations", 0);
    public static final RegistryEntry<DamageType> RADIATION = RegistryEntry.of(RADIATION_TYPE);

    //public static final RegistryKey<DamageType> IN_FIRE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("in_fire"));
    /*public class ModDamageSource extends DamageSource {
    protected ModDamageSource(String name) {
        super(name);
    }

    public static final DamageSource BLEEDING = new ModDamageSource("bleeding").setBypassesArmor().setBypassesProtection();

}*/

    public static void registerDamageSources() {
        BeyondEarth.LOGGER.info("Registering damage sources for " + BeyondEarth.MOD_ID);
    }
}
