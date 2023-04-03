package org.avp.common.config;

import java.util.Collections;
import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigSpawning {

    public boolean overworldSpawnsEnabled = false;
    public boolean autoSpawnsEnabled = true;
    public boolean evolvedXenomorphSpawns = true;

    public Set<String> spawnsAlien = Collections.emptySet();
    public Set<String> spawnsAquaticAlien = Collections.emptySet();
    public Set<String> spawnsPredator = Collections.emptySet();
    public Set<String> spawnsMarine = Collections.emptySet();
    public Set<String> spawnsVarda = Collections.emptySet();

    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityNauticomorph = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityDrone = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityWarrior = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityPraetorian = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityChestburster = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityFacehugger = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityYautjaWarrior = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityYautjaBerserker = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityMarine = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityEngineer = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntitySpaceJockey = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityHammerpede = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityOctohugger = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityDeacon = 5;
    @ConfigValue.Number(description = "Spawn Weight")
    public int spawnWeightEntityTrilobite = 5;

    public ModelConfigSpawning() {}
}
