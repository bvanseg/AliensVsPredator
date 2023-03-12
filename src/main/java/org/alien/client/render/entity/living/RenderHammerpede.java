package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelHammerpede;
import org.alien.common.entity.living.vardic.EntityHammerpede;
import org.avp.AVP;

public class RenderHammerpede extends RenderLivingWrapper<EntityHammerpede, ModelHammerpede>
{
    public RenderHammerpede(RenderManager m)
    {
        super(m, AVP.resources().models().HAMMERPEDE);
    }

    @Override
    protected void preRenderCallback(EntityHammerpede entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.65F, 0.65F, 0.65F);
    }
}
