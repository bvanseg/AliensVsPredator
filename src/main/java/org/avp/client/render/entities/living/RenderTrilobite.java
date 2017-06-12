package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelTrilobite;
import org.avp.entities.living.EntityTrilobite;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderTrilobite extends RenderLivingWrapper<EntityTrilobite, ModelTrilobite>
{
    public RenderTrilobite(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().TRILOBITE);
    }

    @Override
    protected void preRenderCallback(EntityTrilobite trilobite, float partialTicks)
    {
        super.preRenderCallback(trilobite, shadowSize);
        float scale = 1.7F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(-0.2F, 0F, 0F);
    }
}
