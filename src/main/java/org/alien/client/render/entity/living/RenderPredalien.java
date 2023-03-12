package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelPredalien;
import org.alien.common.entity.living.xenomorph.EntityPredalien;
import org.avp.AVP;

public class RenderPredalien extends RenderLivingWrapper<EntityPredalien, ModelPredalien>
{
    public RenderPredalien(RenderManager m)
    {
        super(m, AVP.resources().models().PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityPredalien living, float renderPartialTicks)
    {
        OpenGL.scale(0.75F, 0.75F, 0.75F);
    }
}
