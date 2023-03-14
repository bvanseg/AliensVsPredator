package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.AttachedToHostBrainTask;
import org.alien.common.entity.ai.brain.task.UpdateInfertileStateBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.EntityParasitoid;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;

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
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new AttachedToHostBrainTask());
		this.addTask(new UpdateInfertileStateBrainTask());

		this.initParasiteTasks();
	}

	public void initParasiteTasks() {
		this.addTask(new LeapAtTargetBrainTask(0.8F));
	}
}
