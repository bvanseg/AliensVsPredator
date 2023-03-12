package org.avp.entities.ai.alien;

import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.vardic.EntityGooMutant;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

public class EntitySelectorBabyhead implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorBabyhead instance = new EntitySelectorBabyhead();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof EntityGooMutant)
        {
            return false;
        }
        
        if (target instanceof SpeciesAlien)
        {
            return false;
        }
        
        return true;
    }
}
