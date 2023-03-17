package org.lib.brain.impl;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.lib.brain.memory.BrainMemoryType;

import java.util.List;

/**
 * Represents the different data types that a memory can be represented as. Every memory
 * has a data (memory) type, but not every data type has a memory.
 * 
 * @author Boston Vanseghi
 *
 */
public class AvpBrainMemoryTypes {
	public static final BrainMemoryType<Entity> ENTITY = BrainMemoryType.create(Entity.class);
	
	// Because Java's generic system is pain compared to other languages, we have to trick the compiler's type-checking for the parameterized type.
	@SuppressWarnings("unchecked")
	public static final BrainMemoryType<List<Entity>> ENTITIES = BrainMemoryType.create((Class<List<Entity>>)((Object)List.class));

	public static final BrainMemoryType<List<BlockPos>> BLOCK_POSITIONS = BrainMemoryType.create((Class<List<BlockPos>>)((Object)List.class));
}
