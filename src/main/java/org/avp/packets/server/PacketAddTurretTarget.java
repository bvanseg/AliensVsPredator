package org.avp.packets.server;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityTurret;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PacketAddTurretTarget implements IMessage, IMessageHandler<PacketAddTurretTarget, PacketAddTurretTarget>
{
    public int    x, y, z;
    public String entityIdentifier;

    public PacketAddTurretTarget()
    {
        ;
    }

    public PacketAddTurretTarget(int x, int y, int z, String globalID)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityIdentifier = globalID;
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
    public PacketAddTurretTarget onMessage(PacketAddTurretTarget packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                TileEntityTurret tile = (TileEntityTurret) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (tile != null)
                {
                    tile.addTargetType((Class<? extends Entity>) ForgeRegistries.ENTITIES.getValue(new ResourceLocation(AliensVsPredator.Properties.ID, packet.entityIdentifier)).getEntityClass());
                }
            }
        });

        return null;
    }
}
