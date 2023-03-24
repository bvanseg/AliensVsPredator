package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FindItemBrainTask extends AbstractEntityBrainTask {
	
    private boolean hasPickedUpItem;
    private boolean hasItemTarget;

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private final Predicate<EntityItem> itemPredicate;
	private Consumer<EntityItem> onUseItemCallback;


	private EntityItem closestItemTarget;

	public FindItemBrainTask(Predicate<EntityItem> itemPredicate) {
		this.itemPredicate = itemPredicate;
	}

	public FindItemBrainTask onUseItem(Consumer<EntityItem> onUseItemCallback) {
		this.onUseItemCallback = onUseItemCallback;
		return this;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (ctx.getEntity().world.getTotalWorldTime() % (60 + (ctx.getEntity().getRNG().nextInt(5) * 20)) == 0) {
			this.hasPickedUpItem = false;
			this.hasItemTarget = false;
		}

		Optional<List<EntityItem>> itemEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);

		if (itemEntitiesOptional.isPresent()) {
			boolean isValidItemNearby = itemEntitiesOptional.get().stream()
					.anyMatch(entityItem -> this.itemPredicate.test(entityItem) && entityItem.onGround);
			return isValidItemNearby && !this.hasPickedUpItem;
		}

		return false;
	}

	@Override
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		return this.closestItemTarget != null && !ctx.getEntity().getNavigator().noPath() && !this.hasPickedUpItem;
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		Optional<List<EntityItem>> itemEntities = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);
		
		if (itemEntities.isPresent()) {
			EntityLiving entity = ctx.getEntity();
			
			List<EntityItem> entityItemList = itemEntities.get().stream().filter(this.itemPredicate).collect(Collectors.toList());
			
			if (!entityItemList.isEmpty()) {
	            this.closestItemTarget = entityItemList.get(0);

	            if (!this.hasItemTarget) {
					entity.getNavigator().setPath(entity.getNavigator().getPathToEntityLiving(closestItemTarget), 1);
                    this.hasItemTarget = true;
                }
	        }
		}
	}

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		EntityLiving entity = ctx.getEntity();

		if (entity.getDistanceSq(closestItemTarget) < 2) {
			this.onPickupItem(ctx, closestItemTarget);
			this.hasPickedUpItem = true;
			this.hasItemTarget = false;
		}
	}

	private void onPickupItem(EntityBrainContext ctx, EntityItem entityItem) {
		if (this.onUseItemCallback != null) {
			this.onUseItemCallback.accept(entityItem);
		}
        entityItem.setDead();
		this.closestItemTarget = null;
    }

	@Override
	public void finish(EntityBrainContext ctx) {
		super.finish(ctx);
		this.closestItemTarget = null;
		this.hasItemTarget = false;
	}
}
