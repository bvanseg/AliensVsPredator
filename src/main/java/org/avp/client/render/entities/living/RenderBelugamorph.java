package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelBelugamorph;
import org.avp.common.entities.living.vardic.EntityBelugamorph;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBelugamorph extends RenderXenomorph<EntityBelugamorph, ModelBelugamorph>
{
    public RenderBelugamorph(RenderManager m)
    {
        super(m, AVP.resources().models().BELUGAMORPH, 1F);
    }
}
