package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.alien.common.entity.ai.brain.task.util.EggMoveConstants;
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
public class MoveEggBrainTask extends AbstractEntityBrainTask {

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

	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (!(ctx.getEntity() instanceof EntityDrone))
			return false;

		// Must be carrying at least 1 entity.
		if (ctx.getEntity().getPassengers().isEmpty())
			return false;

		// Must be carrying at least 1 egg.
		if (ctx.getEntity().getPassengers().stream().noneMatch(EntityOvamorph.class::isInstance))
			return false;

		return true;
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

		// Phase 1: Find avoid target.
		if (livingEntitiesOptional.isPresent() && ctx.getEntity().ticksExisted % 20 * 2 == 0) {
			List<EntityOvamorph> nearbyEggs =
					livingEntitiesOptional.get().stream()
							.filter(e -> (e instanceof EntityOvamorph) &&
									!ctx.getEntity().getPassengers().contains(e) &&
									e.getRidingEntity() == null)
							.map(e -> (EntityOvamorph) e).collect(Collectors.toList());

			// If some eggs are found, check to see if we are far away enough from all of them.
			if (!nearbyEggs.isEmpty()) {
				EntityCreature entity = (EntityCreature) ctx.getEntity();

				// If any egg is too close, move away from the nearest egg.
				Entity avoidTarget = nearbyEggs.get(0);

				// Find random position away from avoid target.
				Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(entity, EggMoveConstants.EGG_MOVE_DISTANCE * 2, 7, avoidTarget.getPositionVector());
				if (vec3d == null)
					return;

				if (avoidTarget.getDistanceSq(vec3d.x, vec3d.y, vec3d.z) < avoidTarget.getDistanceSq(entity))
					return;

				Path path = entity.getNavigator().getPathToXYZ(vec3d.x, vec3d.y, vec3d.z);

				if (path == null)
					return;

				entity.getNavigator().setPath(path, 0.5);
			}
		}

		// Phase 2: Avoid avoid target
		if (livingEntitiesOptional.isPresent()) {
			List<EntityOvamorph> nearbyEggs =
					livingEntitiesOptional.get().stream()
							.filter(e -> e instanceof EntityOvamorph && e.getRidingEntity() == null)
							.map(e -> (EntityOvamorph) e).collect(Collectors.toList());

			// If no eggs are close by, we can drop the egg, now.
			if (nearbyEggs.isEmpty() || nearbyEggs.stream().noneMatch(e -> ctx.getEntity().getDistance(e) < EggMoveConstants.EGG_SPACE_REQUIRED)) {
				this.dropEgg(ctx, false);
			}
		} else {
			this.dropEgg(ctx, false);
		}
	}

	private void dropEgg(EntityBrainContext ctx, boolean forced) {
		EntityLiving entity = ctx.getEntity();
		BlockPos pos = entity.getPosition();
		entity.getPassengers().forEach(passenger -> {
			passenger.dismountRidingEntity();
			passenger.setPosition(pos.getX(), pos.getY(), pos.getZ());

			if (passenger instanceof EntityOvamorph) {
				((EntityOvamorph)passenger).setNoAI(false);
				((EntityOvamorph)passenger).hasBeenMoved = !forced;
			}
		});
	}

	@Override
	public void finish(EntityBrainContext ctx) {
		super.finish(ctx);
		this.dropEgg(ctx, true);
		ctx.getEntity().getNavigator().clearPath();
	}
}
