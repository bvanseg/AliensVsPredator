package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.model.entity.living.ModelOvamorphGiger;
import org.alien.common.entity.living.xenomorph.EntityOvamorphGiger;
import org.avp.AVP;

public class RenderOvamorphGiger extends RenderLivingWrapper<EntityOvamorphGiger, ModelOvamorphGiger>
{
    public RenderOvamorphGiger(RenderManager m)
    {
        super(m, AVP.resources().models().OVAMORPH_GIGER);
    }

    @Override
    protected void preRenderCallback(EntityOvamorphGiger ovamorph, float partialTicks)
    {
        super.preRenderCallback(ovamorph, partialTicks);
        OpenGL.scale(1.0F, 1.0F, 1.0F);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityOvamorphGiger ovamorph)
    {
        return this.model.getTexture();
    }
}
