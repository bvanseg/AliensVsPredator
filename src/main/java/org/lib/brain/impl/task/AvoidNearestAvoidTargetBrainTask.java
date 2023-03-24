package org.lib.brain.impl.task;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.Vec3d;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AvoidNearestAvoidTargetBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_AVOID_TARGET, BrainFlagState.PRESENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private Function<Entity, Float> avoidDistancePredicate;
	private final float avoidDistance;
	private final float farSpeed;
	private final float nearSpeed;

	private Path path;

	public AvoidNearestAvoidTargetBrainTask(float avoidFarSpeed, float avoidNearSpeed, Function<Entity, Float> avoidDistancePredicate) {
		this(0F, avoidFarSpeed, avoidNearSpeed);
		this.avoidDistancePredicate = avoidDistancePredicate;

	}

	public AvoidNearestAvoidTargetBrainTask(float avoidDistance, float avoidFarSpeed, float avoidNearSpeed) {
		this.avoidDistance = avoidDistance;
		this.farSpeed = avoidFarSpeed;
		this.nearSpeed = avoidNearSpeed;
	}

	private float getAvoidDistance(Entity entity) {
		if (this.avoidDistancePredicate != null) {
			return this.avoidDistancePredicate.apply(entity);
		}
		return this.avoidDistance;
	}

	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();
		// If already executing, check if the entity has no path.
		if (this.isExecuting()) {
			return !entity.getNavigator().noPath();
		}

		if (!(entity instanceof EntityCreature))
			return false;
		EntityCreature entityCreature = (EntityCreature) ctx.getEntity();

		Optional<Entity> nearestAvoidTargetOptional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_AVOID_TARGET);
		if (!nearestAvoidTargetOptional.isPresent())
			return false;

		Entity avoidEntity = nearestAvoidTargetOptional.get();

		// Find random position away from avoid target.
		Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(entityCreature, (int)this.getAvoidDistance(avoidEntity), 7, avoidEntity.getPositionVector());
		if (vec3d == null)
			return false;

		if (avoidEntity.getDistanceSq(vec3d.x, vec3d.y, vec3d.z) < avoidEntity.getDistanceSq(entity))
			return false;

		this.path = entity.getNavigator().getPathToXYZ(vec3d.x, vec3d.y, vec3d.z);

		if (this.path == null)
			return false;

		double distanceToAvoidEntity = ctx.getEntity().getDistance(avoidEntity);

		return distanceToAvoidEntity <= this.getAvoidDistance(avoidEntity);
	}
	
    @Override
	protected void startExecuting() {
		EntityCreature entity = (EntityCreature) ctx.getEntity();
		Optional<Entity> avoidEntityOptional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_AVOID_TARGET);
		Entity avoidEntity = avoidEntityOptional.get();

		// Init execution task.
		if (!this.isExecuting()) {
			entity.getNavigator().setPath(path, this.farSpeed);
		}

		// Continued execution.
		if (entity.getDistance(avoidEntity) < this.getAvoidDistance(avoidEntity) * 0.75) {
			entity.getNavigator().setSpeed(this.nearSpeed);
		} else {
			entity.getNavigator().setSpeed(this.farSpeed);
		}
    }

	@Override
	public void finish() {
		super.finish();
		this.path = null;
	}
}
