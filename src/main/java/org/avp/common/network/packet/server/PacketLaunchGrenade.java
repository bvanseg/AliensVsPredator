package org.avp.common.network.packet.server;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.AVPItems;
import org.avp.common.entity.EntityGrenade;

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
                    boolean hasNormal = Inventories.playerHas(AVPItems.ITEM_GRENADE, ctx.getServerHandler().player);
                    boolean hasIncendiary = Inventories.playerHas(AVPItems.ITEM_INCENDIARY_GRENADE, ctx.getServerHandler().player);

                    if (hasNormal || hasIncendiary)
                    {
                        EntityGrenade grenade = new EntityGrenade(ctx.getServerHandler().player.world, ctx.getServerHandler().player);
                        grenade.explodeOnImpact = true;
                        grenade.setFlaming(hasIncendiary);
                        ctx.getServerHandler().player.world.spawnEntity(grenade);
                        Inventories.consumeItem(ctx.getServerHandler().player, !hasIncendiary ? AVPItems.ITEM_GRENADE : AVPItems.ITEM_INCENDIARY_GRENADE);
                    }
                }
            }
        });

        return null;
    }
}
