package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigBiomes {

    @ConfigValue.Number(maxValue = Short.MAX_VALUE, description = "Change the internal ID of this biome. WARNING: Changing a biome ID will prevent existing worlds from loading.", requiresRestart = true)
    public int biomeVarda = 223;
    @ConfigValue.Number(maxValue = Short.MAX_VALUE, description = "Change the internal ID of this biome. WARNING: Changing a biome ID will prevent existing worlds from loading.", requiresRestart = true)
    public int biomeVardaForest = 229;
    @ConfigValue.Number(maxValue = Short.MAX_VALUE, description = "Change the internal ID of this biome. WARNING: Changing a biome ID will prevent existing worlds from loading.", requiresRestart = true)
    public int biomeAcheron = 224;

    public ModelConfigBiomes() { /* Do Nothing */ }
}
