package org.avp.common.brain.impl.sensor;

import java.util.ArrayList;

import org.avp.common.brain.impl.BrainMemoryKeys;
import org.avp.common.brain.impl.EntityBrainContext;
import org.avp.common.brain.sensor.AbstractBrainSensor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class EntityBrainSensor extends AbstractBrainSensor<EntityBrainContext> {
	
	private final int cooldownInTicks;
	
	public EntityBrainSensor(int cooldownInTicks) {
		this.cooldownInTicks = cooldownInTicks;
	}

	@Override
	public void sense(EntityBrainContext ctx) {
		// Use ticksExisted instead of world time here so that entities don't have synchronized AI execution.
		if (ctx.getEntity().ticksExisted % cooldownInTicks != 0) {
			return;
		}
		
		Entity entity = ctx.getEntity();
		World world = ctx.getEntity().world;
		
		int range = 16;
        ArrayList<Entity> allEntities = (ArrayList<Entity>) world.getEntitiesWithinAABB(
    		Entity.class,
    		new AxisAlignedBB(entity.getPosition().add(-range, -8, -range), entity.getPosition().add(range, 8, range))
		);
        
        ArrayList<EntityLivingBase> livingEntities = new ArrayList<>();
        ArrayList<EntityItem> itemEntities = new ArrayList<>();
        
        allEntities.sort((e1, e2) -> {
        	double d1 = e1.getDistanceSq(entity);
        	double d2 = e2.getDistanceSq(entity);
        	
        	if (d1 < d2) {
        		return -1;
        	} else if (d1 > d2) {
        		return 1;
        	}
        	
        	return 0;
        });
        
        // Entities collected from all other entities should also be sorted.
        allEntities.forEach(e -> {
        	// Sensing entity is excluded.
        	if (e.equals(entity)) {
        		return;
        	}
        	
        	if (e instanceof EntityLivingBase) {
        		livingEntities.add((EntityLivingBase) e);
        	}
        	
        	if (e instanceof EntityItem) {
        		itemEntities.add((EntityItem) e);
        	}
        });
        
        ctx.getBrain().remember(BrainMemoryKeys.ENTITIES, allEntities);
        ctx.getBrain().remember(BrainMemoryKeys.LIVING_ENTITIES, livingEntities);
        ctx.getBrain().remember(BrainMemoryKeys.ITEM_ENTITIES, itemEntities);
        ctx.getBrain().remember(BrainMemoryKeys.NEAREST_ENTITY, !allEntities.isEmpty() ? allEntities.get(0) : null);
	}

}
