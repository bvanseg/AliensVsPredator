package org.avp.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityLiquidPool extends Entity
{
    protected int lifetime;

    public EntityLiquidPool(World world)
    {
        super(world);
        this.lifetime = 600;
        this.isImmuneToFire = false;
        this.ignoreFrustumCheck = true;
        this.setSize(0.08F, 0.08F);
        this.rotationYaw = this.rand.nextInt(360);
    }

    @Override
    protected void entityInit()
    {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean isInRangeToRenderDist(double range)
    {
        return true;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        this.motionX = 0;
        this.motionY -= 0.03999999910593033D;
        this.motionZ = 0;
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionY *= 0.9800000190734863D;

        if (!this.world.isRemote)
        {
            if (this.ticksExisted > this.lifetime)
            {
                this.setDead();
            }
        }
    }
}
