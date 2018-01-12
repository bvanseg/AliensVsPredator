package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelChestbursterQueen;
import org.avp.entities.living.EntityQueenChestburster;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderQueenChestburster extends RenderLivingWrapper<EntityQueenChestburster, ModelChestbursterQueen>
{
    public RenderQueenChestburster(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().CHESTBUSTER_QUEEN);
    }

    @Override
    protected void preRenderCallback(EntityQueenChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
