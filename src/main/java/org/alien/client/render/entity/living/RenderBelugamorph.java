package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelBelugamorph;
import org.alien.common.entity.living.vardic.EntityBelugamorph;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderBelugamorph extends RenderXenomorph<EntityBelugamorph, ModelBelugamorph>
{
    public RenderBelugamorph(RenderManager m)
    {
        super(m, Resources.instance.models().BELUGAMORPH, 1F);
    }
}
