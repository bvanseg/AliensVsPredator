package org.lib.brain.impl.task;

import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class DestroyBlockBrainTask extends AbstractEntityBrainTask {

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.BLOCK_POSITIONS_OF_INTEREST, BrainFlagState.PRESENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private int attemptTime;
	private final double moveSpeed;
	private final Predicate<Block> destroyPredicate;

	public DestroyBlockBrainTask(double moveSpeed, Predicate<Block> destroyPredicate) {
		this.attemptTime = 0;
		this.moveSpeed = moveSpeed;
		this.destroyPredicate = destroyPredicate;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		Optional<List<BlockPos>> blockPositionsOptional = ctx.getBrain().getMemory(BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST);
		if (!blockPositionsOptional.isPresent())
			return false;

		List<BlockPos> blockPositions = blockPositionsOptional.get();

		if (blockPositions.isEmpty())
			return false;

		BlockPos blockPos = blockPositions.get(0);

		attemptTime--;

		if (!destroyPredicate.test(entity.world.getBlockState(blockPos).getBlock()))
			return false;

		return attemptTime <= 0;
	}

	@Override
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		return !ctx.getEntity().getNavigator().noPath() && this.attemptTime < 20 * 5;
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		EntityCreature entity = (EntityCreature) ctx.getEntity();
		Optional<List<BlockPos>> blockPositionsOptional = ctx.getBrain().getMemory(BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST);
		List<BlockPos> blockPositions = blockPositionsOptional.get();

		if (blockPositions.isEmpty())
			return;

		BlockPos blockPos = blockPositions.get(0);

		// Init execution task.
		entity.getNavigator().tryMoveToXYZ(blockPos.getX(), blockPos.getY(), blockPos.getZ(), moveSpeed);

		double distanceToTargetBlock = ctx.getEntity().getDistance(blockPos.getX(), blockPos.getY(), blockPos.getZ());

		if (distanceToTargetBlock < 2.0D) {
			ctx.getEntity().world.destroyBlock(blockPos, true);
		} else {
			attemptTime++;
		}
    }
}
