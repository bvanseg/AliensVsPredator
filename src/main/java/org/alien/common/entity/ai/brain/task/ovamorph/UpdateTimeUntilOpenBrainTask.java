package org.alien.common.entity.ai.brain.task.ovamorph;

import net.minecraft.world.World;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.avp.common.AVPFluidMaterials;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class UpdateTimeUntilOpenBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
	}
	
	@Override
	protected boolean shouldExecute() {
		if (!(ctx.getEntity() instanceof EntityOvamorph))
			return false;
		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		World world = ovamorph.world;

		// Can't hatch if there is nothing to hatch out of the egg.
		if (!ovamorph.containsFacehugger())
			return false;

		// Don't update hatch state while in mist.
		if (world.getBlockState(ovamorph.getPosition()).getMaterial() == AVPFluidMaterials.MIST)
			return false;

		if (ovamorph.timeLeftUntilOpen.get() <= 0)
			return false;

		return true;
	}
	
    @Override
	protected void startExecuting() {
		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		// Update time until the egg starts to open.
		ovamorph.timeLeftUntilOpen.add(-(ovamorph.acceleratedHatching ? 20 : 1));
	}
}
