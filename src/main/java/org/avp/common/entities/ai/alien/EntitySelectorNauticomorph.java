package org.avp.common.entities.ai.alien;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.avp.common.entities.living.species.SpeciesAlien;
import org.avp.common.entities.living.species.xenomorphs.EntityNauticomorph;

public class EntitySelectorNauticomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorNauticomorph instance = new EntitySelectorNauticomorph();

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        return !(entity instanceof SpeciesAlien) && !(entity instanceof EntityNauticomorph);
    }
}
