package org.avp.entities.ai.alien;

import java.util.ArrayList;

import org.avp.api.parasitoidic.IParasitoid;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntitySelectorTrilobite implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorTrilobite instance = new EntitySelectorTrilobite();

    @Override
    public boolean apply(EntityLivingBase potentialTarget)
    {
        ArrayList<Class<?>> blacklist = IParasitoid.getDefaultEntityBlacklist();

        for (Class<?> c : blacklist)
        {
            if (c.isInstance(potentialTarget))
            {
                return false;
            }
        }

        Organism organism = (Organism) potentialTarget.getCapability(Provider.CAPABILITY, null);

        if (organism != null && organism.hasEmbryo())
        {
            return false;
        }

        if (potentialTarget instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) potentialTarget;

            if (player.capabilities.isCreativeMode)
            {
                return false;
            }
        }

        if (potentialTarget instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) potentialTarget;

            if (living.isChild())
            {
                return false;
            }
        }

        return true;
    }
}
