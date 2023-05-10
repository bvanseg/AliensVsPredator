package org.alien.common.api.parasitoidic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.prometheus.common.entity.living.Species223ODe;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.avp.common.entity.EntityLiquidPool;

import java.util.*;
import java.util.stream.Collectors;

public interface Parasitoid
{
    void attachToEntity(Entity target);

    void implantEmbryo(EntityLivingBase target);

    void detachFromHost();

    void setFertility(boolean fertility);

    boolean isFertile();

    boolean isAttachedToHost();

    boolean canAttach(Entity entity);

    int getTicksOnHost();

    int getDetachTime();

    String IS_FERTILE_NBT_KEY = "IsFertile";

    static void readFromNBT(Parasitoid parasitoid, NBTTagCompound nbt)
    {
        boolean isFertile = nbt.getInteger(IS_FERTILE_NBT_KEY) == 0;
        parasitoid.setFertility(isFertile);
    }

    static NBTTagCompound writeToNBT(Parasitoid parasitoid, NBTTagCompound nbt)
    {
        nbt.setInteger(IS_FERTILE_NBT_KEY, parasitoid.isFertile() ? 0 : 1);
        return nbt;
    }

    // Do not use this directly. Use ModelConfig's parasite data, instead.
    @Deprecated
    static ArrayList<Class<? extends Entity>> getDefaultEntityDenylist()
    {
        ArrayList<Class<? extends Entity>> denylist = new ArrayList<>();

        denylist.add(EntityArmorStand.class);
        denylist.add(SpeciesAlien.class);
        denylist.add(EntityLiquidPool.class);
        denylist.add(EntityFacehugger.class);
        denylist.add(Species223ODe.class);
        denylist.add(EntitySnowman.class);
        denylist.add(EntityGolem.class);
        denylist.add(EntitySkeleton.class);
        denylist.add(EntityZombie.class);
        denylist.add(EntitySpider.class);
        denylist.add(EntitySilverfish.class);
        denylist.add(EntityPigZombie.class);
        denylist.add(EntityGhast.class);
        denylist.add(EntityBlaze.class);
        denylist.add(EntitySlime.class);
        denylist.add(EntityMagmaCube.class);
        denylist.add(EntityWither.class);
        denylist.add(EntityShulker.class);
        denylist.add(EntitySkeletonHorse.class);
        denylist.add(EntityZombieHorse.class);
        denylist.add(EntityEndermite.class);
        denylist.add(EntityEnderman.class);
        denylist.add(EntityRabbit.class);
        denylist.add(EntityChicken.class);
        denylist.add(EntityOcelot.class);
        denylist.add(EntityParrot.class);
        denylist.add(EntityBat.class);
        denylist.add(EntityVex.class);
        denylist.add(EntityHusk.class);
        denylist.add(EntityStray.class);

        return denylist;
    }

    // Do not use this directly. Use ModelConfig's parasite data, instead.
    @Deprecated
    static Set<EntityEntry> getParasitoidDenylistEntries() {
        HashSet<EntityEntry> entityEntries = new HashSet<>();

        for (Class<?> entityClass: getDefaultEntityDenylist()) {
            for (Map.Entry<ResourceLocation, EntityEntry> entry: ForgeRegistries.ENTITIES.getEntries()) {
                // If this entry's entity class equals the denylist entity class OR this entry's entity class is a subclass
                // of the denylist entity class, add this entry to the denylist.
                if (entityClass == entry.getValue().getEntityClass() ||
                        entityClass.isAssignableFrom(entry.getValue().getEntityClass())
                ) {
                    entityEntries.add(entry.getValue());
                }
            }
        }

        return entityEntries;
    }

    // Do not use this directly. Use ModelConfig's parasite data, instead.
    @Deprecated
    static Set<String> getParasitoidDenylistRegistryNames() {
        return getParasitoidDenylistEntries().stream().map(
                entityEntry -> entityEntry.getRegistryName() != null ? entityEntry.getRegistryName().toString() : null
        ).filter(Objects::nonNull).collect(Collectors.toSet());
    }
}
