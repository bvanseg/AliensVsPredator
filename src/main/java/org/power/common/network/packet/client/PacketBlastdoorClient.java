package org.power.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.common.network.packet.common.BlastdoorPacketMode;
import org.power.common.tile.TileEntityBlastdoor;

/**
 * @author Ri5ux
 */
public class PacketBlastdoorClient implements IMessage, IMessageHandler<PacketBlastdoorClient, PacketBlastdoorClient> {


    private BlastdoorPacketMode mode;
    private int        x;
    private int        y;
    private int        z;

    private String     key;
    private boolean    autolock;

    public PacketBlastdoorClient() { /* Do Nothing */ }

    public PacketBlastdoorClient(BlastdoorPacketMode mode, BlockPos pos, Object... data)
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
    public PacketBlastdoorClient onMessage(PacketBlastdoorClient packet, MessageContext ctx) {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
            TileEntity tile = ClientGame.instance.minecraft().world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

            if (tile != null && tile instanceof TileEntityBlastdoor) {
                TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

                switch (packet.mode) {
                    case AUTH:
                        if (blastdoor.isLocked()) {
                            blastdoor.authenticate(packet.key);
                        }
                        break;
                    case SETPSWD:
                        blastdoor.setPassword(packet.key);
                        break;
                    case SETAUTOLOCK:
                        blastdoor.setAutolock(packet.autolock);
                        break;
                    case BIND:
                        ItemStack itemStack = ClientGame.instance.minecraft().player.getHeldItemMainhand();
                        blastdoor.bindToSecurityTuner(itemStack);
                        break;
                    default:
                        break;
                }
            }
        });
        return null;
    }
}