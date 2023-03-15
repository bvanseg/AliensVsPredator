package org.predator.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.client.Resources;
import org.predator.client.model.entity.living.ModelYautja;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;

public class RenderYautjaBerserker extends RenderYautja<EntityYautjaBerserker, ModelYautja>
{
    public RenderYautjaBerserker(RenderManager m)
    {
        super(m, Resources.instance.models().YAUTJA_BERSERKER);
    }
}
