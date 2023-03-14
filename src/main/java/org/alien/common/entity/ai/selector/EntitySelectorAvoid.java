package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.api.parasitoidic.Host;
import org.alien.common.entity.living.SpeciesEngineer;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.living.SpeciesYautja;

import java.util.ArrayList;

public class EntitySelectorAvoid implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorAvoid instance = new EntitySelectorAvoid();

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

        if (potentialTarget instanceof EntityPlayer && ((EntityPlayer)potentialTarget).isCreative())
        {
            return false;
        }
        
        if (potentialTarget.height > 1.5F)
        {
            return true;
        }

        OrganismImpl organism = (OrganismImpl) potentialTarget.getCapability(Provider.CAPABILITY, null);

        if (potentialTarget instanceof Host)
        {
            Host host = (Host) potentialTarget;

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
}
