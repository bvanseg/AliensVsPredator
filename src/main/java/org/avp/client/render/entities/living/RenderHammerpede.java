package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelHammerpede;
import org.avp.entities.living.EntityHammerpede;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderHammerpede extends RenderLivingWrapper<EntityHammerpede, ModelHammerpede>
{
    public RenderHammerpede(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().HAMMERPEDE);
    }

    @Override
    protected void preRenderCallback(EntityHammerpede entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.65F, 0.65F, 0.65F);
    }
}
