package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.EntityAIFacehuggerLeap;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.AttackOnCollideBrainTask;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;
import org.lib.brain.impl.task.SwimBrainTask;
import org.lib.brain.impl.task.WanderBrainTask;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FacehuggerBrain extends ParasitoidBrain {
	public FacehuggerBrain(EntityFacehugger entity) {
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
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIFacehuggerLeap(this.getEntity())));
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
