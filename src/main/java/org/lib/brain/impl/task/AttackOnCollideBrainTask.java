package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.pathfinding.Path;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AttackOnCollideBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
	}
    
    private final double speedTowardsTarget;
    
    public AttackOnCollideBrainTask(double speedTowardsTarget) {
    	this.speedTowardsTarget = speedTowardsTarget;
    }
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLivingBase attackTarget = ctx.getEntity().getAttackTarget();
		return attackTarget != null && !attackTarget.isDead;
	}

	@Override
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		// Entities lose their pathing when they are close to each other, so we need to account for that by doing distance
		// checks here.
		EntityLivingBase nearestAttackTarget = (EntityLivingBase) ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET).get();
		double targetDistance = ctx.getEntity().getDistanceSq(nearestAttackTarget);
		boolean isTargetInRange = targetDistance < ctx.getEntity().width + 2.0;

		return super.shouldContinueExecuting(ctx) && (!ctx.getEntity().getNavigator().noPath() || isTargetInRange);
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		EntityLivingBase nearestAttackTarget = (EntityLivingBase) ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET).get();
        Path pathToNearestAttackTarget = ctx.getEntity().getNavigator().getPathToEntityLiving(nearestAttackTarget);
        ctx.getEntity().getNavigator().setPath(pathToNearestAttackTarget, this.speedTowardsTarget);
    }

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		EntityLivingBase nearestAttackTarget = (EntityLivingBase) ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET).get();
		double targetDistance = ctx.getEntity().getDistanceSq(nearestAttackTarget);
		boolean isTargetInRange = targetDistance < ctx.getEntity().width + 2.0;

		if (isTargetInRange) {
			ctx.getEntity().attackEntityAsMob(nearestAttackTarget);
		}
	}
}
