package org.avp.common.config;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigGeneral {

    @ConfigValue.Boolean(description = "If enabled, experimental mod features will be turned on. If using this on a server, it will need to be enabled on both the client and server to work properly.")
    public boolean experimentalFeatures = false;
    @ConfigValue.Boolean(description = "If disabled, all explosions triggered by this mod will be cancelled.")
    public boolean explosionsEnabled = true;
    @ConfigValue.Boolean(description = "If enabled, a plasma cannon's projectiles will explode upon impact.")
    public boolean plasmaCannonExplosions = true;
    @ConfigValue.Boolean(description = "Toggle the mod's update checking capabilities. Will not check for new updates if disabled.", requiresRestart = true)
    public boolean updaterEnabled = true;
    @ConfigValue.Boolean(description = "Toggle the built in debugging tools. Used primarily in development environments.")
    public boolean debugToolsEnabled = false;
    @ConfigValue.Boolean(description = "If disabled, you will not be allowed to use any nuke-based functionality.")
    public boolean nukesEnabled = true;

    @ConfigValue.Number(description = "Change the default volume of this mod's sounds. EXAMPLE: 100 = 100% Volume, 50 = 50% Volume, 150 = 150% Volume", requiresRestart = true)
    public int globalSoundVolume = 75;

    @ConfigValue.String(description = "Change the wristbracer's code to activate a nuclear detonation.", requiresRestart = true)
    public String wristbracerNukeCode = "009001";

    public ModelConfigGeneral() { /* Do Nothing */ }
}
