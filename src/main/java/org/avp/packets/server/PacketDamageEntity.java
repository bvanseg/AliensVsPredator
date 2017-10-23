package org.avp.packets.server;

import org.avp.DamageSources;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDamageEntity implements IMessage, IMessageHandler<PacketDamageEntity, PacketDamageEntity>
{
    public int   entityId, entitySourceId;
    public float damage;

    public PacketDamageEntity()
    {
        ;
    }

    public PacketDamageEntity(Entity entity, Entity entitySource, float damage)
    {
        this.entityId = entity != null ? entity.getEntityId() : -1;
        this.entitySourceId = entitySource != null ? entitySource.getEntityId() : -1;
        this.damage = damage;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.entityId = buf.readInt();
        this.entitySourceId = buf.readInt();
        this.damage = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.entityId);
        buf.writeInt(this.entitySourceId);
        buf.writeFloat(this.damage);
    }

    @Override
    public PacketDamageEntity onMessage(PacketDamageEntity packet, MessageContext ctx)
    {
        ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                if (packet.entityId != -1)
                {
                    Entity entity = ctx.getServerHandler().playerEntity.world.getEntityByID(packet.entityId);
                    Entity entitySource = ctx.getServerHandler().playerEntity.world.getEntityByID(packet.entitySourceId);

                    if (entity != null)
                    {
                        entity.hurtResistantTime = 0;
                        entity.attackEntityFrom(DamageSources.causeLaserMineDamage(entitySource, entitySource), packet.damage);
                    }
                }
            }
        });

        return null;
    }
}
