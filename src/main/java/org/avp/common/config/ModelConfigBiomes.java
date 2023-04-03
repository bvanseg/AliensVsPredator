package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigBiomes {

    @ConfigValue.Number(key = "biome.varda.id", maxValue = Short.MAX_VALUE, requiresRestart = true)
    public int biomeVarda = 223;
    @ConfigValue.Number(key = "biome.varda.forest.id", maxValue = Short.MAX_VALUE, requiresRestart = true)
    public int biomeVardaForest = 229;
    @ConfigValue.Number(key = "biome.acheron.id", maxValue = Short.MAX_VALUE, requiresRestart = true)
    public int biomeAcheron = 224;

    public ModelConfigBiomes() { /* Do Nothing */ }
}
