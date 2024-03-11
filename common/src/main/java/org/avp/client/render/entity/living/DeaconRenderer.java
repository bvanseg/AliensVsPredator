package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.DeaconModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Deacon;

/**
 * @author Boston Vanseghi
 */
public class DeaconRenderer extends MobRenderer<Deacon, DeaconModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("deacon");

    public DeaconRenderer(EntityRendererProvider.Context context) {
        super(context, new DeaconModel(context.bakeLayer(DeaconModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Deacon entity) {
        return TEXTURE;
    }
}
