package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelDracomorph;
import org.alien.common.entity.living.xenomorph.EntityDracomorph;
import org.avp.client.Resources;

public class RenderDracomorph extends RenderLivingWrapper<EntityDracomorph, ModelDracomorph>
{
    public RenderDracomorph(RenderManager m)
    {
        super(m, Resources.instance.models().DRACOMORPH);
    }

    @Override
    protected void preRenderCallback(EntityDracomorph entityliving, float renderPartialTicks)
    {
        float scale = 3.0F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
