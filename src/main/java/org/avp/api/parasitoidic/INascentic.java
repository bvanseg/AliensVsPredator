package org.avp.api.parasitoidic;

import java.util.ArrayList;

import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.species.SpeciesEngineer;
import org.avp.entities.living.species.SpeciesYautja;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;

public interface INascentic extends IMaturable
{
    public void vitalize(EntityLivingBase host);
    
    public void grow(EntityLivingBase host);

    public static ArrayList<Class<?>> getDefaultEntityRunFromlist()
    {
        ArrayList<Class<?>> blacklist = new ArrayList<Class<?>>();

        blacklist.add(EntitySnowman.class);
        blacklist.add(EntityGolem.class);
        blacklist.add(EntitySkeleton.class);
        blacklist.add(EntityZombie.class);
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
        blacklist.add(EntityVex.class);
        blacklist.add(EntityHusk.class);
        blacklist.add(EntityStray.class);
        blacklist.add(EntityMarine.class);
        blacklist.add(SpeciesYautja.class);
        blacklist.add(SpeciesEngineer.class);

        return blacklist;
    }
    
    public static Predicate<EntityLivingBase> avoidSelector = new Predicate<EntityLivingBase>() {
        @Override
        public boolean apply(EntityLivingBase potentialTarget)
        {
            ArrayList<Class<?>> blacklist = getDefaultEntityRunFromlist();
            
            for (Class<?> c : blacklist)
            {
                if (c.isInstance(potentialTarget))
                {
                    return true;
                }
            }
            
            if (potentialTarget.height > 1.5F)
            {
                return true;
            }

            Organism organism = (Organism) potentialTarget.getCapability(Provider.CAPABILITY, null);

            if (potentialTarget instanceof IHost)
            {
                IHost host = (IHost) potentialTarget;

                if (!host.canHostParasite() || !host.canParasiteAttach())
                {
                    return true;
                }
            }

            if (organism != null && organism.hasEmbryo())
            {
                return true;
            }

            if (!(potentialTarget instanceof EntityLivingBase))
            {
                return true;
            }

            return false;
        }
    };
}
