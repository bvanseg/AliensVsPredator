package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.WarriorModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Warrior;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class WarriorRenderer extends MobRenderer<Warrior, WarriorModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("warrior");


    public WarriorRenderer(EntityRendererProvider.Context context) {
        super(context, new WarriorModel(context.bakeLayer(WarriorModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Warrior entity) {
        return TEXTURE;
    }
}
