package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.FacehuggerRoyalModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.FacehuggerRoyal;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class FacehuggerRoyalRenderer extends MobRenderer<FacehuggerRoyal, FacehuggerRoyalModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("facehugger_royal");


    public FacehuggerRoyalRenderer(EntityRendererProvider.Context context) {
        super(context, new FacehuggerRoyalModel(context.bakeLayer(FacehuggerRoyalModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FacehuggerRoyal entity) {
        return TEXTURE;
    }
}
