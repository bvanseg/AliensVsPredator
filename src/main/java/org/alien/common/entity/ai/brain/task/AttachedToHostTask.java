package org.alien.common.entity.ai.brain.task;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.EntityParasitoid;
import org.alien.common.world.capability.IOrganism;
import org.lib.brain.Brainiac;
import org.lib.brain.flag.AbstractBrainFlag;
import org.lib.brain.flag.BrainFlagState;
import org.lib.brain.impl.BrainFlags;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.task.AbstractBrainTask;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public class AttachedToHostTask extends AbstractBrainTask<EntityBrainContext> {

    private static final Map<AbstractBrainFlag, BrainFlagState> FLAGS = createFlags();

    public static Map<AbstractBrainFlag, BrainFlagState> createFlags() {
        Map<AbstractBrainFlag, BrainFlagState> map = new HashMap<>();
        map.put(BrainFlags.MOVE, BrainFlagState.ABSENT);
        return map;
    }
    @Override
    public Map<AbstractBrainFlag, BrainFlagState> getFlags() {
        return FLAGS;
    }

    @Override
    protected boolean shouldExecute(EntityBrainContext ctx) {
        return ctx.getEntity() instanceof EntityParasitoid &&
                ((EntityParasitoid)ctx.getEntity()).isAttachedToHost() &&
                ctx.getEntity().getRidingEntity() != null &&
                ctx.getEntity().getRidingEntity() instanceof EntityLivingBase;
    }

    @Override
    protected void execute(EntityBrainContext ctx) {
        EntityParasitoid parasite = (EntityParasitoid) ctx.getEntity();
        EntityLivingBase host = (EntityLivingBase) parasite.getRidingEntity();

        parasite.ticksOnHost++;

        if (host instanceof EntityLiving) {
            ((EntityLiving)host).setNoAI(true);

            if (host instanceof Brainiac) {
                ((Brainiac<?>)host).setBrainDisabled(true);
            }
        }

        host.motionY -= 0.05F;
        host.motionY *= 0.98F;
        host.move(MoverType.SELF, 0, host.motionY, 0);

        parasite.rotationYawHead = host.rotationYawHead;
        parasite.rotationYaw = host.rotationYaw;
        parasite.prevRotationYawHead = host.prevRotationYawHead;
        parasite.prevRotationYaw = host.prevRotationYaw;

        if(host instanceof EntityPlayer && ((EntityPlayer)host).capabilities.isCreativeMode)
        {
            IOrganism.Organism organism = (IOrganism.Organism) host.getCapability(IOrganism.Provider.CAPABILITY, null);
            organism.removeEmbryo();
            parasite.detachFromHost();
        }
    }
}
