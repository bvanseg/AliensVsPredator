package org.avp.client.render.entity.living;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import org.avp.client.model.entity.living.DeaconAdultEngineerModel;
import org.avp.common.entity.living.DeaconAdultEngineer;

/**
 * @author Boston Vanseghi
 */
public class DeaconAdultEngineerRenderer extends GeoEntityRenderer<DeaconAdultEngineer> {

    public DeaconAdultEngineerRenderer(EntityRendererProvider.Context context) {
        super(context, new DeaconAdultEngineerModel());
    }
}
