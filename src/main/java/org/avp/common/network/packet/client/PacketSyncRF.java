package org.avp.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.tile.TileEntityRedstoneFluxGenerator;

public class PacketSyncRF implements IMessage, IMessageHandler<PacketSyncRF, PacketSyncRF>
{
    public int rf;
    public int x;
    public int y;
    public int z;

    public PacketSyncRF()
    {
        ;
    }

    public PacketSyncRF(int rf, int x, int y, int z)
    {
        this.rf = rf;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.rf = buf.readInt();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(rf);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public PacketSyncRF onMessage(PacketSyncRF packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
            World world = ClientGame.instance.minecraft().player.world;

            if (world != null)
            {
                TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (tile != null && tile instanceof TileEntityRedstoneFluxGenerator)
                {
                    TileEntityRedstoneFluxGenerator receiver = (TileEntityRedstoneFluxGenerator) tile;
                    receiver.setRfEnergy(packet.rf);
                }
            }
        });

        return null;
    }
}
