package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLiving;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class LookIdleBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.LOOK, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.LOOK, BrainFlagState.PRESENT);
	}

	private double lookX;
	private double lookZ;
	private int idleTime;
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (this.isExecuting()) {
			return this.idleTime >= 0;
		}

		return true;
	}
	
    @Override
	protected void startExecuting(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		// First execution pass.
		if (!this.isExecuting()) {
			double d0 = 6.283185307179586 * entity.getRNG().nextDouble();
			this.lookX = Math.cos(d0);
			this.lookZ = Math.sin(d0);
			this.idleTime = 20 + entity.getRNG().nextInt(20);
			return;
		}

		--this.idleTime;
		entity.getLookHelper().setLookPosition(
				entity.posX + this.lookX,
				entity.posY + entity.getEyeHeight(),
				entity.posZ + this.lookZ,
				entity.getHorizontalFaceSpeed(),
				entity.getVerticalFaceSpeed()
		);
	}
}
