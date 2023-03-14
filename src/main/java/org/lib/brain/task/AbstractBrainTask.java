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
			this.isExecuting = true;
			this.execute(ctx);
		}
		
		if (this.isExecuting && !shouldExecute) {
			this.isExecuting = false;
			this.finish(ctx);
		}
	}
	
	public abstract Map<AbstractBrainFlag, BrainFlagState> getFlags();
	protected abstract boolean shouldExecute(T ctx);
	protected abstract void execute(T ctx);
	protected void finish(T ctx) {}

	public boolean isExecuting() { return this.isExecuting; }
}
