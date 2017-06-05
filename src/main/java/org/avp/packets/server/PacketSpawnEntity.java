package org.avp.packets.server;

import com.arisux.mdx.lib.world.entity.Entities;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSpawnEntity implements IMessage, IMessageHandler<PacketSpawnEntity, PacketSpawnEntity>
{
    public double x, y, z;
    public String entityId;

    public PacketSpawnEntity()
    {
        ;
    }

    public PacketSpawnEntity(double x, double y, double z, String entityId)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityId = entityId.trim();
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
        ByteBufUtils.writeUTF8String(buffer, entityId);
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
        this.x = buffer.readDouble();
        this.y = buffer.readDouble();
        this.z = buffer.readDouble();
        this.entityId = ByteBufUtils.readUTF8String(buffer);
    }

    @Override
    public PacketSpawnEntity onMessage(PacketSpawnEntity message, MessageContext ctx)
    {
        ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                if (ctx.getServerHandler().playerEntity != null && ctx.getServerHandler().playerEntity.world != null)
                {
                    Entity entity = Entities.constructEntity(ctx.getServerHandler().playerEntity.world, Entities.getRegisteredEntityClass(message.entityId));

                    if (entity != null)
                    {
                        entity.setLocationAndAngles(message.x, message.y, message.z, 0.0F, 0.0F);
                        ctx.getServerHandler().playerEntity.world.spawnEntity(entity);
                    }
                }
            }
        });

        return null;
    }
}
