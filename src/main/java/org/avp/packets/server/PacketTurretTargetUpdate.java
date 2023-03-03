package org.avp.packets.server;

import org.avp.tile.TileEntityTurret;

import com.asx.mdx.lib.client.util.Rotation;
import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketTurretTargetUpdate implements IMessage, IMessageHandler<PacketTurretTargetUpdate, PacketTurretTargetUpdate>
{
    public int      x, y, z;
    public int      id;
    public Rotation focrot;

    public PacketTurretTargetUpdate()
    {
        ;
    }

    public PacketTurretTargetUpdate(TileEntityTurret turret)
    {
        this.x = turret.getPos().getX();
        this.y = turret.getPos().getY();
        this.z = turret.getPos().getZ();
        this.id = turret.getTargetHelper().getTargetEntity().getEntityId();
        this.focrot = turret.getLookHelper().getFocusRotation();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.id = buf.readInt();
        this.focrot = new Rotation(0F, 0F).readFromBuffer(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(id);

        if (focrot == null)
        {
            focrot = new Rotation(0F, 0F);
        }
        
        focrot.writeToBuffer(buf);
    }

    @Override
    public PacketTurretTargetUpdate onMessage(PacketTurretTargetUpdate packet, MessageContext ctx)
    {
        Game.minecraft().addScheduledTask(new Runnable() {
            @Override
            public void run()
            {
                TileEntityTurret tile = (TileEntityTurret) Game.minecraft().world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (tile != null)
                {
                    tile.onReceiveTargetUpdatePacket(packet, ctx);
                }
            }
        });

        return null;
    }
}
