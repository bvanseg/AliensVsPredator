package org.lib.brain;

import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.flag.BrainMemoryFlag;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.memory.BrainMemoryKey;
import org.lib.brain.memory.BrainMemoryMap;
import org.lib.brain.sensor.AbstractBrainSensor;
import org.lib.brain.task.AbstractBrainTask;

import java.util.*;
import java.util.stream.Collectors;

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
	private final HashMap<AbstractBrainFlag, AbstractBrainTask<T>> brainFlagUsers;

	private boolean isDisabled = false;
	
	protected AbstractBrain() {
		this.memoryManager = new BrainMemoryMap();
		this.sensors = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.brainFlagStates = new HashMap<>();
		this.brainFlagUsers = new HashMap<>();
	}

	public void init() {}
	
	public final void update(T ctx) {
		if (this.isDisabled)
			return;

		sensors.forEach(sensor -> sensor.sense(ctx));
		tasks.forEach(task -> {
			if (this.canRunTask(task)) {
				task.runTask(ctx);

				if (task.isExecuting()) {
					// Tasks will reserve the flag under their hash so that they can still run while the flags are present.
					this.setFlagMasksForTask(task);
				}
			}
			// If the flag states change, and we weren't able to run the task, but the task is still executing, we need to finish the task.
			else if (task.isExecuting()) {
				task.finish(ctx);
				task.setExecuting(false);

				// Revert flag masks that the task used back to normal once the task is done.
				if (!task.isExecuting()) {
					this.clearFlagMasksForTask(task);
				}
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
		// Do not interrupt.
		if (brainTask.isExecuting())
			return true;

		Map<AbstractBrainFlag, BrainFlagState> requirements = brainTask.getFlagRequirements();

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

	private void setFlagMasksForTask(AbstractBrainTask<T> brainTask) {
		Map<AbstractBrainFlag, BrainFlagState> flagMasks = brainTask.getFlagMasks();

		flagMasks.forEach((key, value) -> {
			this.brainFlagStates.put(key, value);
			this.brainFlagUsers.put(key, brainTask);
		});
	}

	public void clearFlagMasksForTask(AbstractBrainTask<?> brainTask) {
		Map<AbstractBrainFlag, BrainFlagState> flagMasks = brainTask.getFlagMasks().entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().inverse()));

		flagMasks.forEach((key, value) -> {
			this.brainFlagStates.put(key, value);
			this.brainFlagUsers.remove(key);
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

	public List<AbstractBrainSensor<T>> getSensors() {
		return sensors;
	}

	public List<AbstractBrainTask<T>> getTasks() {
		return tasks;
	}

	public void setDisabled(boolean disabled) {
		this.isDisabled = disabled;
	}
}
