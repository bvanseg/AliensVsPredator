package org.alien.common.world.worldgen;

import com.asx.mdx.common.minecraft.Worlds;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.avp.common.block.init.AVPOreBlocks;

import java.util.Random;

/**
 * @author Ri5ux
 */
public class WorldGenerator implements IWorldGenerator
{

    private static final WorldGenMinable WORLDGEN_ORE_BAUXITE = new WorldGenMinable(AVPOreBlocks.ORE_BAUXITE.getDefaultState(), 4);
    private static final WorldGenMinable WORLDGEN_ORE_COPPER = new WorldGenMinable(AVPOreBlocks.ORE_COPPER.getDefaultState(), 4);

    private static final WorldGenMinable WORLDGEN_ORE_SILICON = new WorldGenMinable(AVPOreBlocks.ORE_SILICON.getDefaultState(), 3);
    private static final WorldGenMinable WORLDGEN_ORE_MONAZITE = new WorldGenMinable(AVPOreBlocks.ORE_MONAZITE.getDefaultState(), 3);
    private static final WorldGenMinable WORLDGEN_ORE_LITHIUM = new WorldGenMinable(AVPOreBlocks.ORE_LITHIUM.getDefaultState(), 12);
    private static final WorldGenMinable WORLDGEN_ORE_COBALT = new WorldGenMinable(AVPOreBlocks.ORE_COBALT.getDefaultState(), 6);

    private static final Biome[] VALID_ORE_BIOMES = new Biome[]{
            Biomes.BEACH,
            Biomes.BIRCH_FOREST,
            Biomes.BIRCH_FOREST_HILLS,
            Biomes.COLD_BEACH,
            Biomes.COLD_TAIGA,
            Biomes.COLD_TAIGA_HILLS,
            Biomes.DESERT,
            Biomes.DESERT_HILLS,
            Biomes.EXTREME_HILLS,
            Biomes.EXTREME_HILLS_EDGE,
            Biomes.EXTREME_HILLS_WITH_TREES,
            Biomes.FOREST,
            Biomes.FOREST_HILLS,
            Biomes.FROZEN_OCEAN,
            Biomes.FROZEN_RIVER,
            Biomes.ICE_MOUNTAINS,
            Biomes.ICE_PLAINS,
            Biomes.JUNGLE,
            Biomes.JUNGLE_EDGE,
            Biomes.JUNGLE_HILLS,
            Biomes.PLAINS,
            Biomes.RIVER,
            Biomes.ROOFED_FOREST,
            Biomes.SWAMPLAND,
            Biomes.TAIGA,
            Biomes.TAIGA_HILLS,
            Biomes.OCEAN,
            Biomes.DEEP_OCEAN
    };

    @Override
    public void generate(Random seed, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateSurface(world, seed, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        BlockPos chunkCoords = new BlockPos(chunkX, 0, chunkZ);
        Biome biome = world.getBiome(chunkCoords);
        
        Worlds.generateInBiome(world, WORLDGEN_ORE_BAUXITE, rand, 20, 16, 128, chunkCoords, VALID_ORE_BIOMES);
        Worlds.generateInBiome(world, WORLDGEN_ORE_COPPER, rand, 20, 0, 128, chunkCoords, VALID_ORE_BIOMES);
        Worlds.generateInBiome(world, WORLDGEN_ORE_SILICON, rand, 4, 1, 64, chunkCoords, VALID_ORE_BIOMES);
        Worlds.generateInBiome(world, WORLDGEN_ORE_MONAZITE, rand, 4, 1, 48, chunkCoords, VALID_ORE_BIOMES);
        
        if (biome == Biomes.BEACH || biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN || biome == Biomes.FROZEN_OCEAN || biome == Biomes.FROZEN_RIVER)
        {
            Worlds.generateInBiome(world, WORLDGEN_ORE_LITHIUM, rand, 1, 1, 48, chunkCoords, VALID_ORE_BIOMES);
        }
        
        if (biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_EDGE || biome == Biomes.JUNGLE_HILLS || biome == Biomes.MUTATED_JUNGLE || biome == Biomes.MUTATED_JUNGLE_EDGE)
        {
            Worlds.generateInBiome(world, WORLDGEN_ORE_COBALT, rand, 1, 1, 64, chunkCoords, VALID_ORE_BIOMES);
        }
    }
}
