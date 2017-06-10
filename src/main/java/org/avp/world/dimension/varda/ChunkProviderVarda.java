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

//TODO: This looks ugly
public class ChunkProviderVarda implements IChunkProvider, IChunkGenerator
{
    private NoiseGeneratorOctaves[] noiseGenOctaves = new NoiseGeneratorOctaves[6];
    private Random                  randomSeed;
    private World                   world;
    private double[]                noiseArray;
    private double[]                stoneNoise      = new double[256];

    private MapGenBase              caveGenerator   = new VardaGenCaves();
    private Biome[]                 biomesForGeneration;
    private double[]                noise3;
    private double[]                noise1;
    private double[]                noise2;
    private double[]                noise5;
    private double[]                noise6;
    private float[]                 field_35388_l;

    public ChunkProviderVarda(World world)
    {
        this.world = world;
        this.randomSeed = new Random(world.getSeed());
        this.noiseGenOctaves[0] = new NoiseGeneratorOctaves(this.randomSeed, 16);
        this.noiseGenOctaves[1] = new NoiseGeneratorOctaves(this.randomSeed, 16);
        this.noiseGenOctaves[2] = new NoiseGeneratorOctaves(this.randomSeed, 8);
        this.noiseGenOctaves[3] = new NoiseGeneratorOctaves(this.randomSeed, 4);
        this.noiseGenOctaves[4] = new NoiseGeneratorOctaves(this.randomSeed, 10);
        this.noiseGenOctaves[5] = new NoiseGeneratorOctaves(this.randomSeed, 16);
        new NoiseGeneratorOctaves(this.randomSeed, 8);
    }

    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer primer)
    {
        byte var4 = 4;
        byte var5 = 16;
        byte var6 = 63;
        int var7 = var4 + 1;
        byte var8 = 17;
        int var9 = var4 + 1;
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, var7 + 5, var9 + 5);
        this.noiseArray = initializeNoiseField(this.noiseArray, chunkX * var4, 0, chunkZ * var4, var7, var8, var9);

        for (int sX = 0; sX < var4; sX++)
        {
            for (int sZ = 0; sZ < var4; sZ++)
            {
                for (int sY = 0; sY < var5; sY++)
                {
                    double var13 = 0.125D;
                    double var15 = this.noiseArray[(((sX + 0) * var9 + sZ + 0) * var8 + sY + 0)];
                    double var17 = this.noiseArray[(((sX + 0) * var9 + sZ + 1) * var8 + sY + 0)];
                    double var19 = this.noiseArray[(((sX + 1) * var9 + sZ + 0) * var8 + sY + 0)];
                    double var21 = this.noiseArray[(((sX + 1) * var9 + sZ + 1) * var8 + sY + 0)];
                    double var23 = (this.noiseArray[(((sX + 0) * var9 + sZ + 0) * var8 + sY + 1)] - var15) * var13;
                    double var25 = (this.noiseArray[(((sX + 0) * var9 + sZ + 1) * var8 + sY + 1)] - var17) * var13;
                    double var27 = (this.noiseArray[(((sX + 1) * var9 + sZ + 0) * var8 + sY + 1)] - var19) * var13;
                    double var29 = (this.noiseArray[(((sX + 1) * var9 + sZ + 1) * var8 + sY + 1)] - var21) * var13;

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
                                    primer.setBlockState(sX * 4 + eX, sY * 8 + eY, sZ * 4 + eZ, AliensVsPredator.blocks().unistone.getDefaultState());
                                }
                                else if (sY * 8 + eY < var6)
                                {
                                    primer.setBlockState(sX * 4 + eX, sY * 8 + eY, sZ * 4 + eZ, Blocks.WATER.getDefaultState());
                                }
                                else
                                {
                                    primer.setBlockState(sX * 4 + eX, sY * 8 + eY, sZ * 4 + eZ, Blocks.AIR.getDefaultState());
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
        this.stoneNoise = this.noiseGenOctaves[3].generateNoiseOctaves(this.stoneNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                Biome b = biomes[(z + x * 16)];
                int blockX = chunkX * 16 + x;
                int blockZ = chunkZ * 16 + z;
                int var12 = (int) (this.stoneNoise[(x + z * 16)] / 3.0D + 3.0D + this.randomSeed.nextDouble() * 0.25D);
                int var13 = -1;
                Block top = b.topBlock.getBlock();
                Block fill = b.fillerBlock.getBlock();

                for (int y = 127; y >= 0; y--)
                {
                    // int idx = (startZ * 16 + startX) * 128 + startY;

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
                                    top = b.topBlock.getBlock();
                                    fill = b.fillerBlock.getBlock();
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
                            else
                            {
                                if (var13 <= 0)
                                    continue;
                                var13--;
                                primer.setBlockState(blockX, y, blockZ, fill.getDefaultState());

                                if ((var13 != 0) || (fill != Blocks.SAND))
                                    continue;
                                var13 = this.randomSeed.nextInt(4);
                                fill = Blocks.SANDSTONE;
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
//        Block[] blocks = new Block[16 * 16 * 128];
        this.randomSeed.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.generateTerrain(chunkX, chunkZ, chunkprimer);
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

    private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        if (var1 == null)
        {
            var1 = new double[var5 * var6 * var7];
        }

        if (this.field_35388_l == null)
        {
            this.field_35388_l = new float[25];

            for (int var8 = -2; var8 <= 2; var8++)
            {
                for (int var9 = -2; var9 <= 2; var9++)
                {
                    float var10 = 10.0F / MathHelper.sqrt(var8 * var8 + var9 * var9 + 0.2F);
                    this.field_35388_l[(var8 + 2 + (var9 + 2) * 5)] = var10;
                }
            }
        }

        double var44 = 684.41200000000003D;
        double var45 = 684.41200000000003D;
        this.noise5 = this.noiseGenOctaves[4].generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.noise6 = this.noiseGenOctaves[5].generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        this.noise3 = this.noiseGenOctaves[2].generateNoiseOctaves(this.noise3, var2, var3, var4, var5, var6, var7, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
        this.noise1 = this.noiseGenOctaves[0].generateNoiseOctaves(this.noise1, var2, var3, var4, var5, var6, var7, var44, var45, var44);
        this.noise2 = this.noiseGenOctaves[1].generateNoiseOctaves(this.noise2, var2, var3, var4, var5, var6, var7, var44, var45, var44);
        int var14 = 0;
        int var15 = 0;

        for (int var16 = 0; var16 < var5; var16++)
        {
            for (int var17 = 0; var17 < var7; var17++)
            {
                float var18 = 0.0F;
                float var19 = 0.0F;
                float var20 = 0.0F;
                byte var21 = 2;
                Biome var22 = this.biomesForGeneration[(var16 + 2 + (var17 + 2) * (var5 + 5))];

                for (int var23 = -var21; var23 <= var21; var23++)
                {
                    for (int var24 = -var21; var24 <= var21; var24++)
                    {
                        Biome biome = this.biomesForGeneration[(var16 + var23 + 2 + (var17 + var24 + 2) * (var5 + 5))];
                        float var26 = this.field_35388_l[(var23 + 2 + (var24 + 2) * 5)] / (biome.getBaseHeight() + 2.0F);

                        if (biome.getBaseHeight() > var22.getBaseHeight())
                        {
                            var26 /= 2.0F;
                        }

                        var18 += biome.getHeightVariation() * var26;
                        var19 += biome.getBaseHeight() * var26;
                        var20 += var26;
                    }
                }

                var18 /= var20;
                var19 /= var20;
                var18 = var18 * 0.9F + 0.1F;
                var19 = (var19 * 4.0F - 1.0F) / 8.0F;
                double var47 = this.noise6[var15] / 8000.0D;

                if (var47 < 0.0D)
                {
                    var47 = -var47 * 0.3D;
                }

                var47 = var47 * 3.0D - 2.0D;

                if (var47 < 0.0D)
                {
                    var47 /= 2.0D;

                    if (var47 < -1.0D)
                    {
                        var47 = -1.0D;
                    }

                    var47 /= 1.4D;
                    var47 /= 2.0D;
                }
                else
                {
                    if (var47 > 1.0D)
                    {
                        var47 = 1.0D;
                    }

                    var47 /= 8.0D;
                }

                var15++;

                for (int var46 = 0; var46 < var6; var46++)
                {
                    double var48 = var19;
                    double var28 = var18;
                    var48 += var47 * 0.2D;
                    var48 = var48 * var6 / 16.0D;
                    double var30 = var6 / 2.0D + var48 * 4.0D;
                    double var32 = 0.0D;
                    double var34 = (var46 - var30) * 12.0D * 128.0D / 128.0D / var28;

                    if (var34 < 0.0D)
                    {
                        var34 *= 4.0D;
                    }

                    double var36 = this.noise1[var14] / 512.0D;
                    double var38 = this.noise2[var14] / 512.0D;
                    double var40 = (this.noise3[var14] / 10.0D + 1.0D) / 2.0D;

                    if (var40 < 0.0D)
                    {
                        var32 = var36;
                    }
                    else if (var40 > 1.0D)
                    {
                        var32 = var38;
                    }
                    else
                    {
                        var32 = var36 + (var38 - var36) * var40;
                    }

                    var32 -= var34;

                    if (var46 > var6 - 4)
                    {
                        double var42 = (var46 - (var6 - 4)) / 3.0F;
                        var32 = var32 * (1.0D - var42) + -10.0D * var42;
                    }

                    var1[var14] = var32;
                    var14++;
                }
            }
        }

        return var1;
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

        biome.decorate(this.world, this.randomSeed, new BlockPos(chunkX, 0, chunkZ));
        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, posX + 8, posZ + 8, 16, 16, this.randomSeed);
        posX += 8;
        posZ += 8;

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
