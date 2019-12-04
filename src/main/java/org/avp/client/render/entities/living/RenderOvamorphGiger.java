package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelOvamorphGiger;
import org.avp.entities.living.species.xenomorphs.EntityOvamorphGiger;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderOvamorphGiger extends RenderLivingWrapper<EntityOvamorphGiger, ModelOvamorphGiger>
{
    public RenderOvamorphGiger(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().OVAMORPH_GIGER);
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
