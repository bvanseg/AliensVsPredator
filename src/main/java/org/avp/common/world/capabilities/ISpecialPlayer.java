package org.avp.common.world.capabilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import org.avp.AVP;
import org.avp.common.packets.client.OrganismClientSync;
import org.avp.common.packets.server.OrganismServerSync;
import org.avp.common.world.playermode.PlayerMode;

import java.util.concurrent.Callable;

public interface ISpecialPlayer
{
    public String getBroadcastChannel();

    public void setBroadcastChannel(String broadcastChannel);

    public int getBroadcastRadius();

    public void setBroadcastRadius(int broadcastRadius);

    public void setPlayerMode(PlayerMode playerMode);

    public PlayerMode getPlayerMode();

    public boolean isEntityCullingEnabled();

    public void setEntityCullingEnabled(boolean concelationToggle);

    public boolean isNightvisionEnabled();

    public void setNightvisionEnabled(boolean nightvisionEnabled);

    public boolean canClimb();

    public void setCanClimb(boolean canClimb);

    public class Provider implements ICapabilitySerializable<NBTBase>
    {
        @CapabilityInject(ISpecialPlayer.class)
        public static final Capability<ISpecialPlayer> CAPABILITY = null;

        private ISpecialPlayer                         instance   = CAPABILITY.getDefaultInstance();

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

    public static class SpecialPlayer implements ISpecialPlayer, IStorage<ISpecialPlayer>
    {
        public static class Factory implements Callable<ISpecialPlayer>
        {
            @Override
            public ISpecialPlayer call() throws Exception
            {
                return new SpecialPlayer();
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
        private PlayerMode          playerMode                  = PlayerMode.NORMAL;

        public SpecialPlayer()
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

        public void setPlayerMode(PlayerMode playerMode)
        {
            this.playerMode = playerMode;
        }

        public PlayerMode getPlayerMode()
        {
            return this.playerMode;
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
            AVP.network().sendToServer(new OrganismServerSync(living.getEntityId(), (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null)));
        }

        public void syncWithClients(EntityLivingBase living)
        {
            AVP.network().sendToAll(new OrganismClientSync(living.getEntityId(), (NBTTagCompound) Provider.CAPABILITY.getStorage().writeNBT(Provider.CAPABILITY, this, null)));
        }

        @Override
        public NBTBase writeNBT(Capability<ISpecialPlayer> capability, ISpecialPlayer instance, EnumFacing side)
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
        public void readNBT(Capability<ISpecialPlayer> capability, ISpecialPlayer instance, EnumFacing side, NBTBase nbt)
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
