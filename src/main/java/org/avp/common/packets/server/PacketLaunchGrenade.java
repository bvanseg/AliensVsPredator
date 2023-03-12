package org.avp.common.packets.server;

import org.avp.AliensVsPredator;
import org.avp.common.entities.EntityGrenade;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketLaunchGrenade implements IMessage, IMessageHandler<PacketLaunchGrenade, PacketLaunchGrenade>
{
    public PacketLaunchGrenade()
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
    public PacketLaunchGrenade onMessage(PacketLaunchGrenade packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                if (ctx.getServerHandler().player != null && ctx.getServerHandler().player.world != null)
                {
                    boolean hasNormal = Inventories.playerHas(AliensVsPredator.items().itemGrenade, ctx.getServerHandler().player);
                    boolean hasIncendiary = Inventories.playerHas(AliensVsPredator.items().itemIncendiaryGrenade, ctx.getServerHandler().player);

                    if (hasNormal || hasIncendiary)
                    {
                        EntityGrenade grenade = new EntityGrenade(ctx.getServerHandler().player.world, ctx.getServerHandler().player);
                        grenade.explodeOnImpact = true;
                        grenade.setFlaming(hasIncendiary);
                        ctx.getServerHandler().player.world.spawnEntity(grenade);
                        Inventories.consumeItem(ctx.getServerHandler().player, !hasIncendiary ? AliensVsPredator.items().itemGrenade : AliensVsPredator.items().itemIncendiaryGrenade);
                    }
                }
            }
        });

        return null;
    }
}
