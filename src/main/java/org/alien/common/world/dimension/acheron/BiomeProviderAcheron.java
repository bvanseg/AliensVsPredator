package org.alien.common.world.dimension.acheron;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("all")
public class BiomeProviderAcheron extends BiomeProvider
{
    private Biome biome;
    private float hellTemperature;
    private float rainfall;

    public BiomeProviderAcheron(Biome biome)
    {
        this.biome = biome;
    }
    
    @Override
    public Biome getBiome(BlockPos pos, Biome defaultBiome)
    {
        return super.getBiome(pos, defaultBiome);
    }

    @Override
    public Biome[] getBiomesForGeneration(Biome[] biomeList, int posX, int posZ, int width, int length)
    {
        return this.getBiomes(biomeList, posX, posZ, width, length, true);
    }
    
    @Override
    public Biome[] getBiomes(Biome[] biomeList, int posX, int posZ, int width, int length, boolean cacheFlag)
    {
        if ((biomeList == null) || (biomeList.length < width * length))
        {
            biomeList = new Biome[width * length];
        }

        Arrays.fill(biomeList, 0, width * length, this.biome);
        return biomeList;
    }
    
    @Override
    public float getTemperatureAtHeight(float temp, int height)
    {
        return super.getTemperatureAtHeight(temp, height);
    }

    @Override
    public BlockPos findBiomePosition(int posX, int posZ, int range, List<Biome> biomes, Random seed)
    {
        return biomes.contains(this.biome) ? new BlockPos(posX - posZ + seed.nextInt(posZ * 2 + 1), 0, posZ + seed.nextInt(posZ * 2 + 1)) : null;
    }
    
    @Override
    public boolean areBiomesViable(int posX, int posY, int posZ, List biomeList)
    {
        return biomeList.contains(this.biome);
    }
}
