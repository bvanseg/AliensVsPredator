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
import org.avp.AVP;
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
        if (AVP.settings().areAutoSpawnsEnabled())
        {
            List<Biome> alienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Alien", AVP.settings().getSpawnsAlien().value());
            List<Biome> aquaAlienSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("AlienAquatic", AVP.settings().getSpawnsAquaticAlien().value());
            List<Biome> vardaSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Varda", AVP.settings().getSpawnsVarda().value());

            if (AVP.settings().shouldEvolvedXenomorphsSpawn())
            {
                EntityRegistry.addSpawn(EntityNauticomorph.class, (Integer) AVP.settings().spawnWeightEntityNauticomorph.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(aquaAlienSpawns));
                EntityRegistry.addSpawn(EntityDrone.class, (Integer) AVP.settings().spawnWeightEntityDrone.value(), 1, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityWarrior.class, (Integer) AVP.settings().spawnWeightEntityWarrior.value(), 1, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityPraetorian.class, (Integer) AVP.settings().spawnWeightEntityPraetorian.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityChestburster.class, (Integer) AVP.settings().spawnWeightEntityChestburster.value(), 1, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVP.settings().spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVP.settings().spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(alienSpawns));
            }

            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVP.settings().spawnWeightEntityEngineer.value(), 1, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntitySpaceJockey.class, (Integer) AVP.settings().spawnWeightEntitySpaceJockey.value(), 1, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityHammerpede.class, (Integer) AVP.settings().spawnWeightEntityHammerpede.value(), 0, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityOctohugger.class, (Integer) AVP.settings().spawnWeightEntityOctohugger.value(), 0, 3, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityDeacon.class, (Integer) AVP.settings().spawnWeightEntityDeacon.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVP.settings().spawnWeightEntityEngineer.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
            EntityRegistry.addSpawn(EntityTrilobite.class, (Integer) AVP.settings().spawnWeightEntityTrilobite.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(vardaSpawns));
        }
    }
}
