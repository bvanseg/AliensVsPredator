package org.alien.common.entity.ai.brain.task.ovamorph;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.avp.common.AVPMaterials;
import org.lib.brain.impl.AbstractEntityBrainTask;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class UpdateOpenProgressBrainTask extends AbstractEntityBrainTask {
	
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
		if (world.getBlockState(ovamorph.getPosition()).getMaterial() == AVPMaterials.MIST)
			return false;

		// Don't start opening until the time left until open is less than or equal to 0.
		return ovamorph.getTimeLeftUntilOpen() <= 0;
	}
	
    @Override
	protected void startExecuting() {
		AlienSounds.OVAMORPH_OPEN.playSound(ctx.getEntity());
	}

	@Override
	protected void continueExecuting() {
		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		int newHatchProgress = MathHelper.clamp(ovamorph.getOpenProgress() + 1, -EntityOvamorph.MAX_OPEN_PROGRESS, EntityOvamorph.MAX_OPEN_PROGRESS);
		ovamorph.setOpenProgress(newHatchProgress);
	}
}
