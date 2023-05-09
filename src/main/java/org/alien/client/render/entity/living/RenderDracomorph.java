package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelDracomorph;
import org.alien.common.entity.living.xenomorph.exotic.EntityDracomorph;

public class RenderDracomorph extends RenderLivingWrapper<EntityDracomorph, ModelDracomorph>
{
    public RenderDracomorph(RenderManager m)
    {
        super(m, AlienResources.instance.models().DRACOMORPH);
    }

    @Override
    protected void preRenderCallback(EntityDracomorph entityliving, float renderPartialTicks)
    {
        float scale = 3.0F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
