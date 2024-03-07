package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.PraetorianModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Praetorian;

/**
 * @author Boston Vanseghi
 */
public class PraetorianRenderer extends MobRenderer<Praetorian, PraetorianModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("praetorian");

    public PraetorianRenderer(EntityRendererProvider.Context context) {
        super(context, new PraetorianModel(context.bakeLayer(PraetorianModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Praetorian entity) {
        return TEXTURE;
    }
}
