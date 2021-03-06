package org.lib.brain.memory;

import java.util.HashMap;
import java.util.Optional;

/**
 * Maintains the memory state for the brain.
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainMemoryMap {
	private final HashMap<BrainMemoryKey<?>, Optional<?>> memories = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public <T> Optional<T> getMemory(BrainMemoryKey<? super T> memoryKey) {
		return (Optional<T>) memories.compute(memoryKey, (k, v) -> {
			if (v == null) {
				return Optional.empty();
			}
			
			return v;
		});
	}
	
	public <T> void remember(BrainMemoryKey<?> memoryKey, T data) {
		memories.compute(memoryKey, (k, v) -> Optional.ofNullable(data));
	}
	
	public boolean hasMemory(BrainMemoryKey<?> memoryKey) {
		return memories.containsKey(memoryKey) && memories.get(memoryKey).isPresent();
	}
	
	public void forget(BrainMemoryKey<?> memoryKey) {
		this.memories.remove(memoryKey);
	}

    public void forgetEverything() {
		memories.clear();
    }
}
