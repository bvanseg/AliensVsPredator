package org.avp.packets.client;

import org.avp.entities.living.species.xenomorphs.EntityOvamorph;

import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketOvamorphContainsFacehugger implements IMessage, IMessageHandler<PacketOvamorphContainsFacehugger, PacketOvamorphContainsFacehugger>
{
    private boolean containsFacehugger;
    private int     entityId;

    public PacketOvamorphContainsFacehugger()
    {
        ;
    }

    public PacketOvamorphContainsFacehugger(boolean containsFacehugger, int entityId)
    {
        this.containsFacehugger = containsFacehugger;
        this.entityId = entityId;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.containsFacehugger = buf.readBoolean();
        this.entityId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeBoolean(containsFacehugger);
        buf.writeInt(entityId);
    }

    @Override
    public PacketOvamorphContainsFacehugger onMessage(PacketOvamorphContainsFacehugger packet, MessageContext ctx)
    {
        // System.out.println("Sent packet " + this.getClass().getName());
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                World world = Game.minecraft().player.world;
                Entity entity = world.getEntityByID(packet.entityId);

                if (world != null && entity != null && entity instanceof EntityOvamorph)
                {
                    EntityOvamorph ovamorph = (EntityOvamorph) entity;
                    ovamorph.setContainsFacehugger(packet.containsFacehugger);
                }
            }
        });

        return null;
    }
}
