package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.matriarch.GrowOvipositorBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchEnthrallAlienBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchMoveToHiveCoreBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchReproduceBrainTask;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.lib.brain.impl.profile.BrainProfiles;

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
		this.addTask(new GrowOvipositorBrainTask(), BrainProfiles.STANDARD, BrainProfiles.MATRIARCH_REPRODUCING);
		this.addTask(new MatriarchReproduceBrainTask(), BrainProfiles.MATRIARCH_REPRODUCING);
		this.addTask(new MatriarchEnthrallAlienBrainTask(), BrainProfiles.MATRIARCH_REPRODUCING);
	}
}
