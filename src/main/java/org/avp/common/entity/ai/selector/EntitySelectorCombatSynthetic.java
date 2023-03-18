package org.avp.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.living.SpeciesYautja;

public class EntitySelectorCombatSynthetic implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorCombatSynthetic instance = new EntitySelectorCombatSynthetic();

    @Override
    public boolean test(EntityLivingBase entity)
    {
        if (entity instanceof SpeciesAlien)
            return true;

        if (entity instanceof EntityMob)
            return true;

        if (entity instanceof SpeciesYautja)
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
