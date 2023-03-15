package org.avp.common.network.packet.server;

import com.asx.mdx.lib.util.Game;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.avp.AVP;
import org.avp.common.AVPNetworking;
import org.avp.common.tile.TileEntityBlastdoor;

public class PacketBlastdoorCommon implements IMessage, IMessageHandler<PacketBlastdoorCommon, PacketBlastdoorCommon>
{
    public static class PacketBlastdoorClient extends PacketBlastdoorCommon
    {
        public PacketBlastdoorClient()
        {
            ;
        }

        public PacketBlastdoorClient(PacketMode mode, BlockPos pos, Object... data)
        {
            super(mode, pos, data);
        }

        @Override
        public PacketBlastdoorCommon onMessage(PacketBlastdoorCommon packet, MessageContext ctx)
        {
            Game.minecraft().addScheduledTask(new Runnable() {
                @Override
                public void run()
                {
                    World world = Game.minecraft().world;
                    TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                    if (world != null && tile != null && tile instanceof TileEntityBlastdoor)
                    {
                        TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

                        if (blastdoor != null)
                        {
                            switch (packet.mode)
                            {
                                case AUTH:
                                    if (blastdoor.isLocked())
                                    {
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
                                    ItemStack itemstack = Game.minecraft().player.getHeldItemMainhand();

                                    if (itemstack != null)
                                    {
                                        blastdoor.bindToSecurityTuner(Game.minecraft().player, itemstack);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            });
            return null;
        }
    }

    public enum PacketMode
    {
        NONE(0), AUTH(1), SETPSWD(2), SETAUTOLOCK(3), BIND(4);

        public int id;

        PacketMode(int id)
        {
            this.id = id;
        }

        public static PacketMode byId(int id)
        {
            for (PacketMode mode : values())
            {
                if (mode.id == id)
                {
                    return mode;
                }
            }

            return NONE;
        }
    }

    protected PacketMode mode;
    protected int        x;
    protected int        y;
    protected int        z;

    protected String     key;
    protected boolean    autolock;

    public PacketBlastdoorCommon()
    {
        ;
    }

    public PacketBlastdoorCommon(PacketMode mode, BlockPos pos, Object... data)
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
        this.mode = PacketMode.byId(buf.readInt());
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();

        switch (mode)
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
        buf.writeInt(mode.id);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        switch (mode)
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
    public PacketBlastdoorCommon onMessage(PacketBlastdoorCommon packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable() {
            @Override
            public void run()
            {
                World world = ctx.getServerHandler().player.world;
                TileEntity tile = world.getTileEntity(new BlockPos(packet.x, packet.y, packet.z));

                if (world != null && tile != null && tile instanceof TileEntityBlastdoor)
                {
                    TileEntityBlastdoor blastdoor = (TileEntityBlastdoor) tile;

                    if (blastdoor != null)
                    {
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

                                if (itemstack != null)
                                {
                                    blastdoor.bindToSecurityTuner(ctx.getServerHandler().player, itemstack);
                                }
                                break;
                            default:
                                break;
                        }
                        blastdoor.markDirty();
                        AVPNetworking.instance.sendToAll(new PacketBlastdoorClient(packet.mode, new BlockPos(packet.x, packet.y, packet.z), data));
                    }
                }
            }
        });

        return null;
    }
}
