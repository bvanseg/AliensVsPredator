package org.alien.common;

import com.asx.mdx.common.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.alien.common.entity.AlienCreatureTypes;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.EntityHammerpede;
import org.alien.common.entity.living.vardic.EntityOctohugger;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.world.dimension.varda.BiomeVarda;
import org.avp.common.config.ModelConfig;
import org.lib.common.registry.EntitySpawnRegistryUtil;

import java.util.ArrayList;
import java.util.List;

public class AlienEntitySpawns implements IInitEvent {
    public static final AlienEntitySpawns instance = new AlienEntitySpawns();

    private AlienEntitySpawns() {}

    public static final ArrayList<Biome> DEFAULT_ALIEN_SPAWNS      = new ArrayList<>();
    public static final ArrayList<Biome> DEFAULT_AQUA_ALIEN_SPAWNS = new ArrayList<>();
    public static final ArrayList<Biome> DEFAULT_VARDA_LIFE_SPAWNS = new ArrayList<>();

    static
    {
        DEFAULT_ALIEN_SPAWNS.addAll(
            Lists.newArrayList(
                Biomes.BIRCH_FOREST,
                Biomes.BIRCH_FOREST_HILLS,
                Biomes.COLD_BEACH,
                Biomes.COLD_TAIGA,
                Biomes.COLD_TAIGA_HILLS,
                Biomes.DESERT_HILLS,
                Biomes.EXTREME_HILLS,
                Biomes.EXTREME_HILLS_EDGE,
                Biomes.EXTREME_HILLS_WITH_TREES,
                Biomes.FOREST,
                Biomes.FOREST_HILLS,
                Biomes.ICE_MOUNTAINS,
                Biomes.ICE_PLAINS,
                Biomes.JUNGLE,
                Biomes.JUNGLE_EDGE,
                Biomes.JUNGLE_HILLS,
                Biomes.PLAINS,
                Biomes.ROOFED_FOREST,
                Biomes.SWAMPLAND,
                Biomes.TAIGA,
                Biomes.TAIGA_HILLS
            )
        );

        DEFAULT_AQUA_ALIEN_SPAWNS.addAll(
            Lists.newArrayList(
                Biomes.RIVER,
                Biomes.BEACH,
                Biomes.STONE_BEACH
            )
        );

        DEFAULT_VARDA_LIFE_SPAWNS.addAll(
            Lists.newArrayList(
                BiomeVarda.vardaBadlands,
                BiomeVarda.vardaForest
            )
        );
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        this.registerSpawns();
    }

    private void registerSpawns()
    {
        if (ModelConfig.instance.getSpawning().autoSpawnsEnabled)
        {
            List<Biome> alienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Alien", new ArrayList<>(ModelConfig.instance.getSpawning().getAlienSpawnBiomes()));
            List<Biome> aquaAlienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("AlienAquatic", new ArrayList<>(ModelConfig.instance.getSpawning().getAquaticAlienSpawnBiomes()));
            List<Biome> vardaSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Varda", new ArrayList<>(ModelConfig.instance.getSpawning().getVardaSpawnBiomes()));

            if (ModelConfig.instance.getSpawning().evolvedXenomorphSpawns)
            {
                EntityRegistry.addSpawn(EntityNauticomorph.class, ModelConfig.instance.getSpawning().spawnWeightEntityNauticomorph, 1, 2, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(aquaAlienSpawns));
                EntityRegistry.addSpawn(EntityDrone.class, ModelConfig.instance.getSpawning().spawnWeightEntityDrone, 1, 3, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityWarrior.class, ModelConfig.instance.getSpawning().spawnWeightEntityWarrior, 1, 3, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityPraetorian.class, ModelConfig.instance.getSpawning().spawnWeightEntityPraetorian, 1, 2, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityChestburster.class, ModelConfig.instance.getSpawning().spawnWeightEntityChestburster, 1, 3, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityFacehugger.class, ModelConfig.instance.getSpawning().spawnWeightEntityFacehugger, 1, 2, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(alienSpawns));
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, ModelConfig.instance.getSpawning().spawnWeightEntityFacehugger, 1, 2, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(alienSpawns));
            }

            EntityRegistry.addSpawn(EntityEngineer.class, ModelConfig.instance.getSpawning().spawnWeightEntityEngineer, 1, 1, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntitySpaceJockey.class, ModelConfig.instance.getSpawning().spawnWeightEntitySpaceJockey, 1, 1, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityHammerpede.class, ModelConfig.instance.getSpawning().spawnWeightEntityHammerpede, 0, 3, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityOctohugger.class, ModelConfig.instance.getSpawning().spawnWeightEntityOctohugger, 0, 3, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityDeacon.class, ModelConfig.instance.getSpawning().spawnWeightEntityDeacon, 0, 1, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityEngineer.class, ModelConfig.instance.getSpawning().spawnWeightEntityEngineer, 0, 1, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityTrilobite.class, ModelConfig.instance.getSpawning().spawnWeightEntityTrilobite, 0, 1, AlienCreatureTypes.ALIEN, EntitySpawnRegistryUtil.array(vardaSpawns));
        }
    }
}
