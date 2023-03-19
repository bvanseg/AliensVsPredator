package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import org.alien.common.api.parasitoidic.RoyalOrganism;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FindFoodBrainTask extends AbstractEntityBrainTask {
	
    private boolean hasPickedUpFood;
    private boolean hasFoodTarget;

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private static final Predicate<EntityItem> foodPredicate = entityItem -> {
		Item item = entityItem.getItem().getItem();
		return item instanceof ItemFood;
	};

	private EntityItem closestFood;
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (!(ctx.getEntity() instanceof RoyalOrganism))
			return false;

		if (ctx.getEntity().world.getTotalWorldTime() % (60 + (ctx.getEntity().getRNG().nextInt(5) * 20)) == 0) {
			this.hasPickedUpFood = false;
			this.hasFoodTarget = false;
		}

		Optional<List<EntityItem>> itemEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);

		if (itemEntitiesOptional.isPresent()) {
			boolean isFoodNearby = itemEntitiesOptional.get().stream().anyMatch(foodPredicate);
			return isFoodNearby && !this.hasPickedUpFood;
		}

		return false;
	}

	@Override
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		return this.closestFood != null && !ctx.getEntity().getNavigator().noPath() && !this.hasPickedUpFood;
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		Optional<List<EntityItem>> itemEntities = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);
		
		if (itemEntities.isPresent()) {
			EntityLiving entity = ctx.getEntity();
			
			List<EntityItem> entityItemList = itemEntities.get().stream().filter(foodPredicate).collect(Collectors.toList());
			
			if (!entityItemList.isEmpty()) {
	            this.closestFood = entityItemList.get(0);

	            if (!this.hasFoodTarget) {
					entity.getNavigator().setPath(entity.getNavigator().getPathToEntityLiving(closestFood), 1);
                    this.hasFoodTarget = true;
                }
	        }
		}
	}

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();
		if (entity.getDistanceSq(closestFood) < 2) {
			this.onPickupFood(ctx, closestFood);
			this.hasPickedUpFood = true;
			this.hasFoodTarget = false;
		}
	}

	private void onPickupFood(EntityBrainContext ctx, EntityItem entityItem) {
		RoyalOrganism royalOrganism = (RoyalOrganism) ctx.getEntity();
        royalOrganism.setJellyLevel(royalOrganism.getJellyLevel() + (entityItem.getItem().getCount() * 50));
        entityItem.setDead();
		this.closestFood = null;
    }
}
