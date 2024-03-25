package org.avp.client.render.entity.living;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import org.avp.client.model.entity.living.DeaconModel;
import org.avp.common.entity.living.Deacon;

/**
 * @author Boston Vanseghi
 */
public class DeaconRenderer extends GeoEntityRenderer<Deacon> {

    public DeaconRenderer(EntityRendererProvider.Context context) {
        super(context, new DeaconModel());
    }
}
