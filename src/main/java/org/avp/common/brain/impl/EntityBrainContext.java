package org.avp.common.brain.impl;

import net.minecraft.entity.EntityLiving;
import org.avp.common.brain.AbstractBrain;
import org.avp.common.brain.AbstractBrainContext;

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
