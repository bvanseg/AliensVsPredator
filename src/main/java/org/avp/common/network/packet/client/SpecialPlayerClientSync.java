package org.avp.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;

public class SpecialPlayerClientSync implements IMessage, IMessageHandler<SpecialPlayerClientSync, SpecialPlayerClientSync>
{
    public NBTTagCompound tag;
    private int           entityId;

    public SpecialPlayerClientSync()
    {
        ;
    }

    public SpecialPlayerClientSync(int entityId, NBTTagCompound tag)
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

    @SuppressWarnings("all")
    @Override
    public SpecialPlayerClientSync onMessage(SpecialPlayerClientSync packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                Entity entity = ClientGame.instance.minecraft().player.world.getEntityByID(packet.entityId);

                if (entity != null)
                {
                    SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) entity.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);

                    if (specialPlayer != null)
                    {
                        specialPlayer.readNBT(SpecialPlayerImpl.Provider.CAPABILITY, specialPlayer, null, packet.tag);
                    }
                }
            }
        });

        return null;
    }
}
