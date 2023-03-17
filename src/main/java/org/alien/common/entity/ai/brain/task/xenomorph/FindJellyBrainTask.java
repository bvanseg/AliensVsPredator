package org.alien.common.entity.ai.brain.task.xenomorph;

import net.minecraft.entity.item.EntityItem;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.BrainMemoryKeys;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FindJellyBrainTask extends AbstractEntityBrainTask {
	
    private boolean hasPickedUpJelly;
    private boolean hasJellyTarget;

	@Override
	public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
		map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
	}

	@Override
	public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
		map.put(BrainFlags.MOVE, BrainFlagState.PRESENT);
	}

	private EntityItem closestJelly;

	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (ctx.getEntity().world.getTotalWorldTime() % (60 + (ctx.getEntity().getRNG().nextInt(5) * 20)) == 0) {
			this.hasPickedUpJelly = false;
			this.hasJellyTarget = false;
		}
		
		return !this.hasPickedUpJelly;
	}

	@Override
	protected boolean shouldContinueExecuting(EntityBrainContext ctx) {
		return this.closestJelly != null && (!ctx.getEntity().getNavigator().noPath() || this.hasPickedUpJelly);
	}

	@Override
	protected void startExecuting(EntityBrainContext ctx) {
		Optional<List<EntityItem>> itemEntities = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);
		
		if (itemEntities.isPresent()) {
			SpeciesXenomorph xenomorph = (SpeciesXenomorph)ctx.getEntity();
			
			List<EntityItem> entityItemList = itemEntities.get().stream().filter(
					e -> e.getItem().getItem() == AlienItems.ITEM_ROYAL_JELLY).collect(Collectors.toList());
			
			if (!entityItemList.isEmpty()) {
	            this.closestJelly = entityItemList.get(0);

	            if (xenomorph.isDependantOnHive() && !this.hasJellyTarget) {
                    xenomorph.getNavigator().setPath(xenomorph.getNavigator().getPathToEntityLiving(this.closestJelly), 1);
                    this.hasJellyTarget = true;
                }
	        }
		}
	}

	@Override
	protected void continueExecuting(EntityBrainContext ctx) {
		SpeciesXenomorph xenomorph = (SpeciesXenomorph)ctx.getEntity();

		if (xenomorph.getDistanceSq(this.closestJelly) <= 1) {
			this.onPickupJelly(ctx, this.closestJelly);
			this.hasPickedUpJelly = true;
			this.hasJellyTarget = false;
		}
	}

	private void onPickupJelly(EntityBrainContext ctx, EntityItem entityItem) {
    	SpeciesXenomorph xenomorph = (SpeciesXenomorph) ctx.getEntity();
        xenomorph.setJellyLevel(xenomorph.getJellyLevel() + (entityItem.getItem().getCount() * 100));
        entityItem.setDead();
		this.closestJelly = null;
    }
}