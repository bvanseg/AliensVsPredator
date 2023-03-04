package org.avp.util.brain.impl;

import org.avp.entities.ai.alien.EntitySelectorXenomorph;
import org.avp.util.brain.AbstractBrain;
import org.avp.util.brain.impl.sensor.EntityBrainSensor;
import org.avp.util.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.avp.util.brain.impl.task.AttackOnCollideBrainTask;
import org.avp.util.brain.impl.task.FindJellyBrainTask;
import org.avp.util.brain.impl.task.NearestAttackableTargetBrainTask;
import org.avp.util.brain.impl.task.WanderBrainTask;
import org.avp.util.brain.impl.task.WatchClosestBrainTask;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class XenomorphBrain extends AbstractBrain<EntityBrainContext> {
	
	public XenomorphBrain(EntityLivingBase entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Senses
		this.addSense(new EntityBrainSensor(10));
		this.addSense(new NearestAttackableTargetBrainSensor(4, EntitySelectorXenomorph.instance));
		
		// Tasks
		this.addTask(new WanderBrainTask(0.8D));
		this.addTask(new FindJellyBrainTask());
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new AttackOnCollideBrainTask(1.0D));
	}
}
