package org.lib.brain.impl.sensor;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.sensor.AbstractBrainSensor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author Boston Vanseghi
 *
 */
public class NearestBlockPositionsOfInterestSensor extends AbstractBrainSensor<EntityBrainContext> {

	private final int cooldownInTicks;
	private final int range;
	private final Predicate<Block> blockPredicate;

	public NearestBlockPositionsOfInterestSensor(int cooldownInTicks, int range, Predicate<Block> blockPredicate) {
		this.cooldownInTicks = cooldownInTicks;
		this.range = range;
		this.blockPredicate = blockPredicate;
	}

	private final Comparator<BlockPos> distanceComparator = (e1, e2) -> {
		double d1 = ctx.getEntity().getDistanceSq(e1);
		double d2 = ctx.getEntity().getDistanceSq(e2);

		if (d1 < d2) {
			return -1;
		} else if (d1 > d2) {
			return 1;
		}

		return 0;
	};


	@Override
	public void sense() {
		// Use ticksExisted instead of world time here so that entities don't have synchronized AI execution.
		if (ctx.getEntity().ticksExisted % this.cooldownInTicks != 0) {
			return;
		}

		ArrayList<BlockPos> positionsOfInterest = new ArrayList<>();

		// Searches in a growing radius around the entity, starting at the entity's position. Also searches a block pos
		// up and a block pos down.

		for (int x = -this.range; x <= this.range; x++) {
			for (int z = -this.range; z <= this.range; z++) {
				for (int y = -1; y <= 1; y++) {
					BlockPos pos = ctx.getEntity().getPosition().add(x, y, z);
					validateBlock(ctx, pos, positionsOfInterest);
				}
			}
		}

		// Block positions sorted by distance to be closest to context entity.
		positionsOfInterest.sort(this.distanceComparator);

		ctx.getBrain().remember(BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST, positionsOfInterest);
	}

	private void validateBlock(EntityBrainContext ctx, BlockPos pos, ArrayList<BlockPos> positionsOfInterest) {
		Block block = ctx.getEntity().world.getBlockState(pos).getBlock();
		if (this.blockPredicate.test(block)) {
			positionsOfInterest.add(pos);
		}
	}
}
