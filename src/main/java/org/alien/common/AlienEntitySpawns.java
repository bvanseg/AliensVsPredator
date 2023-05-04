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
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.alien.common.entity.living.xenomorph.EntityPraetorian;
import org.alien.common.entity.living.xenomorph.EntityWarrior;
import org.alien.common.entity.living.xenomorph.burster.EntityChestburster;
import org.alien.common.entity.living.xenomorph.exotic.EntityNauticomorph;
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
        if (ModelConfig.getInstance().getSpawning().autoSpawnsEnabled)
        {
            List<Biome> alienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Alien", new ArrayList<>(ModelConfig.getInstance().getSpawning().getAlienSpawnBiomes()));
            List<Biome> aquaAlienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("AlienAquatic", new ArrayList<>(ModelConfig.getInstance().getSpawning().getAquaticAlienSpawnBiomes()));
            List<Biome> vardaSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Varda", new ArrayList<>(ModelConfig.getInstance().getSpawning().getVardaSpawnBiomes()));

            if (ModelConfig.getInstance().getSpawning().evolvedXenomorphSpawns)
            {
                EntityRegistry.addSpawn(EntityNauticomorph.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityNauticomorph, 1, 2, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(aquaAlienSpawns));
                EntityRegistry.addSpawn(EntityDrone.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityDrone, 1, 3, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityWarrior.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityWarrior, 1, 3, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityPraetorian.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityPraetorian, 1, 2, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityChestburster.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityChestburster, 1, 3, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityFacehugger.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityFacehugger, 1, 2, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(alienSpawns));
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityFacehugger, 1, 2, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(alienSpawns));
            }

            EntityRegistry.addSpawn(EntityEngineer.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityEngineer, 1, 1, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntitySpaceJockey.class, ModelConfig.getInstance().getSpawning().spawnWeightEntitySpaceJockey, 1, 1, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityHammerpede.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityHammerpede, 0, 3, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityOctohugger.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityOctohugger, 0, 3, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityDeacon.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityDeacon, 0, 1, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityEngineer.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityEngineer, 0, 1, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityTrilobite.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityTrilobite, 0, 1, AlienCreatureTypes.getAlienCreatureType(), EntitySpawnRegistryUtil.array(vardaSpawns));
        }
    }
}
