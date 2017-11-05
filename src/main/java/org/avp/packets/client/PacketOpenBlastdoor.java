package org.avp.packets.client;

import org.avp.tile.TileEntityBlastdoor;

import com.arisux.mdx.lib.game.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketOpenBlastdoor implements IMessage, IMessageHandler<PacketOpenBlastdoor, PacketOpenBlastdoor>
{
    private boolean open;
    private int     x;
    private int     y;
    private int     z;

    public PacketOpenBlastdoor()
    {
        ;
    }

    public PacketOpenBlastdoor(boolean open, BlockPos pos)
    {
        this.open = open;
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
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
    public PacketOpenBlastdoor onMessage(PacketOpenBlastdoor packet, MessageContext ctx)
    {
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                World world = Game.minecraft().player.world;
                TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (world != null && tile != null && tile instanceof TileEntityBlastdoor)
                {
                    TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

                    if (blastdoor != null)
                    {
                        blastdoor.setOpen(packet.open, false);
                    }
                }
            }
        });

        return null;
    }
}
