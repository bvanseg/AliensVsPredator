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
	
	public void runTask(T ctx) {
		if (this.isDisabled) return;

		if (this.isExecuting) {
			if (this.shouldContinueExecuting(ctx)) {
				this.continueExecuting(ctx);
			} else {
				this.finish(ctx);
				this.isExecuting = false;
			}
		}

		if (!this.isExecuting && this.shouldExecute(ctx)) {
			this.startExecuting(ctx);
			// Update isExecuting state after execute so that isExecuting is false for the first execution.
			this.isExecuting = true;
		}
	}
	
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return Collections.emptyMap();
	}

	public Map<AbstractBrainFlag, BrainFlagState> getFlagMasks() { return Collections.emptyMap(); }

	protected abstract boolean shouldExecute(T ctx);
	protected boolean shouldContinueExecuting(T ctx) { return this.shouldExecute(ctx); }
	protected abstract void startExecuting(T ctx);
	protected void continueExecuting(T ctx) { this.startExecuting(ctx); }
	public void finish(T ctx) {}

	public boolean isExecuting() { return this.isExecuting; }

	public void setExecuting(boolean executing) {
		isExecuting = executing;
	}

	public void setDisabled(boolean disabled) {
		isDisabled = disabled;
	}
}
