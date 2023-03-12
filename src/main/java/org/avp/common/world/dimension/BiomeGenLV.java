package org.avp.common.world.dimension;

import net.minecraft.world.biome.Biome;

public abstract class BiomeGenLV extends Biome
{
    public BiomeGenLV(BiomeProperties properties)
    {
        super(properties);
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}
