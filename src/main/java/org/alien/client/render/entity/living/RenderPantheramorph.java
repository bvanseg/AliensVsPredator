package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelPantheramorph;
import org.alien.common.entity.living.xenomorphs.EntityPantheramorph;
import org.avp.AVP;

public class RenderPantheramorph extends RenderXenomorph<EntityPantheramorph, ModelPantheramorph>
{
    public RenderPantheramorph(RenderManager m)
    {
        super(m, AVP.resources().models().PANTHERAMORPH, 0.75F);
    }
}
