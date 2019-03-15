package org.avp.entities.ai.alien;

import org.avp.entities.EntityLiquidPool;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntitySelectorXenomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorXenomorph instance = new EntitySelectorXenomorph();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof SpeciesAlien)
            return false;
        
        if (target instanceof EntityLiquidPool)
            return false;
        
        if (target instanceof EntityLivingBase)
        {
            EntityLivingBase livingBase = (EntityLivingBase) target;
            Organism organism = (Organism) livingBase.getCapability(Provider.CAPABILITY, null);
            
            if (organism.hasEmbryo())
            {
                return false;
            }
        }
        
        if (target instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) target;
            
            if (player.capabilities.isCreativeMode)
            {
                return false;
            }
        }
        
        if (!(target instanceof EntityLivingBase))
        {
            return false;
        }
        
        return true;
    }
}
