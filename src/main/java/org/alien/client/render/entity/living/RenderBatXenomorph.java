package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelBatXenomorph;
import org.alien.common.entity.living.xenomorph.exotic.EntityBatXeno;

public class RenderBatXenomorph extends RenderXenomorph<EntityBatXeno, ModelBatXenomorph>
{
    public RenderBatXenomorph(RenderManager m)
    {
        super(m, AlienResources.instance.models().BAT_XENO, 0.75F);
    }
}
