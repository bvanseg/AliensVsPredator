package org.prometheus.common;

import com.asx.mdx.common.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.alien.common.entity.AlienCreatureTypes;
import org.avp.common.config.ModelConfig;
import org.lib.common.registry.EntitySpawnRegistryUtil;
import org.prometheus.common.entity.living.engineer.EntityEngineer;
import org.prometheus.common.entity.living.engineer.EntitySpaceJockey;
import org.prometheus.common.entity.living.species223ode.EntityDeacon;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.prometheus.common.entity.living.vardic.EntityHammerpede;
import org.prometheus.common.entity.living.vardic.EntityOctohugger;
import org.prometheus.common.world.dimension.varda.BiomeVarda;

import java.util.ArrayList;
import java.util.List;

public class PrometheusEntitySpawns implements IInitEvent {
    public static final PrometheusEntitySpawns instance = new PrometheusEntitySpawns();

    private PrometheusEntitySpawns() {}

    public static final ArrayList<Biome> DEFAULT_VARDA_LIFE_SPAWNS = new ArrayList<>();

    static
    {
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
            List<Biome> vardaSpawns = EntitySpawnRegistryUtil.filterOverworldBiomes("Varda", new ArrayList<>(ModelConfig.getInstance().getSpawning().getVardaSpawnBiomes()));

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
