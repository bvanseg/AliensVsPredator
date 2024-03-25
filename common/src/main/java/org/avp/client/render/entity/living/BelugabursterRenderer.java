package org.avp.client.render.entity.living;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.avp.client.model.entity.living.BelugabursterModel;
import org.avp.common.entity.living.Belugaburster;

/**
 * @author Boston Vanseghi
 */
public class BelugabursterRenderer extends GeoEntityRenderer<Belugaburster> {

    public BelugabursterRenderer(EntityRendererProvider.Context context) {
        super(context, new BelugabursterModel());
    }
}
