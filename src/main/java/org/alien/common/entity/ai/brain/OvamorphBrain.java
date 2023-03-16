package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.ovamorph.HatchBrainTask;
import org.alien.common.entity.ai.brain.task.ovamorph.UpdateOpenProgressBrainTask;
import org.alien.common.entity.ai.brain.task.ovamorph.UpdateTimeUntilOpenBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.lib.brain.impl.AbstractEntityBrain;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class OvamorphBrain extends AbstractEntityBrain<EntityOvamorph> {
	public OvamorphBrain(EntityOvamorph entity) {
		super(entity);
	}

	@Override
	public void init() {
		// Brain Senses
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));

		// Brain Tasks

		// Egg pipeline: Find Target -> wait a bit until open -> open -> hatch
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new UpdateTimeUntilOpenBrainTask());
		this.addTask(new UpdateOpenProgressBrainTask());
		this.addTask(new HatchBrainTask());
	}
}
