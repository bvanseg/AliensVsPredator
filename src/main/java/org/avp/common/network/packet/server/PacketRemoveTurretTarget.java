package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.common.tile.TileEntityTurret;

public class PacketRemoveTurretTarget implements IMessage, IMessageHandler<PacketRemoveTurretTarget, PacketRemoveTurretTarget>
{
    public int x, y, z;
    public String entityIdentifier;

    public PacketRemoveTurretTarget()
    {
        ;
    }

    public PacketRemoveTurretTarget(int x, int y, int z, String entityIdentifier)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityIdentifier = entityIdentifier;
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
    public PacketRemoveTurretTarget onMessage(PacketRemoveTurretTarget packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            TileEntityTurret tile = (TileEntityTurret) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null)
            {
                EntityEntry e = null;

                for (EntityEntry ee : ForgeRegistries.ENTITIES)
                {
                    if (ee.getRegistryName().toString().equalsIgnoreCase(packet.entityIdentifier))
                    {
                        e = ee;
                        break;
                    }
                }
                tile.getTargetHelper().removeTargetType((Class<? extends Entity>) e.getEntityClass());
            }
        });
        
        return null;
    }
}
