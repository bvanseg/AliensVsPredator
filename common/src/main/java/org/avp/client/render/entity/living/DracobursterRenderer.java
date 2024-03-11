package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.DracobursterModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Dracoburster;

/**
 * @author Boston Vanseghi
 */
public class DracobursterRenderer extends MobRenderer<Dracoburster, DracobursterModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("dracoburster");

    public DracobursterRenderer(EntityRendererProvider.Context context) {
        super(context, new DracobursterModel(context.bakeLayer(DracobursterModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Dracoburster entity) {
        return TEXTURE;
    }
}
