package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.EntityAcidProjectile;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.EntityDracoEgg;
import org.alien.common.entity.living.EntitySporePod;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.avp.AVP;
import org.avp.common.entity.*;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.*;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.util.ArrayList;

public class AVPEntities implements IInitEvent
{
    public static final AVPEntities instance                  = new AVPEntities();
    private static int                    entityId                  = 0;

    private static final ArrayList<EntityEntry> entities                  = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities            = new ArrayList<>();

    private AVPEntities() {}

    static
    {
        registerEntityEntry(EntitySpear.class, "Spear");
        registerEntityEntry(EntityLaserMine.class, "ProximityMine");
        registerEntityEntry(EntityPlasma.class, "Plasma");
        registerEntityEntry(EntityGrenade.class, "Grenade");
        registerEntityEntry(EntityFlame.class, "Flamethrower");
        registerEntityEntry(EntityAcidPool.class, "AcidPool");
        registerEntityEntry(EntityLiquidLatexPool.class, "LiquidLatexPool");
        registerEntityEntry(EntityAcidProjectile.class, "AcidSpit");
        registerEntityEntry(EntitySmartDisc.class, "EntityDisc");
        registerEntityEntry(EntityShuriken.class, "EntityShuriken");
        registerEntityEntry(EntityTurret.class, "EntityTurret");
        registerEntityEntry(EntityWristbracer.class, "Nuke");
        registerEntityEntry(EntityAPC.class, "APC");
        registerEntityEntry(EntityMechanism.class, "MECHANISM");
        registerEntityEntry(EntityMedpod.class, "Medpod");
        registerEntityEntry(EntitySupplyChute.class, "SupplyChute");
        registerEntityEntry(EntitySupplyChuteMarines.class, "SupplyChuteMarines");
        registerEntityEntry(EntitySupplyChuteSeegson.class, "SupplyChuteSeegson");
        registerEntityEntry(EntitySporePod.class, "SporePod");

        registerLivingEntityEntry(EntityRunnerDrone.class, "RunnerDrone");
        registerLivingEntityEntry(EntityRunnerWarrior.class, "RunnerWarrior");
        registerLivingEntityEntry(EntityDrone.class, "Drone");
        registerLivingEntityEntry(EntityWarrior.class, "Warrior");
        registerLivingEntityEntry(EntitySpitter.class, "Spitter");
        registerLivingEntityEntry(EntityCrusher.class, "Crusher");
        registerLivingEntityEntry(EntityPraetorian.class, "Praetorian");
        registerLivingEntityEntry(EntityMarine.class, "Marine");
        registerLivingEntityEntry(EntityYautjaWarrior.class, "Yautja");
        registerLivingEntityEntry(EntityMatriarch.class, "Queen");
        registerLivingEntityEntry(EntityFacehugger.class, "Facehugger");
        registerLivingEntityEntry(EntityChestburster.class, "Chestbuster");
        registerLivingEntityEntry(EntityOvamorph.class, "Ovamorph");
        registerLivingEntityEntry(EntityRoyalFacehugger.class, "RoyalFacehugger");
        registerLivingEntityEntry(EntityNauticomorph.class, "AquaAlien");
        registerLivingEntityEntry(EntityPredalien.class, "Predalien");
        registerLivingEntityEntry(EntityCombatSynthetic.class, "CombatSynthetic");
        registerLivingEntityEntry(EntityDeacon.class, "Deacon");
        registerLivingEntityEntry(EntityHammerpede.class, "Hammerpede");
        registerLivingEntityEntry(EntityTrilobite.class, "Trilobite");
        registerLivingEntityEntry(EntitySpaceJockey.class, "SpaceJockey");
        registerLivingEntityEntry(EntityEngineer.class, "Engineer");
        registerLivingEntityEntry(EntityYautjaBerserker.class, "YautjaBerserker");
        registerLivingEntityEntry(EntityDeaconShark.class, "DeaconShark");
        registerLivingEntityEntry(EntityUltramorph.class, "Ultramorph");
        registerLivingEntityEntry(EntityGooMutant.class, "GooMutant");
        registerLivingEntityEntry(EntityAethon.class, "Aethon");
        registerLivingEntityEntry(EntityOctohugger.class, "Octohugger");
        registerLivingEntityEntry(EntityBelugaburster.class, "Belugaburster");
        registerLivingEntityEntry(EntityBelugamorph.class, "Belugamorph");
        registerLivingEntityEntry(EntityPredalienChestburster.class, "PredalienChestburster");
        registerLivingEntityEntry(EntityQueenChestburster.class, "QueenChestburster");
        registerLivingEntityEntry(EntityRunnerChestburster.class, "RunnerChestburster");
        registerLivingEntityEntry(EntityDeaconAdult.class, "DeaconAdult");
        registerLivingEntityEntry(EntityOvamorphGiger.class, "OvamorphGiger");

        if (AVP.settings().areExperimentalFeaturesEnabled())
        {
            registerLivingEntityEntry(EntityBabyhead.class, "Babyhead");
            registerLivingEntityEntry(EntityBatXeno.class, "BatXeno");
            registerLivingEntityEntry(EntityBoiler.class, "Boiler");
            registerLivingEntityEntry(EntityDracoburster.class, "Dracoburster");
            registerLivingEntityEntry(EntityDracoEgg.class, "DracoOvamorph");
            registerLivingEntityEntry(EntityDracomorph.class, "Dracomorph");
            registerLivingEntityEntry(EntityMyceliomorph.class, "Myceliomorph");
            registerLivingEntityEntry(EntityPantheramorph.class, "Pantheramorph");
            registerLivingEntityEntry(EntityPredatorHound.class, "HellHound");
            registerLivingEntityEntry(EntityUrsuidae.class, "Ursuidae");
            registerLivingEntityEntry(EntityScelemur.class, "VardaMonkey");
            registerLivingEntityEntry(EntityYautjaMutant.class, "YautjaMutant");
        }
    }

    private static void registerEntityEntryToCollection(Class<? extends Entity> entityClass, String id, ArrayList<EntityEntry> collection) {
        collection.add(EntityEntryBuilder.create().entity(entityClass).id(id, entityId++).name(id).tracker(128, 4, true).build());
    }

    private static void registerEntityEntry(Class<? extends Entity> entityClass, String id) {
        registerEntityEntryToCollection(entityClass, id, entities);
    }

    private static void registerLivingEntityEntry(Class<? extends EntityLivingBase> entityClass, String id) {
        registerEntityEntryToCollection(entityClass, id, livingEntities);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        entities.forEach(ForgeRegistries.ENTITIES::register);
        livingEntities.forEach(ForgeRegistries.ENTITIES::register);
    }
}
