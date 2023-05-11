package org.alien.common.entity.ai.brain.task;

import com.asx.mdx.common.math.MDXMath;
import net.minecraft.util.math.MathHelper;
import org.alien.common.entity.living.xenomorph.exotic.EntityNauticomorph;
import org.lib.brain.impl.AbstractEntityBrainTask;

/**
 * @author Boston Vanseghi
 */
public class UpdatePhosphorescenceLevelBrainTask extends AbstractEntityBrainTask {

    @Override
    protected boolean shouldExecute() {
        return ctx.getEntity() instanceof EntityNauticomorph;
    }

    @Override
    protected void startExecuting() {
        EntityNauticomorph entity = (EntityNauticomorph) ctx.getEntity();
        float mult = 0.02F;
        float downMult = mult;
        float targetLevel = 1F - (float) MDXMath.map(entity.world.getLightBrightness(entity.getPosition()), 0.08, 0.5, 0.08F, 1F);

        if (entity.getAttackTarget() != null)
        {
            mult = 0.08F;
            downMult = mult;
            float time = 20;

            if (entity.ticksExisted % time <= time / 2)
            {
                targetLevel = 0.1F;
            }
        }

        long resultingTime = Math.abs(entity.ticksExisted - entity.getLastAttackedEntityTime());

        if (entity.getLastAttackedEntityTime() > 0  && resultingTime > 0 && resultingTime <= 20)
        {
            mult = 1F;
            downMult = 1F;

            if (entity.ticksExisted % 3 <= 1)
            {
                targetLevel = 0F;
            }
            else
            {
                targetLevel = 1F;
            }
        }

        float currentLevel = entity.phosphorescenceLevel.get();
        float newLevel = currentLevel;

        if (currentLevel < targetLevel)
        {
            newLevel += mult;
        }
        else if (currentLevel > targetLevel)
        {
            newLevel -= downMult;
        }

        newLevel = MathHelper.clamp(newLevel, 0.1F, 1F);

        entity.phosphorescenceLevel.set(newLevel);
    }
}
