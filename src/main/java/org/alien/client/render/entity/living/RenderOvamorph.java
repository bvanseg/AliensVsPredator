package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelOvamorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.avp.common.config.ModelConfig;

public class RenderOvamorph extends RenderLivingWrapper<EntityOvamorph, ModelOvamorph>
{
    public RenderOvamorph(RenderManager m)
    {
        super(m, AlienResources.Models.OVAMORPH);
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
        return ModelConfig.getInstance().isHalloweenEventEnabled() ? AlienResources.Models.OVAMORPH_JACKO.getTexture() :  this.model.getTexture();
    }
}
