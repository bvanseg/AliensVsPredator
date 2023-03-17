package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLivingBase;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class NearestAttackableTargetBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		return true;
	}
	
    @Override
	protected void startExecuting(EntityBrainContext ctx) {
    	Optional<EntityLivingBase> optional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);

    	if (optional.isPresent()) {
    		EntityLivingBase nearestAttackTarget = optional.get();

			if (!nearestAttackTarget.isDead) {
				ctx.getEntity().setAttackTarget(nearestAttackTarget);
			} else {
				ctx.getEntity().setAttackTarget(null);
			}
    	} else {
			ctx.getEntity().setAttackTarget(null);
		}
    }

	@Override
	public void finish(EntityBrainContext ctx) {
		super.finish(ctx);

		if (!ctx.getBrain().hasMemory(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET)) {
			ctx.getEntity().setAttackTarget(null);
		}
	}
}
