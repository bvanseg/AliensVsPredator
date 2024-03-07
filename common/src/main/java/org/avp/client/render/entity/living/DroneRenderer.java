package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.DroneModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Drone;

/**
 * @author Boston Vanseghi
 */
public class DroneRenderer extends MobRenderer<Drone, DroneModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("drone");

    public DroneRenderer(EntityRendererProvider.Context context) {
        super(context, new DroneModel(context.bakeLayer(DroneModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Drone entity) {
        return TEXTURE;
    }
}
