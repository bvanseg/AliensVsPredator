package org.weapon.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.weapon.common.item.firearm.ItemFirearm;

public class PacketReloadFirearm implements IMessage, IMessageHandler<PacketReloadFirearm, PacketReloadFirearm>
{
    public PacketReloadFirearm()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    }

    @Override
    public PacketReloadFirearm onMessage(PacketReloadFirearm message, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            EntityPlayer player = ctx.getServerHandler().player;

            if (player != null && player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
            {
                ((ItemFirearm) player.getHeldItemMainhand().getItem()).reload(ctx.getServerHandler().player, player.getHeldItemMainhand());
            }
            else if (player != null && player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof ItemFirearm)
            {
                ((ItemFirearm) player.getHeldItemOffhand().getItem()).reload(ctx.getServerHandler().player, player.getHeldItemOffhand());
            }
        });

        return null;
    }
}
