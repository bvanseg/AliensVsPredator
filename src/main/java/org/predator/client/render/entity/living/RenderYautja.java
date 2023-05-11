package org.predator.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.predator.client.render.layer.LayerYautjaCloakStaticArc;
import org.predator.client.render.layer.LayerYautjaCloakStaticOverlay;
import org.predator.common.entity.living.SpeciesYautja;
import org.predator.common.entity.living.helper.YautjaCloakHelper;
import org.predator.common.entity.state.CloakState;

public class RenderYautja<T extends SpeciesYautja, MODEL extends Model> extends RenderLivingWrapper<T, MODEL> {
	
    public RenderYautja(RenderManager m, MapModelTexture<MODEL> texturedModel) {
        super(m, texturedModel);
        this.addLayer(new LayerYautjaCloakStaticOverlay(this));
        this.addLayer(new LayerYautjaCloakStaticArc());
    }
    
    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        boolean isRenderableCloakState = entity.cloakState.get() != CloakState.DECLOAKED;

        if (isRenderableCloakState) {
            GlStateManager.alphaFunc(516, 0.003921569F);
            float transparency = 1F - (entity.cloakRenderProgress / (float) YautjaCloakHelper.MAX_CLOAK) + 0.05F;
            GlStateManager.color(1F, 1F, 1F, transparency);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        }

    	super.doRender(entity, x, y, z, entityYaw, partialTicks);

        if (isRenderableCloakState) {
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
            GlStateManager.alphaFunc(516, 0.1F);
        }
    }
}
