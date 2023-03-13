package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelBelugaburster;
import org.alien.common.entity.living.vardic.EntityBelugaburster;
import org.avp.AVP;

public class RenderBelugaburster extends RenderLivingWrapper<EntityBelugaburster, ModelBelugaburster>
{
    public RenderBelugaburster(RenderManager m)
    {
        super(m, AVP.resources().models().BELUGABURSTER);
    }

    @Override
    protected void preRenderCallback(EntityBelugaburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
