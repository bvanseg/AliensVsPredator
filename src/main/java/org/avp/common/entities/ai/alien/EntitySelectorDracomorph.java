package org.avp.common.entities.ai.alien;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.avp.common.entities.living.species.SpeciesAlien;
import org.avp.common.entities.living.species.xenomorphs.EntityMatriarch;

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
