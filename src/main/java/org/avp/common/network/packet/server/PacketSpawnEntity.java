package org.avp.common.network.packet.server;

import com.asx.mdx.lib.world.entity.Entities;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSpawnEntity implements IMessage, IMessageHandler<PacketSpawnEntity, PacketSpawnEntity>
{
    private double x, y, z;
    private String entityId;
    private int    count;

    public PacketSpawnEntity() {}

    public PacketSpawnEntity(double x, double y, double z, String entityId)
    {
    	this(x, y, z, entityId, 1);
    }

    public PacketSpawnEntity(double x, double y, double z, String entityId, int count)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityId = entityId.trim();
        this.count = count;
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
        ByteBufUtils.writeUTF8String(buffer, entityId);
        buffer.writeInt(count);
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
        this.x = buffer.readDouble();
        this.y = buffer.readDouble();
        this.z = buffer.readDouble();
        this.entityId = ByteBufUtils.readUTF8String(buffer);
        this.count = buffer.readInt();
    }

    @Override
    public PacketSpawnEntity onMessage(PacketSpawnEntity packet, MessageContext ctx)
    {
    	EntityPlayerMP player = ctx.getServerHandler().player;
    	Class<? extends Entity> entityClass = Entities.getRegisteredEntityClass(packet.entityId);
    	
    	if (player != null && player.world != null) {
    		for (int i = 0; i < packet.count; i++) {
                Entity entity = Entities.constructEntity(player.world, entityClass);

                if (entity != null) {
                    entity.setLocationAndAngles(packet.x, packet.y, packet.z, 0.0F, 0.0F);
                    player.world.spawnEntity(entity);
                }
    		}
        }

        return null;
    }
}
