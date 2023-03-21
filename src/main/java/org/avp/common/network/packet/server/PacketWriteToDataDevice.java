package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.api.machines.DataDevice;

public class PacketWriteToDataDevice implements IMessage, IMessageHandler<PacketWriteToDataDevice, PacketWriteToDataDevice>
{
    /** Write data to other device with id from device specified using coords x, y, z **/

    public int x, y, z;
    public int id;

    public PacketWriteToDataDevice()
    {
        ;
    }

    public PacketWriteToDataDevice(int x, int y, int z, int id)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(id);
    }

    @Override
    public PacketWriteToDataDevice onMessage(PacketWriteToDataDevice packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            DataDevice device = (DataDevice) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (device != null)
            {
                device.writeToOtherDevice(packet.id);
            }
        });

        return null;
    }
}
