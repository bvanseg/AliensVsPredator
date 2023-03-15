package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelVardaMonkey;
import org.alien.common.entity.living.vardic.EntityScelemur;
import org.avp.client.Resources;

public class RenderScelemur extends RenderLivingWrapper<EntityScelemur, ModelVardaMonkey>
{
    public RenderScelemur(RenderManager m)
    {
        super(m, Resources.instance.models().VARDA_MONKEY);
    }

    @Override
    protected void preRenderCallback(EntityScelemur entityliving, float renderPartialTicks)
    {
        float scale = 1F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
