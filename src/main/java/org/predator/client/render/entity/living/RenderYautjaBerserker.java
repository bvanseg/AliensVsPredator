package org.predator.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.predator.client.model.entity.living.ModelYautja;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;

public class RenderYautjaBerserker extends RenderYautja<EntityYautjaBerserker, ModelYautja>
{
    public RenderYautjaBerserker(RenderManager m)
    {
        super(m, AVP.resources().models().YAUTJA_BERSERKER);
    }

    @Override
    protected void preRenderCallback(EntityYautjaBerserker entityliving, float renderPartialTicks)
    {
        ;
    }
}
