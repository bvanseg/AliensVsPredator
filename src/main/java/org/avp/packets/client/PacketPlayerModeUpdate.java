package org.avp.packets.client;

import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.avp.world.playermode.PlayerMode;

import com.arisux.mdx.lib.game.Game;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketPlayerModeUpdate implements IMessage, IMessageHandler<PacketPlayerModeUpdate, PacketPlayerModeUpdate>
{
    public int mode;

    public PacketPlayerModeUpdate()
    {
        ;
    }

    public PacketPlayerModeUpdate(int mode)
    {
        this.mode = mode;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.mode = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.mode);
    }

    @Override
    public PacketPlayerModeUpdate onMessage(PacketPlayerModeUpdate packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                SpecialPlayer specialPlayer = (SpecialPlayer) Game.minecraft().player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);
                specialPlayer.setPlayerMode(PlayerMode.get(packet.mode));
            }
        });

        return null;
    }
}
