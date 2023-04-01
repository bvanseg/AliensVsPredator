package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.AVPItems;
import org.avp.common.entity.EntityGrenade;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;

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
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            if (ctx.getServerHandler().player != null && ctx.getServerHandler().player.world != null)
            {
                InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(ctx.getServerHandler().player);
                boolean hasNormal = inventorySnapshot.hasItem(AVPItems.ITEM_GRENADE);
                boolean hasIncendiary = inventorySnapshot.hasItem(AVPItems.ITEM_INCENDIARY_GRENADE);

                if (hasNormal || hasIncendiary)
                {
                    EntityGrenade grenade = new EntityGrenade(ctx.getServerHandler().player.world, ctx.getServerHandler().player);
                    grenade.explodeOnImpact = true;
                    grenade.setFlaming(hasIncendiary);
                    ctx.getServerHandler().player.world.spawnEntity(grenade);
                    inventorySnapshot.consumeItem(!hasIncendiary ? AVPItems.ITEM_GRENADE : AVPItems.ITEM_INCENDIARY_GRENADE);
                }
            }
        });

        return null;
    }
}
