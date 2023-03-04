package org.avp.util.brain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.avp.util.brain.flag.AbstractBrainFlag;
import org.avp.util.brain.flag.BrainFlagState;
import org.avp.util.brain.flag.BrainMemoryFlag;
import org.avp.util.brain.impl.BrainFlags;
import org.avp.util.brain.memory.BrainMemoryKey;
import org.avp.util.brain.memory.BrainMemoryMap;
import org.avp.util.brain.sensor.AbstractBrainSensor;
import org.avp.util.brain.task.AbstractBrainTask;

import net.minecraft.entity.EntityLivingBase;

/**
 * A logical processor with input (sensors) and output/results (tasks). The processing pipeline is as follows:
 * <ol>
 * <li>Gather external input.</li>
 * <li>Memorize important input data for later use.</li>
 * <li>Run tasks, presuming the task's flag requirements are met.</li>
 * <li>Produce results from tasks (manifested as observable behavior in the game world).</li>
 * <li>Repeat.
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
// TODO: Abstract minecraft code away from this class (move minecraft code to subtype).
public abstract class AbstractBrain<T extends AbstractBrainContext> {
	private EntityLivingBase entity;
	
	private BrainMemoryMap memoryManager;
	private ArrayList<AbstractBrainSensor<T>> sensors;
	private ArrayList<AbstractBrainTask<T>> tasks;
	private HashMap<AbstractBrainFlag, BrainFlagState> brainFlagStates;
	
	public AbstractBrain(EntityLivingBase entity) {
		this.entity = entity;
		this.memoryManager = new BrainMemoryMap();
		this.sensors = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.brainFlagStates = new HashMap<>();
	}
	
	public void update(T ctx) {
		sensors.forEach((sensor) -> sensor.sense(ctx));
		tasks.forEach((task) -> {
			if (this.canRunTask(task)) {
				// If the task successfully ran, set flags for the masks it used.
				// Setting the used masks will prevent upcoming tasks sharing the same masks from running.
				task.runTask(ctx);
			}
		});
	}

	public void init() {}
	
	public void addSense(AbstractBrainSensor<T> brainSensor) {
		sensors.add(brainSensor);
	}
	
	public void addTask(AbstractBrainTask<T> brainTask) {
		tasks.add(brainTask);
	}
	
	public boolean canRunTask(AbstractBrainTask<T> brainTask) {
		Map<AbstractBrainFlag, BrainFlagState> requirements = brainTask.getFlags();
		
		boolean allRequirementsPass = requirements.entrySet().stream().allMatch((entry) -> {
			// If the flag type is derived from brain memory, we need to additionally check that the memory is present.
			boolean memoryPresent = entry.getKey() instanceof BrainMemoryFlag ?
					this.memoryManager.hasMemory(((BrainMemoryFlag)entry.getKey()).getMemoryKey()) : true;
			
			// Same as before, but this time for memory absence.
			boolean memoryAbsent = entry.getKey() instanceof BrainMemoryFlag ?
					!this.memoryManager.hasMemory(((BrainMemoryFlag)entry.getKey()).getMemoryKey()) : true;
			
			switch (entry.getValue())  {
				case PRESENT:
					return this.brainFlagStates.get(entry.getKey()) == requirements.get(entry.getKey()) && memoryPresent;
				case ABSENT:
					return (!this.brainFlagStates.containsKey(entry.getKey()) || this.brainFlagStates.get(entry.getKey()) == BrainFlagState.ABSENT) && memoryAbsent;
				default:
					return true;
			}
		});
		
		return allRequirementsPass;
	}
	
	public <U> Optional<U> getMemory(BrainMemoryKey<? super U> memoryKey) {
		return this.memoryManager.getMemory(memoryKey);
	}
	
	public <U> void remember(BrainMemoryKey<?> memoryKey, U data) {
		this.memoryManager.remember(memoryKey, data);
		
		if (data != null) {
			AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
			
			if (flag != null) {
				this.brainFlagStates.put(flag, BrainFlagState.PRESENT);
			}
		}
	}
	
	public boolean hasMemory(BrainMemoryKey<?> memoryKey) {
		boolean hasMemory = this.memoryManager.hasMemory(memoryKey);
		AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
		
		if (flag != null) {
			this.brainFlagStates.put(flag, hasMemory ? BrainFlagState.PRESENT : BrainFlagState.ABSENT);
		}
		
		return hasMemory;
	}
	
	public void forget(BrainMemoryKey<?> memoryKey) {
		this.memoryManager.forget(memoryKey);
		
		AbstractBrainFlag flag = BrainFlags.getFlagForKey(memoryKey);
		
		if (flag != null) {
			this.brainFlagStates.put(flag, BrainFlagState.ABSENT);
		}
	}
	
	public EntityLivingBase getEntity() {
		return this.entity;
	}
}
