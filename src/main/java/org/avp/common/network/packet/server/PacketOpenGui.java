package org.avp.common.network.packet.server;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;

public class PacketOpenGui implements IMessage, IMessageHandler<PacketOpenGui, PacketOpenGui>
{
    public int guiIdentifier;

    public PacketOpenGui()
    {
        ;
    }

    public PacketOpenGui(int guiIdentifier)
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
    @SideOnly(Side.CLIENT)
    public PacketOpenGui onMessage(PacketOpenGui packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                EntityPlayer player = ClientGame.instance.minecraft().player;
                FMLNetworkHandler.openGui(player, AVP.instance, packet.guiIdentifier, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
            }
        });
        return null;
    }
}
