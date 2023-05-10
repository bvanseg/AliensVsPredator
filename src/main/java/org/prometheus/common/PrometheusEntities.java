package org.prometheus.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.common.config.ModelConfig;
import org.lib.common.registry.EntityRegistryUtil;
import org.prometheus.common.entity.living.EntityYautjaMutant;
import org.prometheus.common.entity.living.engineer.EntityEngineer;
import org.prometheus.common.entity.living.engineer.EntitySpaceJockey;
import org.prometheus.common.entity.living.species223ode.EntityDeacon;
import org.prometheus.common.entity.living.species223ode.EntityDeaconAdult;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.prometheus.common.entity.living.vardic.*;
import org.prometheus.common.entity.living.xenomorph.EntityUltramorph;

import java.util.ArrayList;

public class PrometheusEntities implements IInitEvent
{
    public static final PrometheusEntities instance                  = new PrometheusEntities();

    private static final ArrayList<EntityEntry> entities                  = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities            = new ArrayList<>();

    private PrometheusEntities() {}

    static
    {
        registerLivingEntityEntry(EntityDeacon.class, "Deacon");
        registerLivingEntityEntry(EntityHammerpede.class, "Hammerpede");
        registerLivingEntityEntry(EntityTrilobite.class, "Trilobite");
        registerLivingEntityEntry(EntitySpaceJockey.class, "SpaceJockey");
        registerLivingEntityEntry(EntityEngineer.class, "Engineer");
        registerLivingEntityEntry(EntityDeaconShark.class, "DeaconShark");
        registerLivingEntityEntry(EntityUltramorph.class, "Ultramorph");
        registerLivingEntityEntry(EntityGooMutant.class, "GooMutant");
        registerLivingEntityEntry(EntityOctohugger.class, "Octohugger");
        registerLivingEntityEntry(EntityBelugaburster.class, "Belugaburster");
        registerLivingEntityEntry(EntityBelugamorph.class, "Belugamorph");
        registerLivingEntityEntry(EntityDeaconAdult.class, "DeaconAdult");

        if (ModelConfig.getInstance().getGeneral().experimentalFeatures)
        {
            registerLivingEntityEntry(EntityBabyhead.class, "Babyhead");
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
