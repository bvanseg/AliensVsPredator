package org.lib.brain.impl.sensor;

import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.sensor.AbstractBrainSensor;

import java.util.ArrayList;

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
	

	@Override
	public void sense(EntityBrainContext ctx) {
		// Use ticksExisted instead of world time here so that entities don't have synchronized AI execution.
		if (ctx.getEntity().ticksExisted % cooldownInTicks != 0) {
			return;
		}

		ArrayList<BlockPos> positionsOfInterest = new ArrayList<>();

		// Searches in a growing radius around the entity, starting at the entity's position. Also searches a block pos
		// up and a block pos down.
		for (int i = 0; i < range; i++) {
			int startX = -i;
			int startZ = -i;

			for (int y = -1; y < 2; y++) {
				for (int x = startX; x <= i; x++) {
					if (x == -i) {
						for (int z = startZ; z < i; z++) {
							validateBlock(ctx, ctx.getEntity().getPosition().add(x, y, z), positionsOfInterest);
						}
					}
					if (x == i) {
						for (int z = startZ; z < i; z++) {
							validateBlock(ctx, ctx.getEntity().getPosition().add(x, y, z), positionsOfInterest);
						}
					}
				}

				for (int z = startZ; z <= i; z++) {
					if (z == -i) {
						for (int x = startX; x < i; x++) {
							validateBlock(ctx, ctx.getEntity().getPosition().add(x, y, z), positionsOfInterest);
						}
					}
					if (z == i) {
						for (int x = startX; x <= i; x++) {
							validateBlock(ctx, ctx.getEntity().getPosition().add(x, y, z), positionsOfInterest);
						}
					}
				}
			}
		}

		// Block positions sorted by distance to be closest to context entity.
		positionsOfInterest.sort((e1, e2) -> {
			double d1 = ctx.getEntity().getDistanceSq(e1);
			double d2 = ctx.getEntity().getDistanceSq(e2);

			if (d1 < d2) {
				return -1;
			} else if (d1 > d2) {
				return 1;
			}

			return 0;
		});

		ctx.getBrain().remember(BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST, positionsOfInterest);
	}

	private void validateBlock(EntityBrainContext ctx, BlockPos pos, ArrayList<BlockPos> positionsOfInterest) {
		Block block = ctx.getEntity().world.getBlockState(pos).getBlock();
		if (blockPredicate.test(block)) {
			positionsOfInterest.add(pos);
		}
	}
}
