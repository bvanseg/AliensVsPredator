package org.avp.util.brain.flag;

import org.avp.util.brain.memory.BrainMemoryKey;

/**
 * This type of flag represents states that are dependent on what the entity remembers.
 * Usage of this flag should be fairly straightforward - Does the entity have a target memory? Then the corresponding flag is set.
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainMemoryFlag extends AbstractBrainFlag {
	private BrainMemoryKey<?> memoryKey;
	
	public BrainMemoryFlag(String identifier, BrainMemoryKey<?> memoryKey) {
		super(identifier);
		this.memoryKey = memoryKey;
	}

	public BrainMemoryKey<?> getMemoryKey() {
		return memoryKey;
	}
}
