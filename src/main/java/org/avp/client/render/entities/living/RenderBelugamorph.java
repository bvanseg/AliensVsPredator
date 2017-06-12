package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelBelugamorph;
import org.avp.entities.living.EntityBelugamorph;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBelugamorph extends RenderXenomorph<EntityBelugamorph, ModelBelugamorph>
{
    public RenderBelugamorph(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().BELUGAMORPH, 1F);
    }
}
