package org.lib.brain.impl;

import net.minecraft.entity.Entity;
import org.lib.brain.AbstractBrain;

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

	public void initSenses() { /* Do Nothing */ }

	public void initTasks() { /* Do Nothing */ }

	@Override
	public final void init() {
		this.initSenses();
		this.initTasks();
	}
}
