package org.avp.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.util.math.MathHelper;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public class RangedAttackBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
        map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
    }

    @Override
    public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
    }

    private int rangedAttackTime;

    private final double entityMoveSpeed;
    private final int maxRangedAttackWaitTime;
    private final float attackRadius;
    private final float maxAttackDistance;

    public RangedAttackBrainTask(double moveSpeed, int maxAttackTime, float maxAttackDistanceIn) {
        this.entityMoveSpeed = moveSpeed;
        this.maxRangedAttackWaitTime = maxAttackTime;
        this.attackRadius = maxAttackDistanceIn;
        this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
    }

    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof IRangedAttackMob)) return false;

        return ctx.getEntity().getAttackTarget() != null &&
                ctx.getEntity().canEntityBeSeen(ctx.getEntity().getAttackTarget());
    }

    @Override
    protected void startExecuting() {
        EntityLivingBase attackTarget = ctx.getEntity().getAttackTarget();
        double d0 = ctx.getEntity().getDistanceSq(attackTarget.posX, attackTarget.getEntityBoundingBox().minY, attackTarget.posZ);

        if (d0 <= this.maxAttackDistance)
        {
            ctx.getEntity().getNavigator().clearPath();
        }
        else
        {
            ctx.getEntity().getNavigator().tryMoveToEntityLiving(attackTarget, this.entityMoveSpeed);
        }

        ctx.getEntity().getLookHelper().setLookPositionWithEntity(attackTarget, 30.0F, 30.0F);

        if (--this.rangedAttackTime <= 0)
        {
            this.attackEntityWithRangedAttack(attackTarget, d0);
        }
    }

    protected void attackEntityWithRangedAttack(EntityLivingBase attackTarget, double d0) {
        float f = MathHelper.sqrt(d0) / this.attackRadius;
        float distanceFactor = MathHelper.clamp(f, 0.1F, 1.0F);
        ((IRangedAttackMob)ctx.getEntity()).attackEntityWithRangedAttack(attackTarget, distanceFactor);
        this.rangedAttackTime = maxRangedAttackWaitTime;
    }
}
