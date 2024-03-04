package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.EngineerModel;
import org.avp.client.render.entity.living.layer.EngineerSuitLayer;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Engineer;

/**
 * @author Boston Vanseghi
 */
public class EngineerRenderer extends MobRenderer<Engineer, EngineerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("engineer");

    public EngineerRenderer(EntityRendererProvider.Context context) {
        super(context, new EngineerModel(context.bakeLayer(EngineerModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new EngineerSuitLayer(this, context.getModelSet()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Engineer entity) {
        return TEXTURE;
    }
}
