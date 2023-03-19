package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.SpecialPlayerClientSync;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;

public class SpecialPlayerServerSync implements IMessage, IMessageHandler<SpecialPlayerServerSync, SpecialPlayerServerSync>
{
    public NBTTagCompound tag;
    private int           entityId;

    public SpecialPlayerServerSync()
    {
        ;
    }

    public SpecialPlayerServerSync(int entityId, NBTTagCompound tag)
    {
        this.entityId = entityId;
        this.tag = tag;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.entityId = buf.readInt();
        this.tag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.entityId);
        ByteBufUtils.writeTag(buf, tag);
    }

    @Override
    public SpecialPlayerServerSync onMessage(SpecialPlayerServerSync packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            Entity entity = ctx.getServerHandler().player.world.getEntityByID(packet.entityId);

            if (entity != null)
            {
                SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) entity.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);

                if (specialPlayer != null)
                {
                    specialPlayer.readNBT(SpecialPlayerImpl.Provider.CAPABILITY, specialPlayer, null, packet.tag);
                    AVPNetworking.instance.sendToAll(new SpecialPlayerClientSync(entity.getEntityId(), (NBTTagCompound) specialPlayer.writeNBT(SpecialPlayerImpl.Provider.CAPABILITY, specialPlayer, null)));
                }
            }
        });

        return null;
    }
}
