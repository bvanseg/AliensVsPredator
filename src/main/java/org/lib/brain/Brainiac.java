package org.lib.brain;

/**
 * Describes a type that is capable of having a brain type.
 *
 * @author Boston Vanseghi
 *
 */
public interface Brainiac<T extends AbstractBrain<?>> {
	T getBrain();

	default void setBrainDisabled(boolean isDisabled) {
		if (getBrain() == null) return;
		getBrain().setDisabled(isDisabled);
	}
}
