package org.avp.common.brain.flag;

/**
 * An abstraction for some property or state the entity is in. Why other implementations are not used:
 * Enums - not extensible.
 * BitSet (or any set) - Flags also come paired with a state that requires more than a binary value set.
 * 
 * Additionally, it is important to recognize that an entity possesses (at least) two types of flags; 1 type for
 * non-serializable states or properties, such as movement or look, and 1 type for serializable states or properties (memories).
 * 
 * Both types of flags are equally important to keep track of, but building two separate systems to track both would create an
 * ungodly amount of boilerplate.
 * 
 * @author Boston Vanseghi
 *
 */
public abstract class AbstractBrainFlag {
	
	private final String identifier;
	
	protected AbstractBrainFlag(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public String toString() {
		return this.identifier;
	}
}
