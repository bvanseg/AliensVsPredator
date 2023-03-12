package org.avp.client.render;

import org.avp.common.entities.EntityAPC;

import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderPlayerAPCEvent
{
    public static final RenderPlayerAPCEvent instance = new RenderPlayerAPCEvent();

    @SubscribeEvent
    public void onRenderPlayerEvent(RenderPlayerEvent.Pre event)
    {
        if (event.getEntityPlayer().isRiding() && event.getEntityPlayer().getRidingEntity()instanceof EntityAPC)
        {
            event.setCanceled(true);
        }
    }
}
