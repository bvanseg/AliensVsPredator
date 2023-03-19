package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.SpeciesAlien;

import javax.annotation.Nullable;

public class EntitySelectorAcidPool implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorAcidPool instance = new EntitySelectorAcidPool();

    @Override
    public boolean test(@Nullable EntityLivingBase living)
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
