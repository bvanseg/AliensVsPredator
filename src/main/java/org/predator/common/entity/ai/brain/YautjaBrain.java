package org.predator.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;
import org.predator.common.entity.ai.EntityAISuperjump;
import org.predator.common.entity.ai.selector.EntitySelectorYautja;
import org.predator.common.entity.living.SpeciesYautja;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class YautjaBrain extends AbstractEntityBrain<SpeciesYautja> {
	public YautjaBrain(SpeciesYautja entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorYautja.instance));

		// Brain Tasks
		SpeciesYautja entity = this.getEntity();
//      this.tasks.addTask(0, new EntityAISwimming(this));
		this.addTask(new AttackOnCollideBrainTask(0.9D));
		this.addTask(new WanderBrainTask(0.6D));
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAISuperjump(entity, 1.0F)));

//		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsTarget(entity, 0.9D, 48)));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
