package org.prometheus.common.entity.ai.brain.parasitoid;

import org.alien.common.entity.ai.brain.parasitoid.ParasitoidBrain;
import org.prometheus.common.entity.ai.brain.task.UpdateHangingPositionBrainTask;
import org.prometheus.common.entity.living.vardic.EntityOctohugger;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class OctohuggerBrain extends ParasitoidBrain {
	public OctohuggerBrain(EntityOctohugger entity) {
		super(entity);
	}

	@Override
	public void initTasks() {
		super.initTasks();

		this.addTask(new UpdateHangingPositionBrainTask());
	}

	@Override
	public void initParasiteTasks() { /* Do Nothing */ }
}
