package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.DeaconAdultEngineerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.DeaconAdultEngineer;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class DeaconAdultEngineerRenderer extends MobRenderer<DeaconAdultEngineer, DeaconAdultEngineerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("deacon_adult_engineer");

    public DeaconAdultEngineerRenderer(EntityRendererProvider.Context context) {
        super(context, new DeaconAdultEngineerModel(context.bakeLayer(DeaconAdultEngineerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DeaconAdultEngineer entity) {
        return TEXTURE;
    }
}
