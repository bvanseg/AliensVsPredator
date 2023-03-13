package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.vardic.EntityHammerpede;

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
