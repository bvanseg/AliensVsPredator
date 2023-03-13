package org.lib.brain;

/**
 * Describes a type that is capable of having a brain type.
 *
 * @author Boston Vanseghi
 *
 */
public interface Brainiac<T extends AbstractBrain<?>> {
	T getBrain();
}
