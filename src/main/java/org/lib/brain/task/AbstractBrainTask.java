package org.lib.brain.task;

import org.lib.brain.AbstractBrainContext;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;

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
	
	private boolean isExecuting = false;
	
	public void runTask(T ctx) {
		boolean shouldExecute = this.shouldExecute(ctx);
		if (shouldExecute) {
			this.execute(ctx);
			// Update isExecuting state after execute so that isExecuting is false for the first execution.
			this.isExecuting = true;
		}
		
		if (this.isExecuting && !shouldExecute) {
			this.finish(ctx);
			this.isExecuting = false;
		}
	}
	
	public abstract Map<AbstractBrainFlag, BrainFlagState> getFlags();
	protected abstract boolean shouldExecute(T ctx);
	protected abstract void execute(T ctx);
	protected void finish(T ctx) {}

	public boolean isExecuting() { return this.isExecuting; }
}
