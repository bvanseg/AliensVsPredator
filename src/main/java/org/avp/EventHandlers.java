package org.avp;

import java.util.ArrayList;

import org.avp.client.input.InputHandler;
import org.avp.client.render.AmmoIndicatorRenderEvent;
import org.avp.client.render.BossBarEvent;
import org.avp.client.render.ChestbursterOverlayEvent;
import org.avp.client.render.FacehuggerRenderEvent;
import org.avp.client.render.LightmapUpdateEvent;
import org.avp.client.render.PlayerModeRenderEvent;
import org.avp.client.render.PressureHUDRenderEvent;
import org.avp.client.render.RenderLivingHook;
import org.avp.client.render.RenderPlayerAPCEvent;
import org.avp.client.render.RenderPlayerHotbarAPCEvent;
import org.avp.client.render.TacticalHUDRenderEvent;
import org.avp.client.render.VisionModeRenderEvent;
import org.avp.client.render.items.RenderMotionTrackerScreen;
import org.avp.world.CapabilityHandler;
import org.avp.world.EntityImpregnationHandler;
import org.avp.world.fluids.BucketHandlingEvent;
import org.avp.world.hives.HiveHandler;
import org.avp.world.hooks.FarmlandRegistry;
import org.avp.world.hooks.MaterialHandler;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.game.IMod;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;


public class EventHandlers implements IInitEvent
{
    public static final EventHandlers instance = new EventHandlers();
    public ArrayList<Object>          events   = new ArrayList<Object>();

    @Override
    public void init(IMod mod, FMLInitializationEvent event)
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
        }

        if (FMLCommonHandler.instance().getSide() == Side.SERVER)
        {
            this.registerEvent(DimensionHandler.instance);
        }

        this.registerEvent(EntityImpregnationHandler.instance);
        this.registerEvent(CapabilityHandler.instance);
        this.registerEvent(SaveHandler.instance);
        this.registerEvent(FarmlandRegistry.instance);
        this.registerEvent(BucketHandlingEvent.instance);
        this.registerEvent(HiveHandler.instance);
        this.registerEvent(MaterialHandler.instance);
    }

    public void registerEvent(Object event)
    {
        this.events.add(event);
        Game.registerEventHandler(event);
    }
}
