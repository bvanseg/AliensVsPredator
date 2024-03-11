package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.DeaconAdultModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.DeaconAdult;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class DeaconAdultRenderer extends MobRenderer<DeaconAdult, DeaconAdultModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("deacon_adult");

    public DeaconAdultRenderer(EntityRendererProvider.Context context) {
        super(context, new DeaconAdultModel(context.bakeLayer(DeaconAdultModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DeaconAdult entity) {
        return TEXTURE;
    }
}
