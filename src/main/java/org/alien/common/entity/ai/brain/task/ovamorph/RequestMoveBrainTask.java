package org.alien.common.entity.ai.brain.task.ovamorph;

import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.ai.brain.task.util.EggMoveConstants;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class RequestMoveBrainTask extends AbstractEntityBrainTask {

	@Override
	protected boolean shouldExecute() {
		if (!(ctx.getEntity() instanceof EntityOvamorph))
			return false;
		EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
		return ovamorph.containsFacehugger() && !ovamorph.hasBeenMoved;
	}
	
    @Override
	protected void startExecuting() {
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);
		if (livingEntitiesOptional.isPresent()) {
			List<EntityLivingBase> livingEntities = livingEntitiesOptional.get();

			EntityOvamorph ovamorph = (EntityOvamorph) ctx.getEntity();
			if (livingEntities.stream().anyMatch(entity -> entity instanceof EntityOvamorph && ctx.getEntity().getDistance(entity) < EggMoveConstants.EGG_SPACE_REQUIRED)) {
				ovamorph.wantsToBeMoved = true;
			}
		}
	}
}
