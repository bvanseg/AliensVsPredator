package org.alien.common.entity.ai.brain.xenomorph;

import org.alien.common.entity.ai.brain.AlienBrain;
import org.alien.common.entity.ai.brain.task.ovamorph.HatchBrainTask;
import org.alien.common.entity.ai.brain.task.ovamorph.RequestMoveBrainTask;
import org.alien.common.entity.ai.brain.task.ovamorph.UpdateOpenProgressBrainTask;
import org.alien.common.entity.ai.brain.task.ovamorph.UpdateTimeUntilOpenBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;
import org.lib.brain.impl.task.NearestAttackableTargetBrainTask;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class OvamorphBrain extends AlienBrain<EntityOvamorph> {
	public OvamorphBrain(EntityOvamorph entity) {
		super(entity);
	}

	@Override
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1));
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorParasitoid.instance));
	}

	@Override
	public void initTasks() {
		super.initTasks();

		// Egg pipeline: Find Target -> wait a bit until open -> open -> hatch
		this.addTask(new NearestAttackableTargetBrainTask());
		this.addTask(new UpdateTimeUntilOpenBrainTask());
		this.addTask(new UpdateOpenProgressBrainTask());
		this.addTask(new HatchBrainTask());

		// Additional behaviors.
		this.addTask(new RequestMoveBrainTask());
	}

	@Override
	public void update() {
		super.update();

		if (!this.getEntity().containsFacehugger()) {
			this.disableAllProfiles();
		}
	}
}
