package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelUltramorph;
import org.alien.common.entity.living.xenomorphs.EntityUltramorph;

public class RenderUltramorph extends RenderXenomorph<EntityUltramorph, ModelUltramorph>
{
    public RenderUltramorph(RenderManager m)
    {
        super(m, AVP.resources().models().ULTRAMORPH, 1.5F);
    }
}
