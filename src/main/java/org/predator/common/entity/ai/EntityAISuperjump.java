package org.predator.common.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class EntityAISuperjump extends EntityAIBase
{
    private Random random;
    /** The entity that is leaping. */
    EntityLiving leaper;
    /** The entity that the leaper is leaping towards. */
    EntityLivingBase leapTarget;
    /** The entity's motionY after leaping. */
    float leapMotionY;

    public EntityAISuperjump(EntityLiving leapingEntity, float leapMotionYIn)
    {
        this.leaper = leapingEntity;
        this.leapMotionY = leapMotionYIn;
        this.setMutexBits(5);
        this.random = new Random();
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        this.leapTarget = this.leaper.getAttackTarget();

        if (this.leapTarget == null)
        {
            return false;
        }
        else
        {
            double distance = this.leaper.getDistanceSq(this.leapTarget);

            if (distance >= 30.0D && distance <= 500.0D)
            {
                if (!this.leaper.onGround)
                {
                    return false;
                }
                else
                {
                    return this.leaper.getRNG().nextInt(5) == 0;
                }
            }
            else
            {
                return false;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        return !this.leaper.onGround;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        double distX = this.leapTarget.posX - this.leaper.posX;
        double distZ = this.leapTarget.posZ - this.leaper.posZ;
        float distance = MathHelper.sqrt(distX * distX + distZ * distZ);

        if ((double)distance >= 1.0E-4D)
        {
            this.leaper.motionX += distX / (double)distance + this.leaper.motionX;
            this.leaper.motionZ += distZ / (double)distance + this.leaper.motionZ;
        }

        this.leaper.motionY = (double)this.leapMotionY + (0.3F / (1 + random.nextInt(2)));
    }
}