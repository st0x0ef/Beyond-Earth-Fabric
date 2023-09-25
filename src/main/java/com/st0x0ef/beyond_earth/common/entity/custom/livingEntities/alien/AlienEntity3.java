package com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.alien;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import com.st0x0ef.beyond_earth.common.entity.ModEntities;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.AlienZombieEntity;
import com.st0x0ef.beyond_earth.common.items.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.*;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.ai.brain.task.VillagerTaskListProvider;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.*;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.Set;

public class AlienEntity3 extends VillagerEntity implements Merchant, Npc {
    public static ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> core(VillagerProfession profession, float p_220638_1_) {
        return VillagerTaskListProvider.createCoreTasks(profession, p_220638_1_);
    }

    private static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.HOME, MemoryModuleType.JOB_SITE, MemoryModuleType.POTENTIAL_JOB_SITE, MemoryModuleType.MEETING_POINT, MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleType.NEAREST_PLAYERS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.WALK_TARGET, MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.BREED_TARGET, MemoryModuleType.PATH, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_BED, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.NEAREST_HOSTILE, MemoryModuleType.SECONDARY_JOB_SITE, MemoryModuleType.HIDING_PLACE, MemoryModuleType.HEARD_BELL_TIME, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.LAST_SLEPT, MemoryModuleType.LAST_WOKEN, MemoryModuleType.LAST_WORKED_AT_POI, MemoryModuleType.GOLEM_DETECTED_RECENTLY);
    private static final ImmutableList<SensorType<? extends Sensor<? super VillagerEntity>>> SENSOR_TYPES = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.NEAREST_ITEMS, SensorType.NEAREST_BED, SensorType.HURT_BY, SensorType.VILLAGER_HOSTILES, SensorType.VILLAGER_BABIES, SensorType.SECONDARY_POIS, SensorType.GOLEM_DETECTED);

    public AlienEntity3(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return PiglinBruteEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new FleeEntityGoal<>(this, AlienZombieEntity.class, 15.0F, 0.5F, 0.5F));
    }

    @Nullable
    @Override
    public VillagerEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        AlienEntity alienentity = new AlienEntity(ModEntities.ALIEN, this.getWorld());

        alienentity.initialize(serverWorld, serverWorld.getLocalDifficulty(new BlockPos((int)passiveEntity.getX(), (int)passiveEntity.getY(), (int)passiveEntity.getZ())), SpawnReason.BREEDING, null, null);
        return alienentity;
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        this.setFireTicks(this.getFireTicks() + 1);
        if (this.getFireTicks() == 0) {
            this.setOnFireFor(8);
        }
        super.onStruckByLightning(world, lightning);
    }

    @Override
    public void summonGolem(ServerWorld world, long time, int requiredCount) {}

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        if (itemstack.getItem() != ModItems.ALIEN_SPAWN_EGG && this.isAlive() && !this.hasCustomer() && !this.isSleeping() && !player.shouldCancelInteraction()) {
            if (this.isBaby()) {
                this.shakeHead();
                return ActionResult.success(this.world.isClient());
            } else {
                boolean flag = this.getOffers().isEmpty();
                if (hand == Hand.MAIN_HAND) {
                    if (flag && !this.world.isClient) {
                        this.shakeHead();
                    }

                    player.incrementStat(Stats.TALKED_TO_VILLAGER);
                }

                if (flag) {
                    return ActionResult.success(this.world.isClient);
                } else {
                    if (!this.world.isClient && !this.offers.isEmpty()) {
                        this.displayMerchantGui(player);
                    }

                    return ActionResult.success(this.world.isClient);
                }
            }
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
        Brain<VillagerEntity> brain = Brain.createProfile(MEMORY_TYPES, SENSOR_TYPES).deserialize(dynamic);
        this.initBrain(brain);
        return brain;
    }

    @Override
    public void reinitializeBrain(ServerWorld world) {
        Brain<VillagerEntity> brain = this.getBrain();
        brain.stopAllTasks(world, this);
        this.brain = brain.copy();
        this.initBrain(this.getBrain());
    }

    private void shakeHead () {
        this.setHeadRollingTimeLeft(40);
        if (!this.world.isClient) {
            this.playSound(SoundEvents.ENTITY_VILLAGER_NO, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    private void displayMerchantGui(PlayerEntity player) {
        this.recalculateSpecialPricesFor(player);
        this.setCustomer(player);
        this.sendOffers(player, this.getDisplayName(), this.getVillagerData().getLevel());
    }

    private void recalculateSpecialPricesFor(PlayerEntity playerIn) {
        int i = this.getReputation(playerIn);
        if (i != 0) {
            for(TradeOffer merchantoffer : this.getOffers()) {
                merchantoffer.increaseSpecialPrice((int) -Math.floor((float)i * merchantoffer.getPriceMultiplier()));
            }
        }

        if (playerIn.hasStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE)) {
            StatusEffectInstance effectinstance = playerIn.getStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE);
            int k = effectinstance.getAmplifier();

            for(TradeOffer merchantoffer1 : this.getOffers()) {
                double d0 = 0.3D + 0.0625D * (double)k;
                int j = (int)Math.floor(d0 * (double)merchantoffer1.getOriginalFirstBuyItem().getCount());
                merchantoffer1.increaseSpecialPrice(-Math.max(j, 1));
            }
        }
    }

    private void initBrain(Brain<VillagerEntity> p_35425_) {
        VillagerProfession villagerprofession = this.getVillagerData().getProfession();

        if (this.isBaby()) {
            p_35425_.setSchedule(Schedule.VILLAGER_BABY);
            p_35425_.setTaskList(Activity.PLAY, VillagerTaskListProvider.createPlayTasks(0.5F));
        } else {
            p_35425_.setSchedule(Schedule.VILLAGER_DEFAULT);
            p_35425_.setTaskList(Activity.WORK, VillagerTaskListProvider.createWorkTasks(villagerprofession, 0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryModuleState.VALUE_PRESENT)));
        }

        p_35425_.setTaskList(Activity.CORE, AlienEntity3.core(villagerprofession, 0.5F));
        p_35425_.setTaskList(Activity.REST, VillagerTaskListProvider.createRestTasks(villagerprofession, 0.5F));
        p_35425_.setTaskList(Activity.IDLE, VillagerTaskListProvider.createIdleTasks(villagerprofession, 0.5F));
        p_35425_.setTaskList(Activity.PANIC, VillagerTaskListProvider.createPanicTasks(villagerprofession, 0.5F));
        p_35425_.setTaskList(Activity.PRE_RAID, VillagerTaskListProvider.createPreRaidTasks(villagerprofession, 0.5F));
        p_35425_.setTaskList(Activity.RAID, VillagerTaskListProvider.createRaidTasks(villagerprofession, 0.5F));
        p_35425_.setTaskList(Activity.HIDE, VillagerTaskListProvider.createHideTasks(villagerprofession, 0.5F));
        p_35425_.setCoreActivities(ImmutableSet.of(Activity.CORE));
        p_35425_.setDefaultActivity(Activity.IDLE);
        p_35425_.doExclusively(Activity.IDLE);
        p_35425_.refreshActivities(this.world.getTimeOfDay(), this.world.getTime());
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        if (reason == SpawnReason.COMMAND || reason == SpawnReason.SPAWN_EGG || reason == SpawnReason.SPAWNER || reason == SpawnReason.DISPENSER) {
            this.setVillagerData(this.getVillagerData().withType(VillagerType.forBiome(world.getBiome(this.getBlockPos()))));
        }

        /*if (reason == SpawnReason.STRUCTURE) {
            this.natural = true;
        }*/

        if (entityData == null) {
            entityData = new PassiveData(false);
        }

        int max = 13;
        int min = 1;

        for (int i = 0; i < new Random().nextInt((max+1)-min)+min; i++) {

            AlienJobs j = AlienJobs.values()[i];

            this.setVillagerData(this.getVillagerData().withProfession(j.getAlienJobs()));
        }

        return entityData;
    }

    /*@Override
    public void baseTick() {
        super.baseTick();

        if (!Config.ALIEN_SPAWN.get()) {
            this.remove(RemovalReason.DISCARDED);
        }
    }*/

    @Override
    protected void fillRecipes() {
        VillagerData villagerdata = this.getVillagerData();
        Int2ObjectMap<TradeOffers.Factory[]> int2objectmap = AlienTrade.TRADES.get(villagerdata.getProfession());
        if (int2objectmap != null && !int2objectmap.isEmpty()) {
            TradeOffers.Factory[] avillagertrades$itrade = int2objectmap.get(villagerdata.getLevel());
            if (avillagertrades$itrade != null) {
                TradeOfferList merchantoffers = this.getOffers();
                this.fillRecipesFromPool(merchantoffers, avillagertrades$itrade, 6);
            }
        }
    }

    protected void addOffersFromItemListings(TradeOfferList p_35278_, TradeOffers.Factory[] p_35279_, int p_35280_) {
        Set<Integer> set = Sets.newHashSet();
        if (p_35279_.length > p_35280_) {
            while(set.size() < p_35280_) {
                set.add(this.random.nextInt(p_35279_.length));
            }
        } else {
            for(int i = 0; i < p_35279_.length; ++i) {
                set.add(i);
            }
        }

        for(Integer integer : set) {
            TradeOffers.Factory villagertrades$itemlisting = p_35279_[integer];
            TradeOffer merchantoffer = villagertrades$itemlisting.create(this, this.random);
            if (merchantoffer != null) {
                p_35278_.add(merchantoffer);
            }
        }
    }

    /*@Override
    public void baseTick() {
        super.baseTick();

        if (!Config.ALIEN_SPAWN.get()) {
            this.remove(RemovalReason.DISCARDED);
        }
    }*/
}
