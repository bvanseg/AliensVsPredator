package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;
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
            double d0 = leaper.getDistanceSq(leapTarget);
            return d0 >= 24.0 && d0 <= 58.0;
        }
	}
	
    @Override
	protected void startExecuting() {
        EntityLiving leaper = ctx.getEntity();
        Entity leapTarget = ctx.getEntity().getAttackTarget();
        double d0 = leapTarget.posX - leaper.posX;
        double d1 = leapTarget.posZ - leaper.posZ;
        float f = MathHelper.sqrt(d0 * d0 + d1 * d1);
        if (f >= 1.0E-4) {
            double distanceModifier = 0.5;
            leaper.motionX += (d0 / f * 0.5 * 0.800000011920929 + leaper.motionX * 0.20000000298023224) * distanceModifier;
            leaper.motionZ += (d1 / f * 0.5 * 0.800000011920929 + leaper.motionZ * 0.20000000298023224) * distanceModifier;
        }

        leaper.motionY = Math.sqrt(leapTarget.getEyeHeight()) / 2F;
    }
}
