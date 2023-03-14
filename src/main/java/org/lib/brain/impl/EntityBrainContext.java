package org.lib.brain.impl;

import net.minecraft.entity.EntityLiving;
import org.lib.brain.AbstractBrain;
import org.lib.brain.AbstractBrainContext;

/**
 * A brain context in the context of a Minecraft living entity.
 * 
 * @author Boston Vanseghi
 *
 */
public class EntityBrainContext implements AbstractBrainContext {

	private final AbstractBrain<?> brain;
	private final EntityLiving entity;

	public EntityBrainContext(AbstractBrain<?> brain, EntityLiving entity) {
		this.brain = brain;
		this.entity = entity;
	}
	
	public EntityLiving getEntity() {
		return this.entity;
	}

	public AbstractBrain<?> getBrain() {
		return this.brain;
	}
}
