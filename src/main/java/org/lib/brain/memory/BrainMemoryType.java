package org.lib.brain.memory;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainMemoryType<T> {
	
	private final Class<T> clazz;
	
	private BrainMemoryType(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public static <M> BrainMemoryType<M> create(Class<M> clazz) {
		return new BrainMemoryType<>(clazz);
	}
	
	public Class<T> getTypeClass() {
		return this.clazz;
	}
}
