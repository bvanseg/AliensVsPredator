package org.avp.common.world;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.world.capability.Organism;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.AVP;
import org.avp.common.world.capability.SpecialPlayer;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;

public class CapabilityHandler implements IPreInitEvent
{
    public static final CapabilityHandler instance = new CapabilityHandler();

    private CapabilityHandler() {}

    public static final ResourceLocation ORGANISM = new ResourceLocation(AVP.Properties.ID, "organism");
    public static final ResourceLocation SPECIAL_PLAYER = new ResourceLocation(AVP.Properties.ID, "special_player");

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        CapabilityManager.INSTANCE.register(Organism.class, new OrganismImpl(), new OrganismImpl.Factory());
        CapabilityManager.INSTANCE.register(SpecialPlayer.class, new SpecialPlayerImpl(), new SpecialPlayerImpl.Factory());
    }
    
    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof EntityLivingBase)
        {
            event.addCapability(ORGANISM, new Provider());
        }
        if (event.getObject() instanceof EntityPlayer)
        {
            event.addCapability(SPECIAL_PLAYER, new SpecialPlayer.Provider());
        }
    }
    
    @SubscribeEvent
    public void onEntityTrackEvent(PlayerEvent.StartTracking event)
    {
        this.syncEntity(event.getTarget());
    }

    @SubscribeEvent
    public void onEntitySpawnInWorld(EntityJoinWorldEvent event)
    {
        if (event.getEntity() != null && !event.getEntity().world.isRemote)
        {
            this.syncEntity(event.getEntity());
        }
    }

    public void syncEntity(Entity target)
    {
        WorldServer worldServer = (WorldServer) target.world;
        if (worldServer == null) return;

        EntityTracker tracker = worldServer.getEntityTracker();

        if (tracker == null) return;
        if (target == null) return;

        if (target instanceof EntityLivingBase)
        {
            OrganismImpl organism = (OrganismImpl) target.getCapability(Provider.CAPABILITY, null);

            if (organism != null)
            {
                if (target instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer) target;
                    organism.syncWithClients(player);
                }
            }
        }

        if (target instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) target;
            SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) target.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);

            if (specialPlayer != null)
            {
                specialPlayer.syncWithClients(player);
            }
        }
    }
}
