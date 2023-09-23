package com.st0x0ef.beyond_earth.common.entity;

import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.MoglerEntity;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.PygroEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.PygroBruteEntity;

public class ModEntities {
    /** LIVING ENTITIES */
    //public static final EntityType<AlienEntity> ALIEN = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "alien"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AlienEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2.5f)).build());
    //public static final EntityType<AlienZombieEntity> ALIEN_ZOMBIE = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "alien_zombie"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AlienZombieEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.4f)).build());
    //public static final EntityType<StarCrawlerEntity> STAR_CRAWLER = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "star_crawler"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StarCrawlerEntity::new).dimensions(EntityDimensions.fixed(1.3f, 1f)).build());
    public static final EntityType<PygroEntity> PYGRO = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "pygro"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PygroEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<PygroBruteEntity> PYGRO_BRUTE = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "pygro_brute"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PygroBruteEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<MoglerEntity> MOGLER = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "mogler"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MoglerEntity::new).dimensions(EntityDimensions.fixed(1.4f, 1.4f)).build());
    //public static final EntityType<MartianRaptor> MARTIAN_RAPTOR = Registry.register(Registries.ENTITY_TYPE, new Identifier(BeyondEarth.MOD_ID, "martian_raptor"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MartianRaptor::new).dimensions(EntityDimensions.fixed(0.75f, 2.0f)).build());


    public static void registerModEntities(){
        BeyondEarth.LOGGER.info("Registering entities for " + BeyondEarth.MOD_ID);
    }
}
