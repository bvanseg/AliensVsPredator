package org.alien.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import org.alien.common.entity.ai.selector.EntitySelectorAvoid;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.xenomorph.EntityChestburster;
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
public class ChestbursterBrain extends AbstractEntityBrain<EntityChestburster> {
	public ChestbursterBrain(EntityChestburster entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));

		// Brain Tasks
		EntityChestburster entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIAvoidEntity<>(entity, EntityLivingBase.class, EntitySelectorAvoid.instance, 8.0F, 0.4F, 0.7F)));
		this.addTask(new AttackOnCollideBrainTask(0.800000011920929D));
		this.addTask(new WanderBrainTask(0.800000011920929D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIAttackMelee(entity, 0.8F, false)));
		this.addTask(new LeapAtTargetBrainTask(0.8F));
	}
}
