package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.AVP;
import org.avp.common.network.packet.client.SpecialPlayerClientSync;
import org.avp.common.world.capability.ISpecialPlayer.SpecialPlayer;

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
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                Entity entity = ctx.getServerHandler().player.world.getEntityByID(packet.entityId);

                if (entity != null)
                {
                    SpecialPlayer specialPlayer = (SpecialPlayer) entity.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

                    if (specialPlayer != null)
                    {
                        specialPlayer.readNBT(SpecialPlayer.Provider.CAPABILITY, specialPlayer, null, packet.tag);
                        AVP.network().sendToAll(new SpecialPlayerClientSync(entity.getEntityId(), (NBTTagCompound) specialPlayer.writeNBT(SpecialPlayer.Provider.CAPABILITY, specialPlayer, null)));
                    }
                }
            }
        });

        return null;
    }
}
