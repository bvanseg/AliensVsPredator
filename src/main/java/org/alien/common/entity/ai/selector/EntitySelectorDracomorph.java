package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorphs.EntityMatriarch;

public class EntitySelectorDracomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorDracomorph instance = new EntitySelectorDracomorph();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof EntityMatriarch)
        {
            return true;
        }
        
        if (target instanceof SpeciesAlien)
        {
            return false;
        }

        return true;
    }
}
