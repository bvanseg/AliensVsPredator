package org.avp.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.alien.common.world.capability.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;

public class OrganismClientSync implements IMessage, IMessageHandler<OrganismClientSync, OrganismClientSync>
{
    public NBTTagCompound tag;
    private int           entityId;

    public OrganismClientSync()
    {
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
        ClientGame.instance.minecraft().addScheduledTask(() -> {
            if (ClientGame.instance.minecraft().player != null && ClientGame.instance.minecraft().player.world != null)
            {
                Entity entity = ClientGame.instance.minecraft().player.world.getEntityByID(packet.entityId);

                if (entity != null)
                {
                    OrganismImpl organism = (OrganismImpl) entity.getCapability(Provider.CAPABILITY, null);

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
