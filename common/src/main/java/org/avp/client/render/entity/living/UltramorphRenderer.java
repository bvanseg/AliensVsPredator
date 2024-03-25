package org.avp.client.render.entity.living;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.avp.client.model.entity.living.UltramorphModel;
import org.avp.common.entity.living.Ultramorph;

/**
 * @author Boston Vanseghi
 */
public class UltramorphRenderer extends GeoEntityRenderer<Ultramorph> {

    public UltramorphRenderer(EntityRendererProvider.Context context) {
        super(context, new UltramorphModel());
    }
}
