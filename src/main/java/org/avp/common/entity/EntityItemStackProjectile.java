package org.avp.common.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityItemStackProjectile extends EntityProjectile
{
    private static final DataParameter<Byte> WEAPON_MATERIAL_ID = EntityDataManager.<Byte> createKey(EntityItemStackProjectile.class, DataSerializers.BYTE);
    protected ItemStack                      itemstack;

    public EntityItemStackProjectile(World world)
    {
        super(world);
    }

    @Override
    public void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEAPON_MATERIAL_ID, (byte) 0);
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

    public void setItemstack(ItemStack itemstack)
    {
        this.itemstack = itemstack;
    }

    @Override
    public ItemStack getItemstack()
    {
        return itemstack;
    }

    public int getWeaponMaterialId()
    {
        return this.getDataManager().get(WEAPON_MATERIAL_ID);
    }

    private static final String STACK_NBT_KEY = "stack";

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);

        if (itemstack != null)
        {
            nbttagcompound.setTag(STACK_NBT_KEY, itemstack.writeToNBT(new NBTTagCompound()));
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        setItemstack(new ItemStack(nbttagcompound.getCompoundTag(STACK_NBT_KEY)));
    }
}
