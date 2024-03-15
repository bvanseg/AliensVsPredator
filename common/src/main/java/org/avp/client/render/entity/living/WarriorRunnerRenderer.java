package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.WarriorRunnerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.WarriorRunner;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class WarriorRunnerRenderer extends MobRenderer<WarriorRunner, WarriorRunnerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("warrior_runner");

    public WarriorRunnerRenderer(EntityRendererProvider.Context context) {
        super(context, new WarriorRunnerModel(context.bakeLayer(WarriorRunnerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WarriorRunner entity) {
        return TEXTURE;
    }
}
