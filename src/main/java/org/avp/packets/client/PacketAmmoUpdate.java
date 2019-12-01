package org.avp.packets.client;

import org.avp.item.ItemFirearm;

import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketAmmoUpdate implements IMessage, IMessageHandler<PacketAmmoUpdate, PacketAmmoUpdate>
{
    public int ammo;

    public PacketAmmoUpdate()
    {
        ;
    }

    public PacketAmmoUpdate(int ammo)
    {
        this.ammo = ammo;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.ammo = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(ammo);
    }

    @Override
    public PacketAmmoUpdate onMessage(PacketAmmoUpdate packet, MessageContext ctx)
    {
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
            	EntityPlayer player = ctx.getServerHandler().player;

                if (player != null && player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
                {
                    ((ItemFirearm) player.getHeldItemMainhand().getItem()).setAmmoCount(packet.ammo);
                }
                else if (player != null && player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof ItemFirearm)
                {
                	((ItemFirearm) player.getHeldItemOffhand().getItem()).setAmmoCount(packet.ammo);
                }
            }
        });
        return null;
    }
}
