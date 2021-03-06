package org.avp.common;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.mods.IInitEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.alien.client.render.ChestbursterOverlayEvent;
import org.alien.client.render.FacehuggerRenderEvent;
import org.alien.common.potion.PotionEffectEventHandler;
import org.alien.common.world.ClientEntityImpregnationHandler;
import org.alien.common.world.CommonEntityImpregnationHandler;
import org.prometheus.common.world.TrilobiteImpregnationHandler;
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
import org.power.client.render.BlastDoorPlacementBoxRenderer;
import org.predator.client.render.VisionModeRenderEvent;
import org.weapon.client.render.AmmoIndicatorRenderEvent;
import org.weapon.common.delay.DelayHandler;
import org.weapon.common.reload.ReloadHandler;

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

            // Tactical helmet
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

            // Render living hooks
            this.registerEvent(RenderLivingHook.instance);
            this.registerEvent(RenderPlasmaCannonHook.instance);

            this.registerEvent(SkyProviderAcheron.instance);
            this.registerEvent(BlastDoorPlacementBoxRenderer.instance);
            this.registerEvent(ClientEntityImpregnationHandler.instance);
        }

        this.registerEvent(CommonEntityImpregnationHandler.instance);
        this.registerEvent(PotionEffectEventHandler.instance);
        this.registerEvent(EntityAccessor.instance);
        this.registerEvent(TrilobiteImpregnationHandler.instance);
        this.registerEvent(CapabilityHandler.instance);
        this.registerEvent(SaveHandler.instance);
        this.registerEvent(FarmlandRegistry.instance);
        this.registerEvent(BucketHandlingEvent.instance);
        this.registerEvent(MaterialHandler.instance);

        this.registerEvent(CachedInventoryHandler.instance);
        this.registerEvent(ReloadHandler.instance);
        this.registerEvent(DelayHandler.instance);
    }

    public void registerEvent(Object event)
    {
        events.add(event);
        Game.instance.registerEventHandler(event);
    }
}
