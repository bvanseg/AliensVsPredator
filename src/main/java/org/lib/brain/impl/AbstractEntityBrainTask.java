package org.lib.brain.impl;

import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public abstract class AbstractEntityBrainTask extends AbstractBrainTask<EntityBrainContext> {
	private static final HashMap<Class<? extends AbstractEntityBrainTask>, HashMap<AbstractBrainFlag, BrainFlagState>> FLAG_REQUIREMENTS = new HashMap<>();

	protected AbstractEntityBrainTask() {
		super();

		if (!FLAG_REQUIREMENTS.containsKey(this.getClass())) {
			FLAG_REQUIREMENTS.computeIfAbsent(this.getClass(), key -> {
				HashMap<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
				this.setFlagRequirements(map);
				return map;
			});
		}
	}

	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {}

	@Override
	public final Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return FLAG_REQUIREMENTS.get(this.getClass());
	}
}
