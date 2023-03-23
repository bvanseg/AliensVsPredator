package org.lib.brain;

import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.flag.BrainMemoryFlag;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.profile.BrainProfiles;
import org.lib.brain.memory.BrainMemoryKey;
import org.lib.brain.memory.BrainMemoryMap;
import org.lib.brain.profile.BrainProfile;
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
	private final HashMap<BrainProfile, ArrayList<AbstractBrainSensor<T>>> profileSensorSets;
	private final HashMap<BrainProfile, ArrayList<AbstractBrainTask<T>>> profileTaskSets;
	private final HashMap<AbstractBrainFlag, BrainFlagState> brainFlagStates;
	private final HashSet<AbstractBrainTask<T>> executingTasks;

	private boolean isDisabled = false;

	private BrainProfile activeProfile;
	
	protected AbstractBrain() {
		this.memoryManager = new BrainMemoryMap();
		this.profileSensorSets = new HashMap<>();
		this.profileTaskSets = new HashMap<>();
		this.brainFlagStates = new HashMap<>();
		this.executingTasks = new HashSet<>();
		this.activeProfile = BrainProfiles.STANDARD;
	}

	public void init() {}
	
	public void update(T ctx) {
		if (this.isDisabled)
			return;

		profileSensorSets.computeIfAbsent(this.activeProfile, key -> new ArrayList<>()).forEach(sensor -> sensor.sense(ctx));

		profileTaskSets.computeIfAbsent(this.activeProfile, key -> new ArrayList<>()).forEach(task -> {
			if (this.canRunTask(task)) {
				if (task.runTask(ctx)) {
					this.setFlagMasksForTask(task);
				} else {
					this.clearFlagMasksForTask(task);
				}
			}
			// If the flag states change, and we weren't able to run the task, but the task is still executing, we need to finish the task.
			else if (task.isExecuting()) {
				task.finish(ctx);
				task.setExecuting(false);
				this.clearFlagMasksForTask(task);
			}
		});
	}

	public final void addSense(AbstractBrainSensor<T> brainSensor, BrainProfile... profiles) {
		Arrays.stream(profiles).forEach(
			profile -> profileSensorSets.computeIfAbsent(profile, key -> new ArrayList<>()).add(brainSensor)
		);
	}

	public final void addSense(AbstractBrainSensor<T> brainSensor) {
		this.addSense(brainSensor, BrainProfiles.STANDARD);
	}
	
	public final void addTask(AbstractBrainTask<T> brainTask, BrainProfile... profiles) {
		Arrays.stream(profiles).forEach(
			profile -> profileTaskSets.computeIfAbsent(profile, key -> new ArrayList<>()).add(brainTask)
		);
	}

	public final void addTask(AbstractBrainTask<T> brainTask) {
		this.addTask(brainTask, BrainProfiles.STANDARD);
	}

	public final boolean canRunTask(AbstractBrainTask<T> brainTask) {
		Map<AbstractBrainFlag, BrainFlagState> requirements = brainTask.getFlagRequirements();

		if (brainTask.isExecuting() && this.executingTasks.contains(brainTask)) {
			return requirements.entrySet().stream()
					.filter(entry -> entry.getKey() instanceof BrainMemoryFlag)
					.allMatch(entry -> doesCurrentStateMatchRequirement(requirements, entry));
		}

		return requirements.entrySet().stream().allMatch(entry -> doesCurrentStateMatchRequirement(requirements, entry));
	}

	private void setFlagMasksForTask(AbstractBrainTask<T> brainTask) {
		this.executingTasks.add(brainTask);
		this.brainFlagStates.putAll(brainTask.getFlagMasks());
	}

	private void clearFlagMasksForTask(AbstractBrainTask<T> brainTask) {
		this.executingTasks.remove(brainTask);
		Map<AbstractBrainFlag, BrainFlagState> inversedFlags = brainTask.getFlagMasks()
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().inverse()));
		this.brainFlagStates.putAll(inversedFlags);
	}

	private boolean doesCurrentStateMatchRequirement(Map<AbstractBrainFlag, BrainFlagState> requirements, Map.Entry<AbstractBrainFlag, BrainFlagState> entry) {
		boolean memoryPresent = true;
		boolean memoryAbsent = true;

		// If the flag type is derived from brain memory, we need to additionally check that the memory is present.
		if (entry.getKey() instanceof BrainMemoryFlag) {
			BrainMemoryFlag memoryFlag = (BrainMemoryFlag) entry.getKey();
			memoryPresent = this.hasMemory(memoryFlag.getMemoryKey());
			memoryAbsent = !memoryPresent;
		}

		switch (entry.getValue())  {
			case PRESENT:
				return this.brainFlagStates.get(entry.getKey()) == requirements.get(entry.getKey()) && memoryPresent;
			case ABSENT:
				return (!this.brainFlagStates.containsKey(entry.getKey()) || this.brainFlagStates.get(entry.getKey()) == BrainFlagState.ABSENT) && memoryAbsent;
			default:
				return true;
		}
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

	public Map<BrainProfile, ArrayList<AbstractBrainSensor<T>>> getProfileSensorSets() {
		return profileSensorSets;
	}

	public void setDisabled(boolean disabled) {
		this.isDisabled = disabled;
	}

	public final void setActiveProfile(BrainProfile profile) {
		this.activeProfile = profile;
	}

	public BrainProfile getActiveProfile() {
		return activeProfile;
	}

	public Map<BrainProfile, ArrayList<AbstractBrainTask<T>>> getProfileTaskSets() {
		return profileTaskSets;
	}
}
