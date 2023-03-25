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
	private final BitSet brainFlagStates;
	private final HashSet<AbstractBrainTask<T>> executingTasks;

	private boolean isDisabled = false;

	private final HashSet<BrainProfile> activeProfiles;
	
	protected AbstractBrain() {
		this.memoryManager = new BrainMemoryMap();
		this.profileSensorSets = new HashMap<>();
		this.profileTaskSets = new HashMap<>();
		this.brainFlagStates = new BitSet();
		this.executingTasks = new HashSet<>();
		this.activeProfiles = new HashSet<>();
		this.activeProfiles.add(BrainProfiles.STANDARD);
	}

	protected abstract T createContext();
	
	public void update() {
		if (this.isDisabled)
			return;

		this.activeProfiles.forEach(profile -> {
			profileSensorSets.computeIfAbsent(profile, key -> new ArrayList<>()).forEach(sensor -> {
				if (sensor.ctx == null) {
					throw new IllegalStateException("Brain sensor has a null context!");
				}

				sensor.sense();
			});

			profileTaskSets.computeIfAbsent(profile, key -> new ArrayList<>()).forEach(task -> {
				if (task.ctx == null) {
					throw new IllegalStateException("Brain task has a null context!");
				}

				if (this.canRunTask(task)) {
					if (task.runTask()) {
						this.setFlagMasksForTask(task);
					}
				}
				// If the flag states change, and we weren't able to run the task, but the task is still executing, we need to clean up the task.
				else if (task.isExecuting()) {
					task.finish();
				}
			});
		});

		memoryManager.forgetEverything();
	}

	public void setDisabled(boolean disabled) {
		this.isDisabled = disabled;
	}

	/*
	 *
	 * INITIALIZATION LOGIC
	 *
	 */

	public void init() {}

	public final void addSense(AbstractBrainSensor<T> brainSensor, BrainProfile... profiles) {
		brainSensor.ctx = this.createContext();
		Arrays.stream(profiles).forEach(
			profile -> profileSensorSets.computeIfAbsent(profile, key -> new ArrayList<>()).add(brainSensor)
		);
	}

	public final void addSense(AbstractBrainSensor<T> brainSensor) {
		this.addSense(brainSensor, BrainProfiles.STANDARD);
	}
	
	public final void addTask(AbstractBrainTask<T> brainTask, BrainProfile... profiles) {
		brainTask.ctx = this.createContext();
		Arrays.stream(profiles).forEach(
			profile -> profileTaskSets.computeIfAbsent(profile, key -> new ArrayList<>()).add(brainTask)
		);
	}

	public final void addTask(AbstractBrainTask<T> brainTask) {
		this.addTask(brainTask, BrainProfiles.STANDARD);
	}

	/*
	 *
	 * FLAG MASK LOGIC
	 *
	 */

	public final boolean canRunTask(AbstractBrainTask<T> brainTask) {
		Map<AbstractBrainFlag, BrainFlagState> requirements = brainTask.getFlagRequirements();

		if (brainTask.isExecuting() && this.executingTasks.contains(brainTask)) {
			return requirements.entrySet().stream()
					.filter(entry -> entry.getKey() instanceof BrainMemoryFlag)
					.allMatch(this::doesCurrentStateMatchRequirement);
		}

		return requirements.entrySet().stream().allMatch(this::doesCurrentStateMatchRequirement);
	}

	private void setFlagMasksForTask(AbstractBrainTask<T> brainTask) {
		this.executingTasks.add(brainTask);
		brainTask.getFlagMasks().forEach((key, value) -> this.brainFlagStates.set(key.getBitmaskId(), value.getBitMaskValue()));
	}

	public void clearFlagMasksForTask(AbstractBrainTask<?> brainTask) {
		this.executingTasks.remove(brainTask);
		brainTask.getFlagMasks().forEach((key, value) -> this.brainFlagStates.set(key.getBitmaskId(), !value.getBitMaskValue()));
	}

	private boolean doesCurrentStateMatchRequirement(Map.Entry<AbstractBrainFlag, BrainFlagState> entry) {
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
				return this.brainFlagStates.get(entry.getKey().getBitmaskId()) && memoryPresent;
			case ABSENT:
				return !this.brainFlagStates.get(entry.getKey().getBitmaskId()) && memoryAbsent;
			default:
				return true;
		}
	}


	/*
	 *
	 * MEMORIES
	 *
	 */

	public <U> Optional<U> getMemory(BrainMemoryKey<? super U> memoryKey) {
		return this.memoryManager.getMemory(memoryKey);
	}
	
	public final <U> void remember(BrainMemoryKey<?> memoryKey, U data) {
		this.memoryManager.remember(memoryKey, data);
		
		if (data != null) {
			AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
			
			if (flag != null) {
				this.brainFlagStates.set(flag.getBitmaskId(), BrainFlagState.PRESENT.getBitMaskValue());
			}
		}
	}
	
	public final boolean hasMemory(BrainMemoryKey<?> memoryKey) {
		boolean hasMemory = this.memoryManager.hasMemory(memoryKey);
		AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
		
		if (flag != null) {
			boolean maskState = (hasMemory ? BrainFlagState.PRESENT : BrainFlagState.ABSENT).getBitMaskValue();
			this.brainFlagStates.set(flag.getBitmaskId(), maskState);
		}
		
		return hasMemory;
	}
	
	public final void forget(BrainMemoryKey<?> memoryKey) {
		this.memoryManager.forget(memoryKey);
		
		AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
		
		if (flag != null) {
			this.brainFlagStates.set(flag.getBitmaskId(), BrainFlagState.ABSENT.getBitMaskValue());
		}
	}

	/*
	 *
	 * PROFILES
	 *
	 */

	public final void enableProfiles(BrainProfile profile, BrainProfile... profiles) {
		this.activeProfiles.add(profile);
		this.activeProfiles.addAll(Arrays.asList(profiles));
	}

	public final void disableAllProfilesExcept(BrainProfile profile) {
		this.disableAllProfiles();
		this.activeProfiles.add(profile);
	}

	public final void disableProfiles(BrainProfile profile, BrainProfile... profiles) {
		this.activeProfiles.remove(profile);
		Arrays.asList(profiles).forEach(this.activeProfiles::remove);
	}

	public final void disableAllProfiles() {
		this.activeProfiles.clear();
	}

	public Set<BrainProfile> getActiveProfiles() {
		return this.activeProfiles;
	}

	public Map<BrainProfile, ArrayList<AbstractBrainTask<T>>> getProfileTaskSets() {
		return profileTaskSets;
	}

	public List<AbstractBrainTask<T>> getAllActiveProfileTasks() {
		ArrayList<AbstractBrainTask<T>> activeTasks = new ArrayList<>();

		this.profileTaskSets.entrySet().stream()
				.filter(e -> this.activeProfiles.contains(e.getKey()))
				.forEach(e -> activeTasks.addAll(e.getValue()));

		return activeTasks;
	}
}
