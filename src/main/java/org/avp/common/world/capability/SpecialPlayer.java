package org.avp.common.world.capability;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.OrganismClientSync;
import org.avp.common.network.packet.server.OrganismServerSync;

import java.util.concurrent.Callable;

public interface SpecialPlayer
{
    String getBroadcastChannel();

    void setBroadcastChannel(String broadcastChannel);

    int getBroadcastRadius();

    void setBroadcastRadius(int broadcastRadius);

    boolean isEntityCullingEnabled();

    void setEntityCullingEnabled(boolean concelationToggle);

    boolean isNightvisionEnabled();

    void setNightvisionEnabled(boolean nightvisionEnabled);

    boolean canClimb();

    void setCanClimb(boolean canClimb);

    class Provider implements ICapabilitySerializable<NBTBase>
    {
        @CapabilityInject(SpecialPlayer.class)
        public static final Capability<SpecialPlayer> CAPABILITY = null;

        private final SpecialPlayer instance   = CAPABILITY.getDefaultInstance();

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

    class SpecialPlayerImpl implements SpecialPlayer, IStorage<SpecialPlayer>
    {
        public static class Factory implements Callable<SpecialPlayer>
        {
            @Override
            public SpecialPlayer call() throws Exception
            {
                return new SpecialPlayerImpl();
            }
        }

        public static final String  IDENTIFIER                  = "SpecialPlayer";
        private static final String ID_INT_BROADCAST_RADIUS     = "broadcastRadius";
        private static final String ID_STRING_BROADCAST_CHANNEL = "broadcastChannel";
        private static final String ID_BOOLEAN_ENTITY_CULLING   = "entityCulling";
        private static final String ID_BOOLEAN_NIGHTVISION      = "nightvisionEnabled";
        private static final String ID_BOOLEAN_CAN_CLIMB        = "canClimb";

        public int                  broadcastRadius;
        private String              broadcastChannel;
        private boolean             entityCulling;
        private boolean             nightvisionEnabled;
        private boolean             canClimb;

        public SpecialPlayerImpl()
        {
            this.broadcastChannel = "Default";
        }

        public String getBroadcastChannel()
        {
            return broadcastChannel;
        }

        public void setBroadcastChannel(String broadcastChannel)
        {
            this.broadcastChannel = broadcastChannel;
        }

        public int getBroadcastRadius()
        {
            return broadcastRadius;
        }

        public void setBroadcastRadius(int broadcastRadius)
        {
            this.broadcastRadius = broadcastRadius;
        }

        public boolean isEntityCullingEnabled()
        {
            return this.entityCulling;
        }

        public void setEntityCullingEnabled(boolean concelationToggle)
        {
            this.entityCulling = concelationToggle;
        }

        public boolean isNightvisionEnabled()
        {
            return nightvisionEnabled;
        }

        public void setNightvisionEnabled(boolean nightvisionEnabled)
        {
            this.nightvisionEnabled = nightvisionEnabled;
        }

        public boolean canClimb()
        {
            return this.canClimb;
        }

        public void setCanClimb(boolean canClimb)
        {
            this.canClimb = canClimb;
        }

        public void syncWithServer(EntityLivingBase living)
        {
            AVPNetworking.instance.sendToServer(new OrganismServerSync(living.getEntityId(), (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null)));
        }

        public void syncWithClients(EntityLivingBase living)
        {
            AVPNetworking.instance.sendToAll(new OrganismClientSync(living.getEntityId(), (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null)));
        }

        @Override
        public NBTBase writeNBT(Capability<SpecialPlayer> capability, SpecialPlayer instance, EnumFacing side)
        {
            NBTTagCompound tag = new NBTTagCompound();

            tag.setInteger(ID_INT_BROADCAST_RADIUS, instance.getBroadcastRadius());
            tag.setString(ID_STRING_BROADCAST_CHANNEL, instance.getBroadcastChannel());
            tag.setBoolean(ID_BOOLEAN_ENTITY_CULLING, instance.isEntityCullingEnabled());
            tag.setBoolean(ID_BOOLEAN_NIGHTVISION, instance.isNightvisionEnabled());
            tag.setBoolean(ID_BOOLEAN_CAN_CLIMB, instance.canClimb());

            return tag;
        }

        @Override
        public void readNBT(Capability<SpecialPlayer> capability, SpecialPlayer instance, EnumFacing side, NBTBase nbt)
        {
            if (nbt instanceof NBTTagCompound)
            {
                NBTTagCompound tag = (NBTTagCompound) nbt;

                instance.setBroadcastChannel(tag.getString(ID_STRING_BROADCAST_CHANNEL));
                instance.setBroadcastRadius(tag.getInteger(ID_INT_BROADCAST_RADIUS));
                instance.setEntityCullingEnabled(tag.getBoolean(ID_BOOLEAN_ENTITY_CULLING));
                instance.setNightvisionEnabled(tag.getBoolean(ID_BOOLEAN_NIGHTVISION));
                instance.setCanClimb(tag.getBoolean(ID_BOOLEAN_CAN_CLIMB));
            }
        }
    }
}
