package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.DroneRunnerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.DroneRunner;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class DroneRunnerRenderer extends MobRenderer<DroneRunner, DroneRunnerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("drone_runner");

    public DroneRunnerRenderer(EntityRendererProvider.Context context) {
        super(context, new DroneRunnerModel(context.bakeLayer(DroneRunnerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DroneRunner entity) {
        return TEXTURE;
    }
}
