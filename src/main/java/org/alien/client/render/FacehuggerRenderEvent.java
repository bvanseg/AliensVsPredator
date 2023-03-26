package org.alien.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.client.AlienResources;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;

public class FacehuggerRenderEvent
{
    public static final FacehuggerRenderEvent instance = new FacehuggerRenderEvent();

    @SubscribeEvent
    public void renderTickOverlay(RenderGameOverlayEvent event)
    {
        if (ClientGame.instance.minecraft().player == null) return;
        if (event.getType() != RenderGameOverlayEvent.ElementType.AIR) return;
        if (ClientGame.instance.minecraft().gameSettings.thirdPersonView != 0) return;
        if (!Entities.isRiding(ClientGame.instance.minecraft().player, EntityFacehugger.class)) return;

        OpenGL.pushMatrix();
        Draw.drawOverlay(AlienResources.instance.BLUR_FACEHUGGER);
        OpenGL.popMatrix();
    }
}
