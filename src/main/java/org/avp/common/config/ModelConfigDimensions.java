package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigDimensions {

    // Dimensions are not given default values on purpose. See the relevant registration for these dimensions (AlienDimensions.java at the time of writing).
    @ConfigValue.Number(maxValue = Short.MAX_VALUE, description = "Change the internal ID of this dimension. WARNING: Changing a dimension ID will prevent existing worlds from loading.", requiresRestart = true)
    public Integer vardaDimId;
    @ConfigValue.Number(maxValue = Short.MAX_VALUE, description = "Change the internal ID of this dimension. WARNING: Changing a dimension ID will prevent existing worlds from loading.", requiresRestart = true)
    public Integer acheronDimId;

    public ModelConfigDimensions() { /* Do Nothing */ }
}
