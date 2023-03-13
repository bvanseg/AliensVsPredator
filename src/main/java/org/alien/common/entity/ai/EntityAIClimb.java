package org.alien.common.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import org.alien.common.entity.living.SpeciesXenomorph;

public class EntityAIClimb extends EntityAIBase
{
    private SpeciesXenomorph xenomorph;
    private float climbSpeed;

    public EntityAIClimb(SpeciesXenomorph xenomorph, float climbSpeed)
    {
        super();
        this.xenomorph = xenomorph;
        this.climbSpeed = climbSpeed;
    }

    @Override
    public boolean shouldExecute()
    {
        return xenomorph.isAbleToClimb();
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return xenomorph.isAbleToClimb() && xenomorph.collidedHorizontally;
    }

    @Override
    public void updateTask()
    {
        super.updateTask();

        xenomorph.motionY += this.climbSpeed;
    }
}
