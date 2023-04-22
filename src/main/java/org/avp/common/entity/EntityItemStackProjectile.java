package org.avp.common.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityItemStackProjectile extends EntityProjectile
{
    protected ItemStack itemStack;

    protected EntityItemStackProjectile(World world)
    {
        super(world);
    }

    @Override
    public void applyEntityHitEffects(Entity entity)
    {
        super.applyEntityHitEffects(entity);

        if (shootingEntity instanceof EntityLivingBase && entity instanceof EntityLivingBase)
        {
            int knockback = EnchantmentHelper.getKnockbackModifier((EntityLivingBase) shootingEntity);

            if (knockback != 0)
            {
                entity.addVelocity(-MathHelper.sin(rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F, 0.1D, MathHelper.cos(rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F);
            }

            knockback = EnchantmentHelper.getFireAspectModifier((EntityLivingBase) shootingEntity);

            if (knockback > 0 && !entity.isBurning())
            {
                entity.setFire(1);
            }
        }
    }

    public void setItemStack(ItemStack itemStack)
    {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack()
    {
        return this.itemStack;
    }

    @Override
    protected final ItemStack getArrowStack() {
        return this.getItemStack();
    }

    private static final String STACK_NBT_KEY = "stack";

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);

        if (itemStack != null)
        {
            nbttagcompound.setTag(STACK_NBT_KEY, this.itemStack.writeToNBT(new NBTTagCompound()));
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        this.setItemStack(new ItemStack(nbttagcompound.getCompoundTag(STACK_NBT_KEY)));
    }
}
