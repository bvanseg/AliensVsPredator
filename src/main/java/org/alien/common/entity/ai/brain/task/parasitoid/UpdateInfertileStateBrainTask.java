package org.alien.common.entity.ai.brain.task.parasitoid;

import net.minecraft.entity.MoverType;
import org.alien.common.entity.living.EntityParasitoid;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

/**
 * @author Boston Vanseghi
 */
public class UpdateInfertileStateBrainTask extends AbstractBrainTask<EntityBrainContext> {

    @Override
    protected boolean shouldExecute(EntityBrainContext ctx) {
        return ctx.getEntity() instanceof EntityParasitoid &&
                !((EntityParasitoid)ctx.getEntity()).isFertile();
    }

    @Override
    protected void startExecuting(EntityBrainContext ctx) {
        EntityParasitoid parasite = (EntityParasitoid) ctx.getEntity();

        if (!parasite.isAttachedToHost()) {
            parasite.setNoAI(true);
        }
    }

    @Override
    protected void continueExecuting(EntityBrainContext ctx) {
        EntityParasitoid parasite = (EntityParasitoid) ctx.getEntity();
        parasite.motionY -= 0.05F;
        parasite.motionY *= 0.98F;
        parasite.move(MoverType.SELF, 0, parasite.motionY, 0);

        parasite.timeSinceInfertile++;

        if(parasite.timeSinceInfertile >= 20 * 60 *  5) {
            parasite.setDead();
        }
    }
}
