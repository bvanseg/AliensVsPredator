package org.alien.client.render;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.util.Game;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.world.capability.IOrganism.Organism;
import org.alien.common.world.capability.IOrganism.Provider;
import org.avp.AVP;

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
                        Draw.drawOverlay(AVP.resources().BLUR_CHESTBURSTER_EMERGE, 1F, 0F, 0F, 1F);
                    }
                }
            }
        }
    }
}
