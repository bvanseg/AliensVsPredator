package org.avp.packets.server;

import org.avp.entities.EntityGrenade;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketFireAPC implements IMessage, IMessageHandler<PacketFireAPC, PacketFireAPC>
{
    public PacketFireAPC()
    {
        ;
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
        ;
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
        ;
    }

    @Override
    public PacketFireAPC onMessage(PacketFireAPC packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                if (ctx.getServerHandler().playerEntity != null && ctx.getServerHandler().playerEntity.world != null)
                {
                    EntityGrenade grenade = new EntityGrenade(ctx.getServerHandler().playerEntity.world, ctx.getServerHandler().playerEntity);
                    grenade.explodeOnImpact = true;
                    grenade.velocity = 1D;
                    ctx.getServerHandler().playerEntity.world.spawnEntity(grenade);
                }
            }
        });
        return null;
    }
}
