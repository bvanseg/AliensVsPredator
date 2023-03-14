package org.alien.common.entity.ai.brain;

import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.ai.selector.EntitySelectorGooMutant;
import org.alien.common.entity.living.vardic.EntityGooMutant;
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
public class GooMutantBrain extends AbstractEntityBrain<EntityGooMutant> {
	public GooMutantBrain(EntityGooMutant entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorGooMutant.instance));

		// Brain Tasks
		EntityGooMutant entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AttackOnCollideBrainTask(1.0D));
		// TODO:
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 1.0D)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveThroughVillage(entity, 1.0D, false)));
		this.addTask(new BrainTaskAdapter(new EntityAIMoveTowardsRestriction(entity, 1.0D)));

		this.addTask(new WanderBrainTask(1.0D));
		this.addTask(new WatchClosestBrainTask(EntityPlayer.class, 8.0F));
		this.addTask(new LookIdleBrainTask());
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
