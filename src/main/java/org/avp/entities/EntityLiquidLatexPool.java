package org.avp.entities;

import net.minecraft.world.World;

public class EntityLiquidLatexPool extends EntityLiquidPool
{
    public EntityLiquidLatexPool(World world)
    {
        super(world);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        this.motionX = 0;
        this.motionZ = 0;
        
        if (!this.world.isRemote)
        {
            if (this.ticksExisted > this.lifetime)
            {
                this.setDead();
            }
        }
    }

    public int getLifetime()
    {
        return lifetime;
    }
}
