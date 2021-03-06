package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.weapon.common.entity.EntityGrenade;

public class PacketFireAPC implements IMessage, IMessageHandler<PacketFireAPC, PacketFireAPC>
{
    public PacketFireAPC()
    {
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
    }

    @Override
    public PacketFireAPC onMessage(PacketFireAPC packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            if (ctx.getServerHandler().player != null && ctx.getServerHandler().player.world != null)
            {
                EntityGrenade grenade = new EntityGrenade(ctx.getServerHandler().player.world, ctx.getServerHandler().player);
                grenade.explodeOnImpact = true;
                grenade.velocity = 1D;
                ctx.getServerHandler().player.world.spawnEntity(grenade);
            }
        });
        return null;
    }
}
