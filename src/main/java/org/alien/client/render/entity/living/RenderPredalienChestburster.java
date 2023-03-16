package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelChestbursterPredalien;
import org.alien.common.entity.living.xenomorph.EntityPredalienChestburster;
import org.avp.client.Resources;

public class RenderPredalienChestburster extends RenderLivingWrapper<EntityPredalienChestburster, ModelChestbursterPredalien>
{
    public RenderPredalienChestburster(RenderManager m)
    {
        super(m, Resources.instance.models().CHESTBUSTER_PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityPredalienChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
