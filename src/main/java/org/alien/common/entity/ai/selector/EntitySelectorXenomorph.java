package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.SpeciesAlien;
import org.avp.common.world.capability.IOrganism.Organism;
import org.avp.common.world.capability.IOrganism.Provider;

public class EntitySelectorXenomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorXenomorph instance = new EntitySelectorXenomorph();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof SpeciesAlien)
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
        
        if (target instanceof EntityWaterMob) {
            return target.isInWater() || target.isOverWater();
        }
        
        if (target instanceof EntityBat) {
        	EntityBat batTarget = (EntityBat) target;
            return !batTarget.onGround || !batTarget.getIsBatHanging();
        }
        
        return true;
    }
}
