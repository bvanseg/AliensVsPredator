package org.avp.client.model.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import net.minecraft.resources.ResourceLocation;
import org.avp.client.util.BasicAnimationUtils;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Belugamorph;
import org.avp.common.entity.living.Chestburster;

public class ChestbursterModel extends GeoModel<Chestburster> {

    private static final String ENTITY_NAME = "chestburster";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(Chestburster entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(Chestburster entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(Chestburster entity) {
        return ANIMATION_LOCATION;
    }

    @Override
    public void setCustomAnimations(Chestburster entity, long instanceId, AnimationState<Chestburster> animationState) {
        // TODO:
    }
}