package org.alien.common.entity.ai.brain.task.ovamorph;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.avp.common.AVPMaterials;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class UpdateOpenProgressBrainTask extends AbstractBrainTask<EntityBrainContext> {
    
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
	protected void execute(EntityBrainContext ctx) {
		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		int newHatchProgress = MathHelper.clamp(ovamorph.getOpenProgress() + 1, -EntityOvamorph.MAX_OPEN_PROGRESS, EntityOvamorph.MAX_OPEN_PROGRESS);
		ovamorph.setOpenProgress(newHatchProgress);
	}
}
