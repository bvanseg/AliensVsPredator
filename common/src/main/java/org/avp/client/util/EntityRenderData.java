package org.avp.client.util;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.avp.common.util.GameObject;

import java.util.function.Supplier;

public record EntityRenderData<T extends Entity>(
    GameObject<EntityType<T>> entityTypeGameObject,
    EntityRendererProvider<T> entityRendererProvider,
    ModelLayerLocation modelLayerLocation,
    Supplier<LayerDefinition> layerDefinitionSupplier
) {
}
