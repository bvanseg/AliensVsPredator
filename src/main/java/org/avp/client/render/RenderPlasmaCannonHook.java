package org.avp.client.render;

import com.asx.mdx.client.ClientGame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.power.common.entity.EntityMedpod;
import org.predator.client.render.RenderPlayerPlasmaCannon;

/**
 * @author Ri5ux
 */
public class RenderPlasmaCannonHook {
    public static final RenderPlasmaCannonHook instance = new RenderPlasmaCannonHook();

    public static final RenderPlayerPlasmaCannon renderPlasmaCannon = new RenderPlayerPlasmaCannon();
    @SubscribeEvent
    public void update(TickEvent.ClientTickEvent event)
    {
        renderPlasmaCannon.update(event, ClientGame.instance.minecraft(), ClientGame.instance.minecraft().world);
    }

    @SubscribeEvent
    public void renderHand(RenderHandEvent event)
    {
        if (ClientGame.instance.minecraft().player.isSpectator()) return;
        renderPlasmaCannon.renderFirstPerson(event, event.getPartialTicks());
    }

    @SubscribeEvent
    public void entityRenderEventPre(RenderLivingEvent.Pre event)
    {
        if (event.getEntity() == null) return;

        if (event.getEntity() instanceof EntityPlayer && !((EntityPlayer)event.getEntity()).isSpectator())
        {
            renderPlasmaCannon.render(event, ClientGame.instance.partialTicks());
        }

        if (event.getEntity().getRidingEntity() instanceof EntityMedpod)
        {
            event.setCanceled(true);
            RenderLivingHook.instance.getRenderer().render(event.getEntity(), event.getRenderer(), event.getX(), event.getY(), event.getZ(), ClientGame.instance.partialTicks());
        }
    }

    @SubscribeEvent
    public void entityRenderEventPost(RenderLivingEvent.Post event)
    {
        if (event.getEntity() == null) return;

        if (event.getEntity() instanceof EntityPlayer && !((EntityPlayer)event.getEntity()).isSpectator())
        {
            renderPlasmaCannon.render(event, ClientGame.instance.partialTicks());
        }

        if (event.getEntity().getRidingEntity() instanceof EntityMedpod)
        {
            event.setCanceled(true);
        }
    }
}
