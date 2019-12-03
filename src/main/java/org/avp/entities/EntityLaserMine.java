package org.avp.entities;

import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.packets.server.PacketDamageEntity;

import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityLaserMine extends Entity
{
    private String ownerUUID;
    public int direction;
    public RayTraceResult laserHit;

    public EntityLaserMine(World world)
    {
        super(world);
        this.ignoreFrustumCheck = true;
        this.setSize(0.5F, 0.5F);
    }

    public EntityLaserMine(World world, BlockPos pos, int direction, String ownerUUID)
    {
        this(world);
        this.direction = direction;
        this.ownerUUID = ownerUUID;
        this.moveToBlockPosAndAngles(pos, 0F, 0F);
        this.setDirectionBasedBounds(direction);
    }

    @Override
    protected void entityInit()
    {
        ;
    }
    
    public boolean canStay()
    {
        List<Entity> entities = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());

        for (Entity entity : entities)
        {
            if (entity instanceof EntityLaserMine)
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

        if (this.world.getTotalWorldTime() % 10 == 0)
        {
            this.laserHit = Entities.rayTraceAll(this, this.getLaserMaxDepth());
        }

        if (this.world.isRemote)
        {
            if (this.getLaserHit() != null && this.getLaserHit().entityHit != null)
            {
                if (!(this.getLaserHit().entityHit instanceof EntityLaserMine))
                {
                    if (!(this.getLaserHit().entityHit instanceof EntityPlayer))
                    {
                        this.explode(this.getLaserHit().entityHit);
                    }
                    else if (this.getLaserHit().entityHit instanceof EntityPlayer && !((EntityPlayer) this.getLaserHit().entityHit).capabilities.isCreativeMode)
                    {
                        this.explode(this.getLaserHit().entityHit);
                    }
                }
            }

            if (!this.canStay())
            {
                this.drop();
            }
        }
    }

    public RayTraceResult getLaserHit()
    {
        return laserHit;
    }

    public int getLaserMaxDepth()
    {
        return 32;
    }

    public double getLaserHitDistanceFromMine()
    {
        if (this.getLaserHit() != null && this.getLaserHit().entityHit != null)
        {
            return (this.posX - this.getLaserHit().entityHit.posX) + (this.posZ - this.getLaserHit().entityHit.posZ) + (this.posY - this.getLaserHit().entityHit.posY);
        }

        if (this.getLaserHit() != null && this.getLaserHit().hitVec != null)
        {
            return (this.posX - this.getLaserHit().hitVec.x) + (this.posZ - this.getLaserHit().hitVec.z) + (this.posY - this.getLaserHit().hitVec.y);
        }

        return this.getLaserMaxDepth();
    }

    public void drop()
    {
        this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(AliensVsPredator.items().itemProximityMine)));
        this.setDead();
    }

    public void explode(Entity entityHit)
    {
        Explosion explosion = new Explosion(world, this, this.posX, this.posY, this.posZ, 4F, false, false);
        explosion.doExplosionB(true);

        if (entityHit != null)
        {
            entityHit.attackEntityFrom(DamageSources.causeLaserMineDamage(this, entityHit), 15F);

            if (this.world.isRemote)
            {
                AliensVsPredator.network().sendToServer(new PacketDamageEntity(entityHit, this, 15F));
            }
        }

        this.setDead();
    }

    public void setDirectionBasedBounds(int side)
    {
        this.rotationYaw = 90F * (this.direction);
        float bounds = -0.00625F;

        float xPos = (float) (this.posX + 0.5F);
        float yPos = (float) (this.posY + 0.5F);
        float zPos = (float) (this.posZ + 0.5F);
        float f6 = 0.53F;

        switch(side)
        {
            case 0:
                xPos -= f6;
                zPos -= f6 * 2;
                break;
            case 1:
                xPos -= f6 * 2;
                zPos -= f6;
                break;
            case 2:
                xPos -= f6;
                zPos += 0.06f;
                break;
            case 3:
                xPos += 0.06f;
                zPos -= f6;
                break;
        }

        this.setPosition(xPos, yPos, zPos);
        this.setEntityBoundingBox(new AxisAlignedBB(xPos - bounds, yPos - bounds, zPos - bounds, xPos + bounds, yPos + bounds, zPos + bounds));
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float damage)
    {
        if (!this.world.isRemote)
        {
            this.drop();
        }

        return true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setByte("Dir", (byte) this.direction);
        nbttagcompound.setString("Owner", this.ownerUUID);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        // this.setDirectionBasedBounds(this.direction = nbttagcompound.getByte("Dir"));
        this.direction = nbttagcompound.getByte("Dir");
        this.ownerUUID = nbttagcompound.getString("Owner");
    }
}
