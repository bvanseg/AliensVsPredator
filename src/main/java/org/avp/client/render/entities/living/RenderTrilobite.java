package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelTrilobite;
import org.avp.common.entities.living.species.species223ode.EntityTrilobite;

public class RenderTrilobite extends RenderLivingWrapper<EntityTrilobite, ModelTrilobite>
{
    public RenderTrilobite(RenderManager m)
    {
        super(m, AVP.resources().models().TRILOBITE);
    }

    @Override
    protected void preRenderCallback(EntityTrilobite trilobite, float partialTicks)
    {
        super.preRenderCallback(trilobite, shadowSize);
        float scale = 2.75F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, 0F, 0F);
    }
}
