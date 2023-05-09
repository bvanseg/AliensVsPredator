package org.alien.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.EntityAcidProjectile;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.EntitySporePod;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.*;
import org.alien.common.entity.living.xenomorph.exotic.*;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityDracoEgg;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorphGiger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.avp.common.config.ModelConfig;
import org.lib.common.registry.EntityRegistryUtil;

import java.util.ArrayList;

public class AlienEntities implements IInitEvent
{
    public static final AlienEntities instance                  = new AlienEntities();

    private static final ArrayList<EntityEntry> entities                  = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities            = new ArrayList<>();

    private AlienEntities() {}

    static
    {
        registerEntityEntry(EntityAcidPool.class, "AcidPool");
        registerEntityEntry(EntityAcidProjectile.class, "AcidSpit");
        registerEntityEntry(EntitySporePod.class, "SporePod");

        registerLivingEntityEntry(EntityRunnerDrone.class, "RunnerDrone");
        registerLivingEntityEntry(EntityRunnerWarrior.class, "RunnerWarrior");
        registerLivingEntityEntry(EntityDrone.class, "Drone");
        registerLivingEntityEntry(EntityWarrior.class, "Warrior");
        registerLivingEntityEntry(EntitySpitter.class, "Spitter");
        registerLivingEntityEntry(EntityCrusher.class, "Crusher");
        registerLivingEntityEntry(EntityPraetorian.class, "Praetorian");
        registerLivingEntityEntry(EntityMatriarch.class, "Queen");
        registerLivingEntityEntry(EntityFacehugger.class, "Facehugger");
        registerLivingEntityEntry(EntityChestburster.class, "Chestbuster");
        registerLivingEntityEntry(EntityOvamorph.class, "Ovamorph");
        registerLivingEntityEntry(EntityRoyalFacehugger.class, "RoyalFacehugger");
        registerLivingEntityEntry(EntityNauticomorph.class, "AquaAlien");
        registerLivingEntityEntry(EntityPredalien.class, "Predalien");
        registerLivingEntityEntry(EntityDeacon.class, "Deacon");
        registerLivingEntityEntry(EntityHammerpede.class, "Hammerpede");
        registerLivingEntityEntry(EntityTrilobite.class, "Trilobite");
        registerLivingEntityEntry(EntitySpaceJockey.class, "SpaceJockey");
        registerLivingEntityEntry(EntityEngineer.class, "Engineer");
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

        if (ModelConfig.getInstance().getGeneral().experimentalFeatures)
        {
            registerLivingEntityEntry(EntityBabyhead.class, "Babyhead");
            registerLivingEntityEntry(EntityBatXeno.class, "BatXeno");
            registerLivingEntityEntry(EntityBoiler.class, "Boiler");
            registerLivingEntityEntry(EntityDracoburster.class, "Dracoburster");
            registerLivingEntityEntry(EntityDracoEgg.class, "DracoOvamorph");
            registerLivingEntityEntry(EntityDracomorph.class, "Dracomorph");
            registerLivingEntityEntry(EntityMyceliomorph.class, "Myceliomorph");
            registerLivingEntityEntry(EntityPantheramorph.class, "Pantheramorph");
            registerLivingEntityEntry(EntityUrsuidae.class, "Ursuidae");
            registerLivingEntityEntry(EntityScelemur.class, "VardaMonkey");
            registerLivingEntityEntry(EntityYautjaMutant.class, "YautjaMutant");
        }
    }

    private static void registerEntityEntryToCollection(Class<? extends Entity> entityClass, String id, ArrayList<EntityEntry> collection) {
        collection.add(EntityEntryBuilder.create().entity(entityClass).id(id, EntityRegistryUtil.getNextEntityID()).name(id).tracker(128, 4, true).build());
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
