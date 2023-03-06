package org.avp.util.brain.impl;

import org.avp.util.brain.AbstractBrain;

import net.minecraft.entity.Entity;

/**
 * An abstraction over AbstractBrain that holds an entity reference.
 * 
 * @author Boston Vanseghi
 *
 * @param <T> The type of entity.
 */
public class AbstractEntityBrain<T extends Entity> extends AbstractBrain<EntityBrainContext> {
	private final T entity;
	
	public AbstractEntityBrain(T entity) {
		this.entity = entity;
	}
	
	public T getEntity() {
		return this.entity;
	}
}
