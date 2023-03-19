package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.matriarch.GrowOvipositorBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchEnthrallAlienBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchMoveToHiveCoreBrainTask;
import org.alien.common.entity.ai.brain.task.matriarch.MatriarchReproduceBrainTask;
import org.alien.common.entity.ai.selector.EntitySelectorXenomorph;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.lib.brain.impl.profile.BrainProfiles;
import org.lib.brain.impl.sensor.EntityBrainSensor;
import org.lib.brain.impl.sensor.NearestAttackableTargetBrainSensor;

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
	public void initSenses() {
		this.addSense(new EntityBrainSensor(1), BrainProfiles.STANDARD, BrainProfiles.MATRIARCH_REPRODUCING);
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorXenomorph.instance));
	}

	@Override
	public void initTasks() {
		super.initTasks();
		this.addTask(new MatriarchMoveToHiveCoreBrainTask());
		this.addTask(new MatriarchEnthrallAlienBrainTask(), BrainProfiles.STANDARD, BrainProfiles.MATRIARCH_REPRODUCING);
		this.addTask(new GrowOvipositorBrainTask(), BrainProfiles.STANDARD, BrainProfiles.MATRIARCH_REPRODUCING);
		this.addTask(new MatriarchReproduceBrainTask(), BrainProfiles.MATRIARCH_REPRODUCING);
	}
}
