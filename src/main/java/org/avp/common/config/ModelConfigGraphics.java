package org.avp.common.config;

import com.asx.mdx.common.io.config.GraphicsSetting;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigGraphics {
    @ConfigValue.Boolean(description = "Turns blood particle effects on or off.")
    public boolean bloodEffects = true;
    @ConfigValue.Enum(description = "The visual complexity and detail of xenomorph hives.")
    public GraphicsSetting hiveTessellation = GraphicsSetting.ULTRA;
    @ConfigValue.Enum(description = "Sets the amount of blood particles and how long they last.")
    public GraphicsSetting bloodDetails = GraphicsSetting.ULTRA;

    public ModelConfigGraphics() { /* Do Nothing */ }
}
