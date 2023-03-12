package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelRoyalFacehugger;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityRoyalFacehugger;

public class RenderRoyalFacehugger extends RenderFacehuggers<EntityRoyalFacehugger, ModelRoyalFacehugger>
{
    public RenderRoyalFacehugger(RenderManager m)
    {
        super(m, AVP.resources().models().ROYALFACEHUGGER);
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
