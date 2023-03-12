package org.avp.common.brain;

import org.avp.common.brain.flag.AbstractBrainFlag;
import org.avp.common.brain.flag.BrainFlagState;
import org.avp.common.brain.flag.BrainMemoryFlag;
import org.avp.common.brain.impl.BrainFlags;
import org.avp.common.brain.memory.BrainMemoryKey;
import org.avp.common.brain.memory.BrainMemoryMap;
import org.avp.common.brain.sensor.AbstractBrainSensor;
import org.avp.common.brain.task.AbstractBrainTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A logical processor with input (sensors) and output/results (tasks). The processing pipeline is as follows:
 * <ol>
 * <li>Gather external input.</li>
 * <li>Memorize important input data for later use.</li>
 * <li>Run tasks, presuming the task's flag requirements are met.</li>
 * <li>Produce results from tasks (manifested as observable behavior in the game world).</li>
 * <li>Repeat.</li>
 * </ol>
 * This class has benefits over Minecraft's AI system in the following ways:
 * <ul>
 * <li>It is tick-efficient (no redundant entity scans).</li>
 * <li>It has a more flexible requirement system (Minecraft's old AI system uses mutex bits and interrupts to create priority.</li>
 * This implementation abstracts over mutex bits in a human-readable way, and allows for more complex masking of flags).</li>
 * <li>It separates concerns. Minecraft tasks try to accomplish too much, and as a result can easily become bloated with not much room
 * for reduction.</li>
 * </ul>
 * The trade-off in this case for processing speed is memory.
 * 
 * @author Boston Vanseghi
 *
 */
public abstract class AbstractBrain<T extends AbstractBrainContext> {
	private final BrainMemoryMap memoryManager;
	private final ArrayList<AbstractBrainSensor<T>> sensors;
	private final ArrayList<AbstractBrainTask<T>> tasks;
	private final HashMap<AbstractBrainFlag, BrainFlagState> brainFlagStates;
	
	protected AbstractBrain() {
		this.memoryManager = new BrainMemoryMap();
		this.sensors = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.brainFlagStates = new HashMap<>();
	}

	public void init() {}
	
	public final void update(T ctx) {
		sensors.forEach(sensor -> sensor.sense(ctx));
		tasks.forEach(task -> {
			if (this.canRunTask(task)) {
				task.runTask(ctx);
			}
		});
	}
	
	public final void addSense(AbstractBrainSensor<T> brainSensor) {
		sensors.add(brainSensor);
	}
	
	public final void addTask(AbstractBrainTask<T> brainTask) {
		tasks.add(brainTask);
	}
	
	public final boolean canRunTask(AbstractBrainTask<T> brainTask) {
		Map<AbstractBrainFlag, BrainFlagState> requirements = brainTask.getFlags();

		return requirements.entrySet().stream().allMatch(entry -> {
			// If the flag type is derived from brain memory, we need to additionally check that the memory is present.
			boolean memoryPresent = !(entry.getKey() instanceof BrainMemoryFlag) || this.memoryManager.hasMemory(((BrainMemoryFlag) entry.getKey()).getMemoryKey());
			
			// Same as before, but this time for memory absence.
			boolean memoryAbsent = !(entry.getKey() instanceof BrainMemoryFlag) || !this.memoryManager.hasMemory(((BrainMemoryFlag) entry.getKey()).getMemoryKey());
			
			switch (entry.getValue())  {
				case PRESENT:
					return this.brainFlagStates.get(entry.getKey()) == requirements.get(entry.getKey()) && memoryPresent;
				case ABSENT:
					return (!this.brainFlagStates.containsKey(entry.getKey()) || this.brainFlagStates.get(entry.getKey()) == BrainFlagState.ABSENT) && memoryAbsent;
				default:
					return true;
			}
		});
	}
	
	public <U> Optional<U> getMemory(BrainMemoryKey<? super U> memoryKey) {
		return this.memoryManager.getMemory(memoryKey);
	}
	
	public final <U> void remember(BrainMemoryKey<?> memoryKey, U data) {
		this.memoryManager.remember(memoryKey, data);
		
		if (data != null) {
			AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
			
			if (flag != null) {
				this.brainFlagStates.put(flag, BrainFlagState.PRESENT);
			}
		}
	}
	
	public final boolean hasMemory(BrainMemoryKey<?> memoryKey) {
		boolean hasMemory = this.memoryManager.hasMemory(memoryKey);
		AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
		
		if (flag != null) {
			this.brainFlagStates.put(flag, hasMemory ? BrainFlagState.PRESENT : BrainFlagState.ABSENT);
		}
		
		return hasMemory;
	}
	
	public final void forget(BrainMemoryKey<?> memoryKey) {
		this.memoryManager.forget(memoryKey);
		
		AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
		
		if (flag != null) {
			this.brainFlagStates.put(flag, BrainFlagState.ABSENT);
		}
	}
}
