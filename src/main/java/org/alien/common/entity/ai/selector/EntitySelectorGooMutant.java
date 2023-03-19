package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.vardic.EntityGooMutant;

public class EntitySelectorGooMutant implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorGooMutant instance = new EntitySelectorGooMutant();

    @Override
    public boolean test(EntityLivingBase target)
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
