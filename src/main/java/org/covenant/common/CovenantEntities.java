package org.covenant.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.covenant.common.entity.living.EntityKetterBird;
import org.covenant.common.entity.living.EntityPaintedMink;
import org.covenant.common.entity.living.EntityStripedDevil;
import org.avp.common.config.ModelConfig;
import org.covenant.common.entity.EntitySporePod;
import org.lib.common.registry.EntityRegistryUtil;

import java.util.ArrayList;

public class CovenantEntities implements IInitEvent {
    public static final CovenantEntities instance = new CovenantEntities();

    private static final ArrayList<EntityEntry> entities = new ArrayList<>();
    private static final ArrayList<EntityEntry> livingEntities = new ArrayList<>();

    private CovenantEntities() {}

    static {
        registerEntityEntry(EntitySporePod.class, "SporePod");

        if (ModelConfig.getInstance().getGeneral().experimentalFeatures) {
            registerLivingEntityEntry(EntityKetterBird.class, "KetterBird");
            registerLivingEntityEntry(EntityPaintedMink.class, "PaintedMink");
            registerLivingEntityEntry(EntityStripedDevil.class, "StripedDevil");
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
