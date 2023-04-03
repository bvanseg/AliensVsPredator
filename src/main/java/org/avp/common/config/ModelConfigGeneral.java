package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigGeneral {

    @ConfigValue.Boolean(key = "experimental.features")
    public boolean experimentalFeatures = false;
    @ConfigValue.Boolean(key = "explosions.enabled")
    public boolean explosionsEnabled = true;
    @ConfigValue.Boolean(key = "plasma.cannon.explosions")
    public boolean plasmaCannonExplosions = true;
    @ConfigValue.Boolean(key = "updater.enabled", requiresRestart = true)
    public boolean updaterEnabled = true;
    @ConfigValue.Boolean(key = "debug.tools.enabled")
    public boolean debugToolsEnabled = false;
    @ConfigValue.Boolean(key = "nukes.enabled")
    public boolean nukesEnabled = true;

    @ConfigValue.Number(key = "global.sound.volume", requiresRestart = true)
    public int globalSoundVolume = 75;

    @ConfigValue.String(key = "wristbracer.nuke.code", requiresRestart = true)
    public String wristbracerNukeCode = "009001";

    public ModelConfigGeneral() { /* Do Nothing */ }
}
