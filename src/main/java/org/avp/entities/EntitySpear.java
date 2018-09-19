package org.avp.entities;

import java.util.List;

import org.avp.DamageSources;

import com.arisux.mdx.lib.game.GameSounds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class EntitySpear extends EntityItemStackProjectile
{
    private int damage;

    public EntitySpear(World world)
    {
        super(world);
    }

    public EntitySpear(World world, double posX, double posY, double posZ)
    {
        this(world);
        setPosition(posX, posY, posZ);
    }

    public EntitySpear(World world, EntityLivingBase entityliving, ItemStack itemstack)
    {
        this(world);
        this.shootingEntity = entityliving;
        this.setItemstack(itemstack);
        this.setLocationAndAngles(entityliving.posX, entityliving.posY + entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.posX -= MathHelper.cos((rotationYaw / 180F) * 3.141593F) * 0.16F;
        this.posY -= 0.1D;
        this.posZ -= MathHelper.sin((rotationYaw / 180F) * 3.141593F) * 0.16F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
        this.motionY = -MathHelper.sin((rotationPitch / 180F) * 3.141593F);
        this.motionZ = MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
        this.shoot(motionX, motionY, motionZ, 1.8F, 1.0F);
    }

    @Override
    public void onUpdate()
    {
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float i = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, i) * 180.0D / Math.PI);
        }

        BlockPos pos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState blockstate = this.world.getBlockState(pos);
        Block block = blockstate.getBlock();

        if (block != Blocks.AIR)
        {
            if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
            {
                AxisAlignedBB box = blockstate.getBoundingBox(this.world, pos);

                if (box != null && box.contains(new Vec3d(this.posX, this.posY, this.posZ)))
                {
                    this.inGround = true;
                }
            }
        }

        if (this.arrowShake > 0)
        {
            --this.arrowShake;
        }

        if (this.inGround)
        {
            if (block == this.inTile)
            {
                ++this.ticksInGround;
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
            Vec3d var17 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d Vec3dd1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult result = this.world.rayTraceBlocks(var17, Vec3dd1, false, true, true);
            var17 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3dd1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (result != null)
            {
                Vec3dd1 = new Vec3d(result.hitVec.x, result.hitVec.y, result.hitVec.z);
            }

            Entity entity = null;

            @SuppressWarnings("unchecked")
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));

            double d = 0.0D;
            int f3;
            float f6;

            for (f3 = 0; f3 < list.size(); ++f3)
            {
                Entity f4 = list.get(f3);

                if (f4.canBeCollidedWith() && (f4 != this.shootingEntity || this.ticksInAir >= 5))
                {
                    f6 = 0.3F;
                    AxisAlignedBB k1 = f4.getEntityBoundingBox().expand(f6, f6, f6);
                    RayTraceResult f7 = k1.calculateIntercept(var17, Vec3dd1);

                    if (f7 != null)
                    {
                        double d1 = var17.distanceTo(f7.hitVec);

                        if (d1 < d || d == 0.0D)
                        {
                            entity = f4;
                            d = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                result = new RayTraceResult(entity);
            }

            float var20;

            if (result != null)
            {
                if (result.entityHit != null)
                {
                    var20 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int var23 = (int) Math.ceil(var20 * 2.0D);

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null)
                    {
                        damagesource = DamageSources.causeShurikenDamage(this);
                    }
                    else
                    {
                        damagesource = DamageSources.causeShurikenDamage(this.shootingEntity);
                    }

                    if (result.entityHit.attackEntityFrom(damagesource, var23))
                    {
                        if (result.entityHit instanceof EntityLivingBase)
                        {
                            ++((EntityLivingBase) result.entityHit).arrowHitTimer;
                        }

                        GameSounds.fxBowHit.playSound(this, 1.0F, 1.2F / (this.rand.nextFloat() * 0.4F + 0.9F));;
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
                    this.xTile = (int) result.hitVec.x;
                    this.yTile = (int) result.hitVec.y;
                    this.zTile = (int) result.hitVec.z;
                    this.inTile = this.world.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock();
                    this.motionX = ((float) (result.hitVec.x - this.posX));
                    this.motionY = ((float) (result.hitVec.y - this.posY));
                    this.motionZ = ((float) (result.hitVec.z - this.posZ));
                    var20 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / var20 * 0.05000000074505806D;
                    this.posY -= this.motionY / var20 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / var20 * 0.05000000074505806D;
                    GameSounds.fxBowHit.playSound(this, 1.0F, 1.2F / (this.rand.nextFloat() * 0.4F + 0.9F));;
                    this.inGround = true;
                    this.arrowShake = 7;
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            var20 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float) (Math.atan2(this.motionY, var20) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
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
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    @Override
    public void onEntityHit(Entity entity)
    {
        if (!world.isRemote)
        {
            DamageSource damagesource = null;

            if (shootingEntity == null)
            {
                damagesource = DamageSources.causeSpearDamage(this);
            }
            else
            {
                damagesource = DamageSources.causeSpearDamage(this.shootingEntity);
            }

            if (entity.attackEntityFrom(damagesource, damage + 1))
            {
                this.applyEntityHitEffects(entity);
                this.playHitSound();

                if (itemstack.getMaxDamage() + 1 > itemstack.getMaxDamage())
                {
                    itemstack.shrink(1);
                    this.setDead();
                }
                else
                {
                    if (shootingEntity instanceof EntityLivingBase)
                    {
                        itemstack.damageItem(1, (EntityLivingBase) shootingEntity);
                    }
                    else
                    {
                        itemstack.attemptDamageItem(1, rand, null);
                    }
                    this.setVelocity(0D, 0D, 0D);
                }
            }
            else
            {
                this.bounce();
            }
        }
    }

    @Override
    public void playHitSound()
    {
        GameSounds.fxBowHit.playSound(this, 1.0F, 1.0F / (this.rand.nextFloat() * 0.4F + 0.9F));;
    }

    @Override
    public int getLifetime()
    {
        return 0;
    }

    @Override
    public int getMaxArrowShake()
    {
        return 10;
    }

    @Override
    public float getGravity()
    {
        return 0.01F;
    }

    @Override
    public boolean canPickup(EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return null;
    }
}
