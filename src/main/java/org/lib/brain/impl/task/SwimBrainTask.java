package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class SwimBrainTask extends AbstractBrainTask<EntityBrainContext> {

    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();

    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
    	Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
    	map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
		return map;
    }

    @Override
	public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
		return FLAGS;
	}

    public SwimBrainTask(EntityLiving entity) {
        if (entity.getNavigator() instanceof PathNavigateGround) {
            ((PathNavigateGround)entity.getNavigator()).setCanSwim(true);
        } else if (entity.getNavigator() instanceof PathNavigateFlying) {
            ((PathNavigateFlying)entity.getNavigator()).setCanFloat(true);
        }
    }
	
	@Override
	protected boolean shouldExecute(EntityBrainContext ctx) {
        EntityLiving entity = ctx.getEntity();
        return entity.isInWater() || entity.isInLava();
	}
	
    @Override
	protected void execute(EntityBrainContext ctx) {
        EntityLiving entity = ctx.getEntity();
        if (entity.getRNG().nextFloat() < 0.8F) {
            entity.getJumpHelper().setJumping();
        }
	}
}
