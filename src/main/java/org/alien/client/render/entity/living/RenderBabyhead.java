package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelBabyhead;
import org.alien.common.entity.living.vardic.EntityBabyhead;

public class RenderBabyhead extends RenderLivingWrapper<EntityBabyhead, ModelBabyhead>
{
    public RenderBabyhead(RenderManager m)
    {
        super(m, AlienResources.instance.models().BABYHEAD);
    }

    @Override
    protected void preRenderCallback(EntityBabyhead entityliving, float renderPartialTicks)
    {
        float scale = 1.25F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
