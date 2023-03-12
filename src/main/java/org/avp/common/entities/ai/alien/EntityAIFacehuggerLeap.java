package org.avp.common.entities.ai.alien;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIFacehuggerLeap extends EntityAIBase
{
    /** The entity that is leaping. */
    EntityLiving leaper;
    /** The entity that the leaper is leaping towards. */
    EntityLivingBase leapTarget;
    
    private long nextLeapTime = 0;

    public EntityAIFacehuggerLeap(EntityLiving leapingEntity)
    {
        this.leaper = leapingEntity;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        this.leapTarget = this.leaper.getAttackTarget();

        if (this.leapTarget == null)
            return false;
        else if(this.leaper.ticksExisted < this.nextLeapTime)
            return false;
        else if(this.leaper.posY + this.leaper.getEyeHeight() > this.leapTarget.posY + this.leapTarget.getEyeHeight())
            return false;
        else if(this.leaper.getDistance(this.leapTarget) > 8.0D || !this.leaper.onGround)
            return false;
        
        return true;
    }
    
    @Override
    public void updateTask()
    {
        if(this.leaper.ticksExisted % 10 == 0)
        {
            this.leaper.motionX *= 13.5f;
            this.leaper.motionZ *= 13.5f;
            
            this.leaper.motionY = Math.sqrt(this.leapTarget.getEyeHeight()) / 2F;
            
            this.nextLeapTime += 20 * 3;            
        }
    }
}