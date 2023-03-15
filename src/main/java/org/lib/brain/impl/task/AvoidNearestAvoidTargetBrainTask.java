package org.lib.brain.impl.task;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.Vec3d;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AvoidNearestAvoidTargetBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_AVOID_TARGET, BrainFlagState.PRESENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}

	private final float avoidDistance;
	private final float farSpeed;
	private final float nearSpeed;

	public AvoidNearestAvoidTargetBrainTask(float avoidDistance, float avoidFarSpeed, float avoidNearSpeed) {
		this.avoidDistance = avoidDistance;
		this.farSpeed = avoidFarSpeed;
		this.nearSpeed = avoidNearSpeed;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (this.isExecuting()) {
			return !ctx.getEntity().getNavigator().noPath();
		}

		if (!(ctx.getEntity() instanceof EntityCreature))
			return false;

		Optional<Entity> nearestAvoidTargetOptional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_AVOID_TARGET);
		if (!nearestAvoidTargetOptional.isPresent())
			return false;

		Entity avoidEntity = nearestAvoidTargetOptional.get();

		double distanceToAvoidEntity = ctx.getEntity().getDistance(avoidEntity);

		return distanceToAvoidEntity <= avoidDistance;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		EntityCreature entity = (EntityCreature) ctx.getEntity();

		Optional<Entity> avoidEntityOptional = ctx.getBrain().getMemory(BrainMemoryKeys.NEAREST_AVOID_TARGET);
		Entity avoidEntity = avoidEntityOptional.get();

		// Init execution task.
		if (!this.isExecuting()) {
			// Find random position away from avoid target.
			Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(entity, 16, 7, new Vec3d(avoidEntity.posX, avoidEntity.posY, avoidEntity.posZ));
			if (vec3d == null)
				return;

			if (avoidEntity.getDistanceSq(vec3d.x, vec3d.y, vec3d.z) < avoidEntity.getDistanceSq(entity))
				return;

			Path path = entity.getNavigator().getPathToXYZ(vec3d.x, vec3d.y, vec3d.z);

			if (path == null)
				return;

			entity.getNavigator().setPath(path, this.farSpeed);
		}

		// Continued execution.
		if (entity.getDistanceSq(avoidEntity) < 49.0) {
			entity.getNavigator().setSpeed(this.nearSpeed);
		} else {
			entity.getNavigator().setSpeed(this.farSpeed);
		}
    }
}
