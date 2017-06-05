package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelRoyalFacehugger;
import org.avp.entities.living.EntityFacehugger;
import org.avp.entities.living.EntityRoyalFacehugger;

import com.arisux.mdx.lib.client.render.OpenGL;

public class RenderRoyalFacehugger extends RenderFacehugger<EntityRoyalFacehugger, ModelRoyalFacehugger>
{
    public RenderRoyalFacehugger()
    {
        super(AliensVsPredator.resources().models().ROYALFACEHUGGER);
    }

    @Override
    protected void preRenderCallback(EntityRoyalFacehugger facehugger, float partialTicks)
    {
        super.preRenderCallback(facehugger, partialTicks);

        float glScale = 1.5F;
        OpenGL.scale(glScale, glScale, glScale);

        if (facehugger instanceof EntityFacehugger)
        {
            if (!((EntityFacehugger) facehugger).isFertile())
            {
                OpenGL.translate(0, 0.1, 0);
            }
        }
    }

    @Override
    protected void scale(EntityRoyalFacehugger facehugger, float glScale)
    {
        super.scale(facehugger, glScale);
    }
}
