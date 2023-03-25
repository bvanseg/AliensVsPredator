package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelUrsuidae;
import org.alien.common.entity.living.vardic.EntityUrsuidae;

public class RenderUrsuidae extends RenderLivingWrapper<EntityUrsuidae, ModelUrsuidae>
{
    public RenderUrsuidae(RenderManager m)
    {
        super(m, AlienResources.instance.models().URSUIDAE);
    }

    @Override
    protected void preRenderCallback(EntityUrsuidae entityliving, float renderPartialTicks)
    {
        float scale = 2.0F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
