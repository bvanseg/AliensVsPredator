package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLivingBase;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

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
		return true;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
    	Optional<EntityLivingBase> optional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);

    	if (optional.isPresent()) {
    		EntityLivingBase nearestAttackTarget = optional.get();

			if (!nearestAttackTarget.isDead) {
				ctx.getEntity().setAttackTarget(nearestAttackTarget);
			} else {
				ctx.getBrain().forget(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
				ctx.getEntity().setAttackTarget(null);
			}
    	} else {
			ctx.getEntity().setAttackTarget(null);
		}
    }
}
