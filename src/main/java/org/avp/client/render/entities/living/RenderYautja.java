package org.avp.client.render.entities.living;

import org.avp.client.render.LayerYautjaCloakStaticArc;
import org.avp.client.render.LayerYautjaCloakStaticOverlay;
import org.avp.entities.living.species.SpeciesYautja;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderYautja<T extends SpeciesYautja, MODEL extends Model> extends RenderLivingWrapper<T, MODEL> {
	
    public RenderYautja(RenderManager m, MapModelTexture<MODEL> texturedModel) {
        super(m, texturedModel);
        this.addLayer(new LayerYautjaCloakStaticOverlay(this));
        this.addLayer(new LayerYautjaCloakStaticArc());
    }
    
    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.enableBlend();
        GL11.glColor4f(1F, 1F, 1F, (1F - (entity.cloakProgress / (float)SpeciesYautja.MAX_CLOAK)) + 0.1001F);
    	super.doRender(entity, x, y, z, entityYaw, partialTicks);
        GL11.glColor4f(1F, 1F, 1F, 1F);
    	GlStateManager.disableBlend();
    }
}
