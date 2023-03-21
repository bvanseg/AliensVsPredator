package org.alien.common.entity.ai.brain.parasitoid;

import org.alien.common.entity.ai.brain.task.FacehuggerLeapAtTargetBrainTask;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FacehuggerBrain extends ParasitoidBrain {
	public FacehuggerBrain(EntityFacehugger entity) {
		super(entity);
	}

	@Override
	public void initParasiteTasks() {
		this.addTask(new FacehuggerLeapAtTargetBrainTask());
	}
}
