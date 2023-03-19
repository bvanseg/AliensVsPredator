package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;

public class EntitySelectorDracomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorDracomorph instance = new EntitySelectorDracomorph();

    @Override
    public boolean test(EntityLivingBase target)
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
