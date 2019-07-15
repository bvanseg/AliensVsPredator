package org.avp.packets.server;

import org.avp.api.machines.IDataDevice;
import org.avp.tile.TileEntityTurret;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketReadFromDataDevice implements IMessage, IMessageHandler<PacketReadFromDataDevice, PacketReadFromDataDevice>
{
    /** Read data from other device with id from device specified using coords x, y, z **/

    public int x, y, z;
    public int id;

    public PacketReadFromDataDevice()
    {
        ;
    }

    public PacketReadFromDataDevice(int x, int y, int z, int id)
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
    public PacketReadFromDataDevice onMessage(PacketReadFromDataDevice packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                IDataDevice device = (TileEntityTurret) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (device != null)
                {
                    device.readFromOtherDevice(packet.id);
                }
            }
        });

        return null;
    }
}
