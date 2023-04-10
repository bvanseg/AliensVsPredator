package org.avp.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.PacketBlastdoorClient;
import org.avp.common.network.packet.common.BlastdoorPacketMode;
import org.avp.common.tile.TileEntityBlastdoor;

/**
 * @author Ri5ux
 */
public class PacketBlastdoorServer implements IMessage, IMessageHandler<PacketBlastdoorServer, PacketBlastdoorServer>
{

    private BlastdoorPacketMode mode;
    private int        x;
    private int        y;
    private int        z;

    private String     key;
    private boolean    autolock;

    public PacketBlastdoorServer()
    {
        ;
    }

    public PacketBlastdoorServer(BlastdoorPacketMode mode, BlockPos pos, Object... data)
    {
        this.mode = mode;
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();

        switch (mode)
        {
            case AUTH:
                this.key = (String) data[0];
                break;
            case SETPSWD:
                this.key = (String) data[0];
                break;
            case SETAUTOLOCK:
                this.autolock = (boolean) data[0];
                break;
            default:
                break;
        }
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.mode = BlastdoorPacketMode.byId(buf.readInt());
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();

        switch (this.mode)
        {
            case AUTH:
                this.key = ByteBufUtils.readUTF8String(buf);
                break;
            case SETPSWD:
                this.key = ByteBufUtils.readUTF8String(buf);
                break;
            case SETAUTOLOCK:
                this.autolock = buf.readBoolean();
                break;
            default:
                break;
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.mode.getId());
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);

        switch (this.mode)
        {
            case AUTH:
                ByteBufUtils.writeUTF8String(buf, this.key);
                break;
            case SETPSWD:
                ByteBufUtils.writeUTF8String(buf, this.key);
                break;
            case SETAUTOLOCK:
                buf.writeBoolean(autolock);
                break;
            default:
                break;
        }
    }

    @Override
    public PacketBlastdoorServer onMessage(PacketBlastdoorServer packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
            World world = ctx.getServerHandler().player.world;
            TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null && tile instanceof TileEntityBlastdoor)
            {
                TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

                Object[] data = new Object[4];

                switch (packet.mode)
                {
                    case AUTH:
                        data[0] = packet.key;
                        if (blastdoor.isLocked())
                        {
                            blastdoor.authenticate(packet.key);
                        }
                        break;
                    case SETPSWD:
                        data[0] = packet.key;
                        blastdoor.setPassword(packet.key);
                        break;
                    case SETAUTOLOCK:
                        data[0] = packet.autolock;
                        blastdoor.setAutolock(packet.autolock);
                        break;
                    case BIND:
                        ItemStack itemstack = ctx.getServerHandler().player.getHeldItemMainhand();
                        blastdoor.bindToSecurityTuner(itemstack);
                        break;
                    default:
                        break;
                }
                blastdoor.markDirty();
                AVPNetworking.instance.sendToAll(new PacketBlastdoorClient(packet.mode, new BlockPos(packet.x, packet.y, packet.z), data));
            }
        });

        return null;
    }
}
