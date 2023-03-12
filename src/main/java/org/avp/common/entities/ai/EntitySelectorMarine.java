package org.avp.common.entities.ai;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.common.entities.living.EntityCombatSynthetic;
import org.avp.common.entities.living.EntityMarine;
import org.avp.common.entities.living.species.SpeciesAlien;
import org.avp.common.entities.living.species.SpeciesXenomorph;
import org.avp.common.entities.living.species.yautja.EntityYautjaWarrior;

public class EntitySelectorMarine implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorMarine instance = new EntitySelectorMarine();

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        if (entity instanceof SpeciesAlien)
            return true;

        if (entity instanceof EntityMob)
            return true;

        if (entity instanceof EntityYautjaWarrior)
            return true;

        if (entity instanceof EntityGolem)
            return true;

        if (entity instanceof SpeciesXenomorph)
            return true;

        if (entity instanceof EntityPlayer)
            return false;

        if (entity instanceof EntityMarine)
            return false;

        if (entity instanceof EntityCombatSynthetic)
            return false;

        return false;
    }
}
