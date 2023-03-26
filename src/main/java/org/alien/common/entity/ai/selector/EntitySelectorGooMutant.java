package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.alien.common.entity.living.vardic.EntityGooMutant;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorGooMutant extends EntitySelectorBase
{
    public static final EntitySelectorGooMutant instance = new EntitySelectorGooMutant();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (target instanceof EntityGooMutant) return false;
        if (Predicates.IS_ALIEN.test(target)) return false;
        
        return true;
    }
}
