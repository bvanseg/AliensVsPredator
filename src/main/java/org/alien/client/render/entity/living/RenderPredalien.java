package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelPredalien;
import org.alien.common.entity.living.xenomorph.EntityPredalien;

public class RenderPredalien extends RenderLivingWrapper<EntityPredalien, ModelPredalien>
{
    public RenderPredalien(RenderManager m)
    {
        super(m, AlienResources.Models.PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityPredalien living, float renderPartialTicks)
    {
        OpenGL.scale(0.75F, 0.75F, 0.75F);
    }
}
