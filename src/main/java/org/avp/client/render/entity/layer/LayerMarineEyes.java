package org.avp.client.render.entity.layer;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import org.avp.client.Resources;
import org.avp.client.render.entity.living.RenderMarine;
import org.avp.common.entity.living.EntityMarine;

/**
 * @author Ri5ux
 */
public class LayerMarineEyes implements LayerRenderer<EntityMarine> {

    private final RenderMarine marineRenderer;

    public LayerMarineEyes(RenderMarine marineRenderer) {
        this.marineRenderer = marineRenderer;
    }

    @Override
    public void doRenderLayer(EntityMarine entityMarine, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        int eyeColor = entityMarine.getEyeColor();
        int r = (eyeColor >> 24) & 0xFF;
        int g = (eyeColor >> 16) & 0xFF;
        int b = (eyeColor >> 8) & 0xFF;
        OpenGL.color(r / 255F, g / 255F, b / 255F, 1F);
        this.marineRenderer.bindTexture(Resources.instance.models().MARINE_EYES.getTexture());
        this.marineRenderer.getMainModel().render(entityMarine, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        OpenGL.color(1F, 1F, 1F, 1F);
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}