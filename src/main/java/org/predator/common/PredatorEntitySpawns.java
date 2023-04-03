package org.predator.common;

import com.asx.mdx.common.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.avp.common.config.ModelConfig;
import org.lib.common.registry.EntitySpawnRegistryUtil;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.util.ArrayList;
import java.util.List;

public class PredatorEntitySpawns implements IInitEvent {
    public static final PredatorEntitySpawns instance = new PredatorEntitySpawns();

    private PredatorEntitySpawns() {}

    public static final ArrayList<Biome>        DEFAULT_PREDATOR_SPAWNS   = new ArrayList<>();

    static
    {
        DEFAULT_PREDATOR_SPAWNS.addAll(
            Lists.newArrayList(
                Biomes.BIRCH_FOREST,
                Biomes.BIRCH_FOREST_HILLS,
                Biomes.DESERT,
                Biomes.DESERT_HILLS,
                Biomes.EXTREME_HILLS,
                Biomes.EXTREME_HILLS_EDGE,
                Biomes.EXTREME_HILLS_WITH_TREES,
                Biomes.FOREST,
                Biomes.FOREST_HILLS,
                Biomes.FROZEN_OCEAN,
                Biomes.FROZEN_RIVER,
                Biomes.ICE_PLAINS,
                Biomes.JUNGLE,
                Biomes.JUNGLE_EDGE,
                Biomes.JUNGLE_HILLS,
                Biomes.TAIGA,
                Biomes.TAIGA_HILLS
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
            List<Biome> predatorSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Predator", new ArrayList<>(ModelConfig.instance.getSpawning().getPredatorSpawnBiomes()));

            EntityRegistry.addSpawn(EntityYautjaWarrior.class, ModelConfig.instance.getSpawning().spawnWeightEntityYautjaWarrior, 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(predatorSpawns));
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, ModelConfig.instance.getSpawning().spawnWeightEntityYautjaBerserker, 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(predatorSpawns));
        }
    }
}
