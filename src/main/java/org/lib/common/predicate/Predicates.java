package org.lib.common.predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.api.parasitoidic.Host;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.capability.Organism;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author Boston Vanseghi
 */
public class Predicates {

    public static final Predicate<Entity> IS_VALID_ENTITY = target -> target != null && !target.isDead;

    public static final Predicate<Entity> EMBRYO_CARRIER = target -> {
        if (!(target instanceof EntityLivingBase)) return false;
        Organism.OrganismImpl organism = (Organism.OrganismImpl) target.getCapability(Organism.Provider.CAPABILITY, null);
        return organism != null && organism.hasEmbryo();
    };

    public static final Predicate<Entity> IS_IMMORTAL_PLAYER = target ->
            target instanceof EntityPlayer && (((EntityPlayer)target).isCreative() || ((EntityPlayer)target).isSpectator());

    public static final Predicate<Entity> IS_CHILD = target -> (target instanceof EntityLivingBase) && ((EntityLivingBase)target).isChild();

    public static final Predicate<Entity> IS_VALID_HOST = target -> {
        if (!(target instanceof EntityLivingBase)) return false;
        if (target instanceof Host)
        {
            Host host = (Host) target;
            return host.canHostParasite() && host.canParasiteAttach();
        }

        return true;
    };

    public static final Predicate<Entity> IS_ALIEN = SpeciesAlien.class::isInstance;

    public static final Predicate<Entity> IS_PARASITOID_TARGET = target -> {
        if (!(target instanceof EntityLivingBase)) return false;

        ArrayList<Class<?>> denyList = Parasitoid.getDefaultEntityBlacklist();

        for (Class<?> c : denyList) {
            if (c.isInstance(target))
                return false;
        }

        return true;
    };
}
