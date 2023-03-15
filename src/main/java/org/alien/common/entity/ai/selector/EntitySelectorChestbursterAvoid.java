package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesEngineer;
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.living.SpeciesYautja;

import java.util.ArrayList;

public class EntitySelectorChestbursterAvoid implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorChestbursterAvoid instance = new EntitySelectorChestbursterAvoid();

    private static final ArrayList<Class<?>> ALLOW_LIST = new ArrayList<>();

    static {
        ALLOW_LIST.add(EntitySnowman.class);
        ALLOW_LIST.add(EntityGolem.class);
        ALLOW_LIST.add(EntitySkeleton.class);
        ALLOW_LIST.add(EntityZombie.class);
        ALLOW_LIST.add(EntityPigZombie.class);
        ALLOW_LIST.add(EntityGhast.class);
        ALLOW_LIST.add(EntityBlaze.class);
        ALLOW_LIST.add(EntitySlime.class);
        ALLOW_LIST.add(EntityMagmaCube.class);
        ALLOW_LIST.add(EntityWither.class);
        ALLOW_LIST.add(EntityShulker.class);
        ALLOW_LIST.add(EntitySkeletonHorse.class);
        ALLOW_LIST.add(EntityZombieHorse.class);
        ALLOW_LIST.add(EntityEndermite.class);
        ALLOW_LIST.add(EntityEnderman.class);
        ALLOW_LIST.add(EntityVex.class);
        ALLOW_LIST.add(EntityHusk.class);
        ALLOW_LIST.add(EntityStray.class);
        ALLOW_LIST.add(EntityMarine.class);
        ALLOW_LIST.add(SpeciesYautja.class);
        ALLOW_LIST.add(SpeciesEngineer.class);
    }

    @Override
    public boolean apply(EntityLivingBase potentialTarget)
    {
        // If the target is a player, return depending on if they're in creative mode or not.
        if (potentialTarget instanceof EntityPlayer)
        {
            return !((EntityPlayer) potentialTarget).isCreative();
        }

        // Do not run away from other aliens.
        if (potentialTarget instanceof SpeciesAlien) {
            return false;
        }

        // If the target is any of these types, run.
        for (Class<?> c : ALLOW_LIST)
        {
            if (c.isInstance(potentialTarget))
            {
                return true;
            }
        }

        // If the target is taller, run.
        return potentialTarget.height > 1.5F;
    }
}
