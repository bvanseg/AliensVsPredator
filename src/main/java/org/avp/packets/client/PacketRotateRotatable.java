package org.avp.packets.client;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.tile.IRotatable;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRotateRotatable implements IMessage, IMessageHandler<PacketRotateRotatable, PacketRotateRotatable>
{
    public int direction;
    public int x;
    public int y;
    public int z;

    public PacketRotateRotatable()
    {
        ;
    }

    public PacketRotateRotatable(int direction, int x, int y, int z)
    {
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.direction = buf.readInt();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(direction);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public PacketRotateRotatable onMessage(PacketRotateRotatable packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                World world = Game.minecraft().player.world;

                if (world != null)
                {
                    TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                    if (tile != null && tile instanceof IRotatable)
                    {
                        IRotatable rotatable = (IRotatable) tile;
                        rotatable.setDirection(EnumFacing.getFront(packet.direction));
                    }
                }
            }
        });

        return null;
    }
}
