package org.avp.common.entities.ai.alien;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.avp.common.entities.living.species.SpeciesAlien;
import org.avp.common.entities.living.vardic.EntityHammerpede;

// TODO: This class isn't yet used, do not delete
public class EntitySelectorHammerpede implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorHammerpede instance = new EntitySelectorHammerpede();

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        return !(entity instanceof SpeciesAlien) && !(entity instanceof EntityHammerpede);
    }
}
