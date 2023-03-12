package org.avp.common.brain.memory;

/**
 * Used to access memory data within the memory manager.
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainMemoryKey<T> {
	public static <U> BrainMemoryKey<? super U> create(BrainMemoryType<? super U> memoryType) {
		return new BrainMemoryKey<U>();
	}
}
