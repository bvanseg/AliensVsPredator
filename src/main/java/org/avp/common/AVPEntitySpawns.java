package org.avp.common;

import com.asx.mdx.common.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.avp.common.config.ModelConfig;
import org.avp.common.entity.MarineCreatureTypes;
import org.avp.common.entity.living.EntityMarine;
import org.lib.common.registry.EntitySpawnRegistryUtil;

import java.util.ArrayList;
import java.util.List;

public class AVPEntitySpawns implements IInitEvent {
    public static final AVPEntitySpawns instance = new AVPEntitySpawns();

    private AVPEntitySpawns() {
    }

    public static final ArrayList<Biome> DEFAULT_MARINE_SPAWNS = new ArrayList<>();

    static {
        DEFAULT_MARINE_SPAWNS.addAll(
                Lists.newArrayList(
                        Biomes.SWAMPLAND,
                        Biomes.FOREST,
                        Biomes.FOREST_HILLS,
                        Biomes.TAIGA,
                        Biomes.TAIGA_HILLS,
                        Biomes.PLAINS
                )
        );
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        this.registerSpawns();
    }

    private void registerSpawns() {
        if (ModelConfig.getInstance().getSpawning().autoSpawnsEnabled) {
            List<Biome> marineSpawns = new ArrayList<>(ModelConfig.getInstance().getSpawning().getMarineSpawnBiomes());

            EntityRegistry.addSpawn(EntityMarine.class, ModelConfig.getInstance().getSpawning().spawnWeightEntityMarine, 1, 1, MarineCreatureTypes.getMarineCreatureType(), EntitySpawnRegistryUtil.array(marineSpawns));
        }
    }
}
