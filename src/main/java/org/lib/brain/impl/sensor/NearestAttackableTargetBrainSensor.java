package org.lib.brain.impl.sensor;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
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
public class NearestAttackableTargetBrainSensor extends AbstractBrainSensor<EntityBrainContext> {
	
	private final int cooldownInTicks;
    private final Predicate<EntityLivingBase> targetPredicate;
	
	public NearestAttackableTargetBrainSensor(int cooldownInTicks, Predicate<EntityLivingBase> targetPredicate) {
		this.cooldownInTicks = cooldownInTicks;
    	this.targetPredicate = targetPredicate;
	}
	

	@Override
	public void sense(EntityBrainContext ctx) {
		// Use ticksExisted instead of world time here so that entities don't have synchronized AI execution.
		if (ctx.getEntity().ticksExisted % cooldownInTicks != 0) {
			return;
		}
		
		Optional<List<EntityLivingBase>> livingEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.LIVING_ENTITIES);

		if (livingEntitiesOptional.isPresent()) {
			List<EntityLivingBase> livingEntities = livingEntitiesOptional.get();
			List<EntityLivingBase> targets = livingEntities.stream().filter(targetPredicate::apply).collect(Collectors.toList());

			if (!targets.isEmpty()) {
		        ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET, targets.get(0));
			} else {
				ctx.getBrain().forget(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
			}
		}
	}
}
