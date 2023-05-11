package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.math.MathHelper;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelMatriarch;
import org.alien.client.render.util.AlienGrowthUtil;
import org.alien.common.entity.living.xenomorph.EntityMatriarch;

public class RenderMatriarch extends RenderLivingWrapper<EntityMatriarch, ModelMatriarch>
{
    public RenderMatriarch(RenderManager m)
    {
        super(m, AlienResources.Models.MATRIARCH);
    }

    @Override
    protected void preRenderCallback(EntityMatriarch matriarch, float partialTicks)
    {
        float jellyLevelPrev = matriarch.growthProgress;
        matriarch.growthProgress = matriarch.jellyLevel.get();
        matriarch.growthProgress = jellyLevelPrev + ((matriarch.growthProgress - jellyLevelPrev) * partialTicks * 0.005f);

        float additionalScale = MathHelper.clamp(matriarch.growthProgress / (AlienGrowthUtil.MATRIARCH_MAX_PSEUDO_JELLY_LEVEL * 2), 0F, 1F);

        OpenGL.scale(1.75F + additionalScale, 1.75F + additionalScale, 1.75F + additionalScale);
    }
}
