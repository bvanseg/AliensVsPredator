package org.predator.common.entity;

import com.asx.mdx.lib.util.GameSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.avp.AVP;
import org.avp.common.DamageSources;
import org.avp.common.entities.EntityItemStackProjectile;
import org.avp.common.entities.EntityProjectile;

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
        this.setItemstack(new ItemStack(AVP.items().itemSpear));
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
        super.onUpdate();
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
                    ;
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
        return this.getItemstack();
    }
}
