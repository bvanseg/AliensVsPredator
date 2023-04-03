package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigGeneral {

    public boolean experimentalFeatures = false;
    public boolean explosionsEnabled = true;
    public boolean plasmaCannonExplosions = true;
    public boolean updaterEnabled = true;
    public boolean debugToolsEnabled = false;
    public boolean nukesEnabled = true;

    @ConfigValue.Number
    private int globalSoundVolume = 75;

    public ModelConfigGeneral() {}
}
