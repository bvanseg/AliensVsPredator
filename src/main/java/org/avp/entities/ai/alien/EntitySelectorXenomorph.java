package org.avp.entities.ai.alien;

import org.avp.entities.EntityLiquidPool;
import org.avp.entities.living.EntitySpeciesAlien;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntitySelectorXenomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorXenomorph instance = new EntitySelectorXenomorph();

    @Override
    public boolean apply(EntityLivingBase potentialTarget)
    {
        if (potentialTarget instanceof EntitySpeciesAlien)
            return false;
        
        if (potentialTarget instanceof EntityLiquidPool)
            return false;
        
        if (potentialTarget instanceof EntityLivingBase)
        {
            EntityLivingBase livingBase = (EntityLivingBase) potentialTarget;
            Organism organism = (Organism) livingBase.getCapability(Provider.CAPABILITY, null);
            
            if (organism.hasEmbryo())
            {
                return false;
            }
        }
        
        if (potentialTarget instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) potentialTarget;
            
            if (player.capabilities.isCreativeMode)
            {
                return false;
            }
        }
        
        if (!(potentialTarget instanceof EntityLiving))
        {
            return false;
        }
        
        return true;
    }
}
