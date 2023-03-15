package org.predator.common;

import com.asx.mdx.core.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.avp.AVP;
import org.lib.registry.EntitySpawnRegistryUtil;
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
        if (AVP.settings().areAutoSpawnsEnabled())
        {
            List<Biome> predatorSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Predator", AVP.settings().getSpawnsPredator().value());

            EntityRegistry.addSpawn(EntityYautjaWarrior.class, (Integer) AVP.settings().spawnWeightEntityYautjaWarrior.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(predatorSpawns));
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, (Integer) AVP.settings().spawnWeightEntityYautjaBerserker.value(), 0, 1, EnumCreatureType.MONSTER, EntitySpawnRegistryUtil.array(predatorSpawns));
        }
    }
}