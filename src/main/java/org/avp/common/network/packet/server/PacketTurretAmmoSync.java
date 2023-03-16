package org.avp.common.network.packet.server;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.tile.TileEntityTurret;

public class PacketTurretAmmoSync implements IMessage, IMessageHandler<PacketTurretAmmoSync, PacketTurretAmmoSync>
{
    private int      x, y, z;
    public  int      ammoCount;

    public PacketTurretAmmoSync() {}

    public PacketTurretAmmoSync(BlockPos pos, int ammoCount)
    {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
        this.ammoCount = ammoCount;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.ammoCount = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(ammoCount);
    }

    @Override
    public PacketTurretAmmoSync onMessage(PacketTurretAmmoSync packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
        	TileEntityTurret tile = (TileEntityTurret) ClientGame.instance.minecraft().world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null) {
                tile.getAmmoHelper().setCurrentAmmoCount(packet.ammoCount);
            }
        });

        return null;
    }
}
