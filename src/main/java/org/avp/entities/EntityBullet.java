package org.avp.entities;

import java.util.List;

import org.avp.DamageSources;
import org.avp.entities.living.EntityMarine;

import com.asx.mdx.lib.util.GameSounds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityBullet extends Entity
{
    private int     xTile;
    private int     yTile;
    private int     zTile;
    private Block   inTile;
    private int     arrowShake;
    private int     ticksInGround;
    private int     ticksInAir;
    private boolean inGround;
    private boolean doesArrowBelongToPlayer;
    private boolean arrowCritical;
    private boolean physics;
    public Entity   shootingEntity;
    public double   damage;

    public EntityBullet(World world)
    {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.AIR;
        this.inGround = false;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.arrowCritical = false;
        this.setSize(0.5F, 0.5F);
    }

    public EntityBullet(World world, double x, double y, double z)
    {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.AIR;
        this.inGround = false;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.arrowCritical = true;
        this.setSize(0.5F, 0.5F);
        this.setPosition(x, y, z);
    }

    public EntityBullet(World world, Object source, float velocity, double damage)
    {
        super(world);
        this.damage = damage;
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.AIR;
        this.inGround = false;
        this.physics = true;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.arrowCritical = true;
        this.setSize(0.5F, 0.5F);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.posY -= 0.10000000149011612D;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
        this.shoot(this.motionX, this.motionY, this.motionZ, velocity * 1.5F, 1.0F);

        if (source instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) source;
            this.shootingEntity = living;
            this.setLocationAndAngles(living.posX, living.posY + living.getEyeHeight(), living.posZ, living.rotationYaw, living.rotationPitch);

            if (source instanceof EntityPlayer)
            {
                this.doesArrowBelongToPlayer = living instanceof EntityPlayer;
            }
        }
    }

    public EntityBullet(World world, Object source, Entity targetEntity, float velocity, double damage)
    {
        super(world);
        this.damage = damage;
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.AIR;
        this.inGround = false;
        this.physics = true;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.arrowCritical = true;
        this.setSize(0.5F, 0.5F);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.posY -= 0.10000000149011612D;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));

        double srcX = 0;
        double srcZ = 0;

        if (source instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) source;
            this.shootingEntity = living;

            this.setLocationAndAngles(living.posX, living.posY + living.getEyeHeight(), living.posZ, living.rotationYaw, living.rotationPitch);
            srcX = living.posX;
            srcZ = living.posZ;

            if (source instanceof EntityPlayer)
            {
                this.doesArrowBelongToPlayer = living instanceof EntityPlayer;
            }
        }

        double x = targetEntity.posX - srcX;
        double y = targetEntity.getEntityBoundingBox().maxY - this.posY;
        double z = targetEntity.posZ - srcZ;
        double v = MathHelper.sqrt(x * x + z * z);

        if (v >= 1.0E-7D)
        {
            float yaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
            float pitch = (float) (-(Math.atan2(y, v) * 180.0D / Math.PI));
            double xOffset = x / v;
            double zOffset = z / v;
            this.setLocationAndAngles(srcX + xOffset, this.posY, srcZ + zOffset, yaw, pitch);
            this.shoot(x, y, z, velocity, damage);
        }
    }

    @Override
    protected void entityInit()
    {
        ;
    }

    public void shoot(double posX, double posY, double posZ, float velocity, double damage)
    {
        float v = MathHelper.sqrt(posX * posX + posY * posY + posZ * posZ);
        posX /= v;
        posY /= v;
        posZ /= v;
        posX += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * damage;
        posY += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * damage;
        posZ += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * damage;
        posX *= velocity;
        posY *= velocity;
        posZ *= velocity;
        this.motionX = posX;
        this.motionY = posY;
        this.motionZ = posZ;
        float v2 = MathHelper.sqrt(posX * posX + posZ * posZ);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(posX, posZ) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(posY, v2) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
    public void setVelocity(double motionX, double motionY, double motionZ)
    {
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float velocity = MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(motionY, velocity) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onUpdate()
    {
        if (this.ticksInAir > 160 || this.ticksInGround > 20)
        {
            this.setDead();
        }

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, velocity) * 180.0D / Math.PI);
        }

        BlockPos pos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState blockstate = this.world.getBlockState(pos);
        Block block = blockstate.getBlock();

        if (block != Blocks.AIR)
        {
            AxisAlignedBB box = blockstate.getCollisionBoundingBox(this.world, pos);

            if (box != null && box.contains(new Vec3d(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0)
        {
            --this.arrowShake;
        }

        if (this.isInWater())
        {
            this.setDead();
        }

        if (this.inGround)
        {
            if (block == Blocks.GLASS_PANE)
            {
                this.world.setBlockToAir(pos);
                GameSounds.fxMinecraftGlassShatter3.playSound(this.world, this.xTile, this.yTile, this.zTile, 1F, 1F);;
                GameSounds.fxMinecraftGlassShatter1.playSound(this.shootingEntity);;
            }

            if (block == this.inTile)
            {
                ++this.ticksInGround;

                if (!this.isInWater())
                {
                    this.setDead();
                }

                if (this.ticksInGround > 20)
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
        }
        else
        {
            ++this.ticksInAir;
            Vec3d vecAt = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d vecNext = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult result = this.world.rayTraceBlocks(vecAt, vecNext, false, true, false);
            vecAt = new Vec3d(this.posX, this.posY, this.posZ);
            vecNext = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (result != null)
            {
                vecNext = new Vec3d(result.hitVec.x, result.hitVec.y, result.hitVec.z);
            }

            Entity entity = null;
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d = 0.0D;
            float radius;

            for (int index = 0; index < list.size(); ++index)
            {
                Entity e = list.get(index);

                if (e.canBeCollidedWith() && (e != this.shootingEntity || this.ticksInAir >= 5))
                {
                    radius = 0.3F;
                    AxisAlignedBB bounds = e.getEntityBoundingBox().expand(radius, radius, radius);
                    RayTraceResult intercept = bounds.calculateIntercept(vecAt, vecNext);

                    if (intercept != null)
                    {
                        double d1 = vecAt.distanceTo(intercept.hitVec);

                        if (d1 < d || d == 0.0D)
                        {
                            entity = e;
                            d = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                result = new RayTraceResult(entity);
            }

            float velocity;

            if (result != null)
            {
                if (result.entityHit != null)
                {
                    if (this.shootingEntity instanceof EntityTurret)
                    {
                        EntityTurret entityTurret = (EntityTurret) this.shootingEntity;

                        if (!entityTurret.getTileEntity().canTargetType(result.entityHit.getClass()))
                        {
                            entityTurret.getTileEntity().setTargetEntity(result.entityHit);
                        }
                    }

                    if (this.shootingEntity instanceof EntityMarine && (result.entityHit instanceof EntityMarine))
                    {
                        this.setDead();
                        return;
                    }

                    velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int attackDamage = (int) Math.ceil(velocity * damage);

                    if (this.arrowCritical)
                    {
                        attackDamage += this.rand.nextInt(attackDamage / 2 + 2);
                    }

                    DamageSource damagesource = this.shootingEntity == null ? DamageSources.causeBulletDamage(this) : DamageSources.bullet;
                    result.entityHit.hurtResistantTime = 0;

                    if (result.entityHit instanceof EntityLivingBase)
                    {
                        ((EntityLivingBase) result.entityHit).getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.9);
                        result.entityHit.attackEntityFrom(damagesource, attackDamage);
                        this.setDead();
                    }
                }
                else
                {
                    this.xTile = (int) result.hitVec.x;
                    this.yTile = (int) result.hitVec.y;
                    this.zTile = (int) result.hitVec.z;
                    this.inTile = this.world.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock();
                    this.motionX = ((float) (result.hitVec.x - this.posX));
                    this.motionY = ((float) (result.hitVec.y - this.posY));
                    this.motionZ = ((float) (result.hitVec.z - this.posZ));
                    velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / velocity * 0.05000000074505806D;
                    this.posY -= this.motionY / velocity * 0.05000000074505806D;
                    this.posZ -= this.motionZ / velocity * 0.05000000074505806D;
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.arrowCritical = false;
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float) (Math.atan2(this.motionY, velocity) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
            {
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
            {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
            {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
            {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float newVelocity = 0.99F;
            radius = 0.05F;

            if (!this.isDead)
            {
                for (int particles = 0; particles < 5; ++particles)
                {
                    this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
                }

                newVelocity = 0.8F;
            }

            if (this.isInWater())
            {
                for (int particles = 0; particles < 5; ++particles)
                {
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
                }

                newVelocity = 0.8F;
            }

            if (this.physics)
            {
                this.motionX *= newVelocity;
                this.motionY *= newVelocity;
                this.motionZ *= newVelocity;
                this.motionY -= 0.05F;
            }
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    public void setPhysics(boolean physics)
    {
        this.physics = physics;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        var1.setShort("xTile", (short) this.xTile);
        var1.setShort("yTile", (short) this.yTile);
        var1.setShort("zTile", (short) this.zTile);
        var1.setByte("shake", (byte) this.arrowShake);
        var1.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        var1.setBoolean("player", this.doesArrowBelongToPlayer);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        this.xTile = var1.getShort("xTile");
        this.yTile = var1.getShort("yTile");
        this.zTile = var1.getShort("zTile");
        this.arrowShake = var1.getByte("shake") & 255;
        this.inGround = var1.getByte("inGround") == 1;
        this.doesArrowBelongToPlayer = var1.getBoolean("player");
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if (!this.doesArrowBelongToPlayer)
        {
            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.setDead();
        }
    }
}
