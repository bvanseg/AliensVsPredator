package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.alien.common.entity.living.EntityAethon;
import org.lib.predicate.EntitySelectorBase;

public class EntitySelectorAethon extends EntitySelectorBase
{
    public static final EntitySelectorAethon instance = new EntitySelectorAethon();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (target instanceof EntityAethon) return false;

        return true;
    }
}
