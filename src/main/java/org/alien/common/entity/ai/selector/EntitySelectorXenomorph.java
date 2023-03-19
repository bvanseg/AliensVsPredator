package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;

public class EntitySelectorXenomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorXenomorph instance = new EntitySelectorXenomorph();

    @Override
    public boolean test(EntityLivingBase target)
    {
        if (target instanceof SpeciesAlien)
            return false;

        OrganismImpl organism = (OrganismImpl) target.getCapability(Provider.CAPABILITY, null);

        if (organism.hasEmbryo())
        {
            return false;
        }
        
        if (target instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) target;
            
            if (player.capabilities.isCreativeMode)
            {
                return false;
            }
        }
        
        if (target instanceof EntityWaterMob) {
            return target.isInWater() || target.isOverWater();
        }
        
        if (target instanceof EntityBat) {
        	return false;
        }
        
        return true;
    }
}
