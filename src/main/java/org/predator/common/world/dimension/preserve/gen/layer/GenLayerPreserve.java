package org.predator.common.world.dimension.preserve.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

/**
 * @author Boston Vanseghi
 */
public abstract class GenLayerPreserve extends GenLayer
{
    protected GenLayerPreserve(long seed)
    {
        super(seed);
    }

    public static GenLayer[] generate(long seed)
    {
        GenLayer biomes = new GenLayerPreserveBiomes(1L);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);

        return new GenLayer[] { biomes, genlayervoronoizoom };
    }
}
