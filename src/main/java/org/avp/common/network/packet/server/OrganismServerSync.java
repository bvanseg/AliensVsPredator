package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.world.capability.IOrganism.Organism;
import org.avp.common.world.capability.IOrganism.Provider;

public class OrganismServerSync implements IMessage, IMessageHandler<OrganismServerSync, OrganismServerSync>
{
    public NBTTagCompound tag;
    private int           entityId;

    public OrganismServerSync()
    {
        ;
    }

    public OrganismServerSync(int entityId, NBTTagCompound tag)
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
    public OrganismServerSync onMessage(OrganismServerSync packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                Entity entity = ctx.getServerHandler().player.world.getEntityByID(packet.entityId);

                if (entity != null)
                {
                    Organism organism = (Organism) entity.getCapability(Provider.CAPABILITY, null);

                    if (organism != null)
                    {
                        Provider.CAPABILITY.getStorage().readNBT(Provider.CAPABILITY, organism, null, packet.tag);
                    }
                }
            }
        });

        return null;
    }
}
