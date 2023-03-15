package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.AVP;
import org.avp.common.entity.*;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.lib.registry.EntityRegistryUtil;

import java.util.ArrayList;

public class AVPEntities implements IInitEvent
{
    public static final AVPEntities instance                  = new AVPEntities();

    private static final ArrayList<EntityEntry> entities                  = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities            = new ArrayList<>();

    private AVPEntities() {}

    static
    {
        registerEntityEntry(EntityGrenade.class, "Grenade");
        registerEntityEntry(EntityFlame.class, "Flamethrower");
        registerEntityEntry(EntityLiquidLatexPool.class, "LiquidLatexPool");
        registerEntityEntry(EntityTurret.class, "EntityTurret");
        registerEntityEntry(EntityAPC.class, "APC");
        registerEntityEntry(EntityMedpod.class, "Medpod");
        registerEntityEntry(EntitySupplyChute.class, "SupplyChute");
        registerEntityEntry(EntitySupplyChuteMarines.class, "SupplyChuteMarines");
        registerEntityEntry(EntitySupplyChuteSeegson.class, "SupplyChuteSeegson");

        registerLivingEntityEntry(EntityMarine.class, "Marine");
        registerLivingEntityEntry(EntityCombatSynthetic.class, "CombatSynthetic");

        if (AVP.settings().areExperimentalFeaturesEnabled())
        {
            // Left blank for experimental marine/weyland-yutani entities.
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
