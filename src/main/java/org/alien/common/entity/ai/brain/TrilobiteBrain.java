package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.selector.EntitySelectorTrilobite;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;

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
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new LeapAtTargetBrainTask(0.85F));
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
