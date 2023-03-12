package org.avp.common.entities.ai.alien;

import org.avp.common.entities.living.EntityAethon;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

public class EntitySelectorAethon implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorAethon instance = new EntitySelectorAethon();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof EntityAethon)
        {
            return false;
        }

        return true;
    }
}
