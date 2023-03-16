package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelChestburster;
import org.alien.common.entity.living.xenomorph.EntityChestburster;
import org.avp.client.Resources;

public class RenderChestburster extends RenderLivingWrapper<EntityChestburster, ModelChestburster>
{
    public RenderChestburster(RenderManager m)
    {
        super(m, Resources.instance.models().CHESTBUSTER);
    }

    @Override
    protected void preRenderCallback(EntityChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
