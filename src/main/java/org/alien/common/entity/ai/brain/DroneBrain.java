package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.BuildHiveBrainTask;
import org.alien.common.entity.living.SpeciesXenomorph;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class DroneBrain extends XenomorphBrain {
	public DroneBrain(SpeciesXenomorph entity) {
		super(entity);
	}

	@Override
	public void init() {
		super.init();

		// Drone-specific tasks.
		this.addTask(new BuildHiveBrainTask());
	}
}
