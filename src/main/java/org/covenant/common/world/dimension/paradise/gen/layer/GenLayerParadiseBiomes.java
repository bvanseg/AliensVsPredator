package org.covenant.common.world.dimension.paradise.gen.layer;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

/**
 * @author Boston Vanseghi
 */
public class GenLayerParadiseBiomes extends GenLayer
{
    // TODO: Slowly convert these over to paradise-specific biomes.
    protected Biome[] allowedBiomes = { Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.PLAINS, Biomes.BEACH, Biomes.OCEAN, Biomes.DEEP_OCEAN };

    public GenLayerParadiseBiomes(long seed, GenLayer genlayer)
    {
        super(seed);
        this.parent = genlayer;
    }

    public GenLayerParadiseBiomes(long seed)
    {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] dest = IntCache.getIntCache(width * depth);

        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx < width; dx++)
            {
                this.initChunkSeed(dx + x, dz + z);
                dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
            }
        }

        return dest;
    }
}
