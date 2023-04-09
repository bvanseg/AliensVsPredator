package org.avp.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLivingBase;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainMemoryKeys;

import java.util.function.Predicate;

/**
 * @author Boston Vanseghi
 */
public class InvalidateAttackTargetBrainTask extends AbstractEntityBrainTask {

    private final Predicate<EntityLivingBase> invalidatePredicate;

    public InvalidateAttackTargetBrainTask(Predicate<EntityLivingBase> invalidatePredicate) {
        this.invalidatePredicate = invalidatePredicate;
    }

    @Override
    protected boolean shouldExecute() {
        return ctx.getEntity().getAttackTarget() != null &&
                !ctx.getEntity().getAttackTarget().isDead &&
                ctx.getEntity().getAttackTarget().getHealth() > 0 &&
                invalidatePredicate.test(ctx.getEntity().getAttackTarget());
    }

    @Override
    protected void startExecuting() {
        ctx.getBrain().forget(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
        ctx.getEntity().setAttackTarget(null);
    }
}
