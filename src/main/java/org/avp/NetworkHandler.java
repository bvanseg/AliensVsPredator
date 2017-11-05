package org.avp;

import org.avp.packets.client.OrganismClientSync;
import org.avp.packets.client.PacketAmmoUpdate;
import org.avp.packets.client.PacketOpenBlastdoor;
import org.avp.packets.client.PacketOpenable;
import org.avp.packets.client.PacketOvamorphContainsFacehugger;
import org.avp.packets.client.PacketPlayerModeUpdate;
import org.avp.packets.client.PacketRotateRotatable;
import org.avp.packets.client.PacketSyncRF;
import org.avp.packets.client.PacketTurretSync;
import org.avp.packets.client.SpecialPlayerClientSync;
import org.avp.packets.server.OrganismServerSync;
import org.avp.packets.server.PacketAddTuretTarget;
import org.avp.packets.server.PacketAssemble;
import org.avp.packets.server.PacketBlastdoorCommon;
import org.avp.packets.server.PacketBlastdoorCommon.PacketBlastdoorClient;
import org.avp.packets.server.PacketDamageEntity;
import org.avp.packets.server.PacketFireAPC;
import org.avp.packets.server.PacketFirearmSync;
import org.avp.packets.server.PacketLaunchGrenade;
import org.avp.packets.server.PacketOpenContainer;
import org.avp.packets.server.PacketOpenGui;
import org.avp.packets.server.PacketPlasmaDischarge;
import org.avp.packets.server.PacketReadFromDataDevice;
import org.avp.packets.server.PacketReloadFirearm;
import org.avp.packets.server.PacketRemoveTurretTarget;
import org.avp.packets.server.PacketSpawnEntity;
import org.avp.packets.server.PacketSpawnNuke;
import org.avp.packets.server.PacketTurretTargetUpdate;
import org.avp.packets.server.PacketWriteToDataDevice;
import org.avp.packets.server.SpecialPlayerServerSync;

import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


public class NetworkHandler extends SimpleNetworkWrapper implements IInitEvent
{
    public static final NetworkHandler instance = new NetworkHandler();
    private int descriminator = 0;

    public NetworkHandler()
    {
        super(AliensVsPredator.Properties.ID.toUpperCase());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerMessage(Side.SERVER, PacketAssemble.class);
        this.registerMessage(Side.SERVER, PacketOpenContainer.class);
        this.registerMessage(Side.SERVER, PacketReloadFirearm.class);
        this.registerMessage(Side.SERVER, PacketLaunchGrenade.class);
        this.registerMessage(Side.SERVER, PacketFireAPC.class);
        this.registerMessage(Side.SERVER, PacketDamageEntity.class);
        this.registerMessage(Side.SERVER, PacketRemoveTurretTarget.class);
        this.registerMessage(Side.SERVER, PacketFirearmSync.class);
        this.registerMessage(Side.SERVER, PacketSpawnEntity.class);
        this.registerMessage(Side.SERVER, PacketSpawnNuke.class);
        this.registerMessage(Side.SERVER, PacketPlasmaDischarge.class);
        this.registerMessage(Side.SERVER, PacketAddTuretTarget.class);
        this.registerMessage(Side.SERVER, PacketReadFromDataDevice.class);
        this.registerMessage(Side.SERVER, PacketWriteToDataDevice.class);
        this.registerMessage(Side.SERVER, OrganismServerSync.class);
        this.registerMessage(Side.SERVER, SpecialPlayerServerSync.class);
        this.registerMessage(Side.SERVER, PacketBlastdoorCommon.class);
        this.registerMessage(Side.CLIENT, PacketTurretTargetUpdate.class);
        this.registerMessage(Side.CLIENT, PacketOvamorphContainsFacehugger.class);
        this.registerMessage(Side.CLIENT, PacketAmmoUpdate.class);
        this.registerMessage(Side.CLIENT, PacketOpenBlastdoor.class);
        this.registerMessage(Side.CLIENT, PacketOpenable.class);
        this.registerMessage(Side.CLIENT, PacketPlayerModeUpdate.class);
        this.registerMessage(Side.CLIENT, PacketTurretSync.class);
        this.registerMessage(Side.CLIENT, OrganismClientSync.class);
        this.registerMessage(Side.CLIENT, SpecialPlayerClientSync.class);
        this.registerMessage(Side.CLIENT, PacketRotateRotatable.class);
        this.registerMessage(Side.CLIENT, PacketSyncRF.class);
        this.registerMessage(Side.CLIENT, PacketOpenGui.class);
        this.registerMessage(Side.CLIENT, PacketBlastdoorClient.class);
    }

    @SuppressWarnings("unchecked")
    private <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Side side, Class<?> packet)
    {
        this.registerMessage((Class<? extends IMessageHandler<REQ, REPLY>>) packet, (Class<REQ>) packet, descriminator++, side);
    }
}
