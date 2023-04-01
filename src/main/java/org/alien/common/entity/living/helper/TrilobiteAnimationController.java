package org.alien.common.entity.living.helper;

import com.asx.mdx.common.minecraft.entity.animations.Animation;
import com.asx.mdx.common.minecraft.entity.animations.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.alien.client.AlienSounds;
import org.alien.common.entity.living.species223ode.EntityTrilobite;

import static com.asx.mdx.common.minecraft.entity.animations.IAnimated.NO_ANIMATION;

/**
 * @author Ri5ux
 */
public class TrilobiteAnimationController {

    public static final Animation IMPREGNATION_ANIMATION = Animation.create(0);
    public static final Animation ANIMATION_HUG_WALL = Animation.create(20 * 5);

    private static final Animation[] ANIMATION_SET = new Animation[] { IMPREGNATION_ANIMATION, ANIMATION_HUG_WALL };

    public void update(EntityTrilobite trilobite) {
        if (trilobite.getAttackTarget() != null)
        {
            if (trilobite.getActiveAnimation() == ANIMATION_HUG_WALL)
            {
                Entity entityIn = trilobite.getAttackTarget();
                float angle = (float) (MathHelper.atan2(entityIn.posZ - trilobite.posZ, entityIn.posX - trilobite.posX) * (180D / Math.PI)) - 90.0F;
                angle = MathHelper.floor((angle / 90) + 0.5) * 90F;
                trilobite.rotationYaw = angle;
            }

            double distanceX = trilobite.prevPosX - trilobite.posX;
            double distanceZ = trilobite.prevPosZ - trilobite.posZ;

            double motion = distanceX * distanceZ;

            if ((trilobite.collidedHorizontally) && trilobite.getActiveAnimation() == NO_ANIMATION && Math.abs(motion) < 0.3D && Math.abs(motion) > 0.0D)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(trilobite, ANIMATION_HUG_WALL);
            }
        }

        if(trilobite.getActiveAnimation() == IMPREGNATION_ANIMATION && trilobite.getAnimationTick() == 95)
        {
            AlienSounds.FACEHUGGER_IMPLANT.playSound(trilobite, 1F, 1F);
        }

        if (trilobite.getRidingEntity() == null && trilobite.getActiveAnimation() == IMPREGNATION_ANIMATION)
        {
            trilobite.setActiveAnimation(NO_ANIMATION);
        }
    }

    public Animation[] getAnimations()
    {
        return ANIMATION_SET;
    }
}
