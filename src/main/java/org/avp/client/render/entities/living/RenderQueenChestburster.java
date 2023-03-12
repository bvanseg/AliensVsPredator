package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelChestbursterQueen;
import org.alien.common.entity.living.xenomorphs.EntityQueenChestburster;

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
