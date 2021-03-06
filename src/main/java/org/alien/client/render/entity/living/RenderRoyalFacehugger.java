package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelRoyalFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;

public class RenderRoyalFacehugger extends RenderFacehuggers<EntityRoyalFacehugger, ModelRoyalFacehugger>
{
    public RenderRoyalFacehugger(RenderManager m)
    {
        super(m, AlienResources.Models.ROYALFACEHUGGER);
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
