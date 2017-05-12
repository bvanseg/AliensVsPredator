package org.avp.entities;

import java.util.List;

import com.arisux.mdxlib.lib.game.GameSounds;
import com.arisux.mdxlib.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;

public abstract class EntityProjectile extends EntityArrow implements IThrowableEntity
{
    protected int xTile;
    protected int yTile;
    protected int zTile;
    protected Block inTile;
    protected boolean inGround;
    protected int ticksInGround;
    protected int ticksInAir;
    public boolean beenInGround;
    public float additionalDamage;
    public int knockback;

    public EntityProjectile(World world)
    {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = null;
        this.inGround = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.additionalDamage = 0;
        this.knockback = 0;
        this.setSize(0.5F, 0.5F);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public Entity getThrower()
    {
        return shootingEntity;
    }

    @Override
    public void setThrower(Entity entity)
    {
        shootingEntity = entity;
    }

    @Override
    public void setThrowableHeading(double posX, double posY, double posZ, float velocity, float deviation)
    {
        float sq = MathHelper.sqrt(posX * posX + posY * posY + posZ * posZ);
        posX /= sq;
        posY /= sq;
        posZ /= sq;
        posX += rand.nextGaussian() * 0.0075F * deviation;
        posY += rand.nextGaussian() * 0.0075F * deviation;
        posZ += rand.nextGaussian() * 0.0075F * deviation;
        posX *= velocity;
        posY *= velocity;
        posZ *= velocity;
        this.motionX = posX;
        this.motionY = posY;
        this.motionZ = posZ;
        float f3 = MathHelper.sqrt(posX * posX + posZ * posZ);
        this.prevRotationYaw = rotationYaw = (float) ((Math.atan2(posX, posZ) * 180D) / Math.PI);
        this.prevRotationPitch = rotationPitch = (float) ((Math.atan2(posY, f3) * 180D) / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
    public void setVelocity(double motionX, double motionY, double motionZ)
    {
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;

        if (aimRotation() && prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
        {
            this.prevRotationYaw = rotationYaw = (float) ((Math.atan2(motionX, motionZ) * 180D) / Math.PI);
            this.prevRotationPitch = rotationPitch = (float) ((Math.atan2(motionY, MathHelper.sqrt(motionX * motionX + motionZ * motionZ)) * 180D) / Math.PI);
            this.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @Override
    public void onUpdate()
    {
        this.onEntityUpdate();
    }

    @Override
    public void onEntityUpdate()
    {
        super.onEntityUpdate();

        if (aimRotation())
        {
            prevRotationYaw = rotationYaw = (float) ((Math.atan2(motionX, motionZ) * 180D) / Math.PI);
            prevRotationPitch = rotationPitch = (float) ((Math.atan2(motionY, MathHelper.sqrt(motionX * motionX + motionZ * motionZ)) * 180D) / Math.PI);
        }

        BlockPos pos = new BlockPos(this.xTile, this.yTile, this.zTile);    
        IBlockState blockstate = this.world.getBlockState(pos);
        Block block = blockstate.getBlock();

        if (block != null)
        {
            AxisAlignedBB box = blockstate.getBoundingBox(this.world, pos);

            if (box != null && box.isVecInside(new Vec3d(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0)
        {
            this.arrowShake--;
        }

        if (this.inGround)
        {
            Block blockIn = block;

            if (blockIn == this.inTile)
            {
                ticksInGround++;

                if (this.getLifetime() != 0 && this.ticksInGround >= this.getLifetime())
                {
                    this.setDead();
                }
            }
            else
            {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2F;
                this.motionY *= this.rand.nextFloat() * 0.2F;
                this.motionZ *= this.rand.nextFloat() * 0.2F;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
            return;
        }

        ticksInAir++;

        Vec3d vecPos = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d vecPosNext = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult hit = world.rayTraceBlocks(vecPos, vecPosNext, false, true, false);

        if (hit != null)
        {
            vecPosNext = new Vec3d(hit.hitVec.xCoord, hit.hitVec.yCoord, hit.hitVec.zCoord);
        }

        Entity target = null;
        @SuppressWarnings("unchecked")
        List<Entity> possibleTargets = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
        double distanceTo = 0.0D;

        for (int x = 0; x < possibleTargets.size(); x++)
        {
            Entity possibleTarget = possibleTargets.get(x);
            if (!possibleTarget.canBeCollidedWith() || possibleTarget == shootingEntity && ticksInAir < 5)
            {
                continue;
            }
            float radius = 0.3F;
            AxisAlignedBB targetBounds = possibleTarget.getEntityBoundingBox().expand(radius, radius, radius);
            RayTraceResult intercept = targetBounds.calculateIntercept(vecPos, vecPosNext);

            if (intercept == null)
            {
                continue;
            }

            double distance = vecPos.distanceTo(intercept.hitVec);

            if (distance < distanceTo || distanceTo == 0.0D)
            {
                target = possibleTarget;
                distanceTo = distance;
            }
        }

        if (target != null)
        {
            hit = new RayTraceResult(target);
        }

        if (hit != null)
        {
            if (hit.entityHit != null)
            {
                this.onEntityHit(hit.entityHit);
            }
            else
            {
                this.onGroundHit(hit);
            }
        }

        if (this.getIsCritical())
        {
            for (int x = 0; x < 2; x++)
            {
                this.world.spawnParticle(EnumParticleTypes.CRIT, posX + (motionX * x) / 4D, posY + (motionY * x) / 4D, posZ + (motionZ * x) / 4D, -motionX, -motionY + 0.2D, -motionZ);
            }
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;

        if (this.aimRotation())
        {
            this.rotationYaw = (float) ((Math.atan2(this.motionX, this.motionZ) * 180D) / Math.PI);

            for (this.rotationPitch = (float) ((Math.atan2(this.motionY, MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ)) * 180D) / Math.PI); this.rotationPitch - this.prevRotationPitch < -180F; this.prevRotationPitch -= 360F)
            {
                ;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180F)
            {
                this.prevRotationPitch += 360F;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180F)
            {
                this.prevRotationYaw -= 360F;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180F)
            {
                this.prevRotationYaw += 360F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        }

        float resistance = getAirResistance();
        float gravity = getGravity();

        if (this.isInWater())
        {
            this.beenInGround = true;

            for (int x = 0; x < 4; x++)
            {
                float radius = 0.25F;
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * radius, this.posY - this.motionY * radius, this.posZ - this.motionZ * radius, this.motionX, this.motionY, this.motionZ);
            }

            resistance *= 0.80808080F;
        }

        this.motionX *= resistance;
        this.motionY *= resistance;
        this.motionZ *= resistance;
        this.motionY -= gravity;
        this.setPosition(posX, posY, posZ);
        Entities.applyCollision(this);
    }

    public void onEntityHit(Entity entity)
    {
        this.applyEntityHitEffects(entity);
        this.bounce();
    }

    public void applyEntityHitEffects(Entity entity)
    {
        if (this.isBurning() && !(entity instanceof EntityEnderman))
        {
            entity.setFire(5);
        }

        if (entity instanceof EntityLivingBase)
        {
            EntityLivingBase entityliving = (EntityLivingBase) entity;

            if (this.knockback > 0)
            {
                float sq = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

                if (sq > 0.0F)
                {
                    entity.addVelocity(this.motionX * this.knockback * 0.6D / sq, 0.1D, this.motionZ * this.knockback * 0.6D / sq);
                }
            }

            if (this.shootingEntity instanceof EntityLivingBase)
            {
                EnchantmentHelper.applyThornEnchantments(entityliving, this.shootingEntity);
                EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase) this.shootingEntity, entityliving);
            }

            if (this.shootingEntity instanceof EntityPlayerMP && this.shootingEntity != entity && entity instanceof EntityPlayer)
            {
                ((EntityPlayerMP) shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0));
            }
        }
    }

    public void onGroundHit(RayTraceResult movingObjPos)
    {
        BlockPos pos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState blockstate = world.getBlockState(pos);
        this.xTile = (int) movingObjPos.hitVec.xCoord;
        this.yTile = (int) movingObjPos.hitVec.yCoord;
        this.zTile = (int) movingObjPos.hitVec.zCoord;
        this.inTile = blockstate.getBlock();
        this.motionX = movingObjPos.hitVec.xCoord - this.posX;
        this.motionY = movingObjPos.hitVec.yCoord - this.posY;
        this.motionZ = movingObjPos.hitVec.zCoord - this.posZ;
        float sq = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.posX -= this.motionX / sq * 0.05D;
        this.posY -= this.motionY / sq * 0.05D;
        this.posZ -= this.motionZ / sq * 0.05D;
        this.inGround = true;
        this.beenInGround = true;
        this.setIsCritical(false);
        this.arrowShake = this.getMaxArrowShake();
        this.playHitSound();

        if (this.inTile != null)
        {
            this.inTile.onEntityCollidedWithBlock(this.world, pos, blockstate, this);
        }
    }

    protected void bounce()
    {
        this.motionX *= -0.1D;
        this.motionY *= -0.1D;
        this.motionZ *= -0.1D;
        this.rotationYaw += 180F;
        this.prevRotationYaw += 180F;
        this.ticksInAir = 0;
    }

    public final double getVelocity()
    {
        return Math.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
    }

    public ItemStack getItemstack()
    {
        return null;
    }

    public boolean aimRotation()
    {
        return true;
    }

    public int getLifetime()
    {
        return 1200;
    }

    public float getAirResistance()
    {
        return 0.99F;
    }

    public float getGravity()
    {
        return 0.05F;
    }

    public int getMaxArrowShake()
    {
        return 7;
    }

    public void playHitSound()
    {
        ;
    }

    public boolean canBeCritical()
    {
        return false;
    }

    public void setAdditionalDamage(float additionalDamage)
    {
        this.additionalDamage = additionalDamage;
    }

    @Override
    public void setKnockbackStrength(int knockback)
    {
        this.knockback = knockback;
    }

    public boolean canPickup(EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if (this.inGround && this.arrowShake <= 0)
        {
            if (this.canPickup(entityplayer))
            {
                if (!this.world.isRemote)
                {
                    ItemStack item = new ItemStack(this.getItemstack().getItem(), 1, this.getItemstack().getItemDamage() + 1);

                    if (item != null && entityplayer.inventory.addItemStackToInventory(item))
                    {
                        GameSounds.fxPop.playSound(this, 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                        this.onItemPickup(entityplayer);
                        this.setDead();
                    }
                }
            }
        }
    }

    protected void onItemPickup(EntityPlayer entityplayer)
    {
        entityplayer.onItemPickup(this, 1);
    }

    @Override
    public float getCollisionBorderSize()
    {
        return 1F;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        tag.setShort("xTile", (short) this.xTile);
        tag.setShort("yTile", (short) this.yTile);
        tag.setShort("zTile", (short) this.zTile);
        tag.setByte("inTile", (byte) Block.getIdFromBlock(this.inTile));
        tag.setByte("shake", (byte) this.arrowShake);
        tag.setBoolean("inGround", this.inGround);
        tag.setBoolean("beenInGround", this.beenInGround);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        this.xTile = tag.getShort("xTile");
        this.yTile = tag.getShort("yTile");
        this.zTile = tag.getShort("zTile");
        this.inTile = Block.getBlockById(tag.getByte("inTile") & 0xFF);
        this.arrowShake = tag.getByte("shake") & 0xFF;
        this.inGround = tag.getBoolean("inGround");
        this.beenInGround = tag.getBoolean("beenInGrond");
    }
}
