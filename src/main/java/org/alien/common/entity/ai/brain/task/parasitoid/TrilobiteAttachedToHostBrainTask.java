package org.alien.common.entity.ai.brain.task.parasitoid;

import com.asx.mdx.internal.MDX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public class TrilobiteAttachedToHostBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    }

    @Override
    protected boolean shouldExecute() {
        return ctx.getEntity() instanceof Parasitoid &&
                ((Parasitoid)ctx.getEntity()).isAttachedToHost() &&
                ctx.getEntity().getRidingEntity() != null &&
                ctx.getEntity().getRidingEntity() instanceof EntityLivingBase;
    }

    @Override
    protected void startExecuting() {
        EntityTrilobite trilobite = (EntityTrilobite) ctx.getEntity();

        trilobite.ticksOnHost++;

        if (trilobite.getRidingEntity() instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) trilobite.getRidingEntity();

            living.setNoAI(true);

            living.rotationYawHead = 0;
            living.rotationYaw = 0;
            living.prevRotationYawHead = 0;
            living.prevRotationYaw = 0;

            trilobite.rotationYawHead = 0;
            trilobite.rotationYaw = 0;
            trilobite.prevRotationYawHead = 0;
            trilobite.prevRotationYaw = 0;

            EntityMoveHelper newMoveHelper = new EntityMoveHelper(living) {
                public void onUpdateMoveHelper()
                {
                    ;
                }
            };
            MDX.access().setMoveHelper(living, newMoveHelper);
            MDX.access().setMoveHelper(trilobite, newMoveHelper);

            EntityLookHelper newLookHelper = new EntityLookHelper(living) {
                public void setLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch)
                {
                    ;
                }

                public void setLookPositionWithEntity(Entity entityIn, float deltaYaw, float deltaPitch)
                {
                    ;
                }

                public float updateRotation(float x, float y, float z)
                {
                    return 0F;
                }
            };
            MDX.access().setLookHelper(living, newLookHelper);
            MDX.access().setLookHelper(trilobite, newLookHelper);
        }
    }
}
