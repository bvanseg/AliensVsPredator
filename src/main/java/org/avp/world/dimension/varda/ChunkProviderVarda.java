package org.avp.world.dimension.varda;

import java.util.List;
import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.world.dimension.varda.gen.VardaGenCaves;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderVarda implements IChunkGenerator
{
    private Random                seed;
    private World                 world;
    private double[]              heightMap;
    private double[]              depthBuffer;
    private Biome[]               biomes;
    private float[]               biomeWeights;

    private NoiseGeneratorOctaves surfaceNoise;
    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorOctaves depthNoise;

    private double[]              mainRegion;
    private double[]              minRegion;
    private double[]              maxRegion;
    private double[]              depthRegion;

    private MapGenBase            caveGenerator = new VardaGenCaves();

    public ChunkProviderVarda(World world)
    {
        this.world = world;
        this.seed = new Random(world.getSeed());
        this.surfaceNoise = new NoiseGeneratorOctaves(this.seed, 4);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.seed, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.seed, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.seed, 8);
        this.depthNoise = new NoiseGeneratorOctaves(this.seed, 16);
        this.depthBuffer = new double[256];
        this.biomeWeights = new float[25];

        for (int x = -2; x <= 2; x++)
        {
            for (int z = -2; z <= 2; z++)
            {
                this.biomeWeights[(x + 2 + (z + 2) * 5)] = 10.0F / MathHelper.sqrt(x * x + z * z + 0.2F);
            }
        }
    }

    private double[] generateHeightmap(int offsetX, int offsetY, int offsetZ, int xSize, int ySize, int zSize)
    {
        if (this.heightMap == null)
        {
            this.heightMap = new double[xSize * ySize * zSize];
        }

        double coordinateScale = 684.41200000000003D;
        double heightScale = 684.41200000000003D;
        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, offsetX, offsetZ, xSize, zSize, 200.0D, 200.0D, 0.5D);
        this.mainRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainRegion, offsetX, offsetY, offsetZ, xSize, ySize, zSize, coordinateScale / 80.0D, heightScale / 160.0D, coordinateScale / 80.0D);
        this.minRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minRegion, offsetX, offsetY, offsetZ, xSize, ySize, zSize, coordinateScale, heightScale, coordinateScale);
        this.maxRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxRegion, offsetX, offsetY, offsetZ, xSize, ySize, zSize, coordinateScale, heightScale, coordinateScale);
        int index = 0;
        int depthIndex = 0;

        for (int x1 = 0; x1 < xSize; x1++)
        {
            for (int z1 = 0; z1 < zSize; z1++)
            {
                float heightVariation = 0.0F;
                float baseHeight = 0.0F;
                float weight = 0.0F;
                Biome biome1 = this.biomes[(x1 + 2 + (z1 + 2) * (xSize + 5))];

                for (int subBiomeX = -2; subBiomeX <= 2; subBiomeX++)
                {
                    for (int subBiomeZ = -2; subBiomeZ <= 2; subBiomeZ++)
                    {
                        Biome biome2 = this.biomes[(x1 + subBiomeX + 2 + (z1 + subBiomeZ + 2) * (xSize + 5))];
                        float biomeWeight = this.biomeWeights[(subBiomeX + 2 + (subBiomeZ + 2) * 5)] / (biome2.getBaseHeight() + 2.0F);

                        if (biome2.getBaseHeight() > biome1.getBaseHeight())
                        {
                            biomeWeight /= 2.0F;
                        }

                        heightVariation += biome2.getHeightVariation() * biomeWeight;
                        baseHeight += biome2.getBaseHeight() * biomeWeight;
                        weight += biomeWeight;
                    }
                }

                heightVariation /= weight;
                baseHeight /= weight;
                heightVariation = heightVariation * 0.9F + 0.1F;
                baseHeight = (baseHeight * 4.0F - 1.0F) / 8.0F;
                double depth = this.depthRegion[depthIndex] / 8000.0D;

                if (depth < 0.0D)
                {
                    depth = -depth * 0.3D;
                }

                depth = depth * 3.0D - 2.0D;

                if (depth < 0.0D)
                {
                    depth /= 2.0D;

                    if (depth < -1.0D)
                    {
                        depth = -1.0D;
                    }

                    depth /= 1.4D;
                    depth /= 2.0D;
                }
                else
                {
                    if (depth > 1.0D)
                    {
                        depth = 1.0D;
                    }

                    depth /= 8.0D;
                }

                depthIndex++;

                double lowerLimitScale = 512;
                double upperLimitScale = 512;

                for (int yLevel = 0; yLevel < ySize; yLevel++)
                {
                    double height = baseHeight;
                    height += depth * 0.2D;
                    height = height * ySize / 16.0D;
                    double var30 = ySize / 2.0D + height * 4.0D;
                    double noiseLevel = 0.0D;
                    double var34 = (yLevel - var30) * 12.0D * 128.0D / 128.0D / heightVariation;

                    if (var34 < 0.0D)
                    {
                        var34 *= 4.0D;
                    }

                    double var36 = this.minRegion[index] / lowerLimitScale;
                    double var38 = this.maxRegion[index] / upperLimitScale;
                    double var40 = (this.mainRegion[index] / 10.0D + 1.0D) / 2.0D;

                    if (var40 < 0.0D)
                    {
                        noiseLevel = var36;
                    }
                    else if (var40 > 1.0D)
                    {
                        noiseLevel = var38;
                    }
                    else
                    {
                        noiseLevel = var36 + (var38 - var36) * var40;
                    }

                    noiseLevel -= var34;

                    if (yLevel > ySize - 4)
                    {
                        double var42 = (yLevel - (ySize - 4)) / 3.0F;
                        noiseLevel = noiseLevel * (1.0D - var42) + -10.0D * var42;
                    }

                    heightMap[index] = noiseLevel;
                    index++;
                }
            }
        }

        return heightMap;
    }

    public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer)
    {
        byte chunkSizeXZ = 4;
        byte chunkSizeY = 16;
        byte midHeight = 63;
        int kSize = chunkSizeXZ + 1;
        byte hSize = 17;
        int lSize = chunkSizeXZ + 1;
        this.biomes = this.world.getBiomeProvider().getBiomesForGeneration(this.biomes, chunkX * 4 - 2, chunkZ * 4 - 2, kSize + 5, lSize + 5);
        this.generateHeightmap(chunkX * chunkSizeXZ, 0, chunkZ * chunkSizeXZ, kSize, hSize, lSize);

        for (int cX = 0; cX < chunkSizeXZ; cX++)
        {
            for (int cZ = 0; cZ < chunkSizeXZ; cZ++)
            {
                for (int cY = 0; cY < chunkSizeY; cY++)
                {
                    double var13 = 0.125D;
                    double var15 = this.heightMap[(((cX + 0) * lSize + cZ + 0) * hSize + cY + 0)];
                    double var17 = this.heightMap[(((cX + 0) * lSize + cZ + 1) * hSize + cY + 0)];
                    double var19 = this.heightMap[(((cX + 1) * lSize + cZ + 0) * hSize + cY + 0)];
                    double var21 = this.heightMap[(((cX + 1) * lSize + cZ + 1) * hSize + cY + 0)];
                    double var23 = (this.heightMap[(((cX + 0) * lSize + cZ + 0) * hSize + cY + 1)] - var15) * var13;
                    double var25 = (this.heightMap[(((cX + 0) * lSize + cZ + 1) * hSize + cY + 1)] - var17) * var13;
                    double var27 = (this.heightMap[(((cX + 1) * lSize + cZ + 0) * hSize + cY + 1)] - var19) * var13;
                    double var29 = (this.heightMap[(((cX + 1) * lSize + cZ + 1) * hSize + cY + 1)] - var21) * var13;

                    for (int eY = 0; eY < 8; eY++)
                    {
                        double var32 = 0.25D;
                        double var34 = var15;
                        double var36 = var17;
                        double var38 = (var19 - var15) * var32;

                        for (int eX = 0; eX < 4; eX++)
                        {
                            double var45 = 0.25D;
                            double var47 = (var36 - var34) * var45;
                            double var49 = var34 - var47;

                            for (int eZ = 0; eZ < 4; eZ++)
                            {
                                if ((var49 += var47) > 0.0D)
                                {
                                    primer.setBlockState(cX * 4 + eX, cY * 8 + eY, cZ * 4 + eZ, AliensVsPredator.blocks().unistone.getDefaultState());
                                }
                                else if (cY * 8 + eY < midHeight)
                                {
                                    primer.setBlockState(cX * 4 + eX, cY * 8 + eY, cZ * 4 + eZ, Blocks.WATER.getDefaultState());
                                }
                                else
                                {
                                    primer.setBlockState(cX * 4 + eX, cY * 8 + eY, cZ * 4 + eZ, Blocks.AIR.getDefaultState());
                                }
                            }

                            var34 += var38;
                        }

                        var15 += var23;
                        var17 += var25;
                        var19 += var27;
                        var21 += var29;
                    }
                }
            }
        }
    }

    public void replaceBiomeBlocks(int chunkX, int chunkZ, ChunkPrimer primer, Biome[] biomes)
    {
        byte var5 = 63;
        double var6 = 0.03125D;
        this.depthBuffer = this.surfaceNoise.generateNoiseOctaves(this.depthBuffer, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                Biome biome = biomes[(z + x * 16)];
                int var12 = (int) (this.depthBuffer[(x + z * 16)] / 3.0D + 3.0D + this.seed.nextDouble() * 0.25D);
                int var13 = -1;
                Block top = biome.topBlock.getBlock();
                Block fill = biome.fillerBlock.getBlock();

                for (int y = 127; y >= 0; y--)
                {
                    int blockX = x;
                    int blockZ = z;

                    if (y <= 0 + this.seed.nextInt(5))
                    {
                        primer.setBlockState(blockX, y, blockZ, Blocks.BEDROCK.getDefaultState());
                    }
                    else
                    {
                        Block block = primer.getBlockState(blockX, y, blockZ).getBlock();

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
                                    fill = AliensVsPredator.blocks().unistone;
                                }
                                else if ((y >= var5 - 4) && (y <= var5 + 1))
                                {
                                    top = biome.topBlock.getBlock();
                                    fill = biome.fillerBlock.getBlock();
                                }

                                if ((y < var5) && (top == Blocks.AIR))
                                {
                                    top = Blocks.WATER;
                                }

                                var13 = var12;

                                if (y >= var5 - 1)
                                {
                                    primer.setBlockState(blockX, y, blockZ, top.getDefaultState());
                                }
                                else
                                {
                                    primer.setBlockState(blockX, y, blockZ, fill.getDefaultState());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void populate(int chunkX, int chunkZ)
    {
        BlockSand.fallInstantly = true;
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        Biome biome = this.world.getBiomeForCoordsBody(new BlockPos(posX + 16, 0, posZ + 16));
        this.seed.setSeed(this.world.getSeed());
        this.seed.setSeed(chunkX * (this.seed.nextLong() / 2L * 2L + 1L) + chunkZ * (this.seed.nextLong() / 2L * 2L + 1L) ^ this.world.getSeed());

        biome.decorate(this.world, this.seed, new BlockPos(posX, 0, posZ));
        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, posX + 8, posZ + 8, 16, 16, this.seed);

        BlockSand.fallInstantly = false;
    }

    @Override
    public Chunk generateChunk(int chunkX, int chunkZ)
    {
        this.seed.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(chunkX, chunkZ, chunkprimer);
        this.biomes = this.world.getBiomeProvider().getBiomes(this.biomes, chunkX * 16, chunkZ * 16, 16, 16);
        this.replaceBiomeBlocks(chunkX, chunkZ, chunkprimer, this.biomes);
        this.caveGenerator.generate(this.world, chunkX, chunkZ, chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, chunkX, chunkZ);
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        Biome biome = this.world.getBiome(pos);
        return biome == null ? null : biome.getSpawnableList(creatureType);
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
        return false;
    }

    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored)
    {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z)
    {
        return;
    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos)
    {
        return false;
    }
}
