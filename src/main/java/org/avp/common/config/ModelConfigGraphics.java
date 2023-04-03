package org.avp.common.config;

import com.asx.mdx.common.io.config.GraphicsSetting;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigGraphics {
    @ConfigValue.Boolean(key = "blood.effects")
    public boolean bloodEffects = true;
    @ConfigValue.Enum(key = "hive.tessellation")
    public GraphicsSetting hiveTessellation = GraphicsSetting.ULTRA;
    @ConfigValue.Enum(key = "blood.details")
    public GraphicsSetting bloodDetails = GraphicsSetting.ULTRA;

    public ModelConfigGraphics() { /* Do Nothing */ }
}
