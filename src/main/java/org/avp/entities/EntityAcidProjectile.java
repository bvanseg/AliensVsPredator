package org.avp.entities;

import java.util.List;

import org.avp.DamageSources;

import com.asx.mdx.lib.world.Pos;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAcidProjectile extends Entity implements IProjectile
{
    private BlockPos    tile;
    private Block       inTile;
    private boolean     inGround;
    public int          canBePickedUp;
    public int          shake;
    public Entity       shootingEntity;
    private int         ticksInGround;
    private int         ticksInAir;
    private double      damage = 2.0D;
    private int         knockbackStrength;

    public EntityAcidProjectile(World world)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
    }

    public EntityAcidProjectile(World world, double posX, double posY, double posZ)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.setPosition(posX, posY, posZ);
    }

    public EntityAcidProjectile(World world, EntityLivingBase shooter, EntityLivingBase target, float velocity, float deviation)
    {
        super(world);
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer)
        {
            this.canBePickedUp = 1;
        }

        this.posY = shooter.posY + shooter.getEyeHeight()  / 1.5D;
        double distX = target.posX - shooter.posX;
        double distY = target.getEntityBoundingBox().minY + target.height / 3.0F - this.posY;
        double distZ = target.posZ - shooter.posZ;
        double distSq = MathHelper.sqrt(distX * distX + distZ * distZ);

        if (distSq >= 1.0E-7D)
        {
            this.setLocationAndAngles(shooter.posX + (distX / distSq), this.posY, shooter.posZ + (distZ / distSq), (float) (Math.atan2(distZ, distX) * 180.0D / Math.PI) - 90.0F, (float) (-(Math.atan2(distY, distSq) * 180.0D / Math.PI)));
            this.shoot(distX, distY + ((float) distSq * 0.2F), distZ, velocity, deviation);
        }
    }

    public EntityAcidProjectile(World world, EntityLivingBase shooter, float velocity)
    {
        super(world);
        setRenderDistanceWeight(10D);
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer)
        {
            this.canBePickedUp = 1;
        }

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(shooter.posX, shooter.posY + shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.posY -= 0.10000000149011612D;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
        this.shoot(this.motionX, this.motionY, this.motionZ, velocity * 1.5F, 1.0F);
    }

    private static final DataParameter<Byte> CRITICAL = EntityDataManager.<Byte> createKey(EntityAcidProjectile.class, DataSerializers.BYTE);

    @Override
    protected void entityInit()
    {
        this.dataManager.register(CRITICAL, (byte) 0);
    }
    
    @Override
    public void shoot(double par1, double par3, double par5, float velocity, float deviation)
    {
        float f2 = MathHelper.sqrt(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= f2;
        par3 /= f2;
        par5 /= f2;
        par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * deviation;
        par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * deviation;
        par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * deviation;
        par1 *= velocity;
        par3 *= velocity;
        par5 *= velocity;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float f3 = MathHelper.sqrt(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(par3, f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double motionX, double motionY, double motionZ)
    {
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(motionY, f) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @Override
    @SuppressWarnings("all")
    public void onUpdate()
    {
        super.onUpdate();

        if (((this.prevPosX - this.posX) + (this.prevPosY - this.posY) + (this.prevPosZ - this.prevPosZ)) == 0)
        {
            if (!world.isRemote && this.inGround)
            {
                Entity entity = new EntityAcidPool(world);
                entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
                world.spawnEntity(entity);
                this.setDead();
            }
        }

        Block block;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ)) * 180.0D / Math.PI);
        }

        block = this.world.getBlockState(this.getPosition()).getBlock();

        if (block != null)
        {
            AxisAlignedBB box = block.getCollisionBoundingBox(this.world.getBlockState(this.getPosition()), this.world, this.tile);

            if (box != null && box.contains(new Vec3d(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if (this.shake > 0)
        {
            --this.shake;
        }

        if (this.inGround)
        {
            IBlockState state = this.world.getBlockState(tile);

            if (block != this.inTile)
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
            Vec3d pos = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d nextPos = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult result = this.world.rayTraceBlocks(pos, nextPos, false, true, true);
            pos = new Vec3d(this.posX, this.posY, this.posZ);
            nextPos = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (result != null)
            {
                nextPos = new Vec3d(result.hitVec.x, result.hitVec.y, result.hitVec.z);
            }

            Entity entity = null;
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            float radius = 0.3F;

            for (int idx = 0; idx < list.size(); ++idx)
            {
                Entity e = list.get(idx);

                if (e.canBeCollidedWith() && (e != this.shootingEntity || this.ticksInAir >= 5))
                {
                    AxisAlignedBB boundingBox = e.getEntityBoundingBox().expand(radius, radius, radius);
                    RayTraceResult interceptResult = boundingBox.calculateIntercept(pos, nextPos);

                    if (interceptResult != null)
                    {
                        double j1 = pos.distanceTo(interceptResult.hitVec);

                        if (j1 < d0 || d0 == 0.0D)
                        {
                            entity = e;
                            d0 = j1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                result = new RayTraceResult(entity);
            }

            if (result != null && result.entityHit != null && result.entityHit instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) result.entityHit;

                if (player.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer) this.shootingEntity).canAttackPlayer(player))
                {
                    result = null;
                }
            }

            float var21;
            float var22;

            if (result != null)
            {
                if (result.entityHit != null)
                {
                    var22 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int var23 = MathHelper.ceil(var22 * this.damage);

                    if (this.getIsCritical())
                    {
                        var23 += this.rand.nextInt(var23 / 2 + 2);
                    }

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null)
                    {
                        damagesource = DamageSources.acidProjectile;
                    }
                    else
                    {
                        damagesource = DamageSources.causeAcidicProjectileDamage(this, this.shootingEntity);
                    }

                    if (this.isBurning() && !(result.entityHit instanceof EntityEnderman))
                    {
                        result.entityHit.setFire(5);
                    }

                    if (result.entityHit != this.shootingEntity && result.entityHit.attackEntityFrom(damagesource, var23))
                    {
                        if (result.entityHit instanceof EntityLivingBase)
                        {
                            EntityLivingBase entitylivingbase = (EntityLivingBase) result.entityHit;

                            if (this.knockbackStrength > 0)
                            {
                                var21 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (var21 > 0.0F)
                                {
                                    result.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579D / var21, 0.1D, this.motionZ * this.knockbackStrength * 0.6000000238418579D / var21);
                                }
                            }
                        }

                        if (!(result.entityHit instanceof EntityEnderman))
                        {
                            this.setDead();
                        }
                    }
                    else
                    {
                        this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                }
                else
                {
                    this.tile = result.getBlockPos();
                    this.inTile = this.world.getBlockState(this.getPosition()).getBlock();
                    this.motionX = ((float) (result.hitVec.x - this.posX));
                    this.motionY = ((float) (result.hitVec.y - this.posY));
                    this.motionZ = ((float) (result.hitVec.z - this.posZ));
                    var22 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / var22 * 0.05000000074505806D;
                    this.posY -= this.motionY / var22 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / var22 * 0.05000000074505806D;
                    this.inGround = true;
                    this.shake = 7;
                    this.setIsCritical(false);

                    if (this.inTile != null)
                    {
                        inTile.onEntityCollision(this.world, this.getPosition(), this.world.getBlockState(this.getPosition()), this);
                    }
                }
            }

            if (this.getIsCritical())
            {
                for (int l = 0; l < 4; ++l)
                {
                    this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            var22 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float) (Math.atan2(this.motionY, var22) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
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
            float var24 = 0.99F;
            radius = 0.05F;

            if (this.isInWater())
            {
                for (int var26 = 0; var26 < 4; ++var26)
                {
                    var21 = 0.25F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * var21, this.posY - this.motionY * var21, this.posZ - this.motionZ * var21, this.motionX, this.motionY, this.motionZ);
                }

                var24 = 0.8F;
            }

            this.motionX *= var24;
            this.motionY *= var24;
            this.motionZ *= var24;
            this.motionY -= radius;
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        new Pos(this.tile).writeToNBT(tag);
        tag.setByte("shake", (byte) this.shake);
        tag.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        tag.setByte("pickup", (byte) this.canBePickedUp);
        tag.setDouble("damage", this.damage);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        Pos pos = Pos.readFromNBT(tag);
        this.tile = new BlockPos(pos.x, pos.y, pos.z);
        this.shake = tag.getByte("shake") & 255;
        this.inGround = tag.getByte("inGround") == 1;

        if (tag.hasKey("damage"))
        {
            this.damage = tag.getDouble("damage");
        }

        if (tag.hasKey("pickup"))
        {
            this.canBePickedUp = tag.getByte("pickup");
        }
        else if (tag.hasKey("player"))
        {
            this.canBePickedUp = tag.getBoolean("player") ? 1 : 0;
        }
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public float getCollisionBorderSize()
    {
        return 0.0F;
    }

    public void setDamage(double damage)
    {
        this.damage = damage;
    }

    public double getDamage()
    {
        return this.damage;
    }

    public void setKnockbackStrength(int strength)
    {
        this.knockbackStrength = strength;
    }

    public void setIsCritical(boolean value)
    {
        byte critical = this.dataManager.get(CRITICAL);
        this.getDataManager().set(CRITICAL, Byte.valueOf(value ? (byte) (critical | 1) : (byte) (critical & -2)));
    }

    public boolean getIsCritical()
    {
        return (this.dataManager.get(CRITICAL) & 1) != 0;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if (!this.world.isRemote)
        {
            this.applyAcid(player, 14 * 20);
        }
    }

    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
            if (result.entityHit != null)
            {
                this.applyAcid((EntityLiving) result.entityHit, 7 * 20);
            }

            this.setDead();
        }
    }

    private void applyAcid(EntityLivingBase living, int ticks)
    {
        living.addPotionEffect(new PotionEffect(MobEffects.POISON, ticks, 0));
    }
}
