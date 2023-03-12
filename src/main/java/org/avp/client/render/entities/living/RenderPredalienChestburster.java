package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelChestbursterPredalien;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalienChestburster;

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
