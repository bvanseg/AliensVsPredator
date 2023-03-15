package org.alien.common.world.capability;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.Embryo;
import org.avp.client.render.TacticalHUDRenderEvent;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.OrganismClientSync;
import org.avp.common.network.packet.server.OrganismServerSync;

import java.util.concurrent.Callable;

public interface Organism
{
    int getHeartRate();

    void setHeartRate(int rate);

    boolean hasEmbryo();

    Embryo getEmbryo();

    void impregnate(Embryo embryo);

    void removeEmbryo();

    void gestate(EntityLivingBase in);

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

        if (this.hasEmbryo())
        {
            this.removeEmbryo();
        }

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

    class OrganismImpl implements Organism, IStorage<Organism>
    {
        public static class Factory implements Callable<Organism>
        {
            @Override
            public Organism call() throws Exception
            {
                return new OrganismImpl();
            }
        }

        private Embryo embryo;
        private int    heartRate;

        public OrganismImpl()
        {
            this.embryo = null;
            this.heartRate = 60;
        }

        /**
         * Gets the heart rate of this organism, which is measured in BPM.
         */
        @Override
        public int getHeartRate()
        {
            return this.heartRate;
        }

        @Override
        public void setHeartRate(int rate)
        {
            this.heartRate = rate;
        }

        @Override
        public boolean hasEmbryo()
        {
            return this.embryo != null;
        }

        @Override
        public Embryo getEmbryo()
        {
            return this.embryo;
        }

        public void impregnate(EntityLivingBase living)
        {
            this.impregnate(Embryo.createFromHost(living));
        }

        @Override
        public void impregnate(Embryo embryo)
        {
            if (embryo != null)
            {
                this.embryo = embryo.createCopy();
            }
        }

        @Override
        public void removeEmbryo()
        {
            this.embryo = null;
        }

        @Override
        public void gestate(EntityLivingBase in)
        {
            if (in != null)
            {
                this.getEmbryo().createNasenticOrganism(in.world);
                this.getEmbryo().grow(in, this);
            }
        }

        public void onTick(EntityLivingBase living, Organism organism)
        {
            World world = living.world;

            if (!world.isRemote && world.getTotalWorldTime() % 60 == 0)
            {
                this.syncWithClients(living);
            }

            if (!world.isRemote)
            {
                if (living.isSprinting())
                {
                    organism.setHeartRate(130 + living.getRNG().nextInt(20));
                }
                else if (living.motionX + living.motionZ > 0)
                {
                    organism.setHeartRate(70 + living.getRNG().nextInt(10));
                }
                else
                {
                    organism.setHeartRate(60 + living.getRNG().nextInt(10));
                }

                if (organism.hasEmbryo())
                {
                    int age = organism.getEmbryo().getAge();
                    int gestationPeriod = organism.getEmbryo().getGestationPeriod();
                    int timeLeft = gestationPeriod - age;
                    int timeBleed = gestationPeriod - (gestationPeriod / 10);

                    if (age >= timeBleed)
                    {
                        organism.setHeartRate(60 + (250 - (timeLeft * 250 / (30 * 20))));

                        if (world.getTotalWorldTime() % 10 == 0)
                        {
                            this.syncWithClients(living);
                        }
                    }
                }
            }

            if (world.isRemote)
            {
                if (living == Game.minecraft().player)
                {
                    TacticalHUDRenderEvent.instance.getElectrocardiogram().setRate(organism.getHeartRate());
                }
            }
        }

        public void syncWithServer(EntityLivingBase living)
        {
            if (living != null)
                AVPNetworking.instance.sendToServer(new OrganismServerSync(living.getEntityId(), (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null)));
        }

        public void syncWithClients(EntityLivingBase living)
        {
            if (living != null && !living.world.isRemote)
                AVPNetworking.instance.sendToAll(new OrganismClientSync(living.getEntityId(), (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null)));
        }

        @Override
        public NBTBase writeNBT(Capability<Organism> capability, Organism instance, EnumFacing side)
        {
            NBTTagCompound tag = new NBTTagCompound();

            Embryo.save(instance.getEmbryo(), tag);
            tag.setInteger("BPM", instance.getHeartRate());

            return tag;
        }

        @Override
        public void readNBT(Capability<Organism> capability, Organism instance, EnumFacing side, NBTBase nbt)
        {
            if (nbt instanceof NBTTagCompound)
            {
                NBTTagCompound tag = (NBTTagCompound) nbt;

                instance.impregnate(Embryo.load(tag));
                instance.setHeartRate(tag.getInteger("BPM"));
            }
        }
    }
}
