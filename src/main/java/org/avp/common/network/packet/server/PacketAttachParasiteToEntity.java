package org.avp.common.network.packet.server;


import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.common.api.parasitoidic.Parasitoid;

public class PacketAttachParasiteToEntity implements IMessage, IMessageHandler<PacketAttachParasiteToEntity, PacketAttachParasiteToEntity>
{
    public int parasiteId;
    public int targetId;

    public PacketAttachParasiteToEntity()
    {
        ;
    }

    public PacketAttachParasiteToEntity(int parasiteId, int targetId)
    {
        this.parasiteId = parasiteId;
        this.targetId = targetId;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.parasiteId = buf.readInt();
        this.targetId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.parasiteId);
        buf.writeInt(this.targetId);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public PacketAttachParasiteToEntity onMessage(PacketAttachParasiteToEntity packet, MessageContext ctx)
    {
        ClientGame.instance.minecraft().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                Entity e = ClientGame.instance.minecraft().world.getEntityByID(packet.parasiteId);
                Entity e2 = ClientGame.instance.minecraft().world.getEntityByID(packet.targetId);
                
                if (e instanceof Parasitoid)
                {
                    Parasitoid parasite = (Parasitoid) e;
                    
                    if (e2 instanceof EntityLivingBase)
                    {
                        EntityLivingBase target = (EntityLivingBase) e2;
                        
                        parasite.attachToEntity(target);
                    }
                }
            }
        });
        return null;
    }
}
