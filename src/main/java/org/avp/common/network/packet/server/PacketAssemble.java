package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.item.crafting.AssemblyManager;
import org.avp.common.item.crafting.AssemblyResult;
import org.avp.common.item.crafting.ItemSchematic;

/**
 * @author Ri5ux
 */
public class PacketAssemble implements IMessage, IMessageHandler<PacketAssemble, PacketAssemble>
{
    private String name;
    private int    count;

    public PacketAssemble() {}

    public PacketAssemble(String name, int count)
    {
        this.name = name;
        this.count = count;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.name = ByteBufUtils.readUTF8String(buf);
        this.count = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, this.name);
        buf.writeInt(this.count);
    }

    @Override
    public PacketAssemble onMessage(PacketAssemble packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            EntityPlayer player = ctx.getServerHandler().player;

            if (player != null)
            {
                ItemSchematic schematic = AssemblyManager.instance.getSchematicByName(packet.name);
                AssemblyResult result = AssemblyResult.getResult(player, schematic, packet.count);

                if (result.canAssembleSchematic()) {
                    result.assemble();
                    player.sendMessage(new TextComponentString(String.format("Assembled %sx %s", packet.count, schematic.getItemStackAssembled().getDisplayName())));
                } else {
                    player.sendMessage(new TextComponentString(String.format("Not enough materials to assemble %sx %s", packet.count, schematic.getItemStackAssembled().getDisplayName())));
                }
            }
        });

        return null;
    }
}
