package org.avp.common;

import org.avp.AliensVsPredator;
import org.avp.common.packets.client.OrganismClientSync;
import org.avp.common.packets.client.PacketAmmoUpdate;
import org.avp.common.packets.client.PacketOpenBlastdoor;
import org.avp.common.packets.client.PacketOpenable;
import org.avp.common.packets.client.PacketOvamorphContainsFacehugger;
import org.avp.common.packets.client.PacketPlayerModeUpdate;
import org.avp.common.packets.client.PacketRotateRotatable;
import org.avp.common.packets.client.PacketSyncRF;
import org.avp.common.packets.client.PacketTurretSync;
import org.avp.common.packets.client.SpecialPlayerClientSync;
import org.avp.common.packets.server.OrganismServerSync;
import org.avp.common.packets.server.PacketAddTurretTarget;
import org.avp.common.packets.server.PacketAssemble;
import org.avp.common.packets.server.PacketAttachParasiteToEntity;
import org.avp.common.packets.server.PacketBlastdoorCommon;
import org.avp.common.packets.server.PacketBlastdoorCommon.PacketBlastdoorClient;
import org.avp.common.packets.server.PacketCryostasisStateUpdate;
import org.avp.common.packets.server.PacketDamageEntity;
import org.avp.common.packets.server.PacketFireAPC;
import org.avp.common.packets.server.PacketFirearmSync;
import org.avp.common.packets.server.PacketLaunchGrenade;
import org.avp.common.packets.server.PacketOpenContainer;
import org.avp.common.packets.server.PacketOpenGui;
import org.avp.common.packets.server.PacketPlasmaDischarge;
import org.avp.common.packets.server.PacketReadFromDataDevice;
import org.avp.common.packets.server.PacketReloadFirearm;
import org.avp.common.packets.server.PacketRemoveTurretTarget;
import org.avp.common.packets.server.PacketSpawnEntity;
import org.avp.common.packets.server.PacketSpawnNuke;
import org.avp.common.packets.server.PacketToggleTurretPlayerTarget;
import org.avp.common.packets.server.PacketTurretAmmoSync;
import org.avp.common.packets.server.PacketTurretTargetUpdate;
import org.avp.common.packets.server.PacketWriteToDataDevice;
import org.avp.common.packets.server.SpecialPlayerServerSync;

import com.asx.mdx.core.mods.IInitEvent;

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
        /** Send to the server **/
        this.registerMessage(Side.SERVER, PacketAssemble.class);
        this.registerMessage(Side.SERVER, PacketOpenContainer.class);
        this.registerMessage(Side.SERVER, PacketReloadFirearm.class);
        this.registerMessage(Side.SERVER, PacketLaunchGrenade.class);
        this.registerMessage(Side.SERVER, PacketFireAPC.class);
        this.registerMessage(Side.SERVER, PacketDamageEntity.class);
        this.registerMessage(Side.SERVER, PacketFirearmSync.class);
        this.registerMessage(Side.SERVER, PacketSpawnEntity.class);
        this.registerMessage(Side.SERVER, PacketSpawnNuke.class);
        this.registerMessage(Side.SERVER, PacketPlasmaDischarge.class);
        this.registerMessage(Side.SERVER, PacketAddTurretTarget.class);
        this.registerMessage(Side.SERVER, PacketRemoveTurretTarget.class);
        this.registerMessage(Side.SERVER, PacketToggleTurretPlayerTarget.class);
        this.registerMessage(Side.SERVER, PacketReadFromDataDevice.class);
        this.registerMessage(Side.SERVER, PacketWriteToDataDevice.class);
        this.registerMessage(Side.SERVER, OrganismServerSync.class);
        this.registerMessage(Side.SERVER, SpecialPlayerServerSync.class);
        this.registerMessage(Side.SERVER, PacketBlastdoorCommon.class);
        
        /** Send to the client **/
        this.registerMessage(Side.CLIENT, PacketTurretAmmoSync.class);
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
        this.registerMessage(Side.CLIENT, PacketAttachParasiteToEntity.class);
        this.registerMessage(Side.CLIENT, PacketCryostasisStateUpdate.class);
    }

    /**
     * @param side - The side this packet will be sent to.
     * @param packet - The packet being registered.
     */
    @SuppressWarnings("unchecked")
    private <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Side side, Class<?> packet)
    {
        this.registerMessage((Class<? extends IMessageHandler<REQ, REPLY>>) packet, (Class<REQ>) packet, descriminator++, side);
    }
}
