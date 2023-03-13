package org.lib.brain.sensor;

import org.lib.brain.AbstractBrainContext;

/**
 * Represents a sensor part of the brain. Sensors run before all other tasks, collecting input from
 * the world around the entity and then remembering what is important.
 * 
 * @author Boston Vanseghi
 *
 */
public abstract class AbstractBrainSensor<T extends AbstractBrainContext> {
	public abstract void sense(T ctx);
}
