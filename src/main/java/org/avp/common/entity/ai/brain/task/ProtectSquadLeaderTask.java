package org.avp.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.avp.common.entity.living.EntityMarine;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainMemoryKeys;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Boston Vanseghi
 */
public class ProtectSquadLeaderTask extends AbstractEntityBrainTask {

    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof EntityMarine)) return false;
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        return marine.getSquadLeader().isPresent() &&
                (marine.getRevengeTarget() == null || marine.getRevengeTarget().isDead || marine.getRevengeTarget().getHealth() <= 0) &&
                (marine.getAttackTarget() == null || marine.getAttackTarget().isDead || marine.getAttackTarget().getHealth() <= 0);
    }

    @Override
    protected void startExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        EntityLivingBase squadLeader = marine.getSquadLeader().get();

        // Check to make sure that the squad leader is still alive in order to be protected.
        if (squadLeader.isDead || squadLeader.getHealth() <= 0F) return;

        Optional<List<EntityLivingBase>> nearbyEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

        if (nearbyEntitiesOptional.isPresent()) {
            List<EntityLivingBase> nearbyEntities = nearbyEntitiesOptional.get();
            List<EntityLiving> entitiesThreateningSquadLeader = nearbyEntities.stream().filter(entity -> {
                if (!(entity instanceof EntityLiving)) return false;
                EntityLiving livingEntity = (EntityLiving) entity;

                if (livingEntity.getAttackTarget() == null) return false;

                return livingEntity.getAttackTarget().getUniqueID().equals(squadLeader.getUniqueID());
            }).map(EntityLiving.class::cast).collect(Collectors.toList());

            if (!entitiesThreateningSquadLeader.isEmpty()) {
                EntityLiving threateningEntity = entitiesThreateningSquadLeader.get(0);
                marine.setAttackTarget(threateningEntity);
                ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET, threateningEntity);
            }
        }
    }
}
