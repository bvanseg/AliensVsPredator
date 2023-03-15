package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.AVP;

public class PacketOpenContainer implements IMessage, IMessageHandler<PacketOpenContainer, PacketOpenContainer>
{
    public int guiIdentifier;

    public PacketOpenContainer()
    {
        ;
    }

    public PacketOpenContainer(int guiIdentifier)
    {
        this.guiIdentifier = guiIdentifier;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.guiIdentifier = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.guiIdentifier);
    }

    @Override
    public PacketOpenContainer onMessage(PacketOpenContainer packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                EntityPlayer player = ctx.getServerHandler().player;
                FMLNetworkHandler.openGui(player, AVP.instance, packet.guiIdentifier, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
            }
        });
        return null;
    }
}
