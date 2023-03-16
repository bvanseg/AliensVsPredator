package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.MoverType;
import org.alien.common.entity.living.EntityParasitoid;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.Collections;
import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public class UpdateInfertileStateBrainTask extends AbstractBrainTask<EntityBrainContext> {

    @Override
    public Map<AbstractBrainFlag, BrainFlagState> getFlagRequirements() {
        return Collections.emptyMap();
    }

    @Override
    protected boolean shouldExecute(EntityBrainContext ctx) {
        return ctx.getEntity() instanceof EntityParasitoid &&
                !((EntityParasitoid)ctx.getEntity()).isFertile();
    }

    @Override
    protected void execute(EntityBrainContext ctx) {
        EntityParasitoid parasite = (EntityParasitoid) ctx.getEntity();

        if (!parasite.isAttachedToHost()) {
            parasite.setNoAI(true);
            parasite.setBrainDisabled(true);
        }

        parasite.motionY -= 0.05F;
        parasite.motionY *= 0.98F;
        parasite.move(MoverType.SELF, 0, parasite.motionY, 0);


        parasite.timeSinceInfertile++;

        if(parasite.timeSinceInfertile >= 20 * 60 *  5) {
            parasite.setDead();
        }
    }
}
