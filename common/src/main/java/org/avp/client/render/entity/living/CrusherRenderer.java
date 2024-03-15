package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.CrusherModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Crusher;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class CrusherRenderer extends MobRenderer<Crusher, CrusherModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("crusher");

    public CrusherRenderer(EntityRendererProvider.Context context) {
        super(context, new CrusherModel(context.bakeLayer(CrusherModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Crusher entity) {
        return TEXTURE;
    }
}
