package org.avp.client.render.entity.living;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import org.avp.client.model.entity.living.DroneModel;
import org.avp.common.entity.living.Drone;

/**
 * @author Boston Vanseghi
 */
public class DroneRenderer extends GeoEntityRenderer<Drone> {

    public DroneRenderer(EntityRendererProvider.Context context) {
        super(context, new DroneModel());
    }
}
