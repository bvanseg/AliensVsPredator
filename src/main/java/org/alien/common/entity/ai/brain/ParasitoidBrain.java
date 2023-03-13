package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.EntityParasitoid;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.AttackOnCollideBrainTask;
import org.lib.brain.impl.task.LeapAtTargetBrainTask;
import org.lib.brain.impl.task.SwimBrainTask;
import org.lib.brain.impl.task.WanderBrainTask;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class ParasitoidBrain extends AbstractEntityBrain<EntityParasitoid> {
	public ParasitoidBrain(EntityParasitoid entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));

		// Brain Tasks
		this.addTask(new SwimBrainTask(this.getEntity()));
		this.addTask(new AttackOnCollideBrainTask(0.55D));
		this.addTask(new WanderBrainTask(0.55D));
		this.addTask(new LeapAtTargetBrainTask(0.8F));
		// this.addTask(new EntityAINearestAttackableTarget<>(this, Entity.class, 0, false, false, this.getEntitySelector()));
	}
}
