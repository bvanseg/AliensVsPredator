package org.covenant.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.covenant.client.model.entity.living.ModelPaintedMink;
import org.covenant.client.render.layer.LayerPaintedMinkEyes;
import org.covenant.client.CovenantResources;
import org.covenant.common.entity.living.EntityPaintedMink;
import org.avp.AVP;

/**
 * @author Boston Vanseghi
 */
public class RenderPaintedMink extends RenderLivingWrapper<EntityPaintedMink, ModelPaintedMink> {
    private static final ResourceLocation[] skins = new ResourceLocation[] {
        new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/painted_mink_1.png"),
        new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/painted_mink_2.png"),
        new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/painted_mink_3.png"),
        new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/painted_mink_4.png")
    };

    public RenderPaintedMink(RenderManager m) {
        super(m, CovenantResources.Models.PAINTED_MINK);
        this.addLayer(new LayerPaintedMinkEyes(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPaintedMink entity) {
        return skins[entity.getVariant()];
    }
}
