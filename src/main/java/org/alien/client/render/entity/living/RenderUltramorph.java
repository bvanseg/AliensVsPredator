package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelUltramorph;
import org.alien.common.entity.living.xenomorph.EntityUltramorph;
import org.avp.client.Resources;

public class RenderUltramorph extends RenderXenomorph<EntityUltramorph, ModelUltramorph>
{
    public RenderUltramorph(RenderManager m)
    {
        super(m, Resources.instance.models().ULTRAMORPH, 1.5F);
    }
}
