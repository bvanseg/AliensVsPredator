package org.alien.common.entity.ai.brain.task.parasitoid;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.world.capability.Organism;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.brain.impl.BrainFlags;

import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public class AttachedToHostBrainTask extends AbstractEntityBrainTask {

    @Override
    public void setFlagRequirements(Map<AbstractBrainFlag, BrainFlagState> map) {
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
    }

    @Override
    protected boolean shouldExecute() {
        return ctx.getEntity() instanceof EntityParasitoid &&
                ((EntityParasitoid)ctx.getEntity()).isAttachedToHost() &&
                ctx.getEntity().getRidingEntity() != null &&
                ctx.getEntity().getRidingEntity() instanceof EntityLivingBase;
    }

    @Override
    protected void startExecuting() {
        EntityParasitoid parasite = (EntityParasitoid) ctx.getEntity();
        EntityLivingBase host = (EntityLivingBase) parasite.getRidingEntity();

        if (host instanceof EntityLiving) {
            EntityLiving livingHost = (EntityLiving) host;
            // Make the host stop moving.
            livingHost.setNoAI(true);
            // Silence the host.
            livingHost.livingSoundTime = -livingHost.getTalkInterval();
        }

        parasite.ticksOnHost++;

        host.motionY -= 0.05F;
        host.motionY *= 0.98F;
        host.move(MoverType.SELF, 0, host.motionY, 0);

        parasite.rotationYawHead = host.rotationYawHead;
        parasite.rotationYaw = host.rotationYaw;
        parasite.prevRotationYawHead = host.prevRotationYawHead;
        parasite.prevRotationYaw = host.prevRotationYaw;

        if(host instanceof EntityPlayer && ((EntityPlayer)host).capabilities.isCreativeMode)
        {
            Organism.OrganismImpl organism = (Organism.OrganismImpl) host.getCapability(Organism.Provider.CAPABILITY, null);
            organism.removeEmbryo();
            parasite.detachFromHost();
        }
    }
}
