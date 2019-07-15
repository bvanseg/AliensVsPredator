package org.avp.packets.client;

import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.util.Game;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OrganismClientSync implements IMessage, IMessageHandler<OrganismClientSync, OrganismClientSync>
{
    public NBTTagCompound tag;
    private int           entityId;

    public OrganismClientSync()
    {
        ;
    }

    public OrganismClientSync(int entityId, NBTTagCompound tag)
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

    @Override
    public OrganismClientSync onMessage(OrganismClientSync packet, MessageContext ctx)
    {
        Game.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                if (Game.minecraft().player != null && Game.minecraft().player.world != null)
                {
                    Entity entity = Game.minecraft().player.world.getEntityByID(packet.entityId);

                    if (entity != null)
                    {
                        Organism organism = (Organism) entity.getCapability(Provider.CAPABILITY, null);

                        if (organism != null)
                        {
                            Provider.CAPABILITY.getStorage().readNBT(Provider.CAPABILITY, organism, null, packet.tag);
                        }
                    }
                }
            }
        });

        return null;
    }
}
