package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelChestbursterPredalien;
import org.alien.client.render.util.AlienGrowthUtil;
import org.alien.common.entity.living.xenomorph.burster.EntityPredalienChestburster;

public class RenderPredalienChestburster extends RenderLivingWrapper<EntityPredalienChestburster, ModelChestbursterPredalien>
{
    public RenderPredalienChestburster(RenderManager m)
    {
        super(m, AlienResources.Models.CHESTBUSTER_PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityPredalienChestburster entitylivingBase, float partialTicks)
    {
        float additionalScale = AlienGrowthUtil.calculateJellyGrowthFactor(entitylivingBase, 0.005f, 3, partialTicks);
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F + additionalScale, 0.55F + additionalScale, 0.55F + additionalScale);
    }
}
