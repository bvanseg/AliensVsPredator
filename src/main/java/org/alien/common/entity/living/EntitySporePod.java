package org.alien.common.entity.living;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class EntitySporePod extends Entity
{
    private int podCount;
    
    public EntitySporePod(World world)
    {
        super(world);
        this.ignoreFrustumCheck = true;
        this.setSize(0.5F, 0.5F);
        this.setRandomAmountOfPods();
    }

    @Override
    protected void entityInit()
    {
        ;
    }

    @Override
    public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }

    public boolean canStay()
    {
        List<Entity> entities = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());

        for (Entity entity : entities)
        {
            if (entity instanceof EntitySporePod)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return true;
    }

    @Override
    public Vec3d getLookVec()
    {
        float f1 = MathHelper.cos(-this.rotationYaw * 0.017453292F - (float) Math.PI);
        float f2 = MathHelper.sin(-this.rotationYaw * 0.017453292F - (float) Math.PI);
        float f3 = -MathHelper.cos(-this.rotationPitch * 0.017453292F);
        float f4 = MathHelper.sin(-this.rotationPitch * 0.017453292F);
        return new Vec3d((f2 * f3), f4, -(f1 * f3));
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        if (this.rotationYaw == 0)
        {
            this.rotationYaw = this.rand.nextInt(360);
        }

        float v = 0.99F;

        if (this.isInWater())
        {
            for (int var24 = 0; var24 < 4; ++var24)
            {
                float r = 0.25F;
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * r, this.posY - this.motionY * r, this.posZ - this.motionZ * r, this.motionX, this.motionY, this.motionZ);
            }

            v = 0.8F;
        }

        this.motionX *= v;
        this.motionY *= v;
        this.motionZ *= v;
        this.motionY -= this.motionX + this.motionZ > 0.7 ? 0.01F : 0.09F;
        this.move(MoverType.SELF, 0F, this.motionY, 0F);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float damage)
    {
        if (!this.world.isRemote)
        {
            this.setDead();
        }

        return true;
    }
    
    public int setRandomAmountOfPods()
    {
        return this.podCount = 1 + rand.nextInt(5);
    }
    
    public int getPodCount()
    {
        return podCount;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        this.podCount = compound.getInteger("PodCount");
    }
    
    @Override
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setInteger("PodCount", this.podCount);
    }
}
