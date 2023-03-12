package org.avp.entities.ai.alien;

import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.xenomorphs.EntityNauticomorph;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

public class EntitySelectorNauticomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorNauticomorph instance = new EntitySelectorNauticomorph();

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        return !(entity instanceof SpeciesAlien) && !(entity instanceof EntityNauticomorph);
    }
}
