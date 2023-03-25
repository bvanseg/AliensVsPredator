package org.lib.brain.task;

import net.minecraft.entity.ai.EntityAIBase;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainTaskAdapter extends AbstractBrainTask<EntityBrainContext> {
	
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
		this.minecraftAITask = minecraftAITask;
		this.flags = getFlagsForMutexBits(minecraftAITask.getMutexBits());
	}

	@Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return this.flags;
	}

	@Override
	protected boolean shouldExecute() {
		if (this.isExecuting()) {
			return this.minecraftAITask.shouldContinueExecuting();
		}
		
		return this.minecraftAITask.shouldExecute();
	}

	@Override
	protected void startExecuting() {
		if (!this.isExecuting()) {
			this.minecraftAITask.startExecuting();
		} else {
			this.minecraftAITask.updateTask();
		}
	}

	@Override
	public void finish() {
		super.finish();
		this.minecraftAITask.resetTask();
	}
}
