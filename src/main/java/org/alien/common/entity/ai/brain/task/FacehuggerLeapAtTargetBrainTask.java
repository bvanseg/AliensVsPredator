package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.entity.ai.helper.LeapHelper;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class FacehuggerLeapAtTargetBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.NEAREST_ATTACKABLE_TARGET, BrainFlagState.PRESENT);
        map.put(BrainFlags.MINECRAFT_SWIM, BrainFlagState.ABSENT);
    }
	
	@Override
	protected boolean shouldExecute() {
        // If the entity is not on the ground, there's nothing to leap off of.
        if (!ctx.getEntity().onGround) {
            return false;
        }

        EntityLiving leaper = ctx.getEntity();
        Entity leapTarget = ctx.getEntity().getAttackTarget();

        if (leapTarget == null) {
            return false;
        } else {
            if (leaper.motionX == 0 && leaper.motionZ == 0)
                return false;

            double d0 = leaper.getDistanceSq(leapTarget);
            return d0 >= 24.0 && d0 <= 58.0;
        }
	}
	
    @Override
	protected void startExecuting() {
        EntityLiving leaper = ctx.getEntity();
        EntityLivingBase leapTarget = ctx.getEntity().getAttackTarget();
        LeapHelper.leapAtTarget(leaper, leapTarget);
    }
}
