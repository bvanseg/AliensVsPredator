package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.MatriarchMoveToHiveCoreBrainTask;
import org.alien.common.entity.living.SpeciesXenomorph;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class MatriarchBrain extends XenomorphBrain {
	public MatriarchBrain(SpeciesXenomorph entity) {
		super(entity);
	}

	@Override
	public void init() {
		super.init();

		// Brain Senses


		// Brain Tasks
		this.addTask(new MatriarchMoveToHiveCoreBrainTask());
	}
}
