package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
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
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.util.*;
import java.util.stream.Collectors;

public class AVPEntitySpawns implements IInitEvent {
    public static final AVPEntitySpawns instance = new AVPEntitySpawns();

    private AVPEntitySpawns() {}

    protected static final ArrayList<Biome> DEFAULT_ALIEN_SPAWNS      = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_AQUA_ALIEN_SPAWNS = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_PREDATOR_SPAWNS   = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_VARDA_LIFE_SPAWNS = new ArrayList<>();
    protected static final ArrayList<Biome>        DEFAULT_MARINE_SPAWNS     = new ArrayList<>();

    static
    {
        DEFAULT_ALIEN_SPAWNS.add(Biomes.BIRCH_FOREST);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.BIRCH_FOREST_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.COLD_BEACH);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.COLD_TAIGA);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.COLD_TAIGA_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.DESERT_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.EXTREME_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.EXTREME_HILLS_EDGE);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.EXTREME_HILLS_WITH_TREES);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.FOREST);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.FOREST_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.ICE_MOUNTAINS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.ICE_PLAINS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.JUNGLE);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.JUNGLE_EDGE);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.JUNGLE_HILLS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.PLAINS);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.ROOFED_FOREST);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.SWAMPLAND);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.TAIGA);
        DEFAULT_ALIEN_SPAWNS.add(Biomes.TAIGA_HILLS);

        DEFAULT_PREDATOR_SPAWNS.add(Biomes.BIRCH_FOREST);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.BIRCH_FOREST_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.DESERT);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.DESERT_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.EXTREME_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.EXTREME_HILLS_EDGE);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.EXTREME_HILLS_WITH_TREES);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FOREST);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FOREST_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FROZEN_OCEAN);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.FROZEN_RIVER);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.ICE_PLAINS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.JUNGLE);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.JUNGLE_EDGE);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.JUNGLE_HILLS);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.TAIGA);
        DEFAULT_PREDATOR_SPAWNS.add(Biomes.TAIGA_HILLS);

        DEFAULT_AQUA_ALIEN_SPAWNS.add(Biomes.RIVER);
        DEFAULT_AQUA_ALIEN_SPAWNS.add(Biomes.BEACH);
        DEFAULT_AQUA_ALIEN_SPAWNS.add(Biomes.STONE_BEACH);

        DEFAULT_MARINE_SPAWNS.add(Biomes.SWAMPLAND);
        DEFAULT_MARINE_SPAWNS.add(Biomes.FOREST);
        DEFAULT_MARINE_SPAWNS.add(Biomes.FOREST_HILLS);
        DEFAULT_MARINE_SPAWNS.add(Biomes.TAIGA);
        DEFAULT_MARINE_SPAWNS.add(Biomes.TAIGA_HILLS);
        DEFAULT_MARINE_SPAWNS.add(Biomes.PLAINS);

        DEFAULT_VARDA_LIFE_SPAWNS.add(BiomeVarda.vardaBadlands);
        DEFAULT_VARDA_LIFE_SPAWNS.add(BiomeVarda.vardaForest);
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        this.registerSpawns();
    }

    private void registerSpawns()
    {
        if (AVP.settings().areAutoSpawnsEnabled())
        {
            List<Biome> alienSpawns = filterOverworldBiomes("Alien", AVP.settings().getSpawnsAlien().value());
            List<Biome> aquaAlienSpawns = filterOverworldBiomes("AlienAquatic", AVP.settings().getSpawnsAquaticAlien().value());
            List<Biome> predatorSpawns = filterOverworldBiomes("Predator", AVP.settings().getSpawnsPredator().value());
            List<Biome> marineSpawns = AVP.settings().getSpawnsMarine().value();
            List<Biome> vardaSpawns = filterOverworldBiomes("Varda", AVP.settings().getSpawnsVarda().value());

            if (AVP.settings().shouldEvolvedXenomorphsSpawn())
            {
                EntityRegistry.addSpawn(EntityNauticomorph.class, (Integer) AVP.settings().spawnWeightEntityNauticomorph.value(), 1, 2, EnumCreatureType.MONSTER, array(aquaAlienSpawns));
                EntityRegistry.addSpawn(EntityDrone.class, (Integer) AVP.settings().spawnWeightEntityDrone.value(), 1, 3, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityWarrior.class, (Integer) AVP.settings().spawnWeightEntityWarrior.value(), 1, 3, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityPraetorian.class, (Integer) AVP.settings().spawnWeightEntityPraetorian.value(), 1, 2, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityChestburster.class, (Integer) AVP.settings().spawnWeightEntityChestburster.value(), 1, 3, EnumCreatureType.MONSTER, array(alienSpawns));
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVP.settings().spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, array(alienSpawns));
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, (Integer) AVP.settings().spawnWeightEntityFacehugger.value(), 1, 2, EnumCreatureType.MONSTER, array(alienSpawns));
            }

            EntityRegistry.addSpawn(EntityYautjaWarrior.class, (Integer) AVP.settings().spawnWeightEntityYautjaWarrior.value(), 0, 1, EnumCreatureType.MONSTER, array(predatorSpawns));
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, (Integer) AVP.settings().spawnWeightEntityYautjaBerserker.value(), 0, 1, EnumCreatureType.MONSTER, array(predatorSpawns));

            EntityRegistry.addSpawn(EntityMarine.class, (Integer) AVP.settings().spawnWeightEntityMarine.value(), 1, 1, EnumCreatureType.CREATURE, array(marineSpawns));

            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVP.settings().spawnWeightEntityEngineer.value(), 1, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntitySpaceJockey.class, (Integer) AVP.settings().spawnWeightEntitySpaceJockey.value(), 1, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityHammerpede.class, (Integer) AVP.settings().spawnWeightEntityHammerpede.value(), 0, 3, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityOctohugger.class, (Integer) AVP.settings().spawnWeightEntityOctohugger.value(), 0, 3, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityDeacon.class, (Integer) AVP.settings().spawnWeightEntityDeacon.value(), 0, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityEngineer.class, (Integer) AVP.settings().spawnWeightEntityEngineer.value(), 0, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
            EntityRegistry.addSpawn(EntityTrilobite.class, (Integer) AVP.settings().spawnWeightEntityTrilobite.value(), 0, 1, EnumCreatureType.MONSTER, array(vardaSpawns));
        }
    }

    public List<Biome> filterOverworldBiomes(String listName, List<Biome> biomes)
    {
        Iterator<Biome> iter = biomes.iterator();
        Set<Biome> overworldBiomes = getOverworldBiomeList();

        while (iter.hasNext())
        {
            Biome biome = iter.next();

            if (!AVP.settings().areOverworldSpawnsEnabled() && overworldBiomes.contains(biome))
            {
                iter.remove();

                System.out.println("Overworld spawn weights disabled. Removing biome from spawn list " + listName + ": " + biome.getRegistryName());
            }
        }

        return biomes;
    }

    public static Set<Biome> getOverworldBiomeList()
    {
        return ForgeRegistries.BIOMES.getValuesCollection().stream().filter(biome -> {
            if (biome.getRegistryName() == null)
                return false;
            boolean isMinecraftBiome = biome.getRegistryName().getNamespace().equalsIgnoreCase("minecraft");
            boolean isOverworldBiome = biome != Biomes.HELL && biome != Biomes.VOID && biome != Biomes.SKY;
            return isMinecraftBiome && isOverworldBiome;
        }).collect(Collectors.toSet());
    }

    private static Biome[] array(List<Biome> biomes)
    {
        return Arrays.copyOf(biomes.toArray(), biomes.toArray().length, Biome[].class);
    }
}
