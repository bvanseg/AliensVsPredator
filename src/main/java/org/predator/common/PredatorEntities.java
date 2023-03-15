package org.predator.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.common.AVPSettings;
import org.lib.registry.EntityRegistryUtil;
import org.predator.common.entity.*;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.util.ArrayList;

public class PredatorEntities implements IInitEvent
{
    public static final PredatorEntities instance                  = new PredatorEntities();

    private static final ArrayList<EntityEntry> entities                  = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities            = new ArrayList<>();

    private PredatorEntities() {}

    static
    {
        registerEntityEntry(EntitySpear.class, "Spear");
        registerEntityEntry(EntityLaserMine.class, "ProximityMine");
        registerEntityEntry(EntityPlasma.class, "Plasma");
        registerEntityEntry(EntitySmartDisc.class, "EntityDisc");
        registerEntityEntry(EntityShuriken.class, "EntityShuriken");
        registerEntityEntry(EntityWristbracer.class, "Nuke");
        registerEntityEntry(EntityMechanism.class, "MECHANISM");

        registerLivingEntityEntry(EntityYautjaWarrior.class, "Yautja");
        registerLivingEntityEntry(EntityYautjaBerserker.class, "YautjaBerserker");

        if (AVPSettings.instance.areExperimentalFeaturesEnabled())
        {
            registerLivingEntityEntry(EntityPredatorHound.class, "HellHound");
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
