package org.alien.common.entity.ai.brain;

import org.alien.common.entity.ai.brain.task.xenomorph.RamTowardsTargetBrainTask;
import org.alien.common.entity.living.xenomorph.EntityCrusher;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class CrusherBrain extends XenomorphBrain {
	public CrusherBrain(EntityCrusher entity) {
		super(entity);
	}

	@Override
	public void initTasks() {
		super.initTasks();
		this.addTask(new RamTowardsTargetBrainTask());
	}
}
