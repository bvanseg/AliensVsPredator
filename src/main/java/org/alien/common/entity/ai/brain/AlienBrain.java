package org.alien.common.entity.ai.brain;

import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.entity.ai.brain.task.MatureBrainTask;
import org.alien.common.entity.ai.brain.task.xenomorph.ProduceJellyBrainTask;
import org.alien.common.entity.living.SpeciesAlien;
import org.lib.brain.impl.AbstractEntityBrain;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public abstract class AlienBrain<T extends SpeciesAlien> extends AbstractEntityBrain<T> {
	protected AlienBrain(T entity) {
		super(entity);
	}

	@Override
	public void initTasks() {
		super.initTasks();
		this.initJellyProductionTask();
		this.initMaturationTask();
	}

	public void initJellyProductionTask() {
		this.addTask(new ProduceJellyBrainTask<>(20, e -> {
			MaturityEntry entry = MaturityEntries.getEntryFor(e.getClass()).orElse(null);
			return entry != null && e.jellyLevel.get() < (entry.getRequiredJellyLevel() / 2);
		}));
	}

	protected void initMaturationTask() {
		this.addTask(new MatureBrainTask());
	}
}
