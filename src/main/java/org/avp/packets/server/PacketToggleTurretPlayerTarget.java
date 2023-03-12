package org.avp.packets.server;

import org.avp.tile.TileEntityTurret;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketToggleTurretPlayerTarget implements IMessage, IMessageHandler<PacketToggleTurretPlayerTarget, PacketToggleTurretPlayerTarget>
{
    public int    x, y, z;
    public String name;

    public PacketToggleTurretPlayerTarget() {}

    public PacketToggleTurretPlayerTarget(int x, int y, int z, String globalID)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = globalID;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.name = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        ByteBufUtils.writeUTF8String(buf, this.name);
    }

    @Override
    public PacketToggleTurretPlayerTarget onMessage(PacketToggleTurretPlayerTarget packet, MessageContext ctx) {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
        	TileEntityTurret tile = (TileEntityTurret) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null) {
            	EntityPlayer targetPlayer = ctx.getServerHandler().player.getServerWorld().getPlayerEntityByName(packet.name);
            	
            	if (targetPlayer != null) {
            		if (tile.getTargetHelper().addTargetPlayer(targetPlayer.getPersistentID())) {
                		ctx.getServerHandler().player.sendMessage(new TextComponentString("Successfully added player '" + packet.name + "' to target list!"));
            		} else if (tile.getTargetHelper().removeTargetPlayer(targetPlayer.getPersistentID())) {
                		ctx.getServerHandler().player.sendMessage(new TextComponentString("Successfully removed player '" + packet.name + "' from target list!"));
            		} else {
                		ctx.getServerHandler().player.sendMessage(new TextComponentString("Unable to add player '" + packet.name + "' to target list."));
            		}
            	}
            }
        });

        return null;
    }
}
