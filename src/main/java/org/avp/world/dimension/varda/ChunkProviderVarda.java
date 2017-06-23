package org.avp.world.dimension.varda;

import java.util.List;
import java.util.Random;

import org.avp.AliensVsPredator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderVarda implements IChunkProvider, IChunkGenerator
{
//	private NoiseGeneratorOctaves[] noiseGenOctaves = new NoiseGeneratorOctaves[6];
	
	private Random randomSeed;
	private World world;
    private ChunkProviderSettings settings;
	private double[] heightMap;
//	private double[] stoneNoise = new double[256];

	private Biome[] biomesForGeneration;
//	private double[] noise3;
//	private double[] noise1;
//	private double[] noise2;
//	private double[] noise5;
//	private double[] noise6;
//	private float[] field_35388_l;
	
    private final WorldType terrainType;

    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorOctaves surfaceNoise;
    public NoiseGeneratorOctaves scaleNoise;
    public NoiseGeneratorOctaves depthNoise;
	
	private IBlockState oceanBlock;
    double[] mainNoiseRegion;
    double[] minLimitRegion;
    double[] maxLimitRegion;
    double[] depthRegion;
    private final float[] biomeWeights;
    private double[] depthBuffer = new double[256];

	public ChunkProviderVarda(World world, long seed, String generatorSettings)
	{
		this.world = world;
		this.randomSeed = new Random(seed);
        this.terrainType = world.getWorldInfo().getTerrainType();
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.randomSeed, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.randomSeed, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.randomSeed, 8);
        this.surfaceNoise = new NoiseGeneratorOctaves(this.randomSeed, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.randomSeed, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.randomSeed, 16);

        if (generatorSettings != null)
        {
            this.settings = ChunkProviderSettings.Factory.jsonToFactory(generatorSettings).build();
            this.oceanBlock = this.settings.useLavaOceans ? Blocks.LAVA.getDefaultState() : Blocks.WATER.getDefaultState();
            world.setSeaLevel(this.settings.seaLevel);
        }
        
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];

        for (int x = -2; x <= 2; ++x)
        {
            for (int z = -2; z <= 2; ++z)
            {
                float f = 10.0F / MathHelper.sqrt((float)(x * x + z * z) + 0.2F);
                this.biomeWeights[x + 2 + (z + 2) * 5] = f;
            }
        }
	}

    private void generateHeightmap(int p_185978_1_, int p_185978_2_, int p_185978_3_)
    {
        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, p_185978_1_, p_185978_3_, 5, 5, (double)this.settings.depthNoiseScaleX, (double)this.settings.depthNoiseScaleZ, (double)this.settings.depthNoiseScaleExponent);
        float f = this.settings.coordinateScale;
        float f1 = this.settings.heightScale;
        this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5, (double)(f / this.settings.mainNoiseScaleX), (double)(f1 / this.settings.mainNoiseScaleY), (double)(f / this.settings.mainNoiseScaleZ));
        this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5, (double)f, (double)f1, (double)f);
        this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, p_185978_1_, p_185978_2_, p_185978_3_, 5, 33, 5, (double)f, (double)f1, (double)f);
        int i = 0;
        int j = 0;

        for (int k = 0; k < 5; ++k)
        {
            for (int l = 0; l < 5; ++l)
            {
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;
                int i1 = 2;
                Biome biome = this.biomesForGeneration[k + 2 + (l + 2) * 10];

                for (int j1 = -2; j1 <= 2; ++j1)
                {
                    for (int k1 = -2; k1 <= 2; ++k1)
                    {
                        Biome biome1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
                        float f5 = this.settings.biomeDepthOffSet + biome1.getBaseHeight() * this.settings.biomeDepthWeight;
                        float f6 = this.settings.biomeScaleOffset + biome1.getHeightVariation() * this.settings.biomeScaleWeight;

                        if (this.terrainType == WorldType.AMPLIFIED && f5 > 0.0F)
                        {
                            f5 = 1.0F + f5 * 2.0F;
                            f6 = 1.0F + f6 * 4.0F;
                        }

                        float f7 = this.biomeWeights[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);

                        if (biome1.getBaseHeight() > biome.getBaseHeight())
                        {
                            f7 /= 2.0F;
                        }

                        f2 += f6 * f7;
                        f3 += f5 * f7;
                        f4 += f7;
                    }
                }

                f2 = f2 / f4;
                f3 = f3 / f4;
                f2 = f2 * 0.9F + 0.1F;
                f3 = (f3 * 4.0F - 1.0F) / 8.0F;
                double d7 = this.depthRegion[j] / 8000.0D;

                if (d7 < 0.0D)
                {
                    d7 = -d7 * 0.3D;
                }

                d7 = d7 * 3.0D - 2.0D;

                if (d7 < 0.0D)
                {
                    d7 = d7 / 2.0D;

                    if (d7 < -1.0D)
                    {
                        d7 = -1.0D;
                    }

                    d7 = d7 / 1.4D;
                    d7 = d7 / 2.0D;
                }
                else
                {
                    if (d7 > 1.0D)
                    {
                        d7 = 1.0D;
                    }

                    d7 = d7 / 8.0D;
                }

                ++j;
                double d8 = (double)f3;
                double d9 = (double)f2;
                d8 = d8 + d7 * 0.2D;
                d8 = d8 * (double)this.settings.baseSize / 8.0D;
                double d0 = (double)this.settings.baseSize + d8 * 4.0D;

                for (int l1 = 0; l1 < 33; ++l1)
                {
                    double d1 = ((double)l1 - d0) * (double)this.settings.stretchY * 128.0D / 256.0D / d9;

                    if (d1 < 0.0D)
                    {
                        d1 *= 4.0D;
                    }

                    double d2 = this.minLimitRegion[i] / (double)this.settings.lowerLimitScale;
                    double d3 = this.maxLimitRegion[i] / (double)this.settings.upperLimitScale;
                    double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
                    double d5 = MathHelper.clamp(d2, d3, d4) - d1;

                    if (l1 > 29)
                    {
                        double d6 = (double)((float)(l1 - 29) / 3.0F);
                        d5 = d5 * (1.0D - d6) + -10.0D * d6;
                    }

                    this.heightMap[i] = d5;
                    ++i;
                }
            }
        }
    }

    public void setBlocksInChunk(int x, int z, ChunkPrimer primer)
    {
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        this.generateHeightmap(x * 4, 0, z * 4);

//        byte var4 = 4;
//        int var7 = var4 + 1;
//        byte var8 = 17;
//        int var9 = var4 + 1;
//        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
//        this.heightMap = this.generateHeightmap(this.heightMap, x * var4, 0, z * var4, var7, var8, var9);

        for (int i = 0; i < 4; ++i)
        {
            int j = i * 5;
            int k = (i + 1) * 5;

            for (int l = 0; l < 4; ++l)
            {
                int i1 = (j + l) * 33;
                int j1 = (j + l + 1) * 33;
                int k1 = (k + l) * 33;
                int l1 = (k + l + 1) * 33;

                for (int i2 = 0; i2 < 32; ++i2)
                {
                    double d0 = 0.125D;
                    double d1 = this.heightMap[i1 + i2];
                    double d2 = this.heightMap[j1 + i2];
                    double d3 = this.heightMap[k1 + i2];
                    double d4 = this.heightMap[l1 + i2];
                    double d5 = (this.heightMap[i1 + i2 + 1] - d1) * 0.125D;
                    double d6 = (this.heightMap[j1 + i2 + 1] - d2) * 0.125D;
                    double d7 = (this.heightMap[k1 + i2 + 1] - d3) * 0.125D;
                    double d8 = (this.heightMap[l1 + i2 + 1] - d4) * 0.125D;

                    for (int j2 = 0; j2 < 8; ++j2)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.25D;
                        double d13 = (d4 - d2) * 0.25D;

                        for (int k2 = 0; k2 < 4; ++k2)
                        {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * 0.25D;
                            double lvt_45_1_ = d10 - d16;

                            for (int l2 = 0; l2 < 4; ++l2)
                            {
                                if ((lvt_45_1_ += d16) > 0.0D)
                                {
                                    primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, AliensVsPredator.blocks().unistone.getDefaultState());
                                }
                                else if (i2 * 8 + j2 < 60)
                                {
                                    primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, this.oceanBlock);
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

//	public void replaceBlocksForBiome(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
//	{
//	}

	//TODO: Expirimental coords on setBlockState()
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
    {
        byte var5 = 63;
        double var6 = 0.03125D;
        this.depthBuffer = this.surfaceNoise.generateNoiseOctaves(this.depthBuffer, x * 16, z * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

        for (int blockX = 0; blockX < 16; blockX++)
        {
            for (int blockZ = 0; blockZ < 16; blockZ++)
            {
                Biome biome = biomesIn[(blockZ + blockX * 16)];
                int var12 = (int) (this.depthBuffer[(blockX + blockZ * 16)] / 3.0D + 3.0D + this.randomSeed.nextDouble() * 0.25D);
                int var13 = -1;
                Block top = biome.topBlock.getBlock();
                Block filler = biome.fillerBlock.getBlock();

                for (int blockY = 127; blockY >= 0; blockY--)
                {
                    int idx = (blockZ * 16 + blockX) * 128 + blockY;

                    if (blockY <= 0 + this.randomSeed.nextInt(5))
                    {
                        primer.setBlockState(blockX, blockY, blockZ, Blocks.BEDROCK.getDefaultState());
                    }
                    else
                    {
                        Block block = primer.getBlockState(blockX, blockY, blockZ).getBlock();

                        if (block == Blocks.AIR)
                        {
                            var13 = -1;
                        }
                        else
                        {
                            if (block == Blocks.STONE)
                                continue;
                            if (var13 == -1)
                            {
                                if (var12 <= 0)
                                {
                                    top = Blocks.AIR;
                                    filler = AliensVsPredator.blocks().unistone;
                                }
                                else if ((blockY >= var5 - 4) && (blockY <= var5 + 1))
                                {
                                    top = biome.topBlock.getBlock();
                                    filler = biome.fillerBlock.getBlock();
                                }

                                if ((blockY < var5) && (top == Blocks.AIR))
                                {
                                    top = Blocks.WATER;
                                }

                                var13 = var12;

                                if (blockY >= var5 - 1)
                                {
                                    primer.setBlockState(blockX, blockY, blockZ, top.getDefaultState());
                                }
                                else
                                {
                                    primer.setBlockState(blockX, blockY, blockZ, filler.getDefaultState());
                                }
                            }
                            else
                            {
                                if (var13 <= 0)
                                    continue;
                                var13--;
                                primer.setBlockState(blockX, blockY, blockZ, filler.getDefaultState());

                                if ((var13 != 0) || (filler != Blocks.SAND))
                                    continue;
                                var13 = this.randomSeed.nextInt(4);
                                filler = Blocks.SANDSTONE;
                            }
                        }
                    }
                }
            }
        }
//        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (double)(x * 16), (double)(z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);
//
//        for (int i = 0; i < 16; ++i)
//        {
//            for (int j = 0; j < 16; ++j)
//            {
//                Biome biome = biomesIn[j + i * 16];
//                biome.genTerrainBlocks(this.world, this.randomSeed, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
//            }
//        }
    }

	@Override
	public Chunk getLoadedChunk(int chunkX, int chunkZ)
	{
		return provideChunk(chunkX, chunkZ);
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ)
	{
		this.randomSeed.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(chunkX, chunkZ, chunkprimer);
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBiomeBlocks(chunkX, chunkZ, chunkprimer, this.biomesForGeneration);

		Chunk chunk = new Chunk(this.world, chunkprimer, chunkX, chunkZ);
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public String makeString()
	{
		return "RandomLevelSource";
	}
	
	@Override
	public boolean tick()
	{
		return false;
	}

    @Override
    public void populate(int chunkX, int chunkZ)
    {
        BlockSand.fallInstantly = true;
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        Biome biome = this.world.getBiomeForCoordsBody(new BlockPos(posX + 16, 0, posZ + 16));
        this.randomSeed.setSeed(this.world.getSeed());
        this.randomSeed.setSeed(chunkX * (this.randomSeed.nextLong() / 2L * 2L + 1L) + chunkZ * (this.randomSeed.nextLong() / 2L * 2L + 1L) ^ this.world.getSeed());

        biome.decorate(this.world, this.randomSeed, new BlockPos(chunkX, 0, chunkZ));
        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, posX + 8, posZ + 8, 16, 16, this.randomSeed);
        
        BlockSand.fallInstantly = false;
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z)
    {
        // TODO Auto-generated method stub
        
    }
}
