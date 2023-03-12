package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelChestburster;
import org.alien.common.entity.living.xenomorphs.EntityChestburster;

public class RenderChestburster extends RenderLivingWrapper<EntityChestburster, ModelChestburster>
{
    public RenderChestburster(RenderManager m)
    {
        super(m, AVP.resources().models().CHESTBUSTER);
    }

    @Override
    protected void preRenderCallback(EntityChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
