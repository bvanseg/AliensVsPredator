package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.OctohuggerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Octohugger;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class OctohuggerRenderer extends MobRenderer<Octohugger, OctohuggerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("octohugger");

    public OctohuggerRenderer(EntityRendererProvider.Context context) {
        super(context, new OctohuggerModel(context.bakeLayer(OctohuggerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Octohugger entity) {
        return TEXTURE;
    }
}
