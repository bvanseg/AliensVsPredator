package org.lib.brain.task;

import org.lib.brain.AbstractBrainContext;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;

import java.util.Collections;
import java.util.Map;

/**
 * Represents a task to execute. Tasks are ran after all sensors are ran, and have access to the brain
 * through the passed in AbstractBrainContext ctx method parameters. From that context, memories can be read
 * or manipulated to help the task achieve its goal.
 * 
 * @author Boston Vanseghi
 *
 */
public abstract class AbstractBrainTask<T extends AbstractBrainContext> {

	private boolean isDisabled = false;
	private boolean isExecuting = false;

	public T ctx;
	
	public boolean runTask() {
		if (this.isDisabled) return false;

		if (!this.isExecuting && this.shouldExecute()) {
			this.startExecuting();
			// Update isExecuting state after execute so that isExecuting is false for the first execution.
			this.isExecuting = true;
		}

		if (this.isExecuting) {
			if (this.shouldContinueExecuting()) {
				this.continueExecuting();
			} else {
				this.finish();
				this.isExecuting = false;
			}
		}

		return this.isExecuting;
	}
	
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return Collections.emptyMap();
	}

	public Map<AbstractBrainFlag, BrainFlagState> getFlagMasks() { return Collections.emptyMap(); }

	protected abstract boolean shouldExecute();
	protected boolean shouldContinueExecuting() { return this.shouldExecute(); }
	protected abstract void startExecuting();
	protected void continueExecuting() { this.startExecuting(); }
	public void finish() {}

	public boolean isExecuting() { return this.isExecuting; }

	public void setExecuting(boolean executing) {
		isExecuting = executing;
	}

	public void setDisabled(boolean disabled) {
		isDisabled = disabled;
	}
}
