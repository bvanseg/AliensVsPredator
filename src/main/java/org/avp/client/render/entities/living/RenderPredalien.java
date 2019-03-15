package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelPredalien;
import org.avp.entities.living.species.xenomorphs.EntityPredalien;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPredalien extends RenderLivingWrapper<EntityPredalien, ModelPredalien>
{
    public RenderPredalien(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityPredalien living, float renderPartialTicks)
    {
        OpenGL.scale(0.75F, 0.75F, 0.75F);
    }
}
