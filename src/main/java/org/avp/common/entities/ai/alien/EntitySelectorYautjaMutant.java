package org.avp.common.entities.ai.alien;

import org.avp.common.entities.living.species.SpeciesAlien;
import org.avp.common.entities.living.vardic.EntityGooMutant;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

public class EntitySelectorYautjaMutant implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorYautjaMutant instance = new EntitySelectorYautjaMutant();

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
