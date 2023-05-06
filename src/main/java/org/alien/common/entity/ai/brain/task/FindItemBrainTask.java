package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FindItemBrainTask extends AbstractEntityBrainTask {

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

	private final double moveSpeed;


	private EntityItem closestItemTarget;

	public FindItemBrainTask(Predicate<EntityItem> itemPredicate) {
		this(itemPredicate, 1.0);
	}

	public FindItemBrainTask(Predicate<EntityItem> itemPredicate, double moveSpeed) {
		this.itemPredicate = entityItem -> itemPredicate.test(entityItem) &&
				entityItem.onGround &&
				ctx.getEntity().canEntityBeSeen(entityItem);
		this.moveSpeed = moveSpeed;
	}

	public FindItemBrainTask onUseItem(Consumer<EntityItem> onUseItemCallback) {
		this.onUseItemCallback = onUseItemCallback;
		return this;
	}
	
	@Override
	protected boolean shouldExecute() {
		if (ctx.getEntity().world.getTotalWorldTime() % (60 + (ctx.getEntity().getRNG().nextInt(5) * 20)) != 0) {
			return false;
		}

		Optional<List<EntityItem>> itemEntitiesOptional = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);

		if (itemEntitiesOptional.isPresent()) {
			Optional<EntityItem> closestItemOptional = itemEntitiesOptional.get().stream().filter(itemPredicate).findFirst();

			if (closestItemOptional.isPresent()) {
				this.closestItemTarget = closestItemOptional.get();
				return true;
			}
		}

		return false;
	}

	@Override
	protected boolean shouldContinueExecuting() {
		return this.closestItemTarget != null && !this.closestItemTarget.isDead && !ctx.getEntity().getNavigator().noPath();
	}

	@Override
	protected void startExecuting() {
		EntityLiving entity = ctx.getEntity();
		entity.getNavigator().setPath(entity.getNavigator().getPathToEntityLiving(this.closestItemTarget), this.moveSpeed);
	}

	@Override
	protected void continueExecuting() {
		EntityLiving entity = ctx.getEntity();

		if (entity.getDistanceSq(this.closestItemTarget) < 2) {
			this.onPickupItem(this.closestItemTarget);
		}
	}

	private void onPickupItem(EntityItem entityItem) {
		if (this.onUseItemCallback != null) {
			this.onUseItemCallback.accept(entityItem);
		}
        entityItem.setDead();
		this.closestItemTarget = null;
    }

	@Override
	public void finish() {
		super.finish();
		this.closestItemTarget = null;
	}
}
