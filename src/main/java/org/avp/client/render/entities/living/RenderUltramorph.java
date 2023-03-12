package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelUltramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityUltramorph;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderUltramorph extends RenderXenomorph<EntityUltramorph, ModelUltramorph>
{
    public RenderUltramorph(RenderManager m)
    {
        super(m, AVP.resources().models().ULTRAMORPH, 1.5F);
    }
}
