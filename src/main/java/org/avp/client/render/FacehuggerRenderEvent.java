package org.avp.client.render;

import org.avp.AliensVsPredator;
import org.avp.entities.living.EntityFacehugger;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.entity.Entities;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FacehuggerRenderEvent
{
    public static final FacehuggerRenderEvent instance = new FacehuggerRenderEvent();

    @SubscribeEvent
    public void renderTickOverlay(RenderGameOverlayEvent event)
    {
        if (Game.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.AIR)
            {
                if (Game.minecraft().gameSettings.thirdPersonView == 0 && Entities.isRiding(Game.minecraft().player, EntityFacehugger.class))
                {
                    OpenGL.pushMatrix();
                    {
                        Draw.drawOverlay(AliensVsPredator.resources().BLUR_FACEHUGGER);
                    }
                    OpenGL.popMatrix();
                }
            }
        }
    }
    
    @SubscribeEvent
    public void entityRenderEvent(RenderLivingEvent.Pre event)
    {
        ;
    }

    @SubscribeEvent
    public void entityRenderEvent(RenderLivingEvent.Post event)
    {
        ;
    }
}
