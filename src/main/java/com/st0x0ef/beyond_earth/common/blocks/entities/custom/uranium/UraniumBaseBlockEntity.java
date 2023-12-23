package com.st0x0ef.beyond_earth.common.blocks.entities.custom.uranium;


import com.st0x0ef.beyond_earth.common.effect.ModStatusEffects;
import com.st0x0ef.beyond_earth.common.util.Methods;
import com.st0x0ef.beyond_earth.common.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class UraniumBaseBlockEntity extends BlockEntity {
    public UraniumBaseBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void tick() {
        Box area = new Box(this.getPos()).expand(5);

        List<LivingEntity> entities = this.world.getNonSpectatingEntities(LivingEntity.class, area);
        for (LivingEntity entity : entities) {
            if(!Methods.isLivingInJetSuit(entity) && !entity.getType().isIn(ModTags.EntityTags.ENTITY_RADIATION_INVULNERABLE_TAG)) {
                entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.RADIATION, 100));
            }
        }
    }
}
