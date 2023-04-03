package org.avp.common.config;

import java.util.Collections;
import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigSpawning {

    @ConfigValue.Boolean(description = "If enabled, mobs will spawn in the overworld using spawn weights.", requiresRestart = true)
    public boolean overworldSpawnsEnabled = false;
    @ConfigValue.Boolean(description = "If disabled, no mobs from this mod will spawn.", requiresRestart = true)
    public boolean autoSpawnsEnabled = true;
    @ConfigValue.Boolean(description = "If disabled, no mature alien states will spawn naturally.", requiresRestart = true)
    public boolean evolvedXenomorphSpawns = true;

    public Set<String> spawnsAlien = Collections.emptySet();
    public Set<String> spawnsAquaticAlien = Collections.emptySet();
    public Set<String> spawnsPredator = Collections.emptySet();
    public Set<String> spawnsMarine = Collections.emptySet();
    public Set<String> spawnsVarda = Collections.emptySet();

    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityNauticomorph = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityDrone = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityWarrior = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityPraetorian = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityChestburster = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityFacehugger = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityYautjaWarrior = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityYautjaBerserker = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityMarine = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityEngineer = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntitySpaceJockey = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityHammerpede = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityOctohugger = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityDeacon = 5;
    @ConfigValue.Number(description = "Spawn Weight", requiresRestart = true)
    public int spawnWeightEntityTrilobite = 5;

    public ModelConfigSpawning() {}
}
