package org.avp.packets.server;

import org.avp.tile.TileEntityTurret;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRemoveTurretPlayerTarget implements IMessage, IMessageHandler<PacketRemoveTurretPlayerTarget, PacketRemoveTurretPlayerTarget>
{
    public int    x, y, z;
    public String name;

    public PacketRemoveTurretPlayerTarget()
    {
        ;
    }

    public PacketRemoveTurretPlayerTarget(int x, int y, int z, String globalID)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = globalID;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.name = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        ByteBufUtils.writeUTF8String(buf, this.name);
    }

    @Override
    public PacketRemoveTurretPlayerTarget onMessage(PacketRemoveTurretPlayerTarget packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                TileEntityTurret tile = (TileEntityTurret) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (tile != null)
                {
                    tile.getTargetHelper().removeTargetPlayer(packet.name);
                }
            }
        });

        return null;
    }
}
