package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelPantheramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityPantheramorph;

public class RenderPantheramorph extends RenderXenomorph<EntityPantheramorph, ModelPantheramorph>
{
    public RenderPantheramorph(RenderManager m)
    {
        super(m, AVP.resources().models().PANTHERAMORPH, 0.75F);
    }
}
