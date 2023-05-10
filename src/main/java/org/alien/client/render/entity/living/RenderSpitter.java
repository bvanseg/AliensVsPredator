package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelSpitter;
import org.alien.common.entity.living.xenomorph.exotic.EntitySpitter;

public class RenderSpitter extends RenderLivingWrapper<EntitySpitter, ModelSpitter>
{
    public RenderSpitter(RenderManager m)
    {
        super(m, AlienResources.Models.SPITTER);
//        this.setRenderPassModel(this.getModel().getModel());
    }

    @Override
    protected void preRenderCallback(EntitySpitter entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.translate(0F, 0.315F, -0.7F);
    }
}
