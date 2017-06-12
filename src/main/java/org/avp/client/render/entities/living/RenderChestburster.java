package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelChestburster;
import org.avp.entities.living.EntityChestburster;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderChestburster extends RenderLivingWrapper<EntityChestburster, ModelChestburster>
{
    public RenderChestburster(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().CHESTBUSTER);
    }

    @Override
    protected void preRenderCallback(EntityChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
