package org.avp.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDismountRidingEntity implements IMessage, IMessageHandler<PacketDismountRidingEntity, PacketDismountRidingEntity>
{
    private int           entityId;

    public PacketDismountRidingEntity()
    {
    }

    public PacketDismountRidingEntity(int entityId)
    {
        this.entityId = entityId;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.entityId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.entityId);
    }

    @Override
    public PacketDismountRidingEntity onMessage(PacketDismountRidingEntity packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
            if (ClientGame.instance.minecraft().player != null && ClientGame.instance.minecraft().player.world != null)
            {
                Entity entity = ClientGame.instance.minecraft().player.world.getEntityByID(packet.entityId);

                if (entity != null)
                {
                    entity.dismountRidingEntity();
                }
            }
        });

        return null;
    }
}
