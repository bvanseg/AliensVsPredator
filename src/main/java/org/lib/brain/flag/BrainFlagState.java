package org.lib.brain.flag;

/**
 * Certain tasks will demand a specific state that a BrainFlag should be in.
 * One could consider using the flag's presence in a collection to dictate state requirement,
 * however, some tasks are indifferent to whether a flag is present or not, and so that third state requires
 * representation.
 * 
 * @author Boston Vanseghi
 *
 */
public enum BrainFlagState {
	PRESENT(true),
	ABSENT(false),
	ANY(false);

	private final boolean bitMaskValue;

	BrainFlagState(boolean bitMaskValue) {
		this.bitMaskValue = bitMaskValue;
	}

	public boolean getBitMaskValue() {
		return bitMaskValue;
	}

	public BrainFlagState inverse() {
		if (this == PRESENT) return ABSENT;
		if (this == ABSENT) return PRESENT;
		return this;
	}
}
