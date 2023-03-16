package org.alien.common;

import com.asx.mdx.common.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.EntityHammerpede;
import org.alien.common.entity.living.vardic.EntityOctohugger;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.world.dimension.varda.BiomeVarda;
import org.avp.common.AVPSettings;
import org.lib.registry.EntitySpawnRegistryUtil;

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
        if (AVPSettings.instance.areAutoSpawnsEnabled())
        {
            List<Biome> alienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Alien", AVPSettings.instance.getSpawnsAlien().value());
            List<Biome> aquaAlienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("AlienAquatic", AVPSettings.instance.getSpawnsAquaticAlien().value());
            List<Biome> vardaSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Varda", AVPSettings.instance.getSpawnsVarda().value());

            if (AVPSettings.instance.shouldEvolvedXenomorphsSpawn())
            {
                EntityRegistry.addSpawn(EntityNauticomorph.class, (Integer) AVPSettings.instance.spawnWeightEntityNauticomorph.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(aquaAlienSpawns));
                EntityRegistry.addSpawn(EntityDrone.class, (Integer) AVPSettings.instance.spawnWeightEntityDrone.value(), 1, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityWarrior.class, (Integer) AVPSettings.instance.spawnWeightEntityWarrior.value(), 1, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityPraetorian.class, (Integer) AVPSettings.instance.spawnWeightEntityPraetorian.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityChestburster.class, (Integer) AVPSettings.instance.spawnWeightEntityChestburster.value(), 1, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVPSettings.instance.spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVPSettings.instance.spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
            }

            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVPSettings.instance.spawnWeightEntityEngineer.value(), 1, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntitySpaceJockey.class, (Integer) AVPSettings.instance.spawnWeightEntitySpaceJockey.value(), 1, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityHammerpede.class, (Integer) AVPSettings.instance.spawnWeightEntityHammerpede.value(), 0, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityOctohugger.class, (Integer) AVPSettings.instance.spawnWeightEntityOctohugger.value(), 0, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityDeacon.class, (Integer) AVPSettings.instance.spawnWeightEntityDeacon.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVPSettings.instance.spawnWeightEntityEngineer.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityTrilobite.class, (Integer) AVPSettings.instance.spawnWeightEntityTrilobite.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
        }
    }
}
