package org.avp.packets.client;

import org.avp.item.ItemFirearm;

import com.arisux.mdx.lib.game.Game;

import io.netty.buffer.ByteBuf;
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
                System.out.println("Sent packet " + this.getClass().getName());
                ((ItemFirearm) Game.minecraft().player.inventory.getCurrentItem().getItem()).setAmmoCount(packet.ammo);
            }
        });
        return null;
    }
}
