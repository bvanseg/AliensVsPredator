package org.avp.util.brain.impl.task;

import java.util.HashMap;
import java.util.Map;

import org.avp.util.brain.flag.AbstractBrainFlag;
import org.avp.util.brain.flag.BrainFlagState;
import org.avp.util.brain.impl.BrainFlags;
import org.avp.util.brain.impl.BrainMemoryKeys;
import org.avp.util.brain.impl.EntityBrainContext;
import org.avp.util.brain.task.AbstractBrainTask;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.pathfinding.Path;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AttackOnCollideBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
    
    private final double speedTowardsTarget;
    
    public AttackOnCollideBrainTask(double speedTowardsTarget) {
    	this.speedTowardsTarget = speedTowardsTarget;
    }
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLivingBase attackTarget = ctx.getEntity().getAttackTarget();
		return attackTarget != null && !attackTarget.isDead && ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET).isPresent();
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityLivingBase nearestAttackTarget = (EntityLivingBase) ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET).get();
        Path pathToNearestAttackTarget = ctx.getEntity().getNavigator().getPathToEntityLiving(nearestAttackTarget);
        ctx.getEntity().getNavigator().setPath(pathToNearestAttackTarget, this.speedTowardsTarget);
        
        boolean isTargetInRange = ctx.getEntity().getDistanceSq(ctx.getEntity().getAttackTarget()) < 2.0D;
        
        if (isTargetInRange) {
        	ctx.getEntity().attackEntityAsMob(ctx.getEntity().getAttackTarget());
        }
    }
	
	@Override
	protected void finish(EntityBrainContext ctx) {
		ctx.getBrain().forget(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
	}
}
