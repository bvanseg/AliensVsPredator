package org.avp.client.render.tactical;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.common.entity.EntityAPC;

/**
 * @author Ri5ux
 */
public class TacticalHelmetAPCGearRenderEvent
{
    public static final TacticalHelmetAPCGearRenderEvent instance = new TacticalHelmetAPCGearRenderEvent();

    private TacticalHelmetAPCGearRenderEvent() {}

    @SubscribeEvent
    public void renderTick(RenderGameOverlayEvent event)
    {
        if (ClientGame.instance.minecraft().player != null && event.getType() == ElementType.HELMET)
        {
            if (ClientGame.instance.minecraft().player.getRidingEntity() instanceof EntityAPC)
            {
                EntityAPC apc = (EntityAPC) ClientGame.instance.minecraft().player.getRidingEntity();
                double apcVelocity = Math.sqrt(apc.motionX * apc.motionX + apc.motionZ * apc.motionZ);
                EntityAPC.Gear apcGear = EntityAPC.Gear.forVelocity(apcVelocity);
                
                Draw.drawString("Gear: " + apcGear.ordinal(), 10, 10, 0xFFFF0000, false);
            }
        }
    }
}
