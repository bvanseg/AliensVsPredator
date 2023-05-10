package org.prometheus.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.render.entity.living.RenderXenomorph;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelBelugamorph;
import org.prometheus.common.entity.living.vardic.EntityBelugamorph;

public class RenderBelugamorph extends RenderXenomorph<EntityBelugamorph, ModelBelugamorph>
{
    public RenderBelugamorph(RenderManager m)
    {
        super(m, PrometheusResources.Models.BELUGAMORPH, 1F);
    }
}
