package org.avp.common.brain.impl.task;

import net.minecraft.entity.EntityLivingBase;
import org.avp.common.brain.flag.AbstractBrainFlag;
import org.avp.common.brain.flag.BrainFlagState;
import org.avp.common.brain.impl.BrainFlags;
import org.avp.common.brain.impl.BrainMemoryKeys;
import org.avp.common.brain.impl.EntityBrainContext;
import org.avp.common.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class NearestAttackableTargetBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		boolean nearestAttackTargetCondition = false;
    	Optional<EntityLivingBase> optional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
    	if (optional.isPresent()) {
    		EntityLivingBase nearestAttackTarget = optional.get();
    		nearestAttackTargetCondition = !nearestAttackTarget.isDead;
    	}

    	EntityLivingBase attackTarget = ctx.getEntity().getAttackTarget();
    	boolean currentAttackTargetCondition = attackTarget == null || attackTarget.isDead;
    	
		return currentAttackTargetCondition && nearestAttackTargetCondition;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
    	Optional<EntityLivingBase> optional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
    	if (optional.isPresent()) {
    		EntityLivingBase nearestAttackTarget = optional.get();
    		ctx.getEntity().setAttackTarget(nearestAttackTarget);
    	}
    }
}
