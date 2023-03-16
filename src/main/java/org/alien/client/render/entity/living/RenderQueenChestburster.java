package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelChestbursterQueen;
import org.alien.common.entity.living.xenomorph.EntityQueenChestburster;
import org.avp.AVP;

public class RenderQueenChestburster extends RenderLivingWrapper<EntityQueenChestburster, ModelChestbursterQueen>
{
    public RenderQueenChestburster(RenderManager m)
    {
        super(m, AVP.resources().models().CHESTBUSTER_QUEEN);
    }

    @Override
    protected void preRenderCallback(EntityQueenChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
