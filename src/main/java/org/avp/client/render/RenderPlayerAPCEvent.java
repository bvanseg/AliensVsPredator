package org.avp.client.render;

import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.common.entity.EntityAPC;

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
