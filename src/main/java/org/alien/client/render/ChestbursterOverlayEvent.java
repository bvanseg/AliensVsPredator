package org.alien.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.client.AlienResources;
import org.alien.common.world.capability.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;

/**
 * @author Ri5ux
 */
public class ChestbursterOverlayEvent
{
    public static final ChestbursterOverlayEvent instance = new ChestbursterOverlayEvent();

    private ChestbursterOverlayEvent() {}

    @SubscribeEvent
    public void renderTickOverlay(Pre event)
    {
        if (ClientGame.instance.minecraft().player == null) return;
        if (event.getType() != RenderGameOverlayEvent.ElementType.HOTBAR) return;

        OrganismImpl organism = (OrganismImpl) ClientGame.instance.minecraft().player.getCapability(Provider.CAPABILITY, null);

        if (organism == null) return;
        if (!organism.hasEmbryo()) return;
        if (!ClientGame.instance.minecraft().player.isDead) return;
        if (organism.getEmbryo().getAge() < organism.getEmbryo().getGestationPeriod() - 80) return;

        Draw.drawOverlay(AlienResources.instance.BLUR_CHESTBURSTER_EMERGE, 1F, 0F, 0F, 1F);
    }
}
