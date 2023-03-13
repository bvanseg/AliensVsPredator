package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import org.alien.common.entity.ai.selector.EntitySelectorTrilobite;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class TrilobiteBrain extends AbstractEntityBrain<EntityTrilobite> {
	public TrilobiteBrain(EntityTrilobite entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorTrilobite.instance));

		// Brain Tasks
		EntityTrilobite entity = this.getEntity();
		this.addTask(new BrainTaskAdapter(new EntityAISwimming(entity)));
		this.addTask(new BrainTaskAdapter(new EntityAICustomAttackOnCollide(entity, 0.800000011920929D, true)));
		this.addTask(new BrainTaskAdapter(new PatchedEntityAIWander(entity, 0.800000011920929D)));
		this.addTask(new BrainTaskAdapter(new EntityAIHurtByTarget(entity, true)));
		this.addTask(new BrainTaskAdapter(new EntityAILeapAtTarget(entity, 0.85F)));
		this.addTask(new BrainTaskAdapter(new EntityAINearestAttackableTarget<>(entity, EntityLivingBase.class, 0, false, false, EntitySelectorTrilobite.instance)));
	}
}
