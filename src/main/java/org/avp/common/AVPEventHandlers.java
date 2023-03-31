package org.avp.common;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.mods.IInitEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.alien.client.render.ChestbursterOverlayEvent;
import org.alien.client.render.FacehuggerRenderEvent;
import org.alien.common.AlienDimensions;
import org.alien.common.world.EntityImpregnationHandler;
import org.alien.common.world.TrilobiteImpregnationHandler;
import org.alien.common.world.dimension.acheron.SkyProviderAcheron;
import org.avp.client.input.AVPInputEventHandler;
import org.avp.client.render.*;
import org.avp.client.render.tactical.TacticalHelmetAPCGearRenderEvent;
import org.avp.client.render.tactical.TacticalHelmetHUDRenderEvent;
import org.avp.client.render.tactical.TacticalHelmetSettingsRenderEvent;
import org.avp.client.render.tactical.TacticalHelmetTrackedEntityRenderEvent;
import org.avp.common.world.CapabilityHandler;
import org.avp.common.world.fluids.BucketHandlingEvent;
import org.avp.common.world.hook.FarmlandRegistry;
import org.avp.common.world.hook.MaterialHandler;
import org.lib.common.EntityAccessor;
import org.lib.common.inventory.CachedInventoryHandler;
import org.predator.client.render.VisionModeRenderEvent;

import java.util.ArrayList;


public class AVPEventHandlers implements IInitEvent
{
    public static final AVPEventHandlers instance = new AVPEventHandlers();
    protected static final ArrayList<Object> events = new ArrayList<>();

    private AVPEventHandlers() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            this.registerEvent(AVPInputEventHandler.instance);
            this.registerEvent(RenderPlayerHotbarAPCEvent.instance);
            this.registerEvent(ChestbursterOverlayEvent.instance);
            this.registerEvent(AmmoIndicatorRenderEvent.instance);

            this.registerEvent(TacticalHelmetHUDRenderEvent.instance);
            this.registerEvent(TacticalHelmetTrackedEntityRenderEvent.instance);
            this.registerEvent(TacticalHelmetAPCGearRenderEvent.instance);
            this.registerEvent(TacticalHelmetSettingsRenderEvent.instance);

            this.registerEvent(PressureHUDRenderEvent.instance);
            this.registerEvent(FacehuggerRenderEvent.instance);
            this.registerEvent(VisionModeRenderEvent.instance);
            this.registerEvent(LightmapUpdateEvent.instance);
            this.registerEvent(RenderPlayerAPCEvent.instance);
            this.registerEvent(BossBarEvent.instance);
            this.registerEvent(RenderLivingHook.instance);
            this.registerEvent(SkyProviderAcheron.instance);
            this.registerEvent(BlastDoorPlacementBoxRenderer.instance);
        }

        if (FMLCommonHandler.instance().getSide() == Side.SERVER)
        {
            this.registerEvent(AlienDimensions.instance);
        }

        this.registerEvent(EntityAccessor.instance);
        this.registerEvent(EntityImpregnationHandler.instance);
        this.registerEvent(TrilobiteImpregnationHandler.instance);
        this.registerEvent(CapabilityHandler.instance);
        this.registerEvent(SaveHandler.instance);
        this.registerEvent(FarmlandRegistry.instance);
        this.registerEvent(BucketHandlingEvent.instance);
        this.registerEvent(MaterialHandler.instance);

        this.registerEvent(CachedInventoryHandler.instance);
    }

    public void registerEvent(Object event)
    {
        events.add(event);
        Game.instance.registerEventHandler(event);
    }
}
