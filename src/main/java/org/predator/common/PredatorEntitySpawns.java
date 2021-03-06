package org.predator.common;

import com.asx.mdx.common.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.avp.common.config.ModelConfig;
import org.lib.common.registry.EntitySpawnRegistryUtil;
import org.predator.common.entity.PredatorCreatureTypes;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import java.util.ArrayList;
import java.util.List;

public class PredatorEntitySpawns implements IInitEvent {
    public static final PredatorEntitySpawns instance = new PredatorEntitySpawns();

    private PredatorEntitySpawns() {
    }

    public static final ArrayList<Biome> DEFAULT_PREDATOR_SPAWNS = new ArrayList<>();

    static {
        DEFAULT_PREDATOR_SPAWNS.addAll(
            Lists.newArrayList(
                Biomes.JUNGLE,
                Biomes.JUNGLE_EDGE,
                Biomes.JUNGLE_HILLS,
                Biomes.MUTATED_JUNGLE,
                Biomes.MUTATED_JUNGLE_EDGE
            )
        );
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        this.registerSpawns();
    }

    private void registerSpawns() {
        if (ModelConfig.getInstance().getSpawning().autoSpawnsEnabled) {
            List<Biome> predatorSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Predator", new ArrayList<>(ModelConfig.getInstance().getSpawning().getPredatorSpawnBiomes()));

            EntityRegistry.addSpawn(EntityYautjaWarrior.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityYautjaWarrior, 1, 1, PredatorCreatureTypes.getPredatorCreatureType(), EntitySpawnRegistryUtil.array(predatorSpawns));
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityYautjaBerserker, 1, 1, PredatorCreatureTypes.getPredatorCreatureType(), EntitySpawnRegistryUtil.array(predatorSpawns));
        }
    }
}
