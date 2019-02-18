package org.avp.packets.client;

import org.avp.api.machines.IOpenable;

import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketOpenable implements IMessage, IMessageHandler<PacketOpenable, PacketOpenable>
{
    private boolean open;
    private int     x;
    private int     y;
    private int     z;

    public PacketOpenable()
    {
        ;
    }

    public PacketOpenable(boolean open, int x, int y, int z)
    {
        this.open = open;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.open = buf.readBoolean();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeBoolean(open);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public PacketOpenable onMessage(PacketOpenable packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                World world = Game.minecraft().player.world;
                TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (world != null && tile != null && tile instanceof IOpenable)
                {
                    IOpenable openable = (IOpenable) tile;

                    if (openable != null)
                    {
                        openable.setOpen(packet.open);
                    }
                }
            }
        });

        return null;
    }
}
