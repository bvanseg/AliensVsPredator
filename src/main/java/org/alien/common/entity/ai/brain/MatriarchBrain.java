package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.matriarch.GrowOvipositorBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchEnthrallAlienBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchMoveToHiveCoreBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchReproduceBrainTask;
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
		this.addTask(new MatriarchMoveToHiveCoreBrainTask());
		this.addTask(new GrowOvipositorBrainTask());
		this.addTask(new MatriarchReproduceBrainTask());
		this.addTask(new MatriarchEnthrallAlienBrainTask());
	}
}
