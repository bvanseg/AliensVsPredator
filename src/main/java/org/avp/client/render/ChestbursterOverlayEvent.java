package org.avp.client.render;

import org.avp.AliensVsPredator;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.arisux.mdxlib.lib.client.render.Draw;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChestbursterOverlayEvent
{
    public static final ChestbursterOverlayEvent instance = new ChestbursterOverlayEvent();

    @SubscribeEvent
    public void renderTickOverlay(Pre event)
    {
        if (Game.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR)
            {
                Organism organism = (Organism) Game.minecraft().player.getCapability(Provider.CAPABILITY, null);

                if (organism.hasEmbryo())
                {
                    if (organism.hasEmbryo() && Game.minecraft().player.isDead && organism.getEmbryo().getAge() >= organism.getEmbryo().getGestationPeriod() - 80)
                    {
                        Draw.drawOverlay(AliensVsPredator.resources().BLUR_CHESTBURSTER_EMERGE, 1F, 0F, 0F, 1F);
                    }
                }
            }
        }
    }
}
