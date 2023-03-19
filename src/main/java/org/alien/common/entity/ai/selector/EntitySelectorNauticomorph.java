package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorph.EntityNauticomorph;

public class EntitySelectorNauticomorph implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorNauticomorph instance = new EntitySelectorNauticomorph();

    @Override
    public boolean test(EntityLivingBase entity)
    {
        return !(entity instanceof SpeciesAlien) && !(entity instanceof EntityNauticomorph);
    }
}
