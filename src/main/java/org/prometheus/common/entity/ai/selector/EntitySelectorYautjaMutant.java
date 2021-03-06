package org.prometheus.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.prometheus.common.entity.living.vardic.EntityGooMutant;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorYautjaMutant extends EntitySelectorBase
{
    public static final EntitySelectorYautjaMutant instance = new EntitySelectorYautjaMutant();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (target instanceof EntityGooMutant)
        {
            return false;
        }

        return !Predicates.IS_ALIEN.test(target);
    }
}
