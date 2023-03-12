package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelPantheramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityPantheramorph;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPantheramorph extends RenderXenomorph<EntityPantheramorph, ModelPantheramorph>
{
    public RenderPantheramorph(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().PANTHERAMORPH, 0.75F);
    }
}
