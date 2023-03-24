package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class PickUpNearestEggBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_AVOID_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private EntityOvamorph targetEgg;

	@Override
	protected boolean shouldExecute() {
		if (!(ctx.getEntity() instanceof EntityDrone))
			return false;

		// Can not be carrying any other entities.
		if (!ctx.getEntity().getPassengers().isEmpty())
			return false;

		return true;
	}

	@Override
	protected boolean shouldContinueExecuting() {
		return this.targetEgg != null &&
				!this.targetEgg.isDead &&
				!this.targetEgg.hasBeenMoved &&
				this.targetEgg.wantsToBeMoved &&
				this.targetEgg.containsFacehugger() &&
				this.targetEgg.getRidingEntity() == null &&
				!ctx.getEntity().getNavigator().noPath();
	}

	@Override
	protected void startExecuting() {
		// Phase 1: Find an egg that wants to be moved.
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

		if (livingEntitiesOptional.isPresent()) {
			List<EntityOvamorph> nearbyEggsWantingToBeMoved =
					livingEntitiesOptional.get().stream()
							.filter(e -> e instanceof EntityOvamorph && !((EntityOvamorph)e).hasBeenMoved && ((EntityOvamorph)e).wantsToBeMoved)
							.map(e -> (EntityOvamorph)e)
							.collect(Collectors.toList());

			// If some eggs are found, try moving the first egg.
			if (!nearbyEggsWantingToBeMoved.isEmpty()) {
				this.targetEgg = nearbyEggsWantingToBeMoved.get(0);

				// Move to first egg.
				ctx.getEntity().getNavigator().tryMoveToEntityLiving(this.targetEgg, 1.0);
			}
		}
	}

	@Override
	protected void continueExecuting() {
		// Phase 2: Pick up egg.
		if (ctx.getEntity().getDistance(this.targetEgg) < 2.0 && this.targetEgg.getRidingEntity() == null) {
			this.targetEgg.startRiding(ctx.getEntity());
			// We have to disable the vanilla AI here, otherwise it will keep resetting the xenomorph's navigator path.
			this.targetEgg.setNoAI(true);
			this.targetEgg = null;
		}
	}

	@Override
	public void finish() {
		super.finish();
		this.targetEgg = null;
		ctx.getEntity().getNavigator().clearPath();
	}
}
