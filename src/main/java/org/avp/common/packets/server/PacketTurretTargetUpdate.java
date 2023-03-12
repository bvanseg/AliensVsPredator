package org.avp.common.packets.server;

import org.avp.common.tile.TileEntityTurret;

import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketTurretTargetUpdate implements IMessage, IMessageHandler<PacketTurretTargetUpdate, PacketTurretTargetUpdate>
{
    private int      x, y, z;
    public  int      id;

    public PacketTurretTargetUpdate() {}

    public PacketTurretTargetUpdate(BlockPos pos, int targetEntityId)
    {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
        this.id = targetEntityId;
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
    public PacketTurretTargetUpdate onMessage(PacketTurretTargetUpdate packet, MessageContext ctx)
    {
        Game.minecraft().addScheduledTask(() -> {
        	TileEntityTurret tile = (TileEntityTurret) Game.minecraft().world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null) {
                tile.getTargetHelper().setTargetEntity(packet);
            }
        });

        return null;
    }
}
