package org.avp.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.avp.common.api.Resizable;

/**
 * @author Ri5ux
 */
public class EntityLiquidPool extends Entity implements Resizable
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
    protected void entityInit() { /* Do Nothing */ }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) { /* Do Nothing */ }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) { /* Do Nothing */ }

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

        if (!this.world.isRemote && (this.ticksExisted > this.lifetime)) {
            this.setDead();
        }
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    @Override
    public void resize(float width, float height) {
        this.setSize(width, height);
    }
}
