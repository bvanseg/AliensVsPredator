package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigDimensions {

    // Dimensions are not given default values on purpose. See the relevant registration for these dimensions (AlienDimensions.java at the time of writing).
    @ConfigValue.Number( key = "varda.dim.id", maxValue = Short.MAX_VALUE, requiresRestart = true)
    public Integer vardaDimId;
    @ConfigValue.Number(key = "acheron.dim.id", maxValue = Short.MAX_VALUE, requiresRestart = true)
    public Integer acheronDimId;
    @ConfigValue.Number(key = "paradise.dim.id", maxValue = Short.MAX_VALUE, requiresRestart = true)
    public Integer paradiseDimId;

    public ModelConfigDimensions() { /* Do Nothing */ }
}
