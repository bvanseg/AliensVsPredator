package org.prometheus.common.entity.ai.brain;

import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.ai.brain.AlienBrain;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.prometheus.common.entity.living.species223ode.EntityDeaconAdult;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.*;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class DeaconAdultBrain extends AlienBrain<EntityDeaconAdult> {
	public DeaconAdultBrain(EntityDeaconAdult entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
	}

	@Override
	public void initTasks() {
		super.initTasks();

		EntityDeaconAdult entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new WanderBrainTask(0.8D));
		this.addTask(new AttackOnCollideBrainTask(1.0D));
		this.addTask(new WatchClosestBrainTask(EntityLivingBase.class, 16F));
		this.addTask(new LeapAtTargetBrainTask(0.6F));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
