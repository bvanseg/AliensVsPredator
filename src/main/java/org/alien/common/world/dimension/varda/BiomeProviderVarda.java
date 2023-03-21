package org.alien.common.world.dimension.varda;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.common.world.dimension.varda.gen.layer.GenLayerVarda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BiomeProviderVarda extends BiomeProvider
{
    public static final List<BiomeVarda> ALLOWED_BIOMES = Arrays.asList(BiomeVarda.vardaBadlands, BiomeVarda.vardaForest);
    private GenLayer                    genBiomes;
    private GenLayer                    biomeIndexLayer;
    private final BiomeCache                  biomeCache;
    private final List<BiomeVarda>            biomesToSpawnIn;

    protected BiomeProviderVarda()
    {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList<>();
        this.biomesToSpawnIn.addAll(ALLOWED_BIOMES);
    }

    public BiomeProviderVarda(long seed, WorldType worldType)
    {
        this();
        GenLayer[] biomeLayer = GenLayerVarda.generate(seed);
        this.genBiomes = biomeLayer[0];
        this.biomeIndexLayer = biomeLayer[1];
    }

    public BiomeProviderVarda(World world)
    {
        this(world.getSeed(), world.getWorldInfo().getTerrainType());
    }

    @Override
    public List getBiomesToSpawnIn()
    {
        return this.biomesToSpawnIn;
    }

    @Override
    public Biome getBiome(BlockPos pos)
    {
        return this.biomeCache.getBiome(pos.getX(), pos.getY(), BiomeVarda.vardaBadlands);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(float temperature, int height)
    {
        return temperature;
    }


    @Override
    public Biome[] getBiomesForGeneration(Biome[] biomeList, int posX, int posZ, int width, int length)
    {
        return this.getBiomes(biomeList, posX, posZ, width, length, true);
    }
    
    @Override
    public Biome[] getBiomes(Biome[] biomes, int chunkX, int chunkZ, int width, int depth, boolean cacheFlag)
    {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < width * depth)
        {
            biomes = new Biome[width * depth];
        }

        if (cacheFlag && width == 16 && depth == 16 && (chunkX & 15) == 0 && (chunkZ & 15) == 0)
        {
            Biome[] aBiome1 = this.biomeCache.getCachedBiomes(chunkX, chunkZ);
            System.arraycopy(aBiome1, 0, biomes, 0, width * depth);
            return biomes;
        }
        else
        {
            int[] indexes = this.biomeIndexLayer.getInts(chunkX, chunkZ, width, depth);

            for (int idx = 0; idx < width * depth; ++idx)
            {
                biomes[idx] = BiomeVarda.getBiome(indexes[idx]);
            }

            return biomes;
        }
    }

    @Override
    public boolean areBiomesViable(int chunkX, int chunkZ, int radius, List allowedBiomes)
    {
        IntCache.resetIntCache();
        int chunkMinX = chunkX - radius >> 2;
        int chunkMinZ = chunkZ - radius >> 2;
        int chunkMaxX = chunkX + radius >> 2;
        int chunkMaxZ = chunkZ + radius >> 2;
        int width = chunkMaxX - chunkMinX + 1;
        int depth = chunkMaxZ - chunkMinZ + 1;
        int[] indexes = this.genBiomes.getInts(chunkMinX, chunkMinZ, width, depth);

        try
        {
            for (int idx = 0; idx < width * depth; ++idx)
            {
                Biome b = Biome.getBiome(indexes[idx]);

                if (!allowedBiomes.contains(b))
                {
                    return false;
                }
            }

            return true;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(chunkX));
            crashreportcategory.addCrashSection("z", Integer.valueOf(chunkZ));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowedBiomes);
            throw new ReportedException(crashreport);
        }
    }

    @Override
    public BlockPos findBiomePosition(int chunkX, int chunkZ, int radius, List<Biome> biomes, Random seed)
    {
        IntCache.resetIntCache();
        int chunkMinX = chunkX - radius >> 2;
        int chunkMinZ = chunkZ - radius >> 2;
        int chunkMaxX = chunkX + radius >> 2;
        int chunkMaxZ = chunkZ + radius >> 2;
        int width = chunkMaxX - chunkMinX + 1;
        int depth = chunkMaxZ - chunkMinZ + 1;
        int[] indexes = this.genBiomes.getInts(chunkMinX, chunkMinZ, width, depth);
        BlockPos chunkposition = null;
        int count = 0;

        for (int idx = 0; idx < width * depth; ++idx)
        {
            int biomeChunkX = chunkMinX + idx % width << 2;
            int biomeChunkZ = chunkMinZ + idx / width << 2;
            Biome biomegen = Biome.getBiome(indexes[idx]);

            if (biomes.contains(biomegen) && (chunkposition == null || seed.nextInt(count + 1) == 0))
            {
                chunkposition = new BlockPos(biomeChunkX, 0, biomeChunkZ);
                ++count;
            }
        }

        return chunkposition;
    }

    @Override
    public void cleanupCache()
    {
        this.biomeCache.cleanupCache();
    }
}
