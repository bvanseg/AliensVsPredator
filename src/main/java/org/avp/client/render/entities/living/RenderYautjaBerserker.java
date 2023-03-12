package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelYautja;
import org.avp.common.entities.living.species.yautja.EntityYautjaBerserker;

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
