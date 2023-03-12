package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.lib.util.Game;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.client.input.InputHandler;
import org.avp.client.render.*;
import org.avp.client.render.items.RenderMotionTrackerScreen;
import org.avp.common.world.CapabilityHandler;
import org.avp.common.world.EntityImpregnationHandler;
import org.avp.common.world.TrilobiteImpregnationHandler;
import org.avp.common.world.dimension.acheron.SkyProviderAcheron;
import org.avp.common.world.fluids.BucketHandlingEvent;
import org.avp.common.world.hooks.FarmlandRegistry;
import org.avp.common.world.hooks.MaterialHandler;

import java.util.ArrayList;


public class EventHandlers implements IInitEvent
{
    public static final EventHandlers instance = new EventHandlers();
    public ArrayList<Object>          events   = new ArrayList<Object>();

    @Override
    public void init(FMLInitializationEvent event)
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            this.registerEvent(InputHandler.instance);
            this.registerEvent(RenderPlayerHotbarAPCEvent.instance);
            this.registerEvent(ChestbursterOverlayEvent.instance);
            this.registerEvent(PlayerModeRenderEvent.instance);
            this.registerEvent(AmmoIndicatorRenderEvent.instance);
            this.registerEvent(TacticalHUDRenderEvent.instance);
            this.registerEvent(PressureHUDRenderEvent.instance);
            this.registerEvent(FacehuggerRenderEvent.instance);
            this.registerEvent(VisionModeRenderEvent.instance);
            this.registerEvent(RenderMotionTrackerScreen.instance);
            this.registerEvent(LightmapUpdateEvent.instance);
            this.registerEvent(RenderPlayerAPCEvent.instance);
            this.registerEvent(BossBarEvent.instance);
            this.registerEvent(RenderLivingHook.instance);
            this.registerEvent(SkyProviderAcheron.instance);
            this.registerEvent(BlastDoorPlacementBoxRenderer.instance);
        }

        if (FMLCommonHandler.instance().getSide() == Side.SERVER)
        {
            this.registerEvent(DimensionHandler.instance);
        }

        this.registerEvent(EntityImpregnationHandler.instance);
        this.registerEvent(TrilobiteImpregnationHandler.instance);
        this.registerEvent(CapabilityHandler.instance);
        this.registerEvent(SaveHandler.instance);
        this.registerEvent(FarmlandRegistry.instance);
        this.registerEvent(BucketHandlingEvent.instance);
        this.registerEvent(MaterialHandler.instance);
    }

    public void registerEvent(Object event)
    {
        this.events.add(event);
        Game.registerEventHandler(event);
    }
}
