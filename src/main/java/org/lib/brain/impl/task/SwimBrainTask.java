package org.lib.brain.impl.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class SwimBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
    }

    @Override
    public void setFlagMasks(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.PRESENT);
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
	protected void startExecuting(EntityBrainContext ctx) {
        EntityLiving entity = ctx.getEntity();
        if (entity.getRNG().nextFloat() < 0.8F) {
            entity.getJumpHelper().setJumping();
        }
	}
}
