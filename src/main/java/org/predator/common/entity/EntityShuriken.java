package org.predator.common.entity;

import com.asx.mdx.client.sound.GameSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.avp.common.AVPDamageSources;
import org.avp.common.entity.EntityItemStackProjectile;
import org.avp.common.entity.EntityProjectile;
import org.predator.common.PredatorItems;

public class EntityShuriken extends EntityItemStackProjectile
{
    private int damage;

    public EntityShuriken(World world)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.setItemstack(new ItemStack(PredatorItems.ITEM_SHURIKEN));
    }

    public EntityShuriken(World world, double posX, double posY, double posZ)
    {
        this(world);
        this.setSize(0.5F, 0.5F);
        this.setPosition(posX, posY, posZ);
    }

    public EntityShuriken(World world, EntityLivingBase entityliving, float velocity)
    {
        this(world);
        this.shootingEntity = entityliving;
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

    public void setArrowHeading(double motionX, double motionY, double motionZ, float velocity, float deviation)
    {
        float v = MathHelper.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
        motionX /= v;
        motionY /= v;
        motionZ /= v;
        motionX += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
        motionY += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
        motionZ += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
        motionX *= velocity;
        motionY *= velocity;
        motionZ *= velocity;
        this.motionX = motionX * 1.1D;
        this.motionY = motionY * 1.1D;
        this.motionZ = motionZ * 1.1D;
        float f3 = MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(motionY, f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
    public void onEntityHit(Entity entity)
    {
        if (entity instanceof EntityProjectile)
            return;

        if (!world.isRemote)
        {
            DamageSource damagesource = null;

            if (shootingEntity == null)
            {
                damagesource = AVPDamageSources.causeShurikenDamage(this);
            }
            else
            {
                damagesource = AVPDamageSources.causeShurikenDamage(this.shootingEntity);
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
        GameSounds.fxBowHit.playSound(this, 1.0F, 1.0F / (this.rand.nextFloat() * 0.4F + 0.9F));
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
