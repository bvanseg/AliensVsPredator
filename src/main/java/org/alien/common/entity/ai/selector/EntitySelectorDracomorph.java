package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorDracomorph extends EntitySelectorBase
{
    public static final EntitySelectorDracomorph instance = new EntitySelectorDracomorph();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (target instanceof EntityMatriarch) return true;
        if (Predicates.IS_ALIEN.test(target)) return false;

        return true;
    }
}
