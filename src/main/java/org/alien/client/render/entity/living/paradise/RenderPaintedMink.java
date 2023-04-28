package org.alien.client.render.entity.living.paradise;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.paradise.ModelPaintedMink;
import org.alien.client.render.layer.LayerPaintedMinkEyes;
import org.alien.common.entity.living.paradise.EntityPaintedMink;
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
        super(m, AlienResources.instance.models().PAINTED_MINK);
        this.addLayer(new LayerPaintedMinkEyes(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPaintedMink entity) {
        return skins[entity.getVariant()];
    }
}
