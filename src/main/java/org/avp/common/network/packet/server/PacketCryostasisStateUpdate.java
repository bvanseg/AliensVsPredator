package org.avp.common.network.packet.server;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.tile.TileEntityCryostasisTube;

public class PacketCryostasisStateUpdate implements IMessage, IMessageHandler<PacketCryostasisStateUpdate, PacketCryostasisStateUpdate>
{
    public int      x, y, z;
    public boolean  cracked, shattered;

    public PacketCryostasisStateUpdate() {}

    public PacketCryostasisStateUpdate(TileEntityCryostasisTube tileEntity)
    {
        this.x = tileEntity.getPos().getX();
        this.y = tileEntity.getPos().getY();
        this.z = tileEntity.getPos().getZ();
        this.cracked = tileEntity.isCracked();
        this.shattered = tileEntity.isShattered();
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.cracked = buffer.readBoolean();
        this.shattered = buffer.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
        buffer.writeInt(x);
        buffer.writeInt(y);
        buffer.writeInt(z);
        buffer.writeBoolean(this.cracked);
        buffer.writeBoolean(this.shattered);
    }

    @Override
    public PacketCryostasisStateUpdate onMessage(PacketCryostasisStateUpdate packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
        	TileEntityCryostasisTube tile = (TileEntityCryostasisTube) ClientGame.instance.minecraft().world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null)
            {
                tile.setCracked(packet.cracked);
                tile.setShattered(packet.shattered);
            }
        });

        return null;
    }
}
