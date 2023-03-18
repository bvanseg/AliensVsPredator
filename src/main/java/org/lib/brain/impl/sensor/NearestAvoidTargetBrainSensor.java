package org.lib.brain.impl.sensor;

import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.sensor.AbstractBrainSensor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class NearestAvoidTargetBrainSensor extends AbstractBrainSensor<EntityBrainContext> {

	private final int cooldownInTicks;
    private final Predicate<Entity> avoidTargetPredicate;

	public NearestAvoidTargetBrainSensor(int cooldownInTicks, Predicate<Entity> avoidTargetPredicate) {
		this.cooldownInTicks = cooldownInTicks;
    	this.avoidTargetPredicate = avoidTargetPredicate;
	}
	

	@Override
	public void sense(EntityBrainContext ctx) {
		// Use ticksExisted instead of world time here so that entities don't have synchronized AI execution.
		if (ctx.getEntity().ticksExisted % cooldownInTicks != 0) {
			return;
		}
		
		Optional<List<Entity>> entitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.ENTITIES);

		if (entitiesOptional.isPresent()) {
			List<Entity> entities = entitiesOptional.get();
			List<Entity> targets = entities.stream().filter(avoidTargetPredicate).collect(Collectors.toList());

			if (!targets.isEmpty()) {
		        ctx.getBrain().remember(BrainMemoryKeys.NEAREST_AVOID_TARGET, targets.get(0));
			} else {
				ctx.getBrain().forget(BrainMemoryKeys.NEAREST_AVOID_TARGET);
			}
		}
	}
}
