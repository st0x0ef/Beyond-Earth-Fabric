package com.st0x0ef.beyond_earth.client.renderers.entities.alien;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.entity.custom.livingEntities.alien.AlienEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

@Environment(EnvType.CLIENT)
public class AlienRenderer extends MobEntityRenderer<AlienEntity, EntityModel<AlienEntity>> {
    /** TEXTURES */
    public static final Identifier ALIEN = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/alien.png");

    public static final Identifier FARMER = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/farmer.png");
    public static final Identifier FISHERMAN = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/fisherman.png");
    public static final Identifier SHEPHERD = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/shepherd.png");
    public static final Identifier FLETCHER = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/fletcher.png");
    public static final Identifier LIBRARIAN = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/librarian.png");
    public static final Identifier CARTOGRAPHER = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/cartographer.png");
    public static final Identifier CLERIC = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/cleric.png");
    public static final Identifier ARMORER = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/armorer.png");
    public static final Identifier WEAPON_SMITH = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/weapon_smith.png");
    public static final Identifier TOOL_SMITH = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/tool_smith.png");
    public static final Identifier BUTCHER = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/butcher.png");
    public static final Identifier LEATHER_WORKER = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/leather_worker.png");
    public static final Identifier MASON = new Identifier(BeyondEarth.MOD_ID,"textures/entity/alien/mason.png");


    public AlienRenderer(EntityRendererFactory.Context context) {
        super(context, new AlienModel<>(context.getPart(AlienModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(AlienEntity entity) {
        if (entity.getVillagerData().getProfession() == VillagerProfession.FARMER) {
            return FARMER;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.FISHERMAN) {
            return FISHERMAN;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.SHEPHERD) {
            return SHEPHERD;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.FLETCHER) {
            return FLETCHER;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.LIBRARIAN) {
            return LIBRARIAN;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.CARTOGRAPHER) {
            return CARTOGRAPHER;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.CLERIC) {
            return CLERIC;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.ARMORER) {
            return ARMORER;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.WEAPONSMITH) {
            return WEAPON_SMITH;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.TOOLSMITH) {
            return TOOL_SMITH;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.BUTCHER) {
            return BUTCHER;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.LEATHERWORKER) {
            return LEATHER_WORKER;
        }
        else if (entity.getVillagerData().getProfession() == VillagerProfession.MASON) {
            return MASON;
        }

        return ALIEN;
    }
}
