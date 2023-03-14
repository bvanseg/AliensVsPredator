package org.predator.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;
import org.predator.common.entity.ai.selector.EntitySelectorYautja;
import org.predator.common.entity.living.EntityPredatorHound;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class HoundBrain extends AbstractEntityBrain<EntityPredatorHound> {
	public HoundBrain(EntityPredatorHound entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		// TODO: Use correct selector here.
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorYautja.instance));

		// Brain Tasks
		EntityPredatorHound entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 5.5D)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveThroughVillage(entity, 5.5D, false)));

		this.addTask(new WanderBrainTask(1.0D));
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16.0F));
		this.addTask(new LookIdleBrainTask());

		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
