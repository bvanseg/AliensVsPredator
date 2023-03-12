package org.avp.common.packets.client;

import org.avp.common.world.capabilities.ISpecialPlayer.SpecialPlayer;

import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SpecialPlayerClientSync implements IMessage, IMessageHandler<SpecialPlayerClientSync, SpecialPlayerClientSync>
{
    public NBTTagCompound tag;
    private int           entityId;

    public SpecialPlayerClientSync()
    {
        ;
    }

    public SpecialPlayerClientSync(int entityId, NBTTagCompound tag)
    {
        this.entityId = entityId;
        this.tag = tag;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.entityId = buf.readInt();
        this.tag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.entityId);
        ByteBufUtils.writeTag(buf, tag);
    }

    @SuppressWarnings("all")
    @Override
    public SpecialPlayerClientSync onMessage(SpecialPlayerClientSync packet, MessageContext ctx)
    {
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                Entity entity = Game.minecraft().player.world.getEntityByID(packet.entityId);

                if (entity != null)
                {
                    SpecialPlayer specialPlayer = (SpecialPlayer) entity.getCapability(SpecialPlayer.Provider.CAPABILITY, null);

                    if (specialPlayer != null)
                    {
                        specialPlayer.readNBT(SpecialPlayer.Provider.CAPABILITY, specialPlayer, null, packet.tag);
                    }
                }
            }
        });

        return null;
    }
}
