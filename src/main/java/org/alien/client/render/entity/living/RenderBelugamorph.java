package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelBelugamorph;
import org.alien.common.entity.living.vardic.EntityBelugamorph;

public class RenderBelugamorph extends RenderXenomorph<EntityBelugamorph, ModelBelugamorph>
{
    public RenderBelugamorph(RenderManager m)
    {
        super(m, AlienResources.instance.models().BELUGAMORPH, 1F);
    }
}
