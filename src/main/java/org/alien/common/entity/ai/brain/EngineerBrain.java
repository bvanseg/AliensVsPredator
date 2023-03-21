package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.selector.EntitySelectorEngineer;
import org.alien.common.entity.living.SpeciesEngineer;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class EngineerBrain extends AbstractEntityBrain<SpeciesEngineer> {
	public EngineerBrain(SpeciesEngineer entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorEngineer.instance));
	}

	@Override
	public void initTasks() {
		SpeciesEngineer entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new LeapAtTargetBrainTask(0.4F));
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
