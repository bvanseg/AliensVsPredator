package org.lib.brain.impl;

import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainActionFlag;
import org.lib.brain.flag.BrainMemoryFlag;
import org.lib.brain.memory.BrainMemoryKey;

import java.util.HashMap;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainFlags {
	public static final AbstractBrainFlag MOVE = new BrainActionFlag("move");
	public static final AbstractBrainFlag LOOK = new BrainActionFlag("look");
	
	// These are compatibility flags with Minecraft's old AI.
	public static final AbstractBrainFlag MINECRAFT_SWIM = new BrainActionFlag("minecraft_swim");
	public static final AbstractBrainFlag MINECRAFT_UNCATEGORIZED = new BrainActionFlag("minecraft_uncategorized");

	private static final HashMap<BrainMemoryKey<?>, BrainMemoryFlag> memoryKeysToBrainFlags = new HashMap<>();
	
	public static final AbstractBrainFlag NEAREST_ATTACKABLE_TARGET = createMemoryFlag("nearest_attackable_target", BrainMemoryKeys.NEAREST_ATTACKABLE_TARGET);
	public static final AbstractBrainFlag NEAREST_AVOID_TARGET = createMemoryFlag("nearest_avoid_target", BrainMemoryKeys.NEAREST_AVOID_TARGET);
	public static final AbstractBrainFlag BLOCK_POSITIONS_OF_INTEREST = createMemoryFlag("block_positions_of_interest", BrainMemoryKeys.BLOCK_POSITIONS_OF_INTEREST);

	private static BrainMemoryFlag createMemoryFlag(String identifier, BrainMemoryKey<?> memoryKey) {
		BrainMemoryFlag flag = new BrainMemoryFlag(identifier, memoryKey);
		memoryKeysToBrainFlags.putIfAbsent(memoryKey, flag);
		return flag;
	}

	public static AbstractBrainFlag getFlagForKey(BrainMemoryKey<?> memoryKey) {
		return memoryKeysToBrainFlags.get(memoryKey);
	}
}
