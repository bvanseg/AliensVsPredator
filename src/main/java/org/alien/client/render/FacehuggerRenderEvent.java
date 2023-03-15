package org.alien.client.render;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.Entities;
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
        if (Game.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.AIR)
            {
                if (Game.minecraft().gameSettings.thirdPersonView == 0 && Entities.isRiding(Game.minecraft().player, EntityFacehugger.class))
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
