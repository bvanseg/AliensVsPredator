package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.world.World;
import org.alien.common.entity.living.SpeciesAlien;
import org.lib.brain.impl.AbstractEntityBrainTask;

import java.util.function.Predicate;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class ProduceJellyBrainTask<T extends SpeciesAlien> extends AbstractEntityBrainTask {

	private final Predicate<T> produceJellyPredicate;
	private final int jellyRate;

	public ProduceJellyBrainTask() {
		this(20, e -> true);
	}

	public ProduceJellyBrainTask(int jellyRate, Predicate<T> produceJellyPredicate) {
		this.jellyRate = jellyRate;
		this.produceJellyPredicate = produceJellyPredicate;
	}

	@Override
	protected boolean shouldExecute() {
		if (!(ctx.getEntity() instanceof SpeciesAlien)) {
			return false;
		}
		SpeciesAlien alien = (SpeciesAlien) ctx.getEntity();

		World world = ctx.getEntity().world;

		if (world.getTotalWorldTime() % this.jellyRate != 0) return false;

		return produceJellyPredicate.test((T) alien);
	}

	@Override
	protected void startExecuting() {
		SpeciesAlien alien = (SpeciesAlien) ctx.getEntity();
		alien.jellyLevel.increment();
	}
}
