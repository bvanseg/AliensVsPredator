package org.avp.common.api.parasitoidic;

import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.nbt.NBTTagCompound;
import org.avp.common.entities.EntityLiquidPool;
import org.alien.common.entity.living.Species223ODe;
import org.alien.common.entity.living.SpeciesAlien;

import java.util.ArrayList;

public interface IParasitoid
{
    public void attachToEntity(Entity target);

    public void implantEmbryo(EntityLivingBase target);

    public void detachFromHost();

    public void setFertility(boolean fertility);

    public boolean isFertile();

    public boolean isAttachedToHost();

    public boolean canAttach(Entity entity);

    public int getTicksOnHost();

    public int getDetachTime();

    public Predicate<EntityLivingBase> getImpregnationEntitySelector();

    public static void readFromNBT(IParasitoid parasitoid, NBTTagCompound nbt)
    {
        boolean isFertile = nbt.getInteger("IsFertile") == 0;
        parasitoid.setFertility(isFertile);
    }

    public static NBTTagCompound writeToNBT(IParasitoid parasitoid, NBTTagCompound nbt)
    {
        nbt.setInteger("IsFertile", parasitoid.isFertile() ? 0 : 1);
        return nbt;
    }

    public static ArrayList<Class<?>> getDefaultEntityBlacklist()
    {
        ArrayList<Class<?>> blacklist = new ArrayList<Class<?>>();

        blacklist.add(EntityArmorStand.class);
        blacklist.add(SpeciesAlien.class);
        blacklist.add(EntityLiquidPool.class);
        blacklist.add(IParasitoid.class);
        blacklist.add(Species223ODe.class);
        blacklist.add(EntitySnowman.class);
        blacklist.add(EntityGolem.class);
        blacklist.add(EntitySkeleton.class);
        blacklist.add(EntityZombie.class);
        blacklist.add(EntitySpider.class);
        blacklist.add(EntitySilverfish.class);
        blacklist.add(EntityPigZombie.class);
        blacklist.add(EntityGhast.class);
        blacklist.add(EntityBlaze.class);
        blacklist.add(EntitySlime.class);
        blacklist.add(EntityMagmaCube.class);
        blacklist.add(EntityWither.class);
        blacklist.add(EntityShulker.class);
        blacklist.add(EntitySkeletonHorse.class);
        blacklist.add(EntityZombieHorse.class);
        blacklist.add(EntityEndermite.class);
        blacklist.add(EntityEnderman.class);
        blacklist.add(EntityRabbit.class);
        blacklist.add(EntityChicken.class);
        blacklist.add(EntityOcelot.class);
        blacklist.add(EntityParrot.class);
        blacklist.add(EntityBat.class);
        blacklist.add(EntityVex.class);
        blacklist.add(EntityHusk.class);
        blacklist.add(EntityStray.class);

        return blacklist;
    }
}
