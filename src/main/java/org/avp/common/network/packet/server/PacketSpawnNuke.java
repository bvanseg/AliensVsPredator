package org.avp.common.network.packet.server;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.AVP;
import org.avp.common.config.ModelConfig;
import org.predator.common.entity.EntityWristbracer;

public class PacketSpawnNuke implements IMessage, IMessageHandler<PacketSpawnNuke, PacketSpawnNuke>
{
    public PacketSpawnNuke()
    {
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
    }

    @Override
    public PacketSpawnNuke onMessage(PacketSpawnNuke packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            EntityPlayer player = ctx.getServerHandler().player;

            if (player != null && ModelConfig.getInstance().getGeneral().nukesEnabled)
            {
                AVP.instance.getLogger().info(String.format("Player %s has just initiated a nuclear explosion at %s, %s, %s", player.getName(), player.posX, player.posY, player.posZ));
                EntityWristbracer nuke = new EntityWristbracer(ctx.getServerHandler().player.world);
                nuke.setLocationAndAngles(ctx.getServerHandler().player.posX, ctx.getServerHandler().player.posY, ctx.getServerHandler().player.posZ, 0F, 0F);
                ctx.getServerHandler().player.world.spawnEntity(nuke);
                Inventories.consumeItem(ctx.getServerHandler().player, ctx.getServerHandler().player.getHeldItemMainhand().getItem());
            }
        });

        return null;
    }
}
