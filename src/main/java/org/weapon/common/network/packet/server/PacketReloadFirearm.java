package org.weapon.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
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

            if (player == null) return;

            if (player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
            {
                ItemFirearm firearm = ((ItemFirearm) player.getHeldItemMainhand().getItem());
                firearm.reload(ctx.getServerHandler().player, player.getHeldItemMainhand(), EnumHand.MAIN_HAND);
            }

            if (player.getHeldItemOffhand().getItem() instanceof ItemFirearm)
            {
                ItemFirearm firearm = ((ItemFirearm) player.getHeldItemOffhand().getItem());
                firearm.reload(ctx.getServerHandler().player, player.getHeldItemOffhand(), EnumHand.OFF_HAND);
            }
        });

        return null;
    }
}
