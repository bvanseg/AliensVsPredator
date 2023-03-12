package org.avp.common.brain.impl;

import java.util.List;

import org.avp.common.brain.memory.BrainMemoryKey;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;

/**
 * Minecraft-specific memory key implementations.
 * 
 * @author Boston Vanseghi
 *
 */
@SuppressWarnings("unchecked")
public class BrainMemoryKeys {

	private BrainMemoryKeys() {}

	public static final BrainMemoryKey<List<Entity>> ENTITIES = (BrainMemoryKey<List<Entity>>) BrainMemoryKey.create(AvpBrainMemoryTypes.ENTITIES);
	public static final BrainMemoryKey<? super List<EntityLivingBase>> LIVING_ENTITIES = (BrainMemoryKey<? super List<EntityLivingBase>>) BrainMemoryKey.create(AvpBrainMemoryTypes.ENTITIES);
	public static final BrainMemoryKey<? super List<EntityItem>> ITEM_ENTITIES = (BrainMemoryKey<? super List<EntityItem>>) BrainMemoryKey.create(AvpBrainMemoryTypes.ENTITIES);
	
	public static final BrainMemoryKey<? super Entity> NEAREST_ENTITY = BrainMemoryKey.create(AvpBrainMemoryTypes.ENTITY);
	public static final BrainMemoryKey<? super Entity> NEAREST_ATTACKABLE_TARGET = BrainMemoryKey.create(AvpBrainMemoryTypes.ENTITY);
}
