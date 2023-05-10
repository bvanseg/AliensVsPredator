package org.prometheus.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.prometheus.common.entity.living.vardic.EntityGooMutant;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorBabyhead extends EntitySelectorBase
{
    public static final EntitySelectorBabyhead instance = new EntitySelectorBabyhead();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (target instanceof EntityGooMutant) return false;
        if (Predicates.IS_ALIEN.test(target)) return false;
        
        return true;
    }
}
