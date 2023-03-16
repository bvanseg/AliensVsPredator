package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelHammerpede;
import org.alien.common.entity.living.vardic.EntityHammerpede;
import org.avp.client.Resources;

public class RenderHammerpede extends RenderLivingWrapper<EntityHammerpede, ModelHammerpede>
{
    public RenderHammerpede(RenderManager m)
    {
        super(m, Resources.instance.models().HAMMERPEDE);
    }

    @Override
    protected void preRenderCallback(EntityHammerpede entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.65F, 0.65F, 0.65F);
    }
}
