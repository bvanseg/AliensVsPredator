package org.alien.common.entity.ai.helper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * @author Boston Vanseghi
 */
public class FacehuggerLeapHelper {

    private FacehuggerLeapHelper() { /* Do Nothing */ }

    public static void leapAtTarget(EntityLivingBase leaper, Entity leapTarget) {
        if (leaper == null || leapTarget == null) return;

        double d0 = leapTarget.posX - leaper.posX;
        double d1 = leapTarget.posZ - leaper.posZ;
        float f = MathHelper.sqrt(d0 * d0 + d1 * d1);

        if (leaper.motionX == 0) {
            leaper.motionX = d0 / f * 0.800000011920929;
        }

        if (leaper.motionZ == 0) {
            leaper.motionZ = d1 / f * 0.800000011920929;
        }

        if (f >= 1.0E-4) {
            double distanceModifier = 0.5;
            leaper.motionX += (d0 / f * 0.800000011920929 + leaper.motionX * 0.20000000298023224) * distanceModifier;
            leaper.motionZ += (d1 / f * 0.800000011920929 + leaper.motionZ * 0.20000000298023224) * distanceModifier;
        }

        leaper.motionY = Math.sqrt(leapTarget.getEyeHeight()) / 2F;
    }
}
