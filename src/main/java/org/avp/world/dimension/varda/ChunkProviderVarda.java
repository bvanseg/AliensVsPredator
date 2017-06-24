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
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderVarda implements IChunkProvider, IChunkGenerator
{
    private Random                randomSeed;
    private World                 world;
    private double[]              noiseArray;
    private double[]              depthBuffer   = new double[256];

    private MapGenBase            caveGenerator = new VardaGenCaves();
    private Biome[]               biomesForGeneration;
    private float[]               parabolicField;

    private NoiseGeneratorOctaves surfaceNoise;
    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorOctaves scaleNoise;
    private NoiseGeneratorOctaves depthNoise;

    private double[]              main;
    private double[]              min;
    private double[]              max;
    private double[]              scale;
    private double[]              depth;

    public ChunkProviderVarda(World world)
    {
        this.world = world;
        this.randomSeed = new Random(world.getSeed());
        this.surfaceNoise = new NoiseGeneratorOctaves(this.randomSeed, 4);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.randomSeed, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.randomSeed, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.randomSeed, 8);
        this.scaleNoise = new NoiseGeneratorOctaves(this.randomSeed, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.randomSeed, 16);
        new NoiseGeneratorOctaves(this.randomSeed, 8);
    }

    public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer)
    {
        byte chunkSizeXZ = 4;
        byte chunkSizeY = 16;
        byte midHeight = 63;
        int kSize = chunkSizeXZ + 1;
        byte hSize = 17;
        int lSize = chunkSizeXZ + 1;
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, kSize + 5, lSize + 5);
        this.noiseArray = initializeNoiseField(this.noiseArray, chunkX * chunkSizeXZ, 0, chunkZ * chunkSizeXZ, kSize, hSize, lSize);

        for (int cX = 0; cX < chunkSizeXZ; cX++)
        {
            for (int cZ = 0; cZ < chunkSizeXZ; cZ++)
            {
                for (int cY = 0; cY < chunkSizeY; cY++)
                {
                    double var13 = 0.125D;
                    double var15 = this.noiseArray[(((cX + 0) * lSize + cZ + 0) * hSize + cY + 0)];
                    double var17 = this.noiseArray[(((cX + 0) * lSize + cZ + 1) * hSize + cY + 0)];
                    double var19 = this.noiseArray[(((cX + 1) * lSize + cZ + 0) * hSize + cY + 0)];
                    double var21 = this.noiseArray[(((cX + 1) * lSize + cZ + 1) * hSize + cY + 0)];
                    double var23 = (this.noiseArray[(((cX + 0) * lSize + cZ + 0) * hSize + cY + 1)] - var15) * var13;
                    double var25 = (this.noiseArray[(((cX + 0) * lSize + cZ + 1) * hSize + cY + 1)] - var17) * var13;
                    double var27 = (this.noiseArray[(((cX + 1) * lSize + cZ + 0) * hSize + cY + 1)] - var19) * var13;
                    double var29 = (this.noiseArray[(((cX + 1) * lSize + cZ + 1) * hSize + cY + 1)] - var21) * var13;

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
                int var12 = (int) (this.depthBuffer[(x + z * 16)] / 3.0D + 3.0D + this.randomSeed.nextDouble() * 0.25D);
                int var13 = -1;
                Block top = biome.topBlock.getBlock();
                Block fill = biome.fillerBlock.getBlock();

                for (int y = 127; y >= 0; y--)
                {
                    int blockX = x;
                    int blockZ = z;

                    if (y <= 0 + this.randomSeed.nextInt(5))
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
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        this.randomSeed.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(chunkX, chunkZ, chunkprimer);
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
        this.replaceBiomeBlocks(chunkX, chunkZ, chunkprimer, this.biomesForGeneration);
        this.caveGenerator.generate(this.world, chunkX, chunkZ, chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, chunkX, chunkZ);
        byte[] biomes = chunk.getBiomeArray();

        for (int x = 0; x < biomes.length; x++)
        {
            biomes[x] = (byte) Biome.getIdForBiome(this.biomesForGeneration[x]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] initializeNoiseField(double[] noiseArr, int offsetX, int offsetY, int offsetZ, int xSize, int ySize, int zSize)
    {
        if (noiseArr == null)
        {
            noiseArr = new double[xSize * ySize * zSize];
        }

        if (this.parabolicField == null)
        {
            this.parabolicField = new float[25];

            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= 2; z++)
                {
                    this.parabolicField[(x + 2 + (z + 2) * 5)] = 10.0F / MathHelper.sqrt(x * x + z * z + 0.2F);
                }
            }
        }

        double widthScale = 684.41200000000003D;
        double heightScale = 684.41200000000003D;
        this.scale = this.scaleNoise.generateNoiseOctaves(this.scale, offsetX, offsetZ, xSize, zSize, 1.121D, 1.121D, 0.5D);
        this.depth = this.depthNoise.generateNoiseOctaves(this.depth, offsetX, offsetZ, xSize, zSize, 200.0D, 200.0D, 0.5D);
        this.main = this.mainPerlinNoise.generateNoiseOctaves(this.main, offsetX, offsetY, offsetZ, xSize, ySize, zSize, widthScale / 80.0D, heightScale / 160.0D, widthScale / 80.0D);
        this.min = this.minLimitPerlinNoise.generateNoiseOctaves(this.min, offsetX, offsetY, offsetZ, xSize, ySize, zSize, widthScale, heightScale, widthScale);
        this.max = this.maxLimitPerlinNoise.generateNoiseOctaves(this.max, offsetX, offsetY, offsetZ, xSize, ySize, zSize, widthScale, heightScale, widthScale);
        int index = 0;
        int var15 = 0;

        for (int biomeX = 0; biomeX < xSize; biomeX++)
        {
            for (int biomeZ = 0; biomeZ < zSize; biomeZ++)
            {
                float heightVariation = 0.0F;
                float baseHeight = 0.0F;
                float multiplier = 0.0F;
                byte var21 = 2;
                Biome biomeForGen = this.biomesForGeneration[(biomeX + 2 + (biomeZ + 2) * (xSize + 5))];

                for (int subBiomeX = -var21; subBiomeX <= var21; subBiomeX++)
                {
                    for (int subBiomeZ = -var21; subBiomeZ <= var21; subBiomeZ++)
                    {
                        Biome subBiomeForGen = this.biomesForGeneration[(biomeX + subBiomeX + 2 + (biomeZ + subBiomeZ + 2) * (xSize + 5))];
                        float mult = this.parabolicField[(subBiomeX + 2 + (subBiomeZ + 2) * 5)] / (subBiomeForGen.getBaseHeight() + 2.0F);

                        if (subBiomeForGen.getBaseHeight() > biomeForGen.getBaseHeight())
                        {
                            mult /= 2.0F;
                        }

                        heightVariation += subBiomeForGen.getHeightVariation() * mult;
                        baseHeight += subBiomeForGen.getBaseHeight() * mult;
                        multiplier += mult;
                    }
                }

                heightVariation /= multiplier;
                baseHeight /= multiplier;
                heightVariation = heightVariation * 0.9F + 0.1F;
                baseHeight = (baseHeight * 4.0F - 1.0F) / 8.0F;
                double depth = this.depth[var15] / 8000.0D;

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

                var15++;

                for (int var46 = 0; var46 < ySize; var46++)
                {
                    double height = baseHeight;
                    height += depth * 0.2D;
                    height = height * ySize / 16.0D;
                    double var30 = ySize / 2.0D + height * 4.0D;
                    double noiseLevel = 0.0D;
                    double var34 = (var46 - var30) * 12.0D * 128.0D / 128.0D / heightVariation;

                    if (var34 < 0.0D)
                    {
                        var34 *= 4.0D;
                    }

                    double var36 = this.min[index] / 512.0D;
                    double var38 = this.max[index] / 512.0D;
                    double var40 = (this.main[index] / 10.0D + 1.0D) / 2.0D;

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

                    if (var46 > ySize - 4)
                    {
                        double var42 = (var46 - (ySize - 4)) / 3.0F;
                        noiseLevel = noiseLevel * (1.0D - var42) + -10.0D * var42;
                    }

                    noiseArr[index] = noiseLevel;
                    index++;
                }
            }
        }

        return noiseArr;
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
    public Chunk getLoadedChunk(int chunkX, int chunkZ)
    {
        return provideChunk(chunkX, chunkZ);
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

        biome.decorate(this.world, this.randomSeed, new BlockPos(posX, 0, posZ));
        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, posX + 8, posZ + 8, 16, 16, this.randomSeed);

        BlockSand.fallInstantly = false;
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
        // TODO Auto-generated method stub
        return false;
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
