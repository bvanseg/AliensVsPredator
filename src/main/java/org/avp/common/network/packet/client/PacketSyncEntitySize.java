package org.avp.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.api.Resizable;

/**
 * @author Boston Vanseghi
 */
public class PacketSyncEntitySize implements IMessage, IMessageHandler<PacketSyncEntitySize, PacketSyncEntitySize> {

    private int entityId;
    private float width;
    private float height;

    public PacketSyncEntitySize() {}

    public PacketSyncEntitySize(Entity entity, float newWidth, float newHeight) {
        if (!(entity instanceof Resizable)) {
            throw new IllegalArgumentException("Passed entity must implement Resizable!");
        }

        this.entityId = entity.getEntityId();
        this.width = newWidth;
        this.height = newHeight;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.entityId = buf.readInt();
        this.width = buf.readFloat();
        this.height = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.entityId);
        buf.writeFloat(this.width);
        buf.writeFloat(this.height);
    }

    @Override
    public PacketSyncEntitySize onMessage(PacketSyncEntitySize packet, MessageContext ctx) {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
            Entity entity = ClientGame.instance.minecraft().player.world.getEntityByID(packet.entityId);

            if (entity == null || !(entity instanceof Resizable)) return;

            ((Resizable) entity).resize(packet.width, packet.height);
        });
        return null;
    }
}
