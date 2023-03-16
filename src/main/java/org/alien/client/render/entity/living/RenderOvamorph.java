package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.model.entity.living.ModelOvamorph;
import org.alien.common.entity.living.xenomorph.EntityOvamorph;
import org.avp.client.Resources;
import org.avp.common.AVPSettings;

public class RenderOvamorph extends RenderLivingWrapper<EntityOvamorph, ModelOvamorph>
{
    public RenderOvamorph(RenderManager m)
    {
        super(m, Resources.instance.models().OVAMORPH);
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
        return AVPSettings.instance.isHalloweenEventEnabled() ? Resources.instance.models().OVAMORPH_JACKO.getTexture() :  this.model.getTexture();
    }
}
