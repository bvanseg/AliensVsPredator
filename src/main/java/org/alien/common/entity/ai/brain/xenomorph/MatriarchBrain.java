package org.alien.common.entity.ai.brain.xenomorph;

import org.alien.common.entity.ai.brain.task.matriarch.*;
import org.alien.common.entity.ai.selector.EntitySelectorMatriarch;
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
		this.addSense(new NearestAttackableTargetBrainSensor(1, EntitySelectorMatriarch.instance));
	}

	@Override
	public void initTasks() {
		super.initTasks();
		this.addTask(new MatriarchMoveToHiveCoreBrainTask());
		this.addTask(new FindEgglayingPositionBrainTask(), BrainProfiles.STANDARD);
		this.addTask(new GrowOvipositorBrainTask(), BrainProfiles.STANDARD, BrainProfiles.MATRIARCH_REPRODUCING);
		this.addTask(new MatriarchEnthrallAlienBrainTask(), BrainProfiles.STANDARD, BrainProfiles.MATRIARCH_REPRODUCING);
		this.addTask(new MatriarchReproduceBrainTask(), BrainProfiles.MATRIARCH_REPRODUCING);
	}
}
