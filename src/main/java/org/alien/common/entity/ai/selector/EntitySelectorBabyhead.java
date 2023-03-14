package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.vardic.EntityGooMutant;

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
