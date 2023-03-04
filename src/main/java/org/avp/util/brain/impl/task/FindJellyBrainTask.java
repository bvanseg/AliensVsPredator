package org.avp.util.brain.impl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.avp.AliensVsPredator;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.util.brain.flag.AbstractBrainFlag;
import org.avp.util.brain.flag.BrainFlagState;
import org.avp.util.brain.impl.BrainFlags;
import org.avp.util.brain.impl.BrainMemoryKeys;
import org.avp.util.brain.impl.EntityBrainContext;
import org.avp.util.brain.task.AbstractBrainTask;

import net.minecraft.entity.item.EntityItem;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FindJellyBrainTask extends AbstractBrainTask<EntityBrainContext> {
	
    private boolean hasPickedUpJelly;
    private boolean hasJellyTarget;
    
    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();
    
    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<AbstractBrainFlag, BrainFlagState>();
    	map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    	map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.ABSENT);
		return map;
    }
    
    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
		if (ctx.getEntity().world.getTotalWorldTime() % (60 + (ctx.getEntity().getRNG().nextInt(5) * 20)) == 0) {
			this.hasPickedUpJelly = false;
			this.hasJellyTarget = false;
		}
		
		return !this.hasPickedUpJelly;
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
		Optional<List<EntityItem>> itemEntities = ctx.getBrain().getMemory(BrainMemoryKeys.ITEM_ENTITIES);
		
		if (itemEntities.isPresent()) {
			SpeciesXenomorph xenomorph = (SpeciesXenomorph)ctx.getEntity();
			
			List<EntityItem> entityItemList = itemEntities.get().stream().filter(
					(e) -> e.getItem().getItem() == AliensVsPredator.items().itemRoyalJelly).collect(Collectors.toList());
			
			if (!entityItemList.isEmpty()) {
	            EntityItem closestJelly = entityItemList.get(0);

	            if (xenomorph.canMoveToJelly() && xenomorph.isDependantOnHive() && !this.hasJellyTarget) {
                    xenomorph.getNavigator().setPath(xenomorph.getNavigator().getPathToEntityLiving(closestJelly), 1);
                    this.hasJellyTarget = true;
                }

                if (xenomorph.getDistanceSq(closestJelly) <= 1) {
                    this.onPickupJelly(ctx, closestJelly);
                    this.hasPickedUpJelly = true;
                    this.hasJellyTarget = false;
                }
	        }
		}
	}

    private void onPickupJelly(EntityBrainContext ctx, EntityItem entityItem) {
    	SpeciesXenomorph xenomorph = (SpeciesXenomorph) ctx.getEntity();
        xenomorph.setJellyLevel(xenomorph.getJellyLevel() + (entityItem.getItem().getCount() * 100));
        entityItem.setDead();
    }
}
