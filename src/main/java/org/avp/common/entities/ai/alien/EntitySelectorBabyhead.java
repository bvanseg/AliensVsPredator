package org.avp.common.entities.ai.alien;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.avp.common.entities.living.species.SpeciesAlien;
import org.avp.common.entities.living.vardic.EntityGooMutant;

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
