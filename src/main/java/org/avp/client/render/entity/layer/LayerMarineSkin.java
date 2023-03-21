package org.avp.client.render.entity.layer;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import org.avp.client.Resources;
import org.avp.client.render.entity.living.RenderMarine;
import org.avp.common.entity.living.EntityMarine;

/**
 * @author Ri5ux
 */
public class LayerMarineSkin implements LayerRenderer<EntityMarine> {

    private final RenderMarine marineRenderer;

    public LayerMarineSkin(RenderMarine marineRenderer) {
        this.marineRenderer = marineRenderer;
    }

    @Override
    public void doRenderLayer(EntityMarine entityMarine, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        int skinTone = entityMarine.getSkinTone();
        int r = (skinTone >> 24) & 0xFF;
        int g = (skinTone >> 16) & 0xFF;
        int b = (skinTone >> 8) & 0xFF;
        OpenGL.color(r / 255F, g / 255F, b / 255F, 1F);
        this.marineRenderer.bindTexture(Resources.instance.models().MARINE_SKIN.getTexture());
        this.marineRenderer.getMainModel().render(entityMarine, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        OpenGL.color(1F, 1F, 1F, 1F);
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}