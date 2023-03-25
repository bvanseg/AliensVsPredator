package org.lib.brain.impl.task;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class AvoidBlockBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.BLOCK_POSITIONS_OF_INTEREST, BrainFlagState.PRESENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private final float avoidDistance;
	private final float farSpeed;
	private final float nearSpeed;
	private final Predicate<Block> avoidPredicate;

	private Path path;

	public AvoidBlockBrainTask(float avoidDistance, float avoidFarSpeed, float avoidNearSpeed, Predicate<Block> avoidPredicate) {
		this.avoidDistance = avoidDistance;
		this.farSpeed = avoidFarSpeed;
		this.nearSpeed = avoidNearSpeed;
		this.avoidPredicate = avoidPredicate;
	}
	
	@Override
	protected boolean shouldExecute() {
		EntityLiving entity = ctx.getEntity();

		if (!(entity instanceof EntityCreature))
			return false;
		EntityCreature entityCreature = (EntityCreature) ctx.getEntity();

		Optional<List<BlockPos>> nearestAvoidTargetOptional = ctx.getBrain().getMemory(BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST);
		if (!nearestAvoidTargetOptional.isPresent())
			return false;

		List<BlockPos> blockPositions = nearestAvoidTargetOptional.get();

		if (blockPositions.isEmpty())
			return false;

		BlockPos blockPos = blockPositions.get(0);

		if (!avoidPredicate.test(entity.world.getBlockState(blockPos).getBlock()))
			return false;

		// Find random position away from avoid target block pos.
		Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(entityCreature, (int)this.avoidDistance, 7, new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ()));
		if (vec3d == null)
			return false;

		this.path = entity.getNavigator().getPathToXYZ(vec3d.x, vec3d.y, vec3d.z);

		if (this.path == null)
			return false;

		double distanceToAvoidEntity = ctx.getEntity().getDistance(blockPos.getX(), blockPos.getY(), blockPos.getZ());

		return distanceToAvoidEntity <= avoidDistance;
	}

	@Override
	protected boolean shouldContinueExecuting() {
		return !ctx.getEntity().getNavigator().noPath();
	}

	@Override
	protected void startExecuting() {
		EntityCreature entity = (EntityCreature) ctx.getEntity();
		Optional<List<BlockPos>> avoidEntityOptional = ctx.getBrain().getMemory(BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST);
		List<BlockPos> blockPositions = avoidEntityOptional.get();

		if (blockPositions.isEmpty())
			return;

		BlockPos blockPos = blockPositions.get(0);

		// Init execution task.
		if (!this.isExecuting()) {
			entity.getNavigator().setPath(path, this.farSpeed);
		}

		// Continued execution.
		if (entity.getDistance(blockPos.getX(), blockPos.getY(), blockPos.getZ()) < this.avoidDistance * 0.75) {
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
