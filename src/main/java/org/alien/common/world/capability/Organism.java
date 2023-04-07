package org.alien.common.world.capability;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.Embryo;

public interface Organism
{
    int getHeartRate();

    void setHeartRate(int rate);

    boolean hasEmbryo();

    Embryo getEmbryo();

    void setEmbryo(Embryo embryo);

    class Provider implements ICapabilitySerializable<NBTBase>
    {
        @CapabilityInject(Organism.class)
        public static final Capability<Organism> CAPABILITY = null;

        private final Organism instance   = CAPABILITY.getDefaultInstance();

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing)
        {
            return capability == CAPABILITY;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing)
        {
            return hasCapability(capability, facing) ? CAPABILITY.<T>cast(this.instance) : null;
        }

        @Override
        public NBTBase serializeNBT()
        {
            return CAPABILITY.getStorage().writeNBT(CAPABILITY, this.instance, null);
        }

        @Override
        public void deserializeNBT(NBTBase nbt)
        {
            CAPABILITY.getStorage().readNBT(CAPABILITY, this.instance, null, nbt);
        }
    }

    default void heal(EntityLivingBase living)
    {
        living.setHealth(living.getMaxHealth());

        if (!living.world.isRemote)
        {
            living.curePotionEffects(new ItemStack(Items.MILK_BUCKET, 1));
            living.getActivePotionEffects().clear();
        }

        this.setEmbryo(null);

        if (Entities.getEntityRiddenBy(living) != null && Entities.getEntityRiddenBy(living) instanceof SpeciesAlien)
        {
            Entities.getEntityRiddenBy(living).setDead();
        }

        if (living instanceof EntityPlayer && living.world.isRemote)
        {
            EntityPlayer player = (EntityPlayer) living;
            player.getFoodStats().setFoodLevel(20);
        }
    }
}
