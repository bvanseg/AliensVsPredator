package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.model.entity.living.ModelOvamorph;
import org.alien.common.entity.living.xenomorphs.EntityOvamorph;
import org.avp.AVP;

public class RenderOvamorph extends RenderLivingWrapper<EntityOvamorph, ModelOvamorph>
{
    public RenderOvamorph(RenderManager m)
    {
        super(m, AVP.resources().models().OVAMORPH);
    }

    @Override
    protected void preRenderCallback(EntityOvamorph ovamorph, float partialTicks)
    {
        super.preRenderCallback(ovamorph, partialTicks);
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityOvamorph ovamorph)
    {
        return AVP.settings().isHalloweenEventEnabled() ? AVP.resources().models().OVAMORPH_JACKO.getTexture() :  this.model.getTexture();
    }
}
