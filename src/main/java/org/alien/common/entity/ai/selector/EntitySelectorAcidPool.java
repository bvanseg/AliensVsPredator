package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

import javax.annotation.Nullable;

public class EntitySelectorAcidPool extends EntitySelectorBase
{
    public static final EntitySelectorAcidPool instance = new EntitySelectorAcidPool();

    @Override
    public boolean test(@Nullable Entity target)
    {
        if (!super.test(target)) return false;

        if (Predicates.IS_ALIEN.test(target)) return false;

        return true;
    }
}
