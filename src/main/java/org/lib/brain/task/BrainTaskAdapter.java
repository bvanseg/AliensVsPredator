package org.lib.brain.task;

import net.minecraft.entity.ai.EntityAIBase;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainTaskAdapter extends AbstractEntityBrainTask {
	
	private static Map<AbstractBrainFlag, BrainFlagState> getFlagsForMutexBits(int mutexBits) {
		HashMap<AbstractBrainFlag, BrainFlagState> flags = new HashMap<>();
		
		BitSet bitSet = BitSet.valueOf(new long[]{mutexBits});
		
		// Movement
		if (bitSet.get(0)) {
			flags.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		}
		
		// Look
		if (bitSet.get(1)) {
			flags.put(BrainFlags.LOOK, BrainFlagState.ABSENT);
		}
		
		// Swim
		if (bitSet.get(2)) {
			flags.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
		}
		
		// Swim
		if (bitSet.get(3)) {
			flags.put(BrainFlags.MINECRAFT_UNCATEGORIZED, BrainFlagState.ABSENT);
		}
		
		return flags;
	}
	
	private final EntityAIBase minecraftAITask;
	private final Map<AbstractBrainFlag, BrainFlagState> flags;
	
	public BrainTaskAdapter(EntityAIBase minecraftAITask) {
		super();
		this.minecraftAITask = minecraftAITask;
		this.flags = getFlagsForMutexBits(minecraftAITask.getMutexBits());
	}

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.putAll(this.flags);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		// Invert the tasks to be set to present on task execute.
		map.putAll(
				map.entrySet()
						.stream()
						.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().inverse()))
		);
	}

	@Override
	protected boolean shouldExecute() {
		return this.minecraftAITask.shouldExecute();
	}

	@Override
	protected boolean shouldContinueExecuting() {
		return this.minecraftAITask.shouldContinueExecuting();
	}

	@Override
	protected void startExecuting() {
		this.minecraftAITask.startExecuting();
	}

	@Override
	protected void continueExecuting() {
		this.minecraftAITask.updateTask();
	}

	@Override
	public void finish() {
		super.finish();
		this.minecraftAITask.resetTask();
	}
}
