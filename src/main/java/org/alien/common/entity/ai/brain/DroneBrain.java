package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.xenomorph.BuildHiveBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.MoveToHiveCoreBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.RecycleAlienBrainTask;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;

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
	public void initTasks() {
		super.initTasks();
		this.addTask(new BuildHiveBrainTask());
		this.addTask(new RecycleAlienBrainTask<>(EntityOvamorph.class, ovamorph -> !ovamorph.containsFacehugger()));
		this.addTask(new RecycleAlienBrainTask<>(EntityFacehugger.class, facehugger -> !facehugger.isFertile() && !facehugger.isAttachedToHost()));
		this.addTask(new MoveToHiveCoreBrainTask());
	}
}
