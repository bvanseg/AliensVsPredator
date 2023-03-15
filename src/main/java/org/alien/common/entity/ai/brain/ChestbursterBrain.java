package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.FindFoodBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorAvoid;
import org.alien.common.entity.living.xenomorph.EntityChestburster;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAvoidTargetBrainSensor;
import org.lib.brain.impl.task.*;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class ChestbursterBrain extends AbstractEntityBrain<EntityChestburster> {
	public ChestbursterBrain(EntityChestburster entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		// TODO:
//		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));
		this.addSense(new NearestAvoidTargetBrainSensor(1, EntitySelectorAvoid.instance));

		// Brain Tasks
		EntityChestburster entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AvoidNearestAvoidTargetBrainTask(8.0F, 0.4F, 0.7F));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		// TODO:
//		this.addTask(new NearestAttackableTargetBrainTask());
		// TODO:
//		this.addTask(new BrainTaskAdapter(new EntityAIAttackMelee(entity, 0.8F, false)));
		this.addTask(new LeapAtTargetBrainTask(0.8F));
		this.addTask(new FindFoodBrainTask());
	}
}
