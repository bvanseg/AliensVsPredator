package org.avp.packets.server;

import org.avp.AliensVsPredator;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

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
        System.out.println("Sent packet " + this.getClass().getName());
        EntityPlayer player = ctx.getServerHandler().playerEntity;
        FMLNetworkHandler.openGui(player, AliensVsPredator.instance(), packet.guiIdentifier, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return null;
    }
}
