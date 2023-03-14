package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.selector.EntitySelectorHammerpede;
import org.alien.common.entity.living.vardic.EntityHammerpede;
import org.lib.brain.impl.AbstractEntityBrain;
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
public class HammerpedeBrain extends AbstractEntityBrain<EntityHammerpede> {
	public HammerpedeBrain(EntityHammerpede entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorHammerpede.instance));

		// Brain Tasks
		EntityHammerpede entity = this.getEntity();
		this.addTask(new SwimBrainTask(entity));
		this.addTask(new AttackOnCollideBrainTask(0.8D));
		this.addTask(new HurtByTargetBrainTask());
		this.addTask(new NearestAttackableTargetBrainTask());
	}
}
