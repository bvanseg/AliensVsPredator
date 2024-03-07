package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.FacehuggerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Facehugger;

/**
 * @author Boston Vanseghi
 */
public class FacehuggerRenderer extends MobRenderer<Facehugger, FacehuggerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("facehugger");

    public FacehuggerRenderer(EntityRendererProvider.Context context) {
        super(context, new FacehuggerModel(context.bakeLayer(FacehuggerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Facehugger entity) {
        return TEXTURE;
    }
}
