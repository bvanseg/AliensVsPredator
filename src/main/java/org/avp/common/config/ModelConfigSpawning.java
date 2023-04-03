package org.avp.common.config;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.alien.common.AlienEntitySpawns;
import org.avp.common.AVPEntitySpawns;
import org.predator.common.PredatorEntitySpawns;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    @ConfigValue.Collection(description = "List of biomes for aliens to spawn in.", requiresRestart = true)
    public Set<String> spawnsAlien = new HashSet<>(AlienEntitySpawns.DEFAULT_ALIEN_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(description = "List of biomes for aquatic aliens to spawn in.", requiresRestart = true)
    public Set<String> spawnsAquaticAlien = new HashSet<>(AlienEntitySpawns.DEFAULT_AQUA_ALIEN_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(description = "List of biomes for predators to spawn in.", requiresRestart = true)
    public Set<String> spawnsPredator = new HashSet<>(PredatorEntitySpawns.DEFAULT_PREDATOR_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(description = "List of biomes for marines to spawn in.", requiresRestart = true)
    public Set<String> spawnsMarine = new HashSet<>(AVPEntitySpawns.DEFAULT_MARINE_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(description = "List of biomes for varda wildlife to spawn in.", requiresRestart = true)
    public Set<String> spawnsVarda = new HashSet<>(AlienEntitySpawns.DEFAULT_VARDA_LIFE_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());

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

    public ModelConfigSpawning() { /* Do Nothing */ }

    public Set<Biome> getAlienSpawnBiomes() {
        return this.spawnsAlien.stream().map(registryName -> ForgeRegistries.BIOMES.getValue(new ResourceLocation(registryName))).collect(Collectors.toSet());
    }

    public Set<Biome> getAquaticAlienSpawnBiomes() {
        return this.spawnsAquaticAlien.stream().map(registryName -> ForgeRegistries.BIOMES.getValue(new ResourceLocation(registryName))).collect(Collectors.toSet());
    }

    public Set<Biome> getPredatorSpawnBiomes() {
        return this.spawnsPredator.stream().map(registryName -> ForgeRegistries.BIOMES.getValue(new ResourceLocation(registryName))).collect(Collectors.toSet());
    }

    public Set<Biome> getMarineSpawnBiomes() {
        return this.spawnsMarine.stream().map(registryName -> ForgeRegistries.BIOMES.getValue(new ResourceLocation(registryName))).collect(Collectors.toSet());
    }

    public Set<Biome> getVardaSpawnBiomes() {
        return this.spawnsVarda.stream().map(registryName -> ForgeRegistries.BIOMES.getValue(new ResourceLocation(registryName))).collect(Collectors.toSet());
    }
}
