package org.lib.brain;

/**
 * Represents a context that can be passed to sensors and tasks during the brain's execution/updating.
 * 
 * @author Boston Vanseghi
 *
 */
public interface AbstractBrainContext {
    AbstractBrain<? extends AbstractBrainContext> getBrain();
}
