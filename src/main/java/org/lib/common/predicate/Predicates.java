package org.lib.common.predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.alien.common.api.parasitoidic.Host;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.capability.Organism;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.common.config.ModelConfig;

import java.util.function.Predicate;

/**
 * @author Boston Vanseghi
 */
public class Predicates {

    public static final Predicate<Entity> IS_VALID_ENTITY = target -> target != null && !target.isDead;

    public static final Predicate<Entity> EMBRYO_CARRIER = target -> {
        if (!(target instanceof EntityLivingBase)) return false;
        OrganismImpl organism = (OrganismImpl) target.getCapability(Organism.Provider.CAPABILITY, null);
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
        EntityEntry entityEntry = EntityRegistry.getEntry(target.getClass());

        if (entityEntry != null &&
            entityEntry.getRegistryName() != null &&
            ModelConfig.getInstance().getParasites().denyList.contains(entityEntry.getRegistryName().toString())
        ) {
            return false;
        }

        return true;
    };

    public static final Predicate<Entity> HAS_ATTACHED_PARASITE =
            target -> target.getPassengers().stream().anyMatch(EntityParasitoid.class::isInstance);
}
