package org.avp.entities;

import net.minecraft.entity.SharedMonsterAttributes;
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
    public boolean isAIDisabled()
    {
        return false;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
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
