package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import com.google.common.collect.Lists;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.avp.common.entity.living.EntityMarine;
import org.lib.registry.EntitySpawnRegistryUtil;

import java.util.ArrayList;
import java.util.List;

public class AVPEntitySpawns implements IInitEvent {
    public static final AVPEntitySpawns instance = new AVPEntitySpawns();

    private AVPEntitySpawns() {}
    protected static final ArrayList<Biome>        DEFAULT_MARINE_SPAWNS     = new ArrayList<>();

    static
    {
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

    private void registerSpawns()
    {
        if (AVPSettings.instance.areAutoSpawnsEnabled())
        {
            List<Biome> marineSpawns = AVPSettings.instance.getSpawnsMarine().value();

            EntityRegistry.addSpawn(EntityMarine.class, (Integer) AVPSettings.instance.spawnWeightEntityMarine.value(), 1, 1, EnumCreatureType.CREATURE, EntitySpawnRegistryUtil.array(marineSpawns));
        }
    }
}
