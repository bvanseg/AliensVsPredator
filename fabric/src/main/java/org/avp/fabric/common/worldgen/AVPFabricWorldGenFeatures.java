package org.avp.fabric.common.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.worldgen.feature.AVPOreFeatures;

public class AVPFabricWorldGenFeatures implements AVPRegistry {

    private static final AVPFabricWorldGenFeatures INSTANCE = new AVPFabricWorldGenFeatures();

    public static AVPFabricWorldGenFeatures getInstance() {
        return INSTANCE;
    }

    @Override
    public void register() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, AVPOreFeatures.getInstance().BAUXITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, AVPOreFeatures.getInstance().COBALT_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, AVPOreFeatures.getInstance().LITHIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, AVPOreFeatures.getInstance().NEODYMIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, AVPOreFeatures.getInstance().SILICA_ORE_PLACED_KEY);
    }
}
