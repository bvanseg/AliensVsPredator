package org.avp.client.util;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

import java.util.function.Supplier;

public record EntityModelLayerData(
    ModelLayerLocation modelLayerLocation,
    Supplier<LayerDefinition> layerDefinitionSupplier
) {
}
