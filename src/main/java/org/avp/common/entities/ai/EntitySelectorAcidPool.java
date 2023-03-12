package org.avp.common.entities.ai;

import javax.annotation.Nullable;

import org.avp.common.entities.living.species.SpeciesAlien;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntitySelectorAcidPool implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorAcidPool instance = new EntitySelectorAcidPool();

    @Override
    public boolean apply(@Nullable EntityLivingBase living)
    {
        if (living instanceof EntityPlayer && ((EntityPlayer)living).capabilities.isCreativeMode)
        {
            return false;
        }
        else if (living instanceof SpeciesAlien)
        {
            return false;
        }

        return true;
    }
}
