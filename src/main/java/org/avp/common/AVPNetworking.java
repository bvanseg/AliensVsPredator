package org.avp.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.AVP;
import org.avp.common.network.packet.client.*;
import org.avp.common.network.packet.server.*;
import org.weapon.common.network.packet.server.PacketLaunchGrenade;
import org.weapon.common.network.packet.server.PacketReloadFirearm;


public class AVPNetworking extends SimpleNetworkWrapper implements IInitEvent
{
    public static final AVPNetworking instance = new AVPNetworking();
    private int discriminator = 0;

    private AVPNetworking()
    {
        super(AVP.Properties.ID.toUpperCase());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        /* Send to the server */
        this.registerMessage(Side.SERVER, PacketAssemble.class);
        this.registerMessage(Side.SERVER, PacketOpenContainer.class);
        this.registerMessage(Side.SERVER, PacketReloadFirearm.class);
        this.registerMessage(Side.SERVER, PacketLaunchGrenade.class);
        this.registerMessage(Side.SERVER, PacketFireAPC.class);
        this.registerMessage(Side.SERVER, PacketDamageEntity.class);
        this.registerMessage(Side.SERVER, PacketSpawnEntity.class);
        this.registerMessage(Side.SERVER, PacketSpawnNuke.class);
        this.registerMessage(Side.SERVER, PacketPlasmaDischarge.class);
        this.registerMessage(Side.SERVER, PacketAddTurretTarget.class);
        this.registerMessage(Side.SERVER, PacketRemoveTurretTarget.class);
        this.registerMessage(Side.SERVER, PacketToggleTurretPlayerTarget.class);
        this.registerMessage(Side.SERVER, PacketReadFromDataDevice.class);
        this.registerMessage(Side.SERVER, PacketWriteToDataDevice.class);
        this.registerMessage(Side.SERVER, OrganismServerSync.class);
        this.registerMessage(Side.SERVER, PacketBlastdoorServer.class);
        
        /* Send to the client */
        this.registerMessage(Side.CLIENT, PacketTurretAmmoSync.class);
        this.registerMessage(Side.CLIENT, PacketTurretTargetUpdate.class);
        this.registerMessage(Side.CLIENT, PacketOpenBlastdoor.class);
        this.registerMessage(Side.CLIENT, PacketOpenable.class);
        this.registerMessage(Side.CLIENT, PacketTurretSync.class);
        this.registerMessage(Side.CLIENT, OrganismClientSync.class);
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
        this.registerMessage((Class<? extends IMessageHandler<REQ, REPLY>>) packet, (Class<REQ>) packet, discriminator++, side);
    }
}
