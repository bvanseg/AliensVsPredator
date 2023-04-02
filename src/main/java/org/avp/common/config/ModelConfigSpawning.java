package org.avp.common.config;

import java.util.Collections;
import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigSpawning {

    private boolean overworldSpawnsEnabled = false;
    private boolean autoSpawnsEnabled = true;
    private boolean evolvedXenomorphSpawns = true;

    private Set<String> spawnsAlien = Collections.emptySet();
    private Set<String> spawnsAquaticAlien = Collections.emptySet();
    private Set<String> spawnsPredator = Collections.emptySet();
    private Set<String> spawnsMarine = Collections.emptySet();
    private Set<String> spawnsVarda = Collections.emptySet();

    @ConfigValue.Number
    private int spawnWeightEntityNauticomorph = 5;
    @ConfigValue.Number
    private int spawnWeightEntityDrone = 5;
    @ConfigValue.Number
    private int spawnWeightEntityWarrior = 5;
    @ConfigValue.Number
    private int spawnWeightEntityPraetorian = 5;
    @ConfigValue.Number
    private int spawnWeightEntityChestburster = 5;
    @ConfigValue.Number
    private int spawnWeightEntityFacehugger = 5;
    @ConfigValue.Number
    private int spawnWeightEntityYautjaWarrior = 5;
    @ConfigValue.Number
    private int spawnWeightEntityYautjaBerserker = 5;
    @ConfigValue.Number
    private int spawnWeightEntityMarine = 5;
    @ConfigValue.Number
    private int spawnWeightEntityEngineer = 5;
    @ConfigValue.Number
    private int spawnWeightEntitySpaceJockey = 5;
    @ConfigValue.Number
    private int spawnWeightEntityHammerpede = 5;
    @ConfigValue.Number
    private int spawnWeightEntityOctohugger = 5;
    @ConfigValue.Number
    private int spawnWeightEntityDeacon = 5;
    @ConfigValue.Number
    private int spawnWeightEntityTrilobite = 5;

    public ModelConfigSpawning() {}
}
