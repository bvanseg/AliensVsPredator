package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import org.alien.common.entity.living.vardic.EntityUrsuidae;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;
import org.lib.brain.task.BrainTaskAdapter;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class UrsuidaeBrain extends AbstractEntityBrain<EntityUrsuidae> {
	public UrsuidaeBrain(EntityUrsuidae entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		// TODO: Fix this predicate!
		this.addSense(new NearestAttackableTargetBrainSensor(1, e -> true));
	}

	@Override
	public void initTasks() {
		EntityUrsuidae entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 0.55D)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveThroughVillage(entity, 0.55D, false)));

		this.addTask(new WanderBrainTask(1.0D));
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16.0F));
		this.addTask(new LookIdleBrainTask());
		this.addTask(new AttackOnCollideBrainTask(0.6D));
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
