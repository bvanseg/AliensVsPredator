package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelChestbursterPredalien;
import org.alien.common.entity.living.xenomorphs.EntityPredalienChestburster;
import org.avp.AVP;

public class RenderPredalienChestburster extends RenderLivingWrapper<EntityPredalienChestburster, ModelChestbursterPredalien>
{
    public RenderPredalienChestburster(RenderManager m)
    {
        super(m, AVP.resources().models().CHESTBUSTER_PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityPredalienChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
