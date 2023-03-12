package org.avp.entities.ai.alien;

import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

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
