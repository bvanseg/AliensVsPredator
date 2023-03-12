package org.avp.common.packets.client;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.tile.IRotatableYAxis;
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
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                World world = Game.minecraft().player.world;

                if (world != null)
                {
                    TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                    if (tile != null && tile instanceof IRotatableYAxis)
                    {
                        IRotatableYAxis rotatable = (IRotatableYAxis) tile;
                        rotatable.setRotationYAxis(EnumFacing.byIndex(packet.direction));
                    }
                }
            }
        });

        return null;
    }
}
