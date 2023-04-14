package org.lib.brain.impl.sensor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.sensor.AbstractBrainSensor;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class NearestAttackableTargetBrainSensor extends AbstractBrainSensor<EntityBrainContext> {
	
	private final int cooldownInTicks;
    private final Predicate<Entity> targetPredicate;
	
	public NearestAttackableTargetBrainSensor(int cooldownInTicks, Predicate<Entity> targetPredicate) {
		this.cooldownInTicks = cooldownInTicks;
    	this.targetPredicate = targetPredicate;
	}
	

	@Override
	public void sense() {
		// Use ticksExisted instead of world time here so that entities don't have synchronized AI execution.
		if (ctx.getEntity().ticksExisted % cooldownInTicks != 0) {
			return;
		}
		
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

		if (livingEntitiesOptional.isPresent()) {
			List<EntityLivingBase> livingEntities = livingEntitiesOptional.get();
			List<EntityLivingBase> targets = livingEntities.stream().filter(
				target -> !target.isDead &&
						target.getHealth() > 0 &&
						targetPredicate.test(target) &&
						ctx.getEntity().canEntityBeSeen(target)
			).collect(Collectors.toList());

			if (!targets.isEmpty()) {
		        ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET, targets.get(0));
			} else {
				ctx.getBrain().forget(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
			}
		}
	}
}
