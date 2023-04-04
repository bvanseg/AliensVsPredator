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

    @ConfigValue.Boolean(key = "overworld.spawns.enabled", requiresRestart = true)
    public boolean overworldSpawnsEnabled = false;
    @ConfigValue.Boolean(key = "auto.spawns.enabled", requiresRestart = true)
    public boolean autoSpawnsEnabled = true;
    @ConfigValue.Boolean(key = "evolved.xenomorph.spawns", requiresRestart = true)
    public boolean evolvedXenomorphSpawns = true;

    @ConfigValue.Collection(key = "spawns.alien", requiresRestart = true)
    public Set<String> spawnsAlien = new HashSet<>(AlienEntitySpawns.DEFAULT_ALIEN_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(key = "spawns.aquatic.alien", requiresRestart = true)
    public Set<String> spawnsAquaticAlien = new HashSet<>(AlienEntitySpawns.DEFAULT_AQUA_ALIEN_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(key = "spawns.predator", requiresRestart = true)
    public Set<String> spawnsPredator = new HashSet<>(PredatorEntitySpawns.DEFAULT_PREDATOR_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(key = "spawns.marine", requiresRestart = true)
    public Set<String> spawnsMarine = new HashSet<>(AVPEntitySpawns.DEFAULT_MARINE_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());
    @ConfigValue.Collection(key = "spawns.varda.wildlife", requiresRestart = true)
    public Set<String> spawnsVarda = new HashSet<>(AlienEntitySpawns.DEFAULT_VARDA_LIFE_SPAWNS).stream().map(biome -> biome.getRegistryName().toString()).collect(Collectors.toSet());

    @ConfigValue.Number(key = "spawn.weight.nauticomorph", requiresRestart = true)
    public int spawnWeightEntityNauticomorph = 5;
    @ConfigValue.Number(key = "spawn.weight.drone", requiresRestart = true)
    public int spawnWeightEntityDrone = 5;
    @ConfigValue.Number(key = "spawn.weight.warrior", requiresRestart = true)
    public int spawnWeightEntityWarrior = 5;
    @ConfigValue.Number(key = "spawn.weight.praetorian", requiresRestart = true)
    public int spawnWeightEntityPraetorian = 5;
    @ConfigValue.Number(key = "spawn.weight.chestburster", requiresRestart = true)
    public int spawnWeightEntityChestburster = 5;
    @ConfigValue.Number(key = "spawn.weight.facehugger", requiresRestart = true)
    public int spawnWeightEntityFacehugger = 5;
    @ConfigValue.Number(key = "spawn.weight.yautja.warrior", requiresRestart = true)
    public int spawnWeightEntityYautjaWarrior = 5;
    @ConfigValue.Number(key = "spawn.weight.yautja.berserker", requiresRestart = true)
    public int spawnWeightEntityYautjaBerserker = 5;
    @ConfigValue.Number(key = "spawn.weight.marine", requiresRestart = true)
    public int spawnWeightEntityMarine = 5;
    @ConfigValue.Number(key = "spawn.weight.engineer", requiresRestart = true)
    public int spawnWeightEntityEngineer = 5;
    @ConfigValue.Number(key = "spawn.weight.space.jockey", requiresRestart = true)
    public int spawnWeightEntitySpaceJockey = 5;
    @ConfigValue.Number(key = "spawn.weight.hammerpede", requiresRestart = true)
    public int spawnWeightEntityHammerpede = 5;
    @ConfigValue.Number(key = "spawn.weight.octohugger", requiresRestart = true)
    public int spawnWeightEntityOctohugger = 5;
    @ConfigValue.Number(key = "spawn.weight.deacon", requiresRestart = true)
    public int spawnWeightEntityDeacon = 5;
    @ConfigValue.Number(key = "spawn.weight.trilobite", requiresRestart = true)
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
