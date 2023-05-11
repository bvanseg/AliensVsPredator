package org.prometheus.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.AlienBrain;
import org.prometheus.common.entity.ai.brain.task.LurkInBlackGooBrainTask;
import org.prometheus.common.entity.ai.selector.EntitySelectorHammerpede;
import org.prometheus.common.entity.living.vardic.EntityHammerpede;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.AttackOnCollideBrainTask;
import org.lib.brain.impl.task.HurtByTargetBrainTask;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;
import org.lib.brain.impl.task.SwimBrainTask;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class HammerpedeBrain extends AlienBrain<EntityHammerpede> {
	public HammerpedeBrain(EntityHammerpede entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorHammerpede.instance));
	}

	@Override
	public void initTasks() {
		super.initTasks();

		EntityHammerpede entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AttackOnCollideBrainTask(0.8D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());

		// Hammerpede-specific tasks
		this.addTask(new LurkInBlackGooBrainTask());
	}
}
