package org.predator.common.world.dimension.preserve.gen.layer;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

/**
 * @author Boston Vanseghi
 */
public class GenLayerPreserveBiomes extends GenLayer
{
    // TODO: Slowly convert these over to game preserve-specific biomes.
    protected Biome[] allowedBiomes = { Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE };

    public GenLayerPreserveBiomes(long seed, GenLayer genlayer)
    {
        super(seed);
        this.parent = genlayer;
    }

    public GenLayerPreserveBiomes(long seed)
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
