package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLivingBase;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainMemoryKeys;

import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class NearestAttackableTargetBrainTask extends AbstractEntityBrainTask {
	@Override
	protected boolean shouldExecute() {
		return true;
	}
	
    @Override
	protected void startExecuting() {
    	Optional<EntityLivingBase> optional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);

    	if (optional.isPresent()) {
    		EntityLivingBase nearestAttackTarget = optional.get();

			if (!nearestAttackTarget.isDead && nearestAttackTarget.getHealth() > 0) {
				ctx.getEntity().setAttackTarget(nearestAttackTarget);
			} else {
				ctx.getEntity().setAttackTarget(null);
			}
    	} else {
			ctx.getEntity().setAttackTarget(null);
		}
    }
}
