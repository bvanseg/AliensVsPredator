package org.avp.packets.server;

import org.avp.item.crafting.AssemblyManager;
import org.avp.item.crafting.Schematic;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketAssemble implements IMessage, IMessageHandler<PacketAssemble, PacketAssemble>
{
    public String id;
    public int    count;

    public PacketAssemble()
    {
        ;
    }

    public PacketAssemble(String id, int count)
    {
        this.id = id;
        this.count = count;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.id = ByteBufUtils.readUTF8String(buf);
        this.count = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, this.id);
        buf.writeInt(this.count);
    }

    @Override
    public PacketAssemble onMessage(PacketAssemble packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                EntityPlayer player = ctx.getServerHandler().player;

                if (player != null)
                {
                    Schematic schematic = AssemblyManager.instance.getSchematic(packet.id);
                    int qtyAssembled = AssemblyManager.tryAssembly(player, schematic, packet.count);

                    if (qtyAssembled > 0)
                    {
                        player.sendMessage(new TextComponentString(String.format("Assembled %sx %s", qtyAssembled, schematic.getItemStackAssembled().getDisplayName())));
                    }
                    else if (qtyAssembled == 0)
                    {
                        player.sendMessage(new TextComponentString(String.format("Not enough materials to assemble %sx %s", packet.count, schematic.getItemStackAssembled().getDisplayName())));
                    }
                }
            }
        });

        return null;
    }
}
