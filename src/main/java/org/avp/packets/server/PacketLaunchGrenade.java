package org.avp.packets.server;

import org.avp.AliensVsPredator;
import org.avp.entities.EntityGrenade;

import com.arisux.mdxlib.lib.world.entity.player.inventory.Inventories;

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
        System.out.println("Sent packet " + this.getClass().getName());
        if (ctx.getServerHandler().playerEntity != null && ctx.getServerHandler().playerEntity.world != null)
        {
            boolean hasNormal = Inventories.playerHas(AliensVsPredator.items().itemGrenade, ctx.getServerHandler().playerEntity);
            boolean hasIncendiary = Inventories.playerHas(AliensVsPredator.items().itemIncendiaryGrenade, ctx.getServerHandler().playerEntity);

            if (hasNormal || hasIncendiary)
            {
                EntityGrenade grenade = new EntityGrenade(ctx.getServerHandler().playerEntity.world, ctx.getServerHandler().playerEntity);
                grenade.explodeOnImpact = true;
                grenade.setFlaming(hasIncendiary);
                ctx.getServerHandler().playerEntity.world.spawnEntity(grenade);
                Inventories.consumeItem(ctx.getServerHandler().playerEntity, !hasIncendiary ? AliensVsPredator.items().itemGrenade : AliensVsPredator.items().itemIncendiaryGrenade);
            }
        }

        return null;
    }
}
