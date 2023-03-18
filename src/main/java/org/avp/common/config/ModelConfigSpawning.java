package org.avp.common.config;

import java.util.Collections;
import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigSpawning {

    private boolean overworldSpawnsEnabled = false;
    private boolean autoSpawnsEnabled = true;
    private boolean evolvedXenomorphSpawns = true;

    private List<String> spawnsAlien = Collections.emptyList();
    private List<String> spawnsAquaticAlien = Collections.emptyList();
    private List<String> spawnsPredator = Collections.emptyList();
    private List<String> spawnsMarine = Collections.emptyList();
    private List<String> spawnsVarda = Collections.emptyList();

    private int spawnWeightEntityNauticomorph = 5;
    private int spawnWeightEntityDrone = 5;
    private int spawnWeightEntityWarrior = 5;
    private int spawnWeightEntityPraetorian = 5;
    private int spawnWeightEntityChestburster = 5;
    private int spawnWeightEntityFacehugger = 5;
    private int spawnWeightEntityYautjaWarrior = 5;
    private int spawnWeightEntityYautjaBerserker = 5;
    private int spawnWeightEntityMarine = 5;
    private int spawnWeightEntityEngineer = 5;
    private int spawnWeightEntitySpaceJockey = 5;
    private int spawnWeightEntityHammerpede = 5;
    private int spawnWeightEntityOctohugger = 5;
    private int spawnWeightEntityDeacon = 5;
    private int spawnWeightEntityTrilobite = 5;

    public ModelConfigSpawning() {}
}
