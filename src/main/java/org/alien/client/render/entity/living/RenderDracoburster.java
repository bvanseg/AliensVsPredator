package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelDracoburster;
import org.alien.common.entity.living.xenomorph.EntityDracoburster;
import org.avp.client.Resources;

public class RenderDracoburster extends RenderLivingWrapper<EntityDracoburster, ModelDracoburster>
{
    public RenderDracoburster(RenderManager m)
    {
        super(m, Resources.instance.models().DRACOBURSTER);
    }

    @Override
    protected void preRenderCallback(EntityDracoburster entityliving, float renderPartialTicks)
    {
        float scale = 0.75F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
