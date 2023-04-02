package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigGeneral {

    private boolean experimentalFeatures = false;
    private boolean explosionsEnabled = true;
    private boolean plasmaCannonExplosions = true;
    private boolean updaterEnabled = true;
    private boolean debugToolsEnabled = false;
    private boolean nukesEnabled = true;

    @ConfigValue.Number
    private int globalSoundVolume = 75;

    public ModelConfigGeneral() {}
}
