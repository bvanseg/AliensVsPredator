package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelUltramorph;
import org.alien.common.entity.living.xenomorph.EntityUltramorph;
import org.avp.AVP;

public class RenderUltramorph extends RenderXenomorph<EntityUltramorph, ModelUltramorph>
{
    public RenderUltramorph(RenderManager m)
    {
        super(m, AVP.resources().models().ULTRAMORPH, 1.5F);
    }
}
