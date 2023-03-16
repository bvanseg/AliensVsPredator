package org.alien.common.entity.ai.brain.task;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import org.alien.common.api.parasitoidic.RoyalOrganism;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FindFoodBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private boolean hasPickedUpFood;
    private boolean hasFoodTarget;
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
		return FLAGS;
	}

	private static final Predicate<EntityItem> foodPredicate = entityItem -> {
		Item item = entityItem.getItem().getItem();
		return item instanceof ItemFood;
	};
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (!(ctx.getEntity() instanceof RoyalOrganism))
			return false;

		if (ctx.getEntity().world.getTotalWorldTime() % (60 + (ctx.getEntity().getRNG().nextInt(5) * 20)) == 0) {
			this.hasPickedUpFood = false;
			this.hasFoodTarget = false;
		}
		
		return !this.hasPickedUpFood;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		Optional<List<EntityItem>> itemEntities = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);
		
		if (itemEntities.isPresent()) {
			EntityLiving entity = ctx.getEntity();
			
			List<EntityItem> entityItemList = itemEntities.get().stream().filter(foodPredicate::apply).collect(Collectors.toList());
			
			if (!entityItemList.isEmpty()) {
	            EntityItem closestFood = entityItemList.get(0);

	            if (!this.hasFoodTarget) {
					entity.getNavigator().setPath(entity.getNavigator().getPathToEntityLiving(closestFood), 1);
                    this.hasFoodTarget = true;
                }

                if (entity.getDistanceSq(closestFood) <= 1) {
                    this.onPickupFood(ctx, closestFood);
                    this.hasPickedUpFood = true;
                    this.hasFoodTarget = false;
                }
	        }
		}
	}

    private void onPickupFood(EntityBrainContext ctx, EntityItem entityItem) {
		RoyalOrganism royalOrganism = (RoyalOrganism) ctx.getEntity();
        royalOrganism.setJellyLevel(royalOrganism.getJellyLevel() + (entityItem.getItem().getCount() * 50));
        entityItem.setDead();
    }
}
