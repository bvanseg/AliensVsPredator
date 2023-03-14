package org.avp.common.network.packet.client;

import com.asx.mdx.lib.util.Game;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.avp.common.world.playermode.PlayerMode;

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
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) Game.minecraft().player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
                specialPlayer.setPlayerMode(PlayerMode.get(packet.mode));
            }
        });

        return null;
    }
}
