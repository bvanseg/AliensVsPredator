package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainMemoryKeys;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class HurtByTargetBrainTask extends AbstractEntityBrainTask {
	
	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();
		EntityLivingBase target = entity.getRevengeTarget();

		if (target == null) {
			return false;
		}

		if (target instanceof EntityPlayer && ((EntityPlayer)target).isCreative()) {
			return false;
		}

		return true;
	}
	
    @Override
	protected void startExecuting() {
		ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET, ctx.getEntity().getRevengeTarget());
	}
}
