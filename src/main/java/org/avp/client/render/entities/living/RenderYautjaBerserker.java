package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelYautja;
import org.avp.entities.living.EntityYautjaBerserker;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderYautjaBerserker extends RenderYautja<EntityYautjaBerserker, ModelYautja>
{
    public RenderYautjaBerserker(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().YAUTJA_BERSERKER);
    }

    @Override
    protected void preRenderCallback(EntityYautjaBerserker entityliving, float renderPartialTicks)
    {
        ;
    }
}
