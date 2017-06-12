package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelUltramorph;
import org.avp.entities.living.EntityUltramorph;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderUltramorph extends RenderXenomorph<EntityUltramorph, ModelUltramorph>
{
    public RenderUltramorph(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().ULTRAMORPH, 1.5F);
    }
}
