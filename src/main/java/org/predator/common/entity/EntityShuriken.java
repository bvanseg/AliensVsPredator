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
    public EntityShuriken(World world)
    {
        super(world);
        this.setSize(0.5F, 0.25F);
        this.setItemStack(new ItemStack(PredatorItems.ITEM_SHURIKEN));
    }

    public EntityShuriken(World world, EntityLivingBase entityliving)
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

    @Override
    public void onEntityHit(Entity entity)
    {
        if (entity instanceof EntityProjectile)
            return;

        if (!world.isRemote)
        {
            DamageSource damagesource;

            if (shootingEntity == null)
            {
                damagesource = AVPDamageSources.causeShurikenDamage(this);
            }
            else
            {
                damagesource = AVPDamageSources.causeShurikenDamage(this.shootingEntity);
            }

            if (entity.attackEntityFrom(damagesource, 1))
            {
                this.applyEntityHitEffects(entity);
                this.playHitSound();

                if (itemStack.getMaxDamage() + 1 > itemStack.getMaxDamage())
                {
                    itemStack.shrink(1);
                    this.setDead();
                }
                else
                {
                    if (shootingEntity instanceof EntityLivingBase)
                    {
                        itemStack.damageItem(1, (EntityLivingBase) shootingEntity);
                    }
                    else
                    {
                        itemStack.attemptDamageItem(1, rand, null);
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
    public ItemStack getItemStack()
    {
        return new ItemStack(PredatorItems.ITEM_SHURIKEN);
    }
}
