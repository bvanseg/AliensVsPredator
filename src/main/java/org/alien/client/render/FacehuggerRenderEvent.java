package org.alien.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.avp.client.Resources;

public class FacehuggerRenderEvent
{
    public static final FacehuggerRenderEvent instance = new FacehuggerRenderEvent();

    @SubscribeEvent
    public void renderTickOverlay(RenderGameOverlayEvent event)
    {
        if (ClientGame.instance.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.AIR)
            {
                if (ClientGame.instance.minecraft().gameSettings.thirdPersonView == 0 && Entities.isRiding(ClientGame.instance.minecraft().player, EntityFacehugger.class))
                {
                    OpenGL.pushMatrix();
                    {
                        Draw.drawOverlay(Resources.instance.BLUR_FACEHUGGER);
                    }
                    OpenGL.popMatrix();
                }
            }
        }
    }
}
