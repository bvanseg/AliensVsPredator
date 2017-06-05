package org.avp.packets.server;

import org.avp.tile.TileEntityTurret;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketAddTuretTarget implements IMessage, IMessageHandler<PacketAddTuretTarget, PacketAddTuretTarget>
{
    public int    x, y, z;
    public String entityIdentifier;

    public PacketAddTuretTarget()
    {
        ;
    }

    public PacketAddTuretTarget(int x, int y, int z, String globalID)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityIdentifier = globalID;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.entityIdentifier = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        ByteBufUtils.writeUTF8String(buf, this.entityIdentifier);
    }

    @Override
    public PacketAddTuretTarget onMessage(PacketAddTuretTarget packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                TileEntityTurret tile = (TileEntityTurret) ctx.getServerHandler().playerEntity.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (tile != null)
                {
                    tile.addTargetType((Class<? extends Entity>) EntityList.NAME_TO_CLASS.get(packet.entityIdentifier));
                }
            }
        });

        return null;
    }
}
