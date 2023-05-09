package org.avp.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLivingBase;
import org.avp.common.entity.living.EntityMarine;

/**
 * @author Boston Vanseghi
 */
public class MarineRangedAttackBrainTask extends RangedAttackBrainTask {

    public MarineRangedAttackBrainTask(double moveSpeed, int maxAttackTime, float maxAttackDistanceIn) {
        super(moveSpeed, maxAttackTime, maxAttackDistanceIn);
    }

    @Override
    protected boolean shouldExecute() {
        return super.shouldExecute() && ((EntityMarine)ctx.getEntity()).hasLoadedAmmunition();
    }

    @Override
    protected void attackEntityWithRangedAttack(EntityLivingBase attackTarget, double d0) {
        super.attackEntityWithRangedAttack(attackTarget, d0);
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        marine.setLoadedAmmunition(marine.getLoadedAmmunition() - 1);
    }
}
