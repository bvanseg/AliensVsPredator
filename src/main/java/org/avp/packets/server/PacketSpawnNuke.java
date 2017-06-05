package org.avp.packets.server;

import org.avp.AliensVsPredator;
import org.avp.entities.EntityWristbracer;

import com.arisux.mdx.MDX;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSpawnNuke implements IMessage, IMessageHandler<PacketSpawnNuke, PacketSpawnNuke>
{
    public PacketSpawnNuke()
    {
        ;
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
        ;
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
        ;
    }

    @Override
    public PacketSpawnNuke onMessage(PacketSpawnNuke packet, MessageContext ctx)
    {
        System.out.println("Sent packet " + this.getClass().getName());
        ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                EntityPlayer player = ctx.getServerHandler().playerEntity;

                if (player != null && AliensVsPredator.settings().areNukesEnabled())
                {
                    MDX.log().info(String.format("Player %s has just initiated a nuclear explosion at %s, %s, %s", player.getName(), player.posX, player.posY, player.posZ));
                    EntityWristbracer nuke = new EntityWristbracer(ctx.getServerHandler().playerEntity.world);
                    nuke.setLocationAndAngles(ctx.getServerHandler().playerEntity.posX, ctx.getServerHandler().playerEntity.posY, ctx.getServerHandler().playerEntity.posZ, 0F, 0F);
                    ctx.getServerHandler().playerEntity.world.spawnEntity(nuke);
                    Inventories.consumeItem(ctx.getServerHandler().playerEntity, ctx.getServerHandler().playerEntity.getHeldItemMainhand().getItem());
                }
            }
        });

        return null;
    }
}
