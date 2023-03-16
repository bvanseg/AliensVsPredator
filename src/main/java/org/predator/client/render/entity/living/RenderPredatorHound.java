package org.predator.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.client.Resources;
import org.predator.client.model.entity.living.ModelPredatorHound;
import org.predator.common.entity.living.EntityPredatorHound;

public class RenderPredatorHound extends RenderLivingWrapper<EntityPredatorHound, ModelPredatorHound>
{
    public RenderPredatorHound(RenderManager m)
    {
        super(m, Resources.instance.models().PREDATOR_HOUND);
    }

    @Override
    protected void preRenderCallback(EntityPredatorHound entityliving, float renderPartialTicks)
    {
        float scale = 1.5F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
