package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelCrusherQuad;
import org.alien.common.entity.living.xenomorph.EntityCrusher;

public class RenderCrusher extends RenderXenomorph<EntityCrusher, ModelCrusherQuad>
{
    public RenderCrusher(RenderManager m)
    {
        super(m, AlienResources.instance.models().CRUSHER_QUAD, 1.6F);
    }

    @Override
    protected void preRenderCallback(EntityCrusher entityCrusher, float renderPartialTicks) {
        super.preRenderCallback(entityCrusher, renderPartialTicks);
        GlStateManager.translate(0F, 0F, -0.2F);
    }
}
