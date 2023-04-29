package org.alien.common.world.worldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.avp.common.block.init.AVPOreBlocks;

import java.util.Random;

/**
 * @author Ri5ux
 */
public class WorldGenerator implements IWorldGenerator
{

    private static final WorldGenMinable WORLDGEN_ORE_BAUXITE = new WorldGenMinable(AVPOreBlocks.ORE_BAUXITE.getDefaultState(), 8);
    private static final WorldGenMinable WORLDGEN_ORE_COPPER = new WorldGenMinable(AVPOreBlocks.ORE_COPPER.getDefaultState(), 8);
    private static final WorldGenMinable WORLDGEN_ORE_SILICON = new WorldGenMinable(AVPOreBlocks.ORE_SILICON.getDefaultState(), 16);
    private static final WorldGenMinable WORLDGEN_ORE_MONAZITE = new WorldGenMinable(AVPOreBlocks.ORE_MONAZITE.getDefaultState(), 4);
    private static final WorldGenMinable WORLDGEN_ORE_LITHIUM = new WorldGenMinable(AVPOreBlocks.ORE_LITHIUM.getDefaultState(), 12);
    private static final WorldGenMinable WORLDGEN_ORE_COBALT = new WorldGenMinable(AVPOreBlocks.ORE_COBALT.getDefaultState(), 6);

    @Override
    public void generate(Random seed, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateSurface(world, seed, chunkX, chunkZ);
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        switch (world.provider.getDimension()) {
            //Nether
            case -1:
                break;
            //Overworld
            case 0:
                this.runGenerator(WORLDGEN_ORE_BAUXITE, 20, 16, 128, world, rand, chunkX, chunkZ);
                this.runGenerator(WORLDGEN_ORE_COPPER, 20, 0, 128, world, rand, chunkX, chunkZ);
                this.runGenerator(WORLDGEN_ORE_SILICON, 4, 1, 64, world, rand, chunkX, chunkZ);
                this.runGenerator(WORLDGEN_ORE_MONAZITE, 4, 1, 48, world, rand, chunkX, chunkZ);

                BlockPos chunkCoords = new BlockPos(chunkX, 0, chunkZ);
                Biome biome = world.getBiome(chunkCoords);


                if (BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.BEACH) || BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.WATER))
                {
                    this.runGenerator(WORLDGEN_ORE_LITHIUM, 2, 1, 48, world, rand, chunkX, chunkZ);
                }

                if (BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.JUNGLE))
                {
                    this.runGenerator(WORLDGEN_ORE_COBALT, 2, 1, 64, world, rand, chunkX, chunkZ);
                }
                break;
            //End
            case 1:
                break;
            //Everything else
            default:
                break;
        }
    }
    private void runGenerator(
        WorldGenMinable worldGenMinable,
        int chancesToSpawn,
        int minHeight, int maxHeight,
        World world,
        Random rand,
        int chunkX, int chunkZ
    ) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
        }

        int heightdiff = maxHeight - minHeight + 1;

        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightdiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            worldGenMinable.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
