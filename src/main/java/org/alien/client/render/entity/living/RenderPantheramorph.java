package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelPantheramorph;
import org.alien.common.entity.living.xenomorph.exotic.EntityPantheramorph;

public class RenderPantheramorph extends RenderXenomorph<EntityPantheramorph, ModelPantheramorph>
{
    public RenderPantheramorph(RenderManager m)
    {
        super(m, AlienResources.Models.PANTHERAMORPH, 0.75F);
    }
}
