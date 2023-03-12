package org.avp.common.brain.task;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import org.avp.common.brain.flag.AbstractBrainFlag;
import org.avp.common.brain.flag.BrainFlagState;
import org.avp.common.brain.impl.BrainFlags;
import org.avp.common.brain.impl.EntityBrainContext;

import net.minecraft.entity.ai.EntityAIBase;

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
	private Map<AbstractBrainFlag, BrainFlagState> flags;
	
	public BrainTaskAdapter(EntityAIBase minecraftAITask) {
		this.minecraftAITask = minecraftAITask;
		this.flags = getFlagsForMutexBits(minecraftAITask.getMutexBits());
	}

	@Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return this.flags;
	}

	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (this.isExecuting()) {
			return this.minecraftAITask.shouldContinueExecuting();
		}
		
		return this.minecraftAITask.shouldExecute();
	}

	@Override
	protected void execute(EntityBrainContext ctx) {
		if (!this.isExecuting()) {
			this.minecraftAITask.startExecuting();
		} else {
			this.minecraftAITask.updateTask();
		}
	}

	@Override
	protected void finish(EntityBrainContext ctx) {
		super.finish(ctx);
		this.minecraftAITask.resetTask();
	}
}
