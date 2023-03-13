package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.EntityAIFacehuggerLeap;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.lib.brain.task.BrainTaskAdapter;

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
		this.addTask(new BrainTaskAdapter(new EntityAIFacehuggerLeap(this.getEntity())));
	}
}
