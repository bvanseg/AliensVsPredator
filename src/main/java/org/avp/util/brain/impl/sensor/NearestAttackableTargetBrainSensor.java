package org.avp.util.brain.impl.sensor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.avp.util.brain.impl.BrainMemoryKeys;
import org.avp.util.brain.impl.EntityBrainContext;
import org.avp.util.brain.sensor.AbstractBrainSensor;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

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
			List<EntityLivingBase> targets = livingEntities.stream().filter((e) -> targetPredicate.apply(e)).collect(Collectors.toList());

			if (!targets.isEmpty()) {
		        ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET, targets.get(0));
			}
		}
        
	}

}
