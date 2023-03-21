package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelChestbursterQueen;
import org.alien.client.render.util.AlienGrowthUtil;
import org.alien.common.entity.living.xenomorph.EntityQueenChestburster;
import org.avp.client.Resources;

public class RenderQueenChestburster extends RenderLivingWrapper<EntityQueenChestburster, ModelChestbursterQueen>
{
    public RenderQueenChestburster(RenderManager m)
    {
        super(m, Resources.instance.models().CHESTBUSTER_QUEEN);
    }

    @Override
    protected void preRenderCallback(EntityQueenChestburster entitylivingBase, float partialTicks)
    {
        float additionalScale = AlienGrowthUtil.calculateJellyGrowthFactor(entitylivingBase, 0.005f, 3, partialTicks);
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F + additionalScale, 0.55F + additionalScale, 0.55F + additionalScale);
    }
}
