package org.avp.world.worldgen;

import java.util.Random;

import org.avp.AVPBlocks;

import com.asx.mdx.lib.world.Worlds;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random seed, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateSurface(world, seed, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        BlockPos chunkCoords = new BlockPos(chunkX, 0, chunkZ);
        Biome biome = world.getBiome(new BlockPos(chunkX, 0, chunkZ));
        Biome[] overworldBiomes = new Biome[] { Biomes.BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.PLAINS, Biomes.RIVER, Biomes.ROOFED_FOREST, Biomes.SWAMPLAND, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.OCEAN, Biomes.DEEP_OCEAN
        };
        
        Worlds.generateInBiome(world, new WorldGenMinable(AVPBlocks.ORE_BAUXITE.getDefaultState(), 4), rand, 20, 16, 128, chunkCoords, overworldBiomes);
        Worlds.generateInBiome(world, new WorldGenMinable(AVPBlocks.ORE_COPPER.getDefaultState(), 4), rand, 20, 0, 128, chunkCoords, overworldBiomes);
        Worlds.generateInBiome(world, new WorldGenMinable(AVPBlocks.ORE_SILICON.getDefaultState(), 3), rand, 4, 1, 64, chunkCoords, overworldBiomes);
        Worlds.generateInBiome(world, new WorldGenMinable(AVPBlocks.ORE_MONAZITE.getDefaultState(), 3), rand, 4, 1, 48, chunkCoords, overworldBiomes);
        
        if (biome == Biomes.BEACH || biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN || biome == Biomes.FROZEN_OCEAN || biome == Biomes.FROZEN_RIVER)
        {
            Worlds.generateInBiome(world, new WorldGenMinable(AVPBlocks.ORE_LITHIUM.getDefaultState(), 12), rand, 1, 1, 48, chunkCoords, overworldBiomes);
        }
        
        if (biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_EDGE || biome == Biomes.JUNGLE_HILLS || biome == Biomes.MUTATED_JUNGLE || biome == Biomes.MUTATED_JUNGLE_EDGE)
        {
            Worlds.generateInBiome(world, new WorldGenMinable(AVPBlocks.ORE_COBALT.getDefaultState(), 6), rand, 1, 1, 64, chunkCoords, overworldBiomes);
        }
    }
}
